package life.majiang.community.controller;

import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithupUser;
import life.majiang.community.provider.GithupProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * kitlen All rights reserved.
 * <p>
 * Author: kitlen
 * Version: 1.0
 * Created Time: 2019-12-20
 * <p>
 * Revision History:
 * Version          Date               Author			Comments
 * 1.0         	2019-12-20		kitlen			Create file
 * ==========================================================================
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithupProvider githupProvider;

    @Value("${githup.client.id}")
    private String client;
    @Value("${githup.client.secret}")
    private String clientSecret;
    @Value("${githup.redirect.uri}")
    private String redirectUri;

    /**
     * 根目录
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,@RequestParam(name = "state")String state){
        AccessTokenDTO dto = new AccessTokenDTO();
        dto.setClient_id(client);
        dto.setClient_secret(clientSecret);
        dto.setCode(code);
        dto.setRedirect_uri(redirectUri);
        dto.setState(state);
        String accessToken = githupProvider.getAccessToken(dto);
        GithupUser user = githupProvider.getUser(accessToken);
        System.out.println(user.getName() + user.getId());
        return "index";
    }
}
