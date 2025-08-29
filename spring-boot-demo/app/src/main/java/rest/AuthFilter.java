package rest;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader("Authorization");
        System.out.println("Auth header: " + authHeader);
        
        if (authHeader == null || !authHeader.equals("Bearer malar2005")) {
            throw new ServletException("Unauthorized request");
        }
        
        chain.doFilter(request, response);
        System.out.println("Request authorized");
    }
}
