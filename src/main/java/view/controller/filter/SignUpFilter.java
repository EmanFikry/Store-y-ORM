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
import view.util.user.Validation;

/**
 *
 * @author Eman-PC
 */
public class SignUpFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestType = httpServletRequest.getMethod();
        if (requestType.equals("POST")) {
            Validation validate = new Validation();
            String name = request.getParameter("uname");
            String birthday = request.getParameter("ubd");
            String email = request.getParameter("uemail");
            String password = request.getParameter("upassword");
            String confirmPassword = request.getParameter("uconfirmPassword");
            String creditLimit = request.getParameter("ucreditLimit");
            String address = request.getParameter("uaddress");

            boolean validData = true;
            if (!validate.validateName(name)) {
                request.getServletContext().setAttribute("invalidName", "Wrong Format");
                validData = false;
            }
            if (!validate.validateAddress(address)) {
                request.getServletContext().setAttribute("invalidAddress", "Wrong Format");
                validData = false;
            }
            if (!validate.validateEmail(email)) {
                request.getServletContext().setAttribute("invalidEmail", "Wrong Format");
                validData = false;
            }
            if (!validate.validateDate(birthday)) {
                request.getServletContext().setAttribute("invalidDate", "Enter date before '2000-02-28'");
                validData = false;
            }
            if (!validate.validatePassword(password, confirmPassword)) {
                request.getServletContext().setAttribute("invalidPassword", "Passwords do not match");
                validData = false;
            }
            if (!validate.validateCreditLimit(creditLimit)) {
                request.getServletContext().setAttribute("invalidCreditLimit", "Enter number greater than 0");
                validData = false;
            }
            if (validData) {
                filterChain.doFilter(request, response);
            } else {
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                httpServletResponse.sendRedirect(httpServletRequest.getScheme() + "://"
                        + httpServletRequest.getServerName() + ":" + request.getServerPort()
                        + httpServletRequest.getContextPath() + "/home.jsp");

            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
