<%@page import="br.ages.util.Util"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<script src="js/masked.js" type="text/javascript"></script>

<script src="js/mediador.js" type="text/javascript"></script>

<div class="panel panel-default panel-addUser">
	<div class="panel-heading panel-heading-custom ">Cadastro de Mediador</div>

	<div class="panel-body">
		
		<div class="form-group erro-msg" style="width: 100%; display: none;">
			<div class="alert alert-danger fade in text-center" role="alert">
				<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		    	<span class="sr-only">Erro:</span>
		    	<span>Verifique o campo em vermelho</span>                
			</div>
		</div>
		
		<jsp:include page="/template/msg.jsp"></jsp:include>

		<form id="form" method="post" action="main?acao=addMediador">

			<div class="form-group">
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Matrícula: <span class="red">*</span></label> 
						<input class="form-control" id="matricula" data-animation=true data-toggle="popover" data-placement="bottom" name="matricula" value="${param.matricula}" type="text" maxlength="9" required title="Matricula:" data-content="A matricula deve ter entre 5 e 9 caracteres">
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">CPF <span class="red">*</span></label> 
						<input class="form-control" id="cpf" name="cpf" value="${param.cpf}" type="text" maxlength="14" required>
					</div>
				</div>
	

				<label class="form-label ages">Nome: <span class="red">*</span></label> <input class="form-control" id="nome" name="nome" value="${param.nome}" type="text"
					maxlength="120" required>

				<label class="form-label ages">E-mail: <span class="red">*</span></label> <input class="form-control" id="email" name="email" value="${param.email}"
					type="text" maxlength="120" required>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Tipo: <span class="red">*</span></label> <select class="form-control" id="tipoMediador" name="tipoMediador"
							required>
							<option value="UM" <%="UM".equals(request.getParameter("tipoMediador")) ? "selected" : ""%>>UM</option>
							<option value="DOIS" <%="DOIS".equals(request.getParameter("tipoMediador")) ? "selected" : ""%>>DOIS</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Status: <span class="red">*</span></label> <select class="form-control" id="statusMediador" name="statusMediador" required>
							<option value="ATIVO" <%="ATIVO".equals(request.getParameter("statusMediador")) ? "selected" : ""%>>Ativo</option>
							<option value="INATIVO" <%="INATIVO".equals(request.getParameter("statusMediador")) ? "selected" : ""%>>Inativo</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Data Cadastro <span class="red">*</span></label> 
						<input class="form-control" id="dataCadastro" name="dataCadastro" value="<%= Util.dateToString(new Date())%>" type="text" readonly="readonly" maxlength="10" style="text-align: center;">
					</div>
				</div>
			</div>
			<p>Campos que contém <span class="red">*</span> são obrigatórios</p>

			<div class="text-center">
				<input class="btn btn-danger limparMediador pull-left" type="reset"  value="Limpar"> 
				<input class="btn btn-primary addMediador pull-right"   type="submit" value="Cadastrar">
			</div>

		</form>

	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
