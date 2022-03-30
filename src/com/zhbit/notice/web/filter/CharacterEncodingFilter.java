package com.zhbit.notice.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig;
	private final String DEFAULTCHARSET = "UTF-8";
	@Override
	public void init(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Character filter...................");
		String charset = filterConfig.getInitParameter("charset");
		if (charset==null)
			charset = DEFAULTCHARSET;
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		response.setCharacterEncoding(charset);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
