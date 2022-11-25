package com.fwk.flowabledemo.listener;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.impl.context.Context;
import org.flowable.task.service.delegate.DelegateTask;

import java.util.Map;

/**
 * @Classname BossTaskHander
 * @Description TODO
 * @Date 2022/11/24 4:02 PM
 * @Created by fuwk
 */
public class ManagerTaskHandler implements TaskListener {


    private final RuntimeService runtimeService = Context.getProcessEngineConfiguration().getRuntimeService();

//    RuntimeService runtimeService1 = SpringUtil.getBean(RuntimeService.class);


    @Override
    public void notify(DelegateTask delegateTask) {
//        System.out.println("manager: ");
//        String[] s = new String[]{"id","assignee","owner",
//                "parentTaskId","name","queryVariables","queryIdentityLinks"};
//        Map<String, Object> map = CommUtil.obj2map(delegateTask, s);
//        JSON.toJSONString(map);

        Map<String, Object> map = runtimeService.getVariables(delegateTask.getExecutionId());
        Object outcome = map.get("outcome");
        if("驳回".equals(outcome)){
            System.out.println("manager批准驳回！");
        }else {
            System.out.println("manager批准通过！");
        }
    }
}
