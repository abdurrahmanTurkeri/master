package library;

import entity.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

public class FacesUtilities {

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();
    }

    public static ServletContext getContext() {
        return (ServletContext) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getContext();

    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getSession(true);

    }

    public static long getRequestParameter(String parameterName, long defaultValue) {
        HttpServletRequest request = getRequest();
        if (request.getParameter(parameterName) != null && !request.getParameter(parameterName).trim().equals("")) {
            return Long.parseLong(request.getParameter(parameterName));
        } else {
            return defaultValue;
        }
    }

    public static String getContextParam(String parameterName, String defaultValue) {
        ServletContext context = getContext();
        if (context.getInitParameter(parameterName) != null && !context.getInitParameter(parameterName).trim().equals("")) {
            return context.getInitParameter(parameterName);
        } else {
            return defaultValue;
        }

    }

    public static String getSessionAtturubute(String key) {
        HttpSession session = FacesUtilities.getSession();
        return (String) session.getAttribute(key);

    }

    public static void setSessionAtturubute(String key, String value) {
        HttpSession session = FacesUtilities.getSession();
        session.setAttribute(key, value);

    }

    public  static String currentDare() {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        Date currentDate = new Date();
        String date = null;
        try {

            date = df.format(currentDate);
        } catch (Exception e) {
        }
        return date;

    }

}
