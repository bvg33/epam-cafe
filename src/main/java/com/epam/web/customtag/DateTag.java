package com.epam.web.customtag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
@SuppressWarnings("serial")
public class DateTag extends TagSupport {
    private String date;
    private static final int DELETED_SYMBOLS=5;

    public DateTag() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int doStartTag() throws JspException {
        String result = date;
        HttpServletRequest request= (HttpServletRequest) this.pageContext.getRequest();
        if(request.getSession().getAttribute("local").equals("en")==false) {
            result = date.replaceAll("-", ".");
        }
        result=result.substring(0,result.length()-DELETED_SYMBOLS);
        try {
            pageContext.getOut().write(result);
        } catch (IOException e) {
            throw new JspException("Tag exception");
        }
        return SKIP_BODY;
    }
}
