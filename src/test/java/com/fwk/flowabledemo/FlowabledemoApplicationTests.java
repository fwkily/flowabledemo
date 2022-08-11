//package com.fwk.flowabledemo;
//
//import org.flowable.engine.HistoryService;
//import org.flowable.engine.ProcessEngine;
//import org.flowable.engine.ProcessEngineConfiguration;
//import org.flowable.engine.TaskService;
//import org.flowable.engine.history.HistoricActivityInstance;
//import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
//import org.flowable.engine.repository.Deployment;
//import org.flowable.engine.repository.ProcessDefinition;
//import org.flowable.engine.runtime.ProcessInstance;
//import org.flowable.task.api.Task;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//@SpringBootTest
//class FlowabledemoApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//	ProcessEngine processEngine = null;
//
//	@BeforeEach
//	public void before(){
//		ProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration();
//		processEngineConfiguration.setJdbcUrl("jdbc:mysql://114.116.9.97:3306/fwkdb?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true");
//		processEngineConfiguration.setJdbcUsername("root");
//		processEngineConfiguration.setJdbcPassword("1qw2!QW@");
//		processEngineConfiguration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
//		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//		processEngine = processEngineConfiguration.buildProcessEngine();
//	}
//
//	@Test
//	public void deploy(){
//
//		Deployment deployment = processEngine.getRepositoryService().createDeployment()
//				.addClasspathResource("testDay.bpmn20.xml")
//				.deploy();
//		ProcessDefinition singleResult = processEngine.getRepositoryService().createProcessDefinitionQuery()
//				.deploymentId(deployment.getId())
//				.singleResult();
//		System.out.println("singleResult.getName() = " + singleResult.getName());
//
//
//	}
//
//	@Test
//	public void run(){
////		Scanner scanner = new Scanner(System.in);
////		System.out.println("你是？");
////		String name = scanner.nextLine();
////		System.out.println("你要请假几天？");
////		Integer days = Integer.valueOf(scanner.nextLine());
////		System.out.println("你为什么请假？");
////		String reason = scanner.nextLine();
//
//		Map<String, Object> variables = new HashMap<>();
//		variables.put("employee", "fwk");
//		variables.put("nrOfHolidays", 3);
//		variables.put("description", "去玩");
//		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("holidayRequest",variables);
//		System.out.println("processInstance.getName() = " + processInstance.getName());
//		System.out.println("processInstance.getId() = " + processInstance.getId());
//		System.out.println("processInstance.getStartTime() = " + processInstance.getStartTime());
//		System.out.println("processInstance.getTenantId() = " + processInstance.getTenantId());
//		System.out.println("processInstance.getProcessVariables().isEmpty() = " + processInstance.getProcessVariables().isEmpty());
//		processInstance.getProcessVariables().forEach((k,v) -> {
//			System.out.println("k = " + k);
//			System.out.println("v = " + v);
//			System.out.println("-----------");
//		});
//	}
//
//	@Test
//	public void task(){
//		TaskService taskService = processEngine.getTaskService();
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
//		System.out.println("You have " + tasks.size() + " tasks:");
//		for (int i=0; i<tasks.size(); i++) {
//			System.out.println((i+1) + ") " + tasks.get(i).getName());
//		}
//		Task task = tasks.get(0);
//		Map<String, Object> processVariables = taskService.getVariables(task.getId());
//		System.out.println(processVariables.get("employee") + " wants " +
//				processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");
//
//		Map<String,Object> variables = new HashMap<>();
//		variables.put("approved", false);
//		taskService.complete(task.getId(), variables);
//	}
//
//	@Test
//	public void taskHis(){
//		HistoryService historyService = processEngine.getHistoryService();
//		List<HistoricActivityInstance> activities =
//				historyService.createHistoricActivityInstanceQuery()
//						.processInstanceId("12501")
//						.finished()
//						.orderByHistoricActivityInstanceEndTime().asc()
//						.list();
//
//		for (HistoricActivityInstance activity : activities) {
//			System.out.println(activity.getActivityId() + " took "
//					+ activity.getDurationInMillis() + " milliseconds");
//		}
//
//	}
//
//
//
//
//
//
//
//}
