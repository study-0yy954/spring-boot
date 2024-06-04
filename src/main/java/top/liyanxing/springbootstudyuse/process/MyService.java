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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String name = authentication.getName();

        String result = StrUtil.format("【{}】\n【{}】\n【{}】\n【{}】", principal, credentials, authorities, name);
        return CommonResult.successData(result);
    }
}
