package top.liyanxing.springbotstudy;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class AccountEntity
{
    private String organizationName;

    private String loginName;

    private String name;

    private String roles;

    private String tel;

    private String email;

    private String password;

    private String organizationId;
}
