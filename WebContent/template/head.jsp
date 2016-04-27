<%@page import="br.ages.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <title>Museu de Ciência e Tecnologia - PUCRS</title>
        <link rel="icon" href="img/favicon.ico">

        <!-- JQUERY -->
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="./css/bootstrap.min.css">
	 	<link rel="stylesheet" href="./css/bootstrap-theme.min.css"> 
		<script src="./js/bootstrap.min.js"></script> 

		<!-- STYLE -->
		<link rel="stylesheet" href="./css/style.css">
        
		<!-- Include the plugin's CSS and JS: Cassio DataTable -->
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

		<!-- Include the plugin's CSS and JS: Cassio DataTable -->
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
 		<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>

		
		<!-- Include the plugin's CSS and JS: Cassio Dual ListBox -->
		<script src="./js/jquery.bootstrap-duallistbox.min.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap-duallistbox.min.css">
		
		<!-- Include the plugin's CSS and JS: Cassio DateTime Picker -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/js/bootstrap-datepicker.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/locales/bootstrap-datepicker.pt-BR.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.0/css/bootstrap-datepicker.min.css">
		
		
		
	
	</head>
    
    <body>
     <% Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao"); %>
    	<div class="container fundo">
    	
    			<nav class="navbar navbar-default">
				<div class="container-fluid">
				
		    		<div class="navbar-header">
			      		<a class="navbar-brand" href="index.jsp">
			        		<img class="logoNavBar" src="./img/logo-mct.png" alt="AGES">
			      		</a>
			    	</div>

					<ul class="nav navbar-nav">
						

			        	<li class="dropdown">
			          		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Mediadores
				          		<span class="caret"></span>
			          		</a>
				          	<ul class="dropdown-menu">
				            	<li><a href="main?acao=listaMediador">Listar</a></li>
				            	<li><a href="main?acao=telaMediador">Cadastrar</a></li> 
				          	</ul>
        				</li>
        				
        				<li class="dropdown">
			          		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Áreas Museu
				          		<span class="caret"></span>
			          		</a>
				          	<ul class="dropdown-menu">
				            	<li><a href="main?acao=listaArea">Listar</a></li>
				            	<li><a href="main?acao=telaArea">Cadastrar</a></li> 
				          	</ul>
        				</li>

        				<li class="dropdown">
			          		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Escala Mediadores
				          		<span class="caret"></span>
			          		</a>
				          	<ul class="dropdown-menu">
				            	<li><a href="main?acao=tela&tela=escalaDia">Diária</a></li>
				            	<li class="dropdown-submenu"><a tabindex="-1" href="#">Mensal</a>
				            		<ul class="dropdown-menu">
				            			<li><a tabindex="-1" href="main?acao=tela&tela=">Cadastrar Escala Mensal</a></li>
						            	<li><a tabindex="-1" href="main?acao=tela&tela=">Listar Escala Mensal</a></li>
				            		</ul>
				            	</li>
				            	
				          	</ul>
        				</li>

					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
			          		<a class="dropdown-toggle" data-toggle="dropdown" href="#">Usuários
				          		<span class="caret"></span>
				          	</a>
				          	<ul class="dropdown-menu">
				            	<li><a href="main?acao=listUser">Listar</a></li>
				            	<li><a href="main?acao=telaUser">Cadastrar</a></li> 
				          	</ul>
        				</li>

        				<li class="dropdown">
        					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
        						<span class="glyphicon glyphicon-user"></span>
        						Olá, <%=usuarioSessao.getNome()%>!
        						<span class="caret"></span>
        					</a>
                           
        					<ul class="dropdown-menu dropdown-menu-right">
        						<li><a href="main?acao=logout">Logout</a></li>
        					</ul>
        				</li>
			      	</ul>
			      	
		    	</div>
			</nav>