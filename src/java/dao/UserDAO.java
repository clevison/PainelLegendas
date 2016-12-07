package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

public class UserDAO implements ILogin{
	 ConnectionMySQL connection = new ConnectionMySQL();
	    
            public boolean insert(User user) throws SQLException {
	        Connection con;
                String permission = "1";
	        try {
	            con = connection.connectionMySQL();
                    String sql = "INSERT INTO user(nickname, email, password, id_perm) VALUES (?,?,?,?)"; 
                    PreparedStatement exe = con.prepareStatement(sql);
                    exe.setString(1,user.getNickname());
                    exe.setString(2,user.getEmail());
                    exe.setString(3,user.getPassword());
                    exe.setString(4,permission);
                    
                    exe.execute();
                    exe.close();
	            return true; 
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }     
            @Override
            public User login(String nickname, String password) throws SQLException {
               Connection con;
               User user = new User();
               try {
                        con = connection.connectionMySQL();
                        String sql = "SELECT * FROM user WHERE nickname = ? AND password = ?";
                        PreparedStatement exe = con.prepareStatement(sql);
                        exe.setString(1, nickname);
                        exe.setString(2, password);
                        
                        ResultSet rs = exe.executeQuery();
                        
                        if (rs.next()) {
                            user.setId_User(Integer.parseInt(rs.getString("id_user")));
                            user.setNickname(rs.getString("nickname"));
                            user.setEmail(rs.getString("email"));
                            user.setPermission(Integer.parseInt(rs.getString("id_perm")));
                            return user;
                        }else{
                            return null;
                        }
                } catch (SQLException e) {
                    throw new SQLException("Erro: " + e.getMessage());
                }
            }
	    
	    public boolean updateEmail(User user) throws SQLException {
                Connection con;
	        try {
                    String sql = "UPDATE user SET Email =? Where id_user=?";
                    con = connection.connectionMySQL();
                    PreparedStatement exe = con.prepareStatement(sql);
                    exe.setString(1, user.getEmail());
                    exe.setInt(2, user.getId_User());
                    exe.execute();
                    exe.close();
	            return true;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }   
	    
	    public boolean updatePassword(User user) throws SQLException {
                Connection con;
	        try {
	             String sql = "UPDATE user SET password =? Where id_user=?";
                        con = connection.connectionMySQL();
                        PreparedStatement exe = con.prepareStatement(sql);
                        exe.setString(1, user.getPassword());
                        exe.setInt(2, user.getId_User());
                        exe.execute();
                        exe.close();
                        return true;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }    
	    
	    public boolean updateNick(User user) throws SQLException {
                Connection con;
	        try {
	             String sql = "UPDATE user SET nickname =? Where id_user=?";
                        con = connection.connectionMySQL();
                        PreparedStatement exe = con.prepareStatement(sql);
                        exe.setString(1, user.getNickname());
                        exe.setInt(2, user.getId_User());
                        exe.execute();
                        exe.close();
                        return true;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }    
	   	    
	    public boolean delete(User user) throws SQLException {
                Connection con;
	        try {
	             String sql = "Delete From user Where id_user=?";
                        con = connection.connectionMySQL();
                        PreparedStatement exe = con.prepareStatement(sql);
                        exe.setInt(1, user.getId_User());
                        exe.execute();
                        exe.close();
                        return true;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    } 
	    
            public ArrayList<User> listUsers() throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
	        ArrayList<User> users = new ArrayList<>();
                String sql = "SELECT * FROM user";
	        try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	User user = new User();
	            	user.setId_User(Integer.parseInt(rs.getString("id_user")));
	            	user.setNickname(rs.getString("nickname"));
	            	user.setEmail(rs.getString("email"));
	            	users.add(user);
	            }
	            return users;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
	    
	    public User SeekForId(int id) throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
                String sql = "SELECT * FROM user where id_usu = ?";
	       try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
                    pstm.setInt(1, id);
	            rs = pstm.executeQuery();
	            User usuario = new User();
	            while (rs.next()) {
	            	usuario.setId_User(Integer.parseInt(rs.getString("id_user")));
	            	usuario.setNickname(rs.getString("nickname"));
	            	usuario.setEmail(rs.getString("email"));	            	 
	            }
	            return usuario;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
            
            public int searchCurrentData(String field, String search) throws SQLException{
	        ResultSet rs;
                int id_user = -1;
	        try {
	            String exe = "select * FROM user WHERE " + field + " = '" + search +"'";
	            PreparedStatement pstm = connection.connectionMySQL().prepareStatement(exe);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
                        id_user = rs.getInt("id_user");
                    }
	            return id_user;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
            
            public String searchData(String field, String search,String dataReturn) throws SQLException{
	        ResultSet rs;
                String data = null;
	        try {
	            String exe = "select * FROM user WHERE " + field + " = '" + search +"'";
	            PreparedStatement pstm = connection.connectionMySQL().prepareStatement(exe);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
                        data = rs.getString(dataReturn);
                    }
	            return data;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
	    
	    public boolean isSeek(String field, String search) throws SQLException {
	        ResultSet rs;
	        try {
	            String exe = "select * FROM user WHERE " + field + " = '" + search +"'";
	            PreparedStatement pstm = connection.connectionMySQL().prepareStatement(exe);
	            rs = pstm.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }

    
  }
