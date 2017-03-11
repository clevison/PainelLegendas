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
public class UserBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public UserBean(){
        
    }
    private String nick;
    private String pass;
    
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
	public Boolean logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return true;
	}
}
