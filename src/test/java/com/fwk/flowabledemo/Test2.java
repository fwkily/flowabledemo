package com.fwk.flowabledemo;

import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程变量
 */
@SpringBootTest
class Test2 {

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
				.addClasspathResource("出差申请单.bpmn20.xml")
				.deploy();
		ProcessDefinition singleResult = processEngine.getRepositoryService().createProcessDefinitionQuery()
				.deploymentId(deployment.getId())
				.singleResult();
		System.out.println("singleResult.getName() = " + singleResult.getName());


	}

	@Test
	public void run(){
		Map<String, Object> variables = new HashMap<>();
		variables.put("assign0", "张三");
		variables.put("assign1", "李四");
		variables.put("assign2", "王五");
		variables.put("assign3", "赵会计");
		processEngine.getRuntimeService().startProcessInstanceById("evection:1:4",variables);

	}

	@Test
	public void completeZhangSan(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId("2501")
				.taskAssignee("张三")
				.singleResult();
		Map<String, Object> processVariables = task.getProcessVariables();
		processVariables.put("num",2);
		taskService.complete(task.getId(),processVariables);
	}

	@Test
	public void updateVariableLocal(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId("2501")
				.taskAssignee("李四")
				.singleResult();
		Map<String, Object> processVariables = task.getProcessVariables();
		processVariables.put("num",6);
		taskService.setVariablesLocal(task.getId(),processVariables);
	}

	@Test
	public void updateVariable(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId("2501")
				.taskAssignee("李四")
				.singleResult();
		//局部变量和全局变量都有的情况下，这里取出来的是局部变量
		Map<String, Object> processVariables = task.getProcessVariables();
		processVariables.put("num",1);
		taskService.setVariables(task.getId(),processVariables);
	}

	@Test
	public void completeLiSi(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId("2501")
				.taskAssignee("李四")
				.singleResult();
		taskService.complete(task.getId());
	}

	@Test
	public void completeZhao(){
		TaskService taskService = processEngine.getTaskService();
		Task task = taskService.createTaskQuery().processInstanceId("2501")
				.taskAssignee("赵会计")
				.singleResult();
		taskService.complete(task.getId());
	}




}
