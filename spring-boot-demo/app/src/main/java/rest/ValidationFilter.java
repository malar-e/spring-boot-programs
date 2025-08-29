package car.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String param = httpRequest.getRequestURI();
        System.out.println("URI: " + param);
        
        if (!param.contains("/api/users")) {
            throw new ServletException("Invalid URI");
        }
        
        chain.doFilter(request, response);
        System.out.println("Validation filter done");
    }
}
