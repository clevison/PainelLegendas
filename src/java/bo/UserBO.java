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
    
    public boolean validateInput(String nickname, String email,  String password){
         return password.trim().length()> 0 && (email.trim().length() > 0 && nickname.trim().length() > 0);
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
    public boolean validatePassword(String password){
        Pattern upper = Pattern.compile("[A-Z]");
        Pattern lower = Pattern.compile("[a-z]");
        Pattern numbers = Pattern.compile("[0-9]");
        return (password.length() >= 4) && upper.matcher(password).find() && lower.matcher(password).find() && numbers.matcher(password).find();
    }; 
    
    private String generateHash(String password) {
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
