package top.liyanxing.springbotstudy;

import cn.hutool.core.lang.Console;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MainTest
{
    public static void main(String[] args)
    {
        PasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String resutl = encoder.encode("123");

        Console.log("输出数据【{}】", resutl);

        encoder.matches("123", resutl);
    }
}
