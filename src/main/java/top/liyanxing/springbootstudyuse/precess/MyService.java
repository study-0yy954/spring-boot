package top.liyanxing.springbootstudyuse.precess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import top.liyanxing.common.CommonResult;

import java.util.Collection;

@Service
public class MyService
{
    @Autowired
    private ObjectMapper objectMapper;

    public CommonResult<ObjectNode> gitHubUserInfo(OAuth2User oauth2User, OAuth2AuthorizedClient authorizedClient)
    {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("oauth2User", objectMapper.valueToTree(oauth2User));
        objectNode.put("authorizedClient", objectMapper.valueToTree(authorizedClient));

        return CommonResult.successData(objectNode);
    }
}
