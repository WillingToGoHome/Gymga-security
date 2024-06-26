package com.willingtogohome.gymga.login.config.handler;

import com.willingtogohome.gymga.login.auth.model.AuthDetails;
import com.willingtogohome.gymga.login.common.UserRole;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@Configuration
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
   @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        AuthDetails dto =
                (AuthDetails) authentication.getPrincipal();
        System.out.println("인증후=>"+dto);
        //권한리스트를 추출
        Collection<? extends GrantedAuthority> authlist = dto.getAuthorities();
        Iterator<? extends GrantedAuthority> authlist_it= authlist.iterator();
        String url="/";
        while(authlist_it.hasNext()) {
            GrantedAuthority authority= authlist_it.next();
            //설정되어 있는 권한 중 ADMIN이 있다면
            if(authority.getAuthority().equals(UserRole.ADMIN.getRole())) {
                url="/main";
                break;
            } else if (authority.getAuthority().equals(UserRole.USER.getRole())) {
                url="/main";
                break;
            }
        }

        response.sendRedirect(url);
    }
}
