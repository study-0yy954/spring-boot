package top.liyanxing.springbootstudyuse.config.springsecurity;

import cn.hutool.core.collection.CollUtil;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        LambdaQueryWrapper<TbAccount> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(TbAccount::getLoginName, username);

        TbAccount tbAccountFromDb = accountMapper.selectOne(wrapper);
        if (Objects.isNull(tbAccountFromDb))
        {
            throw new UsernameNotFoundException(username);
        }

        return new User(username,
                        tbAccountFromDb.getPassword(),
                        tbAccountFromDb.getEnable(),
                        true,
                        true,
                        true,
                        CollUtil.newArrayList());
    }
}
