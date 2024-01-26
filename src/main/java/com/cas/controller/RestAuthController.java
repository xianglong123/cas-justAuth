package com.cas.controller;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthAlipayRequest;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: xianglong
 * @create: 2024-01-25 16:09
 **/
@RestController
@RequestMapping("/oauth")
public class RestAuthController {

    @RequestMapping("/render/github")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getAuthRequest();
        String authorize = authRequest.authorize("123456");
        System.out.println(authorize);
        response.sendRedirect(authorize);
    }

    @RequestMapping("/callback/github")
    public Object login(AuthCallback callback) {
        AuthRequest authRequest = getAuthRequest();
        return authRequest.login(callback);
    }

    private AuthRequest getAuthRequest() {
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId("5bb753d8e3d0d1015829")
                .clientSecret("5d8eff6edc443c023d624a7490778601dd79eea0")
                .redirectUri("http://www.xianglong.vip")
                .build());
    }


    private AuthRequest getAliAuthRequest() {
        return new AuthAlipayRequest(AuthConfig.builder()
                .clientId("5bb753d8e3d0d1015829")
                .clientSecret("5d8eff6edc443c023d624a7490778601dd79eea0")
                .redirectUri("http://www.xianglong.vip")
                .build(), "");
    }


}
