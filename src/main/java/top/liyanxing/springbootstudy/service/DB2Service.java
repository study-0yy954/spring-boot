package top.liyanxing.springbootstudy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.liyanxing.springbootstudy.entity.House;
import top.liyanxing.springbootstudy.entity.Student;
import top.liyanxing.springbootstudy.mapper.HouseMapper;
import top.liyanxing.springbootstudy.mapper.StudentMapper;

@DS("db2")
@Service
public class DB2Service
{
    @Autowired
    private HouseMapper houseMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save()
    {
        House house = House.getInstance();
        house.setAddress(StrUtil.concat(true, "北京天通苑 ", DateUtil.now()));
        houseMapper.insert(house);
    }
}
