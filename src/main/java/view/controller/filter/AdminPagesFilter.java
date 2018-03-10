/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eman-PC
 */
public class AdminPagesFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getServletContext().getAttribute("role") != null) {
            String role = (String) httpServletRequest.getServletContext().getAttribute("role");
            if (!role.isEmpty() && role.equals("admin")) {
                filterChain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                        + httpServletRequest.getServerName() + ":" + request.getServerPort()
                        + httpServletRequest.getContextPath() + "/home.jsp");
            }
        } else {
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                    + httpServletRequest.getServerName() + ":" + request.getServerPort()
                    + httpServletRequest.getContextPath() + "/home.jsp");
        }
    }

    @Override
    public void destroy() {
    }

}
