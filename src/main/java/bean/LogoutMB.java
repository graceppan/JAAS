/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author hasee
 */
@Named(value = "logoutMB")
@RequestScoped
public class LogoutMB {

    private static Logger log=Logger.getLogger(LogoutMB.class.getName());
    
    public String logout(){
        String destination="/index?faces-redirect=true";
        FacesContext context=FacesContext.getCurrentInstance();
        HttpServletRequest request=(HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException ex) {
            log.log(Level.SEVERE, "Failed to logout user!", ex);
            destination="/loginError?faces-redirect=true";           
        }
        return destination;
    }
    
}
