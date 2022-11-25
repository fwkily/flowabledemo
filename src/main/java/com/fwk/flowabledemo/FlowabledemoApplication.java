package com.fwk.flowabledemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
public class FlowabledemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(FlowabledemoApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(FlowabledemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(final RepositoryService repositoryService,
//								  final RuntimeService runtimeService,
//								  final TaskService taskService) {
//
//		return new CommandLineRunner() {
//			@Override
//			public void run(String... strings) throws Exception {
//				System.out.println("Number of process definitions : "
//						+ repositoryService.createProcessDefinitionQuery().count());
//				System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//				runtimeService.startProcessInstanceByKey("oneTaskProcess");
//				System.out.println("Number of tasks after process start: "
//						+ taskService.createTaskQuery().count());
//			}
//		};
//	}

//	@Bean
//	public CommandLineRunner runner(){
//		return args -> {
//			ProcessEngine bean = SpringUtil.getContext().getBean(ProcessEngine.class);
//			logger.info("bean名称:{}",bean.toString());
//		};
//	}


}
