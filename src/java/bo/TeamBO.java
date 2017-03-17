/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import dao.TeamDAO;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.Team;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author clevi
 */
public class TeamBO{
    //Crud AREA
    public boolean insertTeam(String name, String photo, int user){       
        
        try {
           Team team = new Team();
           team.setName(name);
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
    //END Crud AREA
    
    //Validate AREA
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
         return "png".equals(FilenameUtils.getExtension(photo)) || "jpg".equals(FilenameUtils.getExtension(photo).toLowerCase());
    };
    
     public boolean validateServlet(HttpServletRequest request){
         return ServletFileUpload.isMultipartContent(request);
    }
    //END Validate AREA
    
    //Others AREA
    public ArrayList<Team> listTeam(){
        TeamDAO teamDAO =  new TeamDAO();
         try {
              return teamDAO.listTeams();
         } catch (SQLException e) {
             System.out.println(e.getMessage());
             return null;
         }
    }
    public ArrayList<Team> listMyTeam(User user){
        TeamDAO teamDAO =  new TeamDAO();
         try {
              return teamDAO.listMyTeams(user);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
             return null;
         }
    }
    //END Others AREA
}