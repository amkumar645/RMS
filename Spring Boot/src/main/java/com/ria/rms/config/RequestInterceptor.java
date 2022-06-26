package com.ria.rms.config;

import com.ria.rms.util.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    private CustomLogger logger;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("uuid", UUID.randomUUID());
        logger.logUrl();
        logger.logQueryParams();
        return true;
    }
}
