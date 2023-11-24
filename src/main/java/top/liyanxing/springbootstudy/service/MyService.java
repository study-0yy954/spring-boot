package top.liyanxing.springbootstudy.service;

import cn.hutool.core.lang.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudy.entity.Student;
import top.liyanxing.springbootstudy.mapper.StudentMapper;

@Service
public class MyService
{
    @Autowired
    private StudentMapper studentMapper;

    public CommonResult<String> test1()
    {
        Student stu = Student.getInstance();
        stu.setName("张三");
        studentMapper.insert(stu);
        return CommonResult.successData("插入成功");
    }
}
