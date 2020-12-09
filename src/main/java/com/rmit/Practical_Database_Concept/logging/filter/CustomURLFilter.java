package com.rmit.Practical_Database_Concept.logging.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

@Slf4j
public class CustomURLFilter implements Filter {
    private static final String REQUEST_ID = "request_id";

    private static final String REQUEST_USERNAME = "request_username";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * This will be the place to insert user id or username into request
         */

        String requestId = UUID.randomUUID().toString();

        servletRequest.setAttribute(REQUEST_ID, requestId);

        logRequest((HttpServletRequest) servletRequest, requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}

    private void logRequest(HttpServletRequest request, String requestId) {
        if (request != null) {
            StringBuilder data = new StringBuilder();

            data.append("\nLOGGING REQUEST-----------------------------------\n")
                .append("[REQUEST-ID]: ").append(requestId).append("\n");

            Object objectId = request.getAttribute(REQUEST_USERNAME);

            if (objectId != null) {
                data.append("[REQUEST-USERNAME]: ").append(objectId.toString()).append("\n");
            }

            log.info(data.toString());
            data.append("[PATH]: ").append(request.getRequestURI()).append("\n")
                .append("[QUERIES]: ").append(request.getQueryString()).append("\n")
                .append("[HEADERS]: ").append("\n");

            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                data.append("---").append(key).append(" : ").append(value).append("\n");
            }
            data.append("LOGGING REQUEST-----------------------------------\n");

            log.info(data.toString());
        }
    }
}
