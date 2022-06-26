package com.ria.rms.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class CustomLogger {

    public static final String METHOD = "{}\t[Method]\t\t\t{}.{}";
    public static final String URL = "{}\t[URL] \t\t\t\t{}:{}";
    public static final String QUERY_PARAMS = "{}\t[Query Params] \t\t{}";
    public static final String REQUEST_BODY = "{}\t[RequestBody] \t\t{}";
    public static final String RESPONSE_STATUS = "{}\t[Response Status] \t{}:{}";
    public static final String RESPONSE_BODY = "{}\t[ResponseBody] \t\t{}";
    public static final String EXCEPTION = "{}\t[Exception] \t\t{} \n[Stacktrace] {}";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    public void logCalledMethod(String className, String methodName) {
        log.info(METHOD, getSessionUUID(), className, methodName);
    }

    public void logUrl() {
        log.info("====================================================================");
        log.info(URL, getSessionUUID(), request.getMethod(), request.getRequestURI());
        log.info("--------------------------------------------------------------------");
    }

    public void logQueryParams() {
        log.info(QUERY_PARAMS, getSessionUUID(), request.getQueryString());
    }

    public void logRequestBody(Object body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            log.info(REQUEST_BODY, getSessionUUID(), objectMapper.writeValueAsString(body));
        } catch (Exception e) {
            log.info(REQUEST_BODY, getSessionUUID(), body);
        }

    }

    public void logResponseStatus() {
        log.info(RESPONSE_STATUS, getSessionUUID(), response.getStatus(), HttpStatus.valueOf(response.getStatus()).getReasonPhrase());
    }

    public void logResponseBody(Object body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            log.info(RESPONSE_BODY, getSessionUUID(), objectMapper.writeValueAsString(body));
        } catch (Exception e) {
            log.info(RESPONSE_BODY, getSessionUUID(), body);
        }
    }

    public void logException(Exception exception) {
        log.info(RESPONSE_BODY, getSessionUUID(), exception.getMessage(), exception.getStackTrace());
    }

    private Object getSessionUUID() {
        return request.getAttribute("uuid");
    }
}
