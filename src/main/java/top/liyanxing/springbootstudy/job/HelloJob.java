package top.liyanxing.springbootstudy.job;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job
{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        Console.log("任务执行，现在的时间：{}", DateUtil.now());
    }
}
