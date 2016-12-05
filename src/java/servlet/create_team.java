package servlet;

import bo.TeamBO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet(name = "create_team", urlPatterns = "/create_team")
public class create_team extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            User user = (User)request.getAttribute("user");
            System.out.println("user:" +user);
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            String name="";
            String message="";
            try {
                List<FileItem> formItems = upload.parseRequest(request);
                for (FileItem item : formItems) {
                    String fieldname = item.getFieldName();
                    String fieldvalue = item.getString();
                    switch (fieldname) {
                        case "name":
                            name = fieldvalue;
                            break;
                        case "message":
                            message = fieldvalue;
                            break;
                    }
                }
            }catch(FileUploadException ex) {
                RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Ocorreu um erro inesperado&cause=Tente novamente mais tarde. Se o erro persistir Contate um administrador pelo email suporte@painellegendas.com");
                rs.forward(request, response);
            }
            
            
            
            //Get path the application
            ServletContext servletContext = getServletContext();
            String contextPath = servletContext.getRealPath(File.separator);
            TeamBO teamBO =  new TeamBO();
            
            if (teamBO.validateServlet(request)) {
                if (teamBO.validateInput(name)){
                    if (teamBO.validateName(name)){
                        String pathImage = teamBO.uploadImage(request,contextPath);
                        if( pathImage != null){
                             // if(teamBO.insertUser(name, message, pathImage,)){
                                    response.sendRedirect(request.getContextPath()+"/pages/main.jsp");
                              /*}else{
                                 RequestDispatcher rs = request.getRequestDispatcher("/pages/error.jsp?message=Ocorreu um erro inesperado&cause=Tente novamente mais tarde. Se o erro persistir Contate um administrador pelo email suporte@painellegendas.com");
				 rs.forward(request, response);
                            }*/
                               System.out.println("Validou Tudo sadsadsadsa");
                        }else{
                            response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Upload falhou !&cause=Nao foi possivel upar o arquivo, ou o extensao invalida");
                        }
                    }else{
                        response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Nome invalido !&cause=Equipe ja cadastrada com esse nome");
                    }
                }else{
                    response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
                }
             }else{
                    response.sendRedirect(request.getContextPath()+"/pages/create_team.jsp?message=Dados invalidos !&cause=Este servlet lida apenas com pedido de upload");
            }
            
            
    }
}
