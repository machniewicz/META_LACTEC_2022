package br.com.nmcz.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (res.getHeader("Origin") != null) {
			
			res.setHeader("Access-Control-Allow-Credentials", "true");
			
			res.setHeader("Acess-Control-Allow-Origin", req.getHeader("Origin"));
			
			res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
			
			res.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
		
		}
		
		if (req.getMethod().equals("OPTIONS")) {
			
			res.getWriter().print("OK");
			
			res.getWriter().flush();
			
			return;
		}
		
		chain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
}
