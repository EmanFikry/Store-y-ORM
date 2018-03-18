/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller.filter;

import controller.DAODelegate.DAOService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dataAccessLayer.entity.ItiStoreYUser;

/**
 *
 * @author Eman-PC
 */
public class SignInFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestType = httpServletRequest.getMethod();
        if (requestType.equals("POST")) {

            String email = request.getParameter("loginemail");
            String password = request.getParameter("loginpas");

            if (email.equals("admin@hotmail.com")) {
                if (password.equals("admin1234")) {
                    httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                            + httpServletRequest.getServerName() + ":" + request.getServerPort()
                            + httpServletRequest.getContextPath() + "/adminHome.jsp");
                    httpServletRequest.getServletContext().setAttribute("role", "admin");
                } else {
                    request.getServletContext().setAttribute("loginInvalidPassword", "wrong password");
                    httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                            + httpServletRequest.getServerName() + ":" + request.getServerPort()
                            + httpServletRequest.getContextPath() + "/home.jsp");
                }
            } else {
                //check if user exists in db or not
                DAOService daoService = new DAOService();
                ItiStoreYUser user = daoService.checkLogin(email, password);
                if (user == null) {
                    boolean isExisted = daoService.isEmailExist(email);
                    if (isExisted) {
                        request.getServletContext().setAttribute("loginInvalidPassword", "wrong password");
                    } else {
                        request.getServletContext().setAttribute("loginInvalidEmail", "Email does not exist");
                    }
                    httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                            + httpServletRequest.getServerName() + ":" + request.getServerPort()
                            + httpServletRequest.getContextPath() + "/home.jsp");
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
