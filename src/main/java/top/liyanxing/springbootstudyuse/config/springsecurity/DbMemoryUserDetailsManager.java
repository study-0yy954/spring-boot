package top.liyanxing.springbootstudyuse.config.springsecurity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import top.liyanxing.springbootstudyuse.entity.TbAccount;
import top.liyanxing.springbootstudyuse.entity.TbAccountMapper;

import java.util.Objects;

@Component
public class DbMemoryUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService
{
    @Autowired
    private TbAccountMapper accountMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword)
    {
        return null;
    }

    @Override
    public void createUser(UserDetails user)
    {

    }

    @Override
    public void updateUser(UserDetails user)
    {
    }

    @Override
    public void deleteUser(String username)
    {
    }

    @Override
    public void changePassword(String oldPassword, String newPassword)
    {
    }

    @Override
    public boolean userExists(String username)
    {
        return false;
    }

    /**
     * 重写此方法，这个方法不需要手动调用，登录时会自动调用.
     * @param username 用户名
     * @return 登录的用户
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // 根据登录名从数据库中查询用户(账号)
        LambdaQueryWrapper<TbAccount> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TbAccount::getLoginName, username);

        // 账号不存在的话抛出异常
        TbAccount tbAccountFromDb = accountMapper.selectOne(wrapper);
        if (Objects.isNull(tbAccountFromDb))
        {
            throw new UsernameNotFoundException(username);
        }

        return User.withUsername(username)
                   .password(tbAccountFromDb.getPassword())
                   .disabled(!tbAccountFromDb.getEnable())
                   .credentialsExpired(false)
                   .accountLocked(false)
                   .roles("ADMIN")
                   .build();
    }
}
