package com.fwk.flowabledemo;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试候选人
 */
@SpringBootTest
class Test3 {

	@Test
	void contextLoads() {
	}

	ProcessEngine processEngine = null;

	@BeforeEach
	public void before(){
		processEngine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void deploy(){

		Deployment deployment = processEngine.getRepositoryService().createDeployment()
				.addClasspathResource("测试候选人.bpmn20.xml")
				.deploy();
		ProcessDefinition singleResult = processEngine.getRepositoryService().createProcessDefinitionQuery()
				.deploymentId(deployment.getId())
				.singleResult();
		System.out.println("singleResult.getName() = " + singleResult.getName());


	}

	@Test
	public void run(){
		Map<String, Object> variables = new HashMap<>();
		variables.put("candidate1", "候选张");
		variables.put("candidate2", "候选李");
		variables.put("candidate3", "候选王");
		processEngine.getRuntimeService().startProcessInstanceById("testCandidate:1:12504",variables);

	}

	@Test
	public void queryCandidate(){
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery()
				.processDefinitionId("testCandidate:1:12504")
				.taskCandidateUser("候选李")
				.list();
		tasks.forEach(it -> {
			System.out.println("it.getId() = " + it.getId());
			System.out.println("it.getName() = " + it.getName());
		});
	}

	/**
	 * 认领任务
	 * 如果一个用户认领了这个任务，那么其他用户就不能再认领该任务了
	 * 所以，如果一个用户认领了该任务又不想处理，可以退还任务
	 */
	@Test
	public void claim(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery()
				.processDefinitionId("testCandidate:1:12504")
				.taskCandidateUser("候选李")
				.singleResult();
		if(task != null){
			taskService.claim(task.getId(),"候选李");
			System.out.println("任务认领成功！");
		}
	}

	/**
	 * 退还任务
	 * 如果一个用户认领了这个任务，那么其他用户就不能再认领该任务了
	 * 所以，如果一个用户认领了该任务又不想处理，可以退还任务
	 */
	@Test
	public void unClaim(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery()
				.processDefinitionId("testCandidate:1:12504")
				.taskAssignee("候选李")
				.singleResult();
		if(task != null){
			taskService.unclaim(task.getId());
			System.out.println("任务退还成功！");
		}
	}

	/**
	 * 交接任务
	 * 如果一个用户认领了这个任务，如果不想处理可以交接给其他候选人
	 */
	@Test
	public void taskCandidate(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery()
				.processDefinitionId("testCandidate:1:12504")
				.taskAssignee("候选李")
				.singleResult();
		if(task != null){
			taskService.setAssignee(task.getId(),"候选王");
			System.out.println("任务交接给候选王！");
		}
	}

	/**
	 * 完成任务
	 */
	@Test
	public void completeTask(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery()
				.processDefinitionId("testCandidate:1:12504")
				.taskAssignee("候选王")
				.singleResult();
		taskService.complete(task.getId());
	}






}
