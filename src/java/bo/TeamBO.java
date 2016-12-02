/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import dao.TeamDAO;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.imageio.ImageIO;
import static javax.imageio.ImageIO.getCacheDirectory;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;
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
         return "png".equals(FilenameUtils.getExtension(photo)) || "jpg".equals(FilenameUtils.getExtension(photo).toLowerCase());
    }; 
    public String uploadImage(HttpServletRequest request,String Parentpath){
            
            File path = new File(Parentpath);
            FileItemFactory itemfactory = new DiskFileItemFactory(); 
            ServletFileUpload upload = new ServletFileUpload(itemfactory);
            try{
                    List<FileItem>  items = upload.parseRequest(request);
                    String pathImage = path.getParentFile().getParentFile()+ "\\web\\upload\\images_teams";
                    
                    for(FileItem item:items){
                    if (item.getName() != null) {
                        if(validatePhoto(item.getName())){
                            File uploadDir = new File(pathImage);
                            File file = File.createTempFile("img",".png",uploadDir);
                            item.write(file);
                        }else{
                            return null;
                        }
                    }
                }
                return pathImage;
            }
            catch(FileUploadException e){
                 System.out.println("Error: " + e.getMessage());
                 return null;
            }
            catch(Exception ex){
                 System.out.println("Error: " + ex.getMessage() + " csaca :" + ex.getCause());
                 return null;
            }
    }
    public boolean validateServlet(HttpServletRequest request){
         return ServletFileUpload.isMultipartContent(request);
    }
}
