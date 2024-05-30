package top.liyanxing.springbootstudyuse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class TbAccount
{

    private String loginName;

    private String password;

    private Boolean enable;
}