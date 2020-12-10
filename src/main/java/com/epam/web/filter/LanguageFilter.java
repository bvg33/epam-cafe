package com.epam.web.filter;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        RequestContextHelper requestHelper=new RequestContextHelper(request);
        RequestContext requestContext=requestHelper.createContext();
        String language= (String) requestContext.getSessionAttribute("local");
        if(language==null){
            requestContext.addSessionAttribute("local","en");
            requestHelper.updateRequest(requestContext);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
