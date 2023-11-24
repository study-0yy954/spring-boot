package top.liyanxing.springbootstudy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liyanxing.springbootstudy.entity.Student;
import top.liyanxing.springbootstudy.mapper.StudentMapper;

@DS("db1")
@Service
public class DB1Service
{
    @Autowired
    private StudentMapper studentMapper;

    public void save()
    {
        Student stu = Student.getInstance();
        stu.setName(StrUtil.concat(true, "张三 ", DateUtil.now()));
        studentMapper.insert(stu);
    }
}
