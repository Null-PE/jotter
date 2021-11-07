package com.example.server.interceptor;

import com.example.server.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{"index"};
        String uri = request.getRequestURI();
        String page = StringUtils.remove(request.getRequestURI(), contextPath + "/");

        if (beginWith(page, requireAuthPages)) {
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("login");
                return false;
            }
        }
        return true;
    }

    private boolean beginWith(String page, String[] requiredAuthPages) {
        return Arrays.stream(requiredAuthPages).anyMatch(p -> StringUtils.startsWith(page, p));
    }
}
