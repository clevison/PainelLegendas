package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Team;
import model.User;

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
                    exe.setInt(4, team.getAdmim());
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
            public ArrayList<Team> listTeams(User user) throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
                UserDAO userDAO = null;
	        ArrayList<Team> teams = new ArrayList<>();
                String sql = "SELECT team.id_team, team.name, team.message, team.photo, team.admim,team_user.id_user " +
                "FROM team LEFT JOIN team_user " +
                "ON team.id_team = team_user.id_team_user " +
                "WHERE team_user.id_user != "+ user.getId_User() +" OR team_user.id_user IS NULL";
	        try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	Team team = new Team();
	            	team.setId_Team(Integer.parseInt(rs.getString("id_team")));
	            	team.setName(rs.getString("name"));
                        team.setMessage(rs.getString("message"));
	            	team.setPhoto(rs.getString("photo"));
                        team.setAdmim(Integer.parseInt(rs.getString("id_team")));
	            	teams.add(team);
	            }
	            return teams;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
            public ArrayList<Team> listMyTeams(User user) throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
                UserDAO userDAO = null;
	        ArrayList<Team> teams = new ArrayList<>();
                String sql = "SELECT team.id_team, team.name, team.message, team.photo, team.admim,team_user.id_user " +
                             "FROM team INNER JOIN team_user " +
                             "ON team.id_team = team_user.id_team_user " +
                             "WHERE team_user.id_user =" + user.getId_User();
	        try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	Team team = new Team();
	            	team.setId_Team(Integer.parseInt(rs.getString("id_team")));
	            	team.setName(rs.getString("name"));
                        team.setMessage(rs.getString("message"));
	            	team.setPhoto(rs.getString("photo"));
                        team.setAdmim(Integer.parseInt(rs.getString("id_team")));
	            	teams.add(team);
	            }
	            return teams;
	        } catch (SQLException e) {
	        	throw new SQLException("Erro: " + e.getMessage());
	        }
	    }
  }
