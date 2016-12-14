/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import bo.TeamBO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Team;
/**
 *
 * @author clevi
 *//**
 *
 * @author clevi
 */
@WebServlet(name = "teams", urlPatterns = {"/teams"})
public class teams extends HttpServlet {
    private static final long serialVersionUID = 1L;  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Team> teamsList = new ArrayList<>();
        TeamBO teamBO = new TeamBO();
        teamsList = teamBO.listTeam();
        request.setAttribute("teamsList", teamsList);
        RequestDispatcher rs = request.getRequestDispatcher("/pages/teams.jsp");
        rs.forward(request, response);
    }
}