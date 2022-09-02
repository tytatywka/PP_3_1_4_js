package com.example.andreyrestjs.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;


public class CustomFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String badRequest = ((HttpServletRequest) servletRequest).getRequestURI();

        if (badRequest.contains(("/porn"))) {
            String[] arrayUrl = badRequest.split(Pattern.quote("/"));
            int agePorn = Integer.parseInt(arrayUrl[2]);
            if (agePorn < 18) {
                httpServletResponse.sendRedirect("/user");
            } else filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}






