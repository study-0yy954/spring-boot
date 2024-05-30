package top.liyanxing.springbootstudyuse.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter
@Setter
@ToString
public class Student
{
    private String name;

    private Date birthday;
}