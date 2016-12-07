/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bo;

import dao.UserDAO;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.regex.Pattern;
import model.User;

/**
 *
 * @author clevi
 */
public class UserBO{
    //Insert AREA
    public boolean insertUser(String nickname, String email,  String password){       
        
        try {
           User user = new User();
           user.setNickname(nickname);
           user.setEmail(email);
           user.setPassword(generateHash(password));

            UserDAO uDAO = new UserDAO();
            uDAO.insert(user);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }           
    }
   //Update AREA
    public boolean UpdateEmail(User user){       
        try {
            UserDAO uDAO = new UserDAO();
            return uDAO.updateEmail(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }           
    }
   
    public boolean UpdateNick(User user){       
        try {
            UserDAO uDAO = new UserDAO();
            return uDAO.updateNick(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }           
    }
    
    public boolean UpdatePassword(User user){       
        try {
            UserDAO uDAO = new UserDAO();
            return uDAO.updatePassword(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }           
    }
    //Validation AREA
    public boolean validateInput(String nickname, String email,  String password){
         return password.trim().length()> 0 && (email.trim().length() > 0 && nickname.trim().length() > 0);
    }; 
    
    public boolean validateInput(String nickname, String email){
         return (email.trim().length() > 0 && nickname.trim().length() > 0);
    }; 
    
    public boolean validateNickname(String nickname){
        UserDAO userDAO = new UserDAO();
        try{
           return !userDAO.isSeek("nickname", nickname);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             return false;
         }       
    }; 
    
     public boolean validateEmail(String email){
        UserDAO userDAO = new UserDAO();
        try{
           return !userDAO.isSeek("email", email);
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
             return false;
        }       
    };
     
    public boolean EqualData(String newData, String field,int actualId){
        UserDAO userDAO = new UserDAO();
        try{
            int returnId = userDAO.searchCurrentData(field, newData);
            if (returnId == -1) {
                return true;
            }
            if (returnId == actualId) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
             return false;
         }       
    }; 
    
    public boolean validatePassword(String password){
        Pattern upper = Pattern.compile("[A-Z]");
        Pattern lower = Pattern.compile("[a-z]");
        Pattern numbers = Pattern.compile("[0-9]");
        return (password.length() >= 4) && upper.matcher(password).find() && lower.matcher(password).find() && numbers.matcher(password).find();
    }; 
    
    public boolean equalsPassword(String password, String id_user){
        UserDAO uDAO = new UserDAO();
        String databasePass;
        try{
            databasePass = uDAO.searchData("id_user", id_user,"password");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return databasePass.equals(generateHash(password));
    }; 
    
    //Others
    public String generateHash(String password) {
        try{
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte messageDigest[] = algorithm.digest(password.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
              hexString.append(String.format("%02X", 0xFF & b));
            }
            return hexString.toString();
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
            return null;
        }       
    }; 

    public User login(String nickname, String password){
        UserDAO userDao = new UserDAO();
        try{
            return userDao.login(nickname, generateHash(password));
        }catch(SQLException ex){
            return null;
        }
    }
}