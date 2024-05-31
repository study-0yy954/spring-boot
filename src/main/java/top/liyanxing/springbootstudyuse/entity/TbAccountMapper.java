package top.liyanxing.springbootstudyuse.entity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TbAccountMapper extends BaseMapper<TbAccount>
{
}
