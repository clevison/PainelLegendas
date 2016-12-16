<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">
	
	<title>Equipes cadastradas</title>

	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/gt_favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mycss.css">
</head>

<body class="home" id="container">

	<!-- Fixed navbar -->
	<jsp:include page="fixed_navbar.jsp"/>
	<!-- /.navbar -->

	<!-- Main -->
	<main id="main">
		<div class="container">
			<div class="portfolio">
                            <c:forEach var="teams" items="${myTeamsList}">
                                 <div class="team">
                                     <div class="title">
                                             <h1>${teams.name}</h1>
                                     </div>
                                     <img class="image" src="upload/images_teams/${teams.photo}">
                                     <a class="button">Acessar</a>
                                 </div>
                             </c:forEach>
                        
                            <c:if test="${empty(myTeamsList)}">
                               <h1>Você ainda não faz parte de nenhuma equipe</h1>
                            </c:if>
                        </div>
		</div>
	</main>
	<!-- /Main -->
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jQuery.headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
</body>
</html>
