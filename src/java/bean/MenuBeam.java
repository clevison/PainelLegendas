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
public class MenuBeam implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public MenuBeam(){
    }
    //validate Menu
    public boolean isUserLogged(){
        User user = SessionUtils.getUser();
        return user != null;
    } 
    public String LinkImagem() {
        User user = SessionUtils.getUser();
        String link = "";  
        if (user != null) {
            link = "index";
        }else{
            link = "main";
        }
        return link;
    }
}
