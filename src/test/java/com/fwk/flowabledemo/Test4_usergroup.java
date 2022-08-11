package com.fwk.flowabledemo;

import org.flowable.engine.IdentityService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试用户和组
 */
@SpringBootTest
class Test4_usergroup {

	ProcessEngine processEngine;

	@BeforeEach
	public void before(){
		processEngine = ProcessEngines.getDefaultProcessEngine();
	}

	@Test
	public void addUser(){
		IdentityService identityService = processEngine.getIdentityService();
//		User user = identityService.newUser("李菲");
//		user.setEmail("3423423@qq.com");
//		user.setFirstName("li");
//		user.setLastName("fei");
//		user.setPassword("123");
		User user = identityService.newUser("狂战");
		user.setEmail("3423423@qq.com");
		user.setFirstName("kuang");
		user.setLastName("zhan");
		user.setPassword("123");
		identityService.saveUser(user);
	}

	@Test
	public void addGroup(){
		IdentityService identityService = processEngine.getIdentityService();
		Group group = identityService.newGroup("group2");
		group.setName("宣传部");
		group.setType("type2");
		identityService.saveGroup(group);

	}

	@Test
	public void addUserToGroup(){
		IdentityService identityService = processEngine.getIdentityService();
//		identityService.createMembership("狂战", "group2");
		identityService.createMembership("李菲", "group1");
	}


}