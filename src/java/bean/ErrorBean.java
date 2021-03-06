/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ErrorBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public ErrorBean(){
        
    }
    
     public String getStatusCode(){
        String val = String.valueOf((Integer)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.status_code"));
        return val;
    }
    public String getMessage(){
        String val =  (String)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.message");
        return val;
    }
    public String getExceptionType(){
        String val = FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.exception_type").toString();
        return val;
    }
 
    public String getException(){
        String val =  (String)((Exception)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.exception")).toString();
        return val;
    }
    
    public String getRequestURI(){
        return (String)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.request_uri");
    }
    public String getServletName(){
        return (String)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.servlet_name");
    }
}
