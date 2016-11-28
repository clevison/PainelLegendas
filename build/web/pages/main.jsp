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

	<!-- Modal to create team -->
	<div class="modal fade" id="createTeamModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Criar equipe</h4>
				</div>
				<div class="modal-body">
					<form>
						<p><input type="text" class="myInput" placeholder="Nome da equipe"></p>
						<p><textarea class="myInput" placeholder="Mensagem" rows="5"></textarea></p>
						<br />
						<p><input type="submit" class="btn btn-success" value="Enviar"></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal to create team -->

	<!-- Modal to edit profile -->
	<div class="modal fade" id="editProfileModal" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Editar perfil</h4>
				</div>
				<div class="modal-body">
					<form>
						<p><input type="text" class="myInput" placeholder="Novo nome de usuário" value="{nickname}"></p>
						<p><input type="email" class="myInput" placeholder="Novo e-mail" value="{email}"></p>
						<p><input type="password" class="myInput" placeholder="Nova senha" value="{senha}"></p>
						<br />
						<p><input type="submit" class="btn btn-success" value="Salvar"></p>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal to edit profile -->
	
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
                                        <li class="active"><a href="${pageContext.request.contextPath}/main.jsp">Equipes cadastradas</a></li>
                                        <li class="active"><a href="${pageContext.request.contextPath}/about.jsp">Sobre o site</a></li>
					<li><a class="btn" data-toggle="modal" data-target="#createTeamModal">CRIAR EQUIPE</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Olá, {nickname}<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" data-toggle="modal" data-target="#editProfileModal">Editar perfil</a></li>
							<li><a href="logout.jsp">Sair</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div> 
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
