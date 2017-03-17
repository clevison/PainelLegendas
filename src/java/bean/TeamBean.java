/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bo.TeamBO;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import model.Team;
import model.User;

@ManagedBean
@SessionScoped
public class TeamBean implements Serializable{
    /**
     * Creates a new instance of UserBean
     */
    public TeamBean(){
        
    }
    public ArrayList<Team> listAllTeams(){
        ArrayList<Team> teamsList = new ArrayList<>();
        TeamBO teamBO = new TeamBO();
        teamsList = teamBO.listTeam();
        return  teamsList;
    } 
     public ArrayList<Team> listMyTeams(){
        User user = SessionUtils.getUser();
        ArrayList<Team> teamsList = new ArrayList<>();
        TeamBO teamBO = new TeamBO();
        teamsList = teamBO.listMyTeam(user);
        return  teamsList;
    } 
}
