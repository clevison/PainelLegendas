/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import bean.SessionUtils;
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
import model.User;

/**
 *
 * @author clevi
 */
@WebFilter("/faces/pages/*")
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
        
        HttpServletRequest req = (HttpServletRequest) request;
		
        String url = req.getRequestURI();

        HttpSession sessao = req.getSession();
        
        if (req.getRequestURI().equals("/PainelLegendas/faces/pages/login.xhtml") || req.getRequestURI().equals("/PainelLegendas/faces/pages/register.xhtml")) {
            if (sessao.getAttribute("loggedUser") != null) {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/faces/pages/main.xhtml");
            } else {
                chain.doFilter(request, response); 
            }
        } else {
            if (sessao.getAttribute("loggedUser") != null) {
                chain.doFilter(request, response);
            } else {
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath() + "/faces/pages/login.xhtml");
            }
        }
    }
}