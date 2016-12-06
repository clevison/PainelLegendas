package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Team;

public class TeamDAO{
	 ConnectionMySQL connection = new ConnectionMySQL();
	    
	 	public boolean insert(Team team) throws SQLException {
	        Connection con;
                int permission =1;
	        try {
	            con = connection.connectionMySQL();
                    String sql = "INSERT INTO team(name, message, photo, admim) VALUES(?,?,?,?)";
	            PreparedStatement exe = con.prepareStatement(sql);
                    exe.setString(1, team.getName());
                    exe.setString(2, team.getMessage());
                    exe.setString(3, team.getPhoto());
                    exe.setInt(4, team.getAdmim().getId_User());
                    exe.execute();
                    exe.close();
	            return true; 
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }      
                
	    public boolean isSeek(String field, String search) throws SQLException {
	        ResultSet rs;
	        try {
	            String exe = "select * FROM team WHERE " + field + " = '" + search +"'";
	            PreparedStatement pstm = connection.connectionMySQL().prepareStatement(exe);
	            rs = pstm.executeQuery();
	            return rs.next();
	        } catch (SQLException e) {
	            throw new SQLException("Erro: " + e.getMessage());
	        }
	    }

    
  }
