package rest;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.stereotype.Component; 
import org.springframework.core.annotation.Order;

@Component
@Order(2) // cant set url patterns in component if you want use FilterRegistrationBean
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println("Incoming request: " + httpRequest.getMethod() + " " + httpRequest.getRequestURI());
        
        chain.doFilter(request, response);
        
        System.out.println("Response sent for: " + httpRequest.getRequestURI());
    }
}
