/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import dao.TeamDAO;
import java.sql.SQLException;
import model.Team;
import model.User;

/**
 *
 * @author clevi
 */
public class TeamBO{
     public boolean insertTeam(String name, String message,  String photo, User user){       
        
        try {
           Team team = new Team();
           team.setName(name);
           team.setMessage(message);
           team.setPhoto(photo);
           team.setAdmim(user);
           
           TeamDAO tDAO = new TeamDAO();
           tDAO.insert(team);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }           
    }
    
    public boolean validateInput(String name){
         return name.trim().length()> 0;
    }; 
    public boolean validateName(String name){
        TeamDAO tDAO = new TeamDAO();
        try{
           return !tDAO.isSeek("name", name);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             return false;
         }       
    }; 
    public boolean validatePhoto(String photo){
        try{
            return true;
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
             return false;
        }       
    }; 
}
