package xyz.esp8266.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.esp8266.community.dto.AccessTokenDTO;
import xyz.esp8266.community.dto.GithubUser;
import xyz.esp8266.community.provider.GithubProvider;


@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("23cea2678c592912ef5f");
        accessTokenDTO.setClient_secret("4a8515f65cd83789be5954b8390e4f1102cc1cf5");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("https://elec.utools.club/callback");
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
