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
        Menu();
    }
    //validate Menu
    public String Menu(){
        User user = SessionUtils.getUser();
        String menu = "";
        if (user != null) {
             menu =      
                  "<li escape='false' class='active'><a href='main'>Minhas equipes</a></li>"
                  +"<li escape='false' class='active'><a href='teams'>Equipes cadastradas</a></li>"
                  + "<li escape='false' class='active'><a href='about'>Sobre o site</a></li>"
                  + "<li escape='false' ><a href='create_team' class='btn' data-toggle='modal'>CRIAR EQUIPE</a></li>"
                  + "<li escape='false' class='dropdown'>"
                  + "<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Olá,"+user.getNickname()+" <b class='caret'></b></a>"
                     + "<ul class='dropdown-menu'>"
                       + "<li><a href='edit_profile'>Editar perfil</a></li>"
                        + "<li><a href='edit_password.jsp'>Alterar senha</a></li>"
                                + "<li><a href='logout'>Sair</a></li>";
        }else{
          menu = "<a href='main'>Minhas equipes</a>";
        }
        return menu;
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
