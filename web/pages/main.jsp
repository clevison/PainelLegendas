<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<!-- Modal to request entry -->
	<div class="modal fade" id="requestModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Solicitar entrada</h4>
				</div>
				<div class="modal-body">
					<form>
						<p><textarea class="myInput" placeholder="Mensagem" rows="5"></textarea></p>
						<br />
						<p><input type="submit" class="btn btn-success" value="Enviar"></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal to request entry -->

	<!-- Fixed navbar -->
	<jsp:include page="fixed_navbar.jsp"/>
	<!-- /.navbar -->

	<!-- Main -->
	<main id="main">
		<div class="container">
			<div class="portfolio">
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a data-toggle="modal" data-target="#requestModal" class="button">Solicitar entrada</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a href="#" class="button">Acessar</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a data-toggle="modal" data-target="#requestModal" class="button">Solicitar entrada</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a href="#" class="button">Acessar</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a data-toggle="modal" data-target="#requestModal" class="button">Solicitar entrada</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a href="#" class="button">Acessar</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a data-toggle="modal" data-target="#requestModal" class="button">Solicitar entrada</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a href="#" class="button">Acessar</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a data-toggle="modal" data-target="#requestModal" class="button">Solicitar entrada</a>
				</div>
				
				<div class="team">
					<div class="title">
						<h1>Equipe</h1>
					</div>
					<img class="image" src="https://www.outsystems.com/PortalTheme/img/UserImage.png?24752">
					<a href="#" class="button">Acessar</a>
				</div>
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
