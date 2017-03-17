/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.User;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public MenuBean(){
    }
    //validate Menu
    public boolean isUserLogged(){
        User user = SessionUtils.getUser();
        return user != null;
    } 
    public String linkImagem() {
        User user = SessionUtils.getUser();
        String link = "";  
        if (user != null) {
            link = "/faces/index.xhtml";
        }else{
            link = "/faces/pages/main.xhtml";
        }
        return link;
    }
}
