package top.liyanxing.springbotstudy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountEntity
{
    @JsonIgnore
    private String organizationName;

    private String loginName;

    private String name;

    private String roles;

    private String tel;

    private String email;

    private String password;

    private String organizationId;
}
