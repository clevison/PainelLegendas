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
                    String sql = "INSERT INTO team(name, photo, admim) VALUES(?,?,?)";
	            PreparedStatement exe = con.prepareStatement(sql);
                    exe.setString(1, team.getName());
                    exe.setString(2, team.getPhoto());
                    exe.setInt(3, team.getAdmim());
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
            public ArrayList<Team> listTeams() throws SQLException{
	        ResultSet rs;
	        PreparedStatement pstm;
	        ArrayList<Team> teams = new ArrayList<>();
                String sql = "SELECT * from team";
	        try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	Team team = new Team();
	            	team.setId_Team(Integer.parseInt(rs.getString("id_team")));
	            	team.setName(rs.getString("name"));
	            	team.setPhoto(rs.getString("photo"));
                        team.setAdmim(Integer.parseInt(rs.getString("admim")));
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
                String sql = "SELECT  t.id_team, t.name, t.photo, t.admim, u.id_user, u.nickname\n" +
                    "FROM user u, team t\n" +
                    "Where t.admim = u.id_user\n" +
                    "and u.id_user = " +  user.getId_User() +
                    "\n" +
                    "UNION\n" +
                    "SELECT  t.id_team, t.name, t.photo, t.admim, u.id_user, u.nickname\n" +
                    "FROM user u, team t, team_user tu\n" +
                    "WHERE u.id_user = tu.id_user AND t.id_team = tu.id_team\n" +
                    "\n" +
                    "and u.id_user = " + user.getId_User();
                System.out.println(sql);
	        try {
	            pstm = connection.connectionMySQL().prepareStatement(sql);
	            rs = pstm.executeQuery();
	            while (rs.next()) {
	            	Team team = new Team();
	            	team.setId_Team(Integer.parseInt(rs.getString("id_team")));
	            	team.setName(rs.getString("name"));
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
