package com.ssafy.happyhouse.controller;

import java.io.IOException;

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

@WebFilter("/*")
public class LoginFilter implements Filter {

   @Override
   public void destroy() {
      // TODO Auto-generated method stub

   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
         throws IOException, ServletException {
      HttpServletRequest httpServletRequest = (HttpServletRequest) req;
      HttpServletResponse httpServletResponse = (HttpServletResponse) res;
      req.setCharacterEncoding("utf-8"); 
      String path = httpServletRequest.getRequestURI();
      String action = httpServletRequest.getParameter("action");

      System.out.println("doFilter path : " + path);
      System.out.println("action : " + action);

      HttpSession session = httpServletRequest.getSession();

      if (!path.contains("index.jsp") && !"MEMBERREG".equals(action) && !path.contains("join.jsp") && 
            !path.contains(".gif") && !path.contains(".bmp") 
            && !(path.contains("membermain.do") && "LOGIN".equals(action))
             && !(path.contains("membermain.do") && "JOIN".equals(action))
             && !(path.contains("membermain.do") && "FINDPWD".equals(action))
             && !path.contains("assets") && !path.contains("css") && !path.contains("scripts.js")
             && !path.contains("GoogleMapServlet")
             && !path.contains("FSelectBoxController")) {
         String uid = (String) session.getAttribute("uid");
         if (uid == null) {
            httpServletResponse.sendRedirect("index.jsp");
            return;
         }
      }

      chain.doFilter(req, res);
   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
      // TODO Auto-generated method stub

   }

}

