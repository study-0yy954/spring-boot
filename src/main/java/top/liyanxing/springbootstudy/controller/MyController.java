package top.liyanxing.springbootstudy.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/zTest")
    public CommonResult<String> zTest(@RequestParam String startAt) throws SchedulerException
    {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                                        .withIdentity(JOB_NAME, JOB_GROUP)
                                        .build();
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                                             .withIdentity(TRIGGER_NAME, TRIGGER_GROUP)
                                             .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                                             .startAt(DateUtil.parseDateTime(startAt))
                                             .build();
        scheduler.scheduleJob(jobDetail, trigger);

        return CommonResult.successData(DateUtil.now());
    }

    // @GetMapping("/start")
    // public CommonResult<String> start() throws SchedulerException
    // {
    //     scheduler.start();
    //     return CommonResult.successData(DateUtil.now());
    // }
}