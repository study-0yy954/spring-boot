package top.liyanxing.springbootstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.liyanxing.springbootstudy.entity.Student;

@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student>
{
}
