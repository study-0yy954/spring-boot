package top.liyanxing.springbootstudyuse.precess;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.liyanxing.common.CommonResult;

@RestController
public class MyController
{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MyService service;

    @GetMapping("/beans")
    public CommonResult<String[]> beans()
    {
        return CommonResult.successData(applicationContext.getBeanDefinitionNames());
    }

    @GetMapping("/githubUserInfo")
    public CommonResult<ObjectNode> githubUserInfo(@AuthenticationPrincipal OAuth2User oauth2User,
                                                   @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient)
    {
        return service.gitHubUserInfo(oauth2User, authorizedClient);
    }
}