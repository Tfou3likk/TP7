package fr.univ.tours.jakartaee.tp6.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Boolean.TRUE;

@WebFilter(filterName = "SessionFilter", urlPatterns = {"/home", "/marketplace", "/basket"})
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletReq, ServletResponse servletResp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletReq;
        HttpServletResponse resp = (HttpServletResponse) servletResp;
        if(req.getSession(false) == null || !TRUE.equals(req.getSession(false).getAttribute("isLogged"))){
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        filterChain.doFilter(servletReq, servletResp);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
