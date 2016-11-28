<%@page import="model.User"%>
<%
        User user = (User)session.getAttribute("user");
%>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container">
        <div class="navbar-header">
                <!-- Button for smallest screens -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp">Página inicial</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/pages/teams.jsp">Equipes cadastradas</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/pages/about.jsp">Sobre o site</a></li>
                    <li class="active"><a href="${pageContext.request.contextPath}/pages/login.jsp" class="btn">ENTRAR</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div> 