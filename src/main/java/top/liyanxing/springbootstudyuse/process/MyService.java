package top.liyanxing.springbootstudyuse.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.entity.TbAccount;
import top.liyanxing.springbootstudyuse.entity.TbAccountMapper;

@Service
public class MyService
{
    @Autowired
    private TbAccountMapper accountMapper;

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
}
