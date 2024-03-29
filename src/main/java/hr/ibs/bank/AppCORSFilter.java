package hr.ibs.bank;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class SimleCORSFilter
 */
@Component
@WebFilter("/SimleCORSFilter")
public class
AppCORSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AppCORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;

		res.setHeader("Access-Control-Allow-Origin", "*");
	    res.setHeader("Content-Type", "application/json");
	    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
	    res.setHeader("Access-Control-Max-Age", "3600");	    
	    res.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, content-type");
	    res.setHeader("Accept", "*/*");
	    
	    chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
