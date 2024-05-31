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
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                                      .username(account.getLoginName())
                                      .password(account.getPassword())
                                      .roles("ADMIN")
                                      .build();

        TbAccount accountToSave = TbAccount.getInstance();
        accountToSave.setLoginName(account.getLoginName());
        accountToSave.setPassword(userDetails.getPassword());
        accountMapper.insert(accountToSave);
        return CommonResult.successData("新建成功");
    }
}
