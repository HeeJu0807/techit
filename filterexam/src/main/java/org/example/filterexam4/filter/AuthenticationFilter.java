package org.example.filterexam4.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.filterexam4.entity.User;
import org.example.filterexam4.service.UserService;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String path = request.getRequestURI();  // 요청 주소 ex) /welcome, /loginform, /admin/list
            String auth = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("auth")) {
                        auth = cookie.getValue();
                        break;
                    }
                }
            }
            // 인증된 사용자라면
            if (auth != null) {
                User user = userService.findByUsername(auth);

                if (user != null) {
                    user.setUsername(auth);
                    UserContext.setUser(user);

                    if ((path.equals("/admin") && user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN")))
                            || (path.equals("/info") && user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_USER")))) {

                        filterChain.doFilter(servletRequest, servletResponse);
                        UserContext.clear();
                        return;
                    }
                }

                // 권한이 없는 사용자가 접근하려고 하면
                if (path.equals("/admin") || path.equals("/info")) {
                    response.sendRedirect("/access-denied");
                }

            }
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            UserContext.clear();
        }
    }
}
