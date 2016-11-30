package servlet;

import bo.TeamBO;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.User;


@WebServlet(name = "create_team", urlPatterns = "/create_team")
public class create_team extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                  
            //User user = (User)request.getAttribute("user");
            
            String name = request.getParameter("name");
            String message = request.getParameter("message");
            Part filePart = request.getPart("file");
            String file = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            System.out.println("Nome:" + name);
            System.out.println("mensagem:" + message);
            System.out.println("file:" + file);
           //   System.out.println("user:" +user);
            
            TeamBO teamBO =  new TeamBO();
            if (teamBO.validateInput(name)) {
                if (teamBO.validateName(name)) {
                    if (teamBO.validatePhoto(file)) {
                           /* if(teamBO.insertUser(name, message, file,)){
                                response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
                            }else{
                             RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Ocorreu um erro inesperado&cause=Tente novamente mais tarde. Se o erro persistir Contate um administrador pelo email suporte@painellegendas.com");
                             rs.forward(request, response);
                            }*/
                    }else{
                       response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Photo invalida !&cause=Arquivo muito grande ou nao encontrado");
                    }
                }else{
                    response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Nome invalido !&cause=Equipe ja cadastrada com esse nome");
                }
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
            }
	}
}
