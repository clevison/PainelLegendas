<%@page import="java.io.File"%>
<%@page import="model.User"%>
<%
        User user = (User)session.getAttribute("user");
        String menu;
        String path = getServletContext().getContextPath();
        String link;
        if(user != null){
             link = path+"/main";
             menu = "<li class='active'><a href='"+path+"/main'>Minhas equipes</a></li>"
                  +"<li class='active'><a href='"+path+"/teams'>Equipes cadastradas</a></li>"
                  + "<li class='active'><a href='"+path+"/about.jsp'>Sobre o site</a></li>"
                  + "<li><a href='"+path+"/pages/create_team.jsp' class='btn' data-toggle='modal'>CRIAR EQUIPE</a></li>"
                  + "<li class='dropdown'>"
                  + "<a href='#' class='dropdown-toggle' data-toggle='dropdown'>Olá,"+user.getNickname()+" <b class='caret'></b></a>"
                     + "<ul class='dropdown-menu'>"
                       + "<li><a href='"+path+"/pages/edit_profile.jsp'>Editar perfil</a></li>"
                        + "<li><a href='"+path+"/pages/edit_password.jsp'>Alterar senha</a></li>"
                                + "<li><a href='"+path+"/logout'>Sair</a></li>"
                       +"</ul>";
        }else{
            link = path+"/index.jsp";
            menu = "<li class='active'><a href='"+path+"/index.jsp'>Página inicial</a></li>" 
                 + "<li class='active'><a href='"+path+"/about.jsp'>Sobre o site</a></li>"
                 + "<li class='active'><a href='"+path+"/pages/login.jsp' class='btn'>ENTRAR</a></li>";
        }
%>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container">
        <div class="navbar-header">
                <!-- Button for smallest screens -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand" href="<%= link %>"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                    <!-- Button for smallest screens -->
                    <%= menu %>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div> 