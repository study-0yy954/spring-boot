package top.liyanxing.springbootstudyuse.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;
import top.liyanxing.springbootstudyuse.entity.TbAccount;

@RestController
public class MyController
{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MyService myService;



    @GetMapping("/beans")
    public CommonResult<String[]> beans()
    {
        return CommonResult.successData(applicationContext.getBeanDefinitionNames());
    }

    @GetMapping("/getUserInfo")
    public CommonResult<String> getUserInfo()
    {
        return myService.getUserInfo();
    }



    @GetMapping("/user/list")
    @PreAuthorize("hasRole('ADMIN1')")
    public CommonResult<String> userList()
    {
        return CommonResult.successData("你访问了/user/list接口");
    }

    @PostMapping("/user/add")
    public CommonResult<String> userAdd()
    {
        return CommonResult.successData("你访问了/user/add接口");
    }



    @PostMapping("/public/saveAccount")
    public CommonResult<String> saveAccount(@RequestBody TbAccount account)
    {
        return myService.saveAccount(account);
    }

    @GetMapping("/public/test")
    public CommonResult<String> test()
    {
        return CommonResult.successData("你访问了一个不需要认证的接口");
    }
}