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
import model.User;
/**
 *
 * @author clevi
 *//**
 *
 * @author clevi
 */
@WebServlet(name = "main", urlPatterns = {"/main"})
public class main extends HttpServlet {
    private static final long serialVersionUID = 1L;  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Team> teamsList = new ArrayList<>();
        User user = (User)request.getSession(false).getAttribute("user");
        TeamBO teamBO = new TeamBO();
        teamsList = teamBO.listMyTeam(user);
        if (teamsList != null) {
            request.setAttribute("myTeamsList", teamsList);
            RequestDispatcher rs = request.getRequestDispatcher("/pages/main.jsp");
            rs.forward(request, response);
        }else{
            RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Erro ao Listar Equipes&cause=Por favor informe ao nosso suporte pelo email suporte@painellegendas.com");
            rs.forward(request, response);
        }
        
    }
}