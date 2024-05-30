package top.liyanxing.springbootstudyuse.config.springsecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

public class DbMemoryUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService
{
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
        return null;
    }
}
