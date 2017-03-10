/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bo.UserBO;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.User;
import java.io.Serializable;

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
	public String Login() {
		UserBO userBO  = new UserBO();
                User user = new User();
                user =  userBO.login(nick, pass);
                System.err.println(user.getNickname());
		if (user != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("loggedUser", user);
			return "Logged";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username or Passowrd",
							"Please enter correct username and Password"));
			return "NotLogged";
		}
        } 
        //logout event, invalidate session
	public Boolean logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return true;
	}
}
