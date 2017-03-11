/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bo.UserBO;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RegisterBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public RegisterBean(){
        
    }
    private String nick;
    private String email;
    private String pass;
    private String confirmPass;
    
    
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

    public String getEmail() {
        return email;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }
    
    //validate Register
    public String register() {
        UserBO userBO = new UserBO();
        if (userBO.equalsPassword(pass, confirmPass)) {
            if (userBO.validateInput(nick, email, pass)) {
                if (userBO.validatePassword(pass)) {
                    if (userBO.validateNickname(nick)) {
                        if (userBO.validateEmail(email)) {

                                if(userBO.insertUser(nick, email, pass)){
                                   return "login"+"?faces-redirect=true";
                                }else{
                                 FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Um erro ocorreu no sistema, tente novamente mais tarde",""));
                                return "register";
                            }
                        }else{
                            FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Email inválido ou já existente",""));
                            return "register";
                        }
                    }else{
                       FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Nickname inválido ou já existente",""));
                        return "register";
                    }
                }else{
                   FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Senha inválida, Pelo menos 4 digitos com Letras maiúsculas, minúsculas e números",""));
                    return "register";
                }
            }else{
               FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Dados inválidos",""));
                return "register";
            }
        }else{
               FacesContext.getCurrentInstance().addMessage(
                                        null,
                                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                                        "Senhas diferentes",""));
                return "register";
            }
            
    } 
}
