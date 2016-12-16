package servlet;

import bo.UserBO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;


@WebServlet(name = "edit_password", urlPatterns = "/edit_password")
public class edit_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //Atual user
            User user = (User)request.getSession(false).getAttribute("user");     
           
            String lastPassword = request.getParameter("lastPassword");
            String password = request.getParameter("password");
             UserBO userBO = new UserBO();
             
            if (userBO.validateInput(password, lastPassword)) {
                 if (userBO.equalsPassword(lastPassword,Integer.toString(user.getId_User()))) {
                    if (userBO.validatePassword(password)) {
                        user.setPassword(userBO.generateHash(password));
                        userBO.UpdatePassword(user);
                        response.sendRedirect(request.getContextPath()+"/main");
                    }else{
                         response.sendRedirect(request.getContextPath()+"/pages/edit_password.jsp?message=Senha invalida !&cause=Pelo menos 4 digitos, letras maiusculas e minusculas e numeros");
                    }  
                }else{
                    response.sendRedirect(request.getContextPath()+"/pages/edit_password.jsp?message=Senha invalida !&cause=Senha nao corresponde a senha do usuario");
                }   
            }else{
                response.sendRedirect(request.getContextPath()+"/pages/edit_password.jsp?message=Dados invalidos !&cause=Os Dados nao podem ser vazios");
            }
	}
      
}