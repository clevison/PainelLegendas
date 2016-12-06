<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Painel de legendas</title>

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/gt_favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mycss.css">
</head>

<body class="home" id="container">

        <%
            String title = request.getParameter("message");
            if(title == null){
                title = "Criar Equipe";
            }
            String subTitle = request.getParameter("cause");
            if(subTitle == null){
                subTitle = "";
            }
        %>
	<!-- Fixed navbar -->
	<jsp:include page="fixed_navbar.jsp"/>
	<!-- /.navbar -->

	<!--create team -->
        <header id="head">
            <div class="container">
                <div class="modal-content">
                        <div class="modal-header">
                                <h4 class="modal-title"><%= title %></h4>
                                <p><%= subTitle %></p>
                        </div>
                        <div class="modal-body">
                                <form method="POST" action="${pageContext.request.contextPath}/create_team" enctype="multipart/form-data">
                                    <p><input type="text" name="name" class="myInput" placeholder="Nome da equipe" required ></p>
                                        <p><textarea class="myInput" name="message" placeholder="Mensagem" maxlength="300" rows="5"></textarea></p>
                                        <input id="uploadFile"  placeholder="Selecione uma imagem..." disabled="disabled" />
                                             <div class="fileUpload btn btn-primary">
                                                <span>Upload</span>
                                                <input id="uploadBtn" name="file" type="file" class="upload myInput" required />
                                            </div>
                                        <p><input type="submit" class="btn btn-success" value="Enviar"></p>
                                </form>
                        </div>
                </div>
            </div>
        </header>
	<!-- /create team -->

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jQuery.headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
</body>
</html>
