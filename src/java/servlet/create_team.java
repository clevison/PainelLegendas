package servlet;

import bo.TeamBO;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;


@WebServlet(name = "create_team", urlPatterns = "/create_team")
public class create_team extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            //User user = (User)request.getAttribute("user");
           
            TeamBO teamBO =  new TeamBO();
            ServletContext servletContext = getServletContext();
            String contextPath = servletContext.getRealPath(File.separator);
            Map<String,String> items = teamBO.uploadImage(request,contextPath);
            User user = (User)request.getSession(false).getAttribute("user");
            
            if (items == null) {
                response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Upload falhou !&cause=Nao foi possivel upar o arquivo, ou o extensao invalida");
            } else {
                
                 String name = items.get("name");
                 String message = items.get("message");
                 String pathImage = items.get("path");
                 
                if (teamBO.validateServlet(request)) {
                    if (teamBO.validateInput(name)){
                        if (teamBO.validateName(name)){
                            if( pathImage != null){
                                if(teamBO.insertTeam(name, message,pathImage,user)){
                                    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
                                }else{
                                    removeImage(pathImage);
                                    RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Ocorreu um erro inesperado&cause=Tente novamente mais tarde. Se o erro persistir Contate um administrador pelo email suporte@painellegendas.com");
                                    rs.forward(request, response);
                                }
                            }else{
                                removeImage(pathImage);
                                response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Upload falhou !&cause=Nao foi possivel upar o arquivo, ou o extensao invalida");
                            }
                        }else{
                            removeImage(pathImage);
                            response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Nome invalido !&cause=Equipe ja cadastrada com esse nome");
                        }
                    }else{
                        removeImage(pathImage);
                        response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
                    }
                }else{
                    removeImage(pathImage);
                    response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Dados invalidos !&cause=Este servlet lida apenas com pedido de upload");
                }
            }
    }
    public void removeImage(String path){
        try{
             File file  = new File(path);
             file.delete();
        }catch(Exception ex){
           System.out.println(ex.toString());
        }
    }
}
