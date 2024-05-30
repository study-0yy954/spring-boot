package top.liyanxing.springbotstudy;

import cn.hutool.core.lang.Console;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainTest
{
    public static void main(String[] args)
    {
        PasswordEncoder encoder1 = new BCryptPasswordEncoder(4);
        String resutl1 = encoder1.encode("123");
        Console.log("输出数据【{}】", resutl1);

        PasswordEncoder encoder2 = new BCryptPasswordEncoder(5);
        Console.log("输出数据【{}】", encoder2.matches("123", resutl1));
    }
}
