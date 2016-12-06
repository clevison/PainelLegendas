/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clevi
 */
@WebFilter("/pages/*")
public class FilterLogin implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public FilterLogin() {
    }    
    public void destroy(){
    }
    public void init(FilterConfig fConfig){
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
        String url = httpServletRequest.getRequestURI();

        HttpSession sessao = httpServletRequest.getSession();

        if (sessao.getAttribute("user") != null || url.lastIndexOf("login.jsp")>-1 || url.lastIndexOf("register.jsp")>-1){
               chain.doFilter(request, response); 
        }else{
             ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath()+"/pages/login.jsp");
        }
    }
}