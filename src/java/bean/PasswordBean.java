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
public class PasswordBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public PasswordBean(){
        
    }
    private String currentPass;
    private String newPass;
    private String confirmNewPass;

    public String getConfirmNewPass() {
        return confirmNewPass;
    }

    public void setConfirmNewPass(String confirmNewPass) {
        this.confirmNewPass = confirmNewPass;
    }
    
    public String getCurrentPass() {
        return currentPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
    
    //Update password
    public String updatePassword(){
        User user = SessionUtils.getUser();
        UserBO userBO = new UserBO();
        User newUser = new User();
        
        if (userBO.equalsPasswordForUser(currentPass,Integer.toString(user.getId_User()))) {
            if (userBO.equalsPassword(newPass, confirmNewPass)) {
                if (userBO.validatePassword(newPass)) {
                        newUser.setPassword(userBO.generateHash(newPass));
                        user.setPassword(userBO.generateHash(newPass));
                        if(userBO.updatePassword(user)){
                            return "main"+"?faces-redirect=true";
                        } else{
                            FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Um erro ocorreu no sistema, tente novamente mais tarde",""));
                        }
                } else{
                    FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Nova senha inválida! Pelo menos 4 dígitos com letras maiúsculas, minúsculas e números",""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "As novas senhas informadas são diferentes",""));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "A senha atual informada está errada!",""));
        }
        return "";
    }
}
