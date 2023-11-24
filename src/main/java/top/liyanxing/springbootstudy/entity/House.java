package top.liyanxing.springbootstudy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_house")
public class House
{
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("address")
    private String address;

    public static House getInstance()
    {
        House obj = new House();
        return obj;
    }
}
