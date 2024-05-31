package top.liyanxing.springbotstudy;

import cn.hutool.core.lang.Console;
import cn.hutool.extra.spring.SpringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.liyanxing.springbootstudyuse.Application;
import top.liyanxing.springbootstudyuse.common.baseclass.ObjectMapperOpt;
import top.liyanxing.springbootstudyuse.process.MyController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ApplicationTest
{
    @Autowired
    private ObjectMapperOpt objectMapperOpt;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test1()
    {
        ObjectMapperOpt oMapper = SpringUtil.getBean(ObjectMapperOpt.class);

        Console.log("来自手动获取【{}】", oMapper);
        Console.log("来自手动获取【{}】", oMapper.getObjectMapper());

        Console.log("输出数据【{}】", objectMapperOpt);
        Console.log("输出数据【{}】", objectMapper);
    }
}
