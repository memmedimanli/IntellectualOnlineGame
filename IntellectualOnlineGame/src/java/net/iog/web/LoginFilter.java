/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iog.web;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author memmedimanli
 */
public class LoginFilter implements Filter {
    
  
    private FilterConfig filterConfig = null;
    
 
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
             
  
        Throwable problem = null;
        try {
            
            if(session.getAttribute("user")!=null && session.getAttribute("loginTime") != null)
            {
                System.out.println("User " + session.getAttribute("user")  + " is logged in, continue processing.");
                chain.doFilter(request, response);
            }else
            {
                System.out.println("User is not logged in, redirect to welcome page.");
                res.sendRedirect("welcome.jsp");
            }
            
        } catch (Throwable t) {
           
            problem = t;
            t.printStackTrace();
        }

    
    }

    
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

   
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

   
    public void destroy() {        
    }

    
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        
        }
    }

   