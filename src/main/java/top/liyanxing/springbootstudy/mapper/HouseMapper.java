package top.liyanxing.springbootstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.liyanxing.springbootstudy.entity.House;

@Mapper
@Repository
public interface HouseMapper extends BaseMapper<House>
{
}
