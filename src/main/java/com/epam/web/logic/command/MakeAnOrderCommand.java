package com.epam.web.logic.command;

import com.epam.web.context.RequestContext;
import com.epam.web.context.RequestContextHelper;
import com.epam.web.entity.Bucket;
import com.epam.web.entity.Order;
import com.epam.web.entity.User;
import com.epam.web.enums.OrderStateEnum;
import com.epam.web.enums.OrderTypeEnum;
import com.epam.web.exceptions.DaoException;
import com.epam.web.exceptions.ServiceException;
import com.epam.web.logic.service.MakeAnOrderService;
import com.epam.web.logic.validator.CVCValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class MakeAnOrderCommand implements Command {
    private final MakeAnOrderService service;
    private static final String PAGE="WEB-INF/view/bucket.jsp";
    private static final String ERROR_PAGE="command=goToBucket&error=true";
    public MakeAnOrderCommand(MakeAnOrderService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(RequestContextHelper helper, HttpServletResponse response) throws DaoException, ServiceException {
        RequestContext context=helper.createContext();
        String ids[]=helper.getRequest().getParameterValues("dishId");
        String counts[]=helper.getRequest().getParameterValues("count");
        String price=context.getRequestParameter("price");
        String time=context.getRequestParameter("issue-time");
        String typeString=context.getRequestParameter("cash");
        String cvc=context.getRequestParameter("cvc");
        if(!service.isValidCVC(cvc,new CVCValidator())){
            return CommandResult.redirect(ERROR_PAGE);
        }
        OrderTypeEnum type=OrderTypeEnum.valueOf(typeString.toUpperCase());
        int nextOrderNumber=service.createNextOrderNumber();
        Order order=createOrder(price,time,context,type);
        ArrayList<Bucket>buckets=createBuckets(ids,counts,nextOrderNumber);
        service.takeOrder(buckets,order);
        context.removeSessionAttribute("bucket");
        helper.updateRequest(context);
        return CommandResult.forward(PAGE);
    }

    private Order createOrder(String price,String time,RequestContext context,OrderTypeEnum type){
        User user= (User) context.getSessionAttribute("user");
        int userId=user.getId();
        return new Order(0,price,type,OrderStateEnum.ACCEPT,time,userId);
    }

    private ArrayList<Bucket> createBuckets(String ids[],String counts[],int orderNumber){
        ArrayList<Bucket>arrayList=new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            int intId=Integer.valueOf(ids[i]);
            int intCount=Integer.valueOf(counts[i]);
            Bucket bucket=new Bucket(0,intId,orderNumber,intCount);
            arrayList.add(bucket);
        }
        return arrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeAnOrderCommand that = (MakeAnOrderCommand) o;
        return Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service);
    }
}
