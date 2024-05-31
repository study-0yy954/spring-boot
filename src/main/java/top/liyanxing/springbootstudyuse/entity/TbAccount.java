package top.liyanxing.springbootstudyuse.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@TableName("tb_account")
public class TbAccount
{
    @TableId(value = "loginName", type = IdType.INPUT)
    private String loginName;

    @TableField("password")
    private String password;

    @TableField("enable")
    private Boolean enable;

    public static TbAccount getInstance()
    {
        TbAccount obj = new TbAccount();
        return obj;
    }
}