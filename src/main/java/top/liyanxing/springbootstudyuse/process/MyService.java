package top.liyanxing.springbootstudyuse.process;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.entity.TbAccount;
import top.liyanxing.springbootstudyuse.entity.TbAccountMapper;

import java.util.Collection;

@Service
public class MyService
{
    @Autowired
    private TbAccountMapper accountMapper;

    /**
     * 新增一个账号
     * @param account 账号信息
     * @return 结果
     */
    public CommonResult<String> saveAccount(TbAccount account)
    {
        // 创建一个UserDetail对象，创建这个对象主要是为了用它的加密方法获取加密后的密码
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                                      .username(account.getLoginName())
                                      .password(account.getPassword())
                                      .roles("ADMIN")
                                      .build();

        // 将账号插入表
        TbAccount accountToSave = TbAccount.getInstance();
        accountToSave.setLoginName(account.getLoginName());
        accountToSave.setPassword(userDetails.getPassword());
        accountMapper.insert(accountToSave);
        return CommonResult.successData("新建成功");
    }

    /**
     * 获取当前登录账号的信息
     * @return 账号信息
     */
    public CommonResult<String> getUserInfo()
    {
        // 获取 Authentication 对象
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 通过 Authentication 对象获取信息
        Object principal = authentication.getPrincipal(); // 账号主要信息
        Object credentials = authentication.getCredentials(); // 账号凭证，例如密码，因为SpringSecurity默认脱敏，所以获取到是null.
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 账号授权信息.
        String name = authentication.getName(); // 账号登录名

        String result = StrUtil.format("【{}】【{}】【{}】【{}】", principal, credentials, authorities, name);
        return CommonResult.successData(result);
    }
}
