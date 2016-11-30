package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Team;
import model.User;

public class TeamDAO{
	 ConnectionMySQL connection = new ConnectionMySQL();
	    
	 	public int insert(Team team) throws SQLException {
	        Connection con;
                int permission =1;
	        try {
	            con = connection.connectionMySQL();
	            PreparedStatement exe = con.prepareStatement("INSERT INTO team(name, message, photo, admim) VALUES ('" + team.getName() + "', '" 
                    + team.getMessage()+ "', '" + team.getPhoto() + "', '" + team.getAdmim().getId_User() + "')");
	            int performed = exe.executeUpdate();
	            return performed; 
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
