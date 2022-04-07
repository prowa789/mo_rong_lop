package com.moronglop.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// custom success url for Sinh viên admin và giáo vụ
@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws ServletException, IOException {

            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            String redirectURL = request.getContextPath();

            if (userDetails.hasRole("SINH_VIEN")) {
                redirectURL = "sv";
            } else if (userDetails.hasRole("GIAO_VU")) {
                redirectURL = "gv/profile";
            } else if (userDetails.hasRole("ADMIN")) {
                redirectURL = "admin";
            }

            response.sendRedirect(redirectURL);

        }
}