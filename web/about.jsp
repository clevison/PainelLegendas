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

	<!-- Fixed navbar -->
	<jsp:include page="/pages/fixed_navbar.jsp"/>
	<!-- /.navbar -->

	<!-- Header -->
	<header id="head">
		<div class="container">
			<div class="row">
				<h1 class="lead">Desenvolvedores</h1>
				<p class="tagline">O site foi desenvolvido para faciliar a gerência nos projetos de Legendar<br />
				E outra descrição melhor com uma frase de efeito, por que essa está horrivel</p>
			</div>
                        <div class="portfolioDev">
                                    <div class="dev">
                                                <div class="title">
                                                        <h1>Clevison</h1>
                                                </div>
                                                <img class="image" src="resources/images/clevison.jpg">
                                                <a class="button">clevison.luiz@gmail.com</a>
                                    </div>
                        </div>
                        <div class="portfolioDev">
                                    <div class="dev" id="dev">
                                                <div class="title">
                                                        <h1>Denner</h1>
                                                </div>
                                                <img class="image" src="resources/images/denner.jpg">
                                                <a class="button">arthurdenner7@gmail.com</a>
                                    </div>
                        </div>
                        <div class="portfolioDev">
                                <div class="dev">
                                            <div class="title">
                                                    <h1>Gerdson</h1>
                                            </div>
                                            <img class="image" src="resources/images/gerdson.jpg">
                                            <a class="button">gerdson@gmail.com</a>
                                </div>
                        </div>
		</div>
	</header>
	<!-- /Header -->

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jQuery.headroom.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
</body>
</html>
