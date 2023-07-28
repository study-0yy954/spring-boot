package top.liyanxing.springbootstudy.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudy.job.HelloJob;

@RestController
public class MyController
{
    @Autowired
    private Scheduler scheduler;

    private static final String JOB_NAME = "JOB_NAME";

    private static final String JOB_GROUP = "JOB_GROUP";

    private static final String TRIGGER_NAME = "TRIGGER_NAME";

    private static final String TRIGGER_GROUP = "TRIGGER_GROUP";

    @GetMapping("/start")
    public CommonResult<String> zTest() throws SchedulerException
    {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                                        .withIdentity(JOB_NAME, JOB_GROUP)
                                        .build();
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                                              .withIdentity(TRIGGER_NAME, TRIGGER_GROUP)
                                              .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3))
                                              .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        return CommonResult.successData("启动成功");
    }
}