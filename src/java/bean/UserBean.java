/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bo.UserBO;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public UserBean(){
        
    }
    private String nick;
    private String pass;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNick() {
        return nick;
    }

    public String getPass() {
        return pass;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    //validate login
    public String login() {
        UserBO userBO  = new UserBO();
        User user = new User();
        user =  userBO.login(nick, pass);
        if (user != null) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("loggedUser", user);
            setEmail(user.getEmail());
            return "main"+"?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "Nickname ou senha incorretos",
                                    "Por favor insira um usário e senha válidos"));
            return "login";
        }
    } 
    //logout event, invalidate session
    public void logout(){
        try {
           ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
           ec.invalidateSession();
           ec.redirect("../index.xhtml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void update(){
        UserBO userBO = new UserBO();
        User user = SessionUtils.getUser();
         
        //New data
        User newUser = new User();
        newUser.setNickname(nick);
        newUser.setEmail(email);
        newUser.setPermission(user.getPermission());
        newUser.setId_User(user.getId_User());
        
        if (userBO.validateInput(nick, email)) {
            updateNickname(newUser, userBO,user);
            updateEmail(newUser, userBO,user);
            
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("loggedUser", newUser);
        }else{
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Um erro inesperado aconteceu",
                        ""));
        }
    }
    private void updateNickname(User newUser, UserBO userBO, User userSession){

        if (userBO.equalData(nick, "nickname", newUser.getId_User())) {
            if(userBO.updateNick(newUser)){
                newUser.setNickname(nick);
            }else{
                newUser.setNickname(userSession.getNickname());
                nick = userSession.getNickname();
            }
           
        }else{
            newUser.setNickname(userSession.getNickname());
            nick = userSession.getNickname();
            FacesContext.getCurrentInstance().addMessage(
                   null,
                   new FacesMessage(FacesMessage.SEVERITY_WARN,
                                   "Nickname incorreto ou já existente",
                           ""));
        }
    }
    
    private void updateEmail(User newUser, UserBO userBO, User userSession){

            if (userBO.equalData(email,"email",newUser.getId_User())) {
                if(userBO.updateEmail(newUser)){
                   newUser.setEmail(email); 
                }else{
                   newUser.setEmail(userSession.getEmail());
                   email = userSession.getEmail(); 
                }
                
            }else{
            newUser.setEmail(userSession.getEmail());
            email = userSession.getEmail();
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Email incorreto ou já existente",
                            ""));
            }
    }
            
}
