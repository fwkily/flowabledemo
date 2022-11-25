package com.fwk.flowabledemo.listener;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.impl.context.Context;
import org.flowable.task.service.delegate.DelegateTask;

import java.util.Map;

/**
 * @Classname BossTaskHander
 * @Description 监听器，可做额外的业务处理逻辑
 * @Date 2022/11/24 4:02 PM
 * @Created by fuwk
 */
public class BossTaskHandler implements TaskListener {

    //两种方式都可以获取bean，但是通过autowired获取不到
    private final RuntimeService runtimeService = Context.getProcessEngineConfiguration().getRuntimeService();

//    RuntimeService runtimeService1 = SpringUtil.getBean(RuntimeService.class);

    @Override
    public void notify(DelegateTask delegateTask) {
        Map<String, Object> map = runtimeService.getVariables(delegateTask.getExecutionId());
        Object outcome = map.get("outcome");
        if("驳回".equals(outcome)){
            System.out.println("boss批准驳回！");
        }else {
            System.out.println("boss批准通过！");
        }
    }
}
