package top.liyanxing.springbotstudy;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liyanxing.springbootstudyuse.Application;
import top.liyanxing.springbootstudyuse.process.MyController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ApplicationTest
{
    @Autowired
    private MyController myController;

    @Test
    public void test1()
    {
        Console.log(myController);
    }
}
