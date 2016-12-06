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
                            user.setPermission(Integer.parseInt(rs.getString("id_perm")));
                            return user;
                        }else{
                            return null;
                        }
                } catch (SQLException e) {
                    throw new SQLException("Erro: " + e.getMessage());
                }
            }
	    
	    public int updateEmail(User usuario) throws SQLException {
	        Statement stmt;
	        try {
	            stmt = connection.connectionMySQL().createStatement();
	            String exe = "UPDATE usuario SET Email = '" + usuario.getEmail() + "'"
	                    + " WHERE id_usu = '" + usuario.getId_User() +"'";
	            stmt.executeUpdate(exe);
	            return 1;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }   
	    
	    public int updateSenha(User usuario) throws SQLException {
	        Statement stmt;
	        try {
	            stmt = connection.connectionMySQL().createStatement();
	            String exe = "UPDATE usuario SET senha = '" + usuario.getPassword() + "'"
	                    + " WHERE id_usu = '" + usuario.getId_User() +"'";
	            stmt.executeUpdate(exe);
	            return 1;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }    
	    
	    public int updateNick(User usuario) throws SQLException {
	        Statement stmt;
	        try {
	            stmt = connection.connectionMySQL().createStatement();
	            String exe = "UPDATE usuario SET nick = '" + usuario.getNickname() + "'"
	                    + " WHERE id_usu = '" + usuario.getId_User() +"'";
            stmt.executeUpdate(exe);
	            return 1;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }    
	   	    
	    public int delete(String nick) throws SQLException {
	        Statement stmt;
	        try {
	            stmt = connection.connectionMySQL().createStatement();
	            String exe = "DELETE FROM usuario  WHERE nick = '" + nick +"'";
	            stmt.executeUpdate(exe);
	            return 1;
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    } 
	    public ArrayList<User> listarUsuarios() throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
	        ArrayList<User> usuarios = new ArrayList<>();
	        try {
	            pstm = connection.connectionMySQL().prepareStatement("SELECT * FROM usuario");
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	User usuario = new User();
	            	usuario.setId_User(Integer.parseInt(rs.getString("id_usu")));
	            	usuario.setNickname(rs.getString("nick"));
	            	usuario.setEmail(rs.getString("email"));
	            	usuarios.add(usuario);
	            }
	            return usuarios;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
	    
	    public User buscarPorId(int id) throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
	       try {
	            pstm = connection.connectionMySQL().prepareStatement("SELECT * FROM usuario where id_usu = " + id);
	            rs = pstm.executeQuery();
	            User usuario = new User();
	            while (rs.next()) {
	            	usuario.setId_User(Integer.parseInt(rs.getString("id_usu")));
	            	usuario.setNickname(rs.getString("nick"));
	            	usuario.setEmail(rs.getString("email"));	            	 
	            }
	            return usuario;
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
