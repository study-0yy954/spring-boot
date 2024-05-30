package top.liyanxing.springbootstudyuse.process;

import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }
}
