package com.epam.web.filter;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Role;
import com.epam.web.entity.User;
import com.epam.web.enums.AdminCommandEnum;
import com.epam.web.exceptions.NoRootsException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RootFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        RequestContextHelper requestHelper=new RequestContextHelper(request);
        RequestContext requestContext=requestHelper.createContext();
        String command= requestContext.getRequestParameter("command");
        User user= (User) requestContext.getSessionAttribute("user");
        AdminCommandEnum[] values = AdminCommandEnum.values();
        for(AdminCommandEnum value:values){
            if(value.getCommand().equals(command)&& user!=null && user.getRole()== Role.USER){
                throw new NoRootsException("You have no roots to do this operation");
            }else if(user==null && value.getCommand().equals(command)){
                throw new NoRootsException("You have no roots to do this operation");
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
