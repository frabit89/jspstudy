package com.gdu.prj.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;


public class BoardFilter extends HttpFilter implements Filter {
       

    public BoardFilter() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	  
	  // HttpServletRequest / HttpServletResponse
	  HttpServletRequest req = (HttpServletRequest) request;
	  HttpServletResponse res = (HttpServletResponse) response;
	  
	  // 요청 UTF-8 인코딩
	  req.setCharacterEncoding("UTF-8");
	  
	  // 요청 방식 확인 + 요청 주소 확인
	  System.out.print(String.format("%-4s", req.getMethod()));
	  System.out.print(" | ");
	  System.out.println(req.getRequestURI());
	  
	  // 요청 파라미터 확인
	  Map<String, String[]> params = req.getParameterMap();
	  for(Map.Entry<String, String[]> param : params.entrySet()) {
	    System.out.print(String.format("%-4s", " "));
	    System.out.print(String.format("%-10s", param.getKey()) + ":");
	    System.out.print(Arrays.toString(param.getValue()));
	  }
	  
	  
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
