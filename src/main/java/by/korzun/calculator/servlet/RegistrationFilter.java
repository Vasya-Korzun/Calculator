package by.korzun.calculator.servlet;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RegistrationFilter implements Filter {

    private FilterConfig config;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter run");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Optional<Cookie> userCookie = cookies.stream()
                .filter(cookie -> cookie.getName().equalsIgnoreCase("Uaser"))
                .findFirst();
        if (userCookie.isPresent() && userCookie.get().getValue().equalsIgnoreCase("true")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void destroy() {
        config = null;
    }
}
