<%@page import="java.util.Date"%>
<%@page import="br.ages.util.Util"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<div class="panel panel-default panel-addUser">
	<div class="panel-heading panel-heading-custom ">Cadastro de Área Conhecimento</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<form method="post" action="main?acao=">

			<div class="form-group">
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Numero: <span class="red">*</span></label> 
						<input class="form-control" id="numero" name="numero"	value="${param.matricula}" type="text" maxlength="9" required>
					</div>
					<div class="col-sm-8">
						<label class="form-label ages">Nome: <span class="red">*</span></label> 
						<input class="form-control" id="nome" name="nome" value="${param.nome}" type="text"	maxlength="120" required>
					</div>
				</div>
				<label class="form-label ages">Observação:</label> 
				<input class="form-control" id="obs" name="obs" value="${param.obs}" 	type="text" maxlength="120" required>

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Andar: <span class="red">*</span></label> <select class="form-control" id="tipo" name="perfilAcesso"
							required>
							<option value="Primeiro" <%="Primeiro".equals(request.getParameter("tipo")) ? "selected" : ""%>>Primeiro</option>
							<option value="Segundo" <%="Segundo".equals(request.getParameter("tipo")) ? "selected" : ""%>>Segundo</option>
							<option value="Terceiro" <%="Terceiro".equals(request.getParameter("tipo")) ? "selected" : ""%>>Terceiro</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Status: <span class="red">*</span></label> <select class="form-control" id="statusMediador" name="statusUsuario" required>
							<option value="ATIVO" <%="ATIVO".equals(request.getParameter("statusMediador")) ? "selected" : ""%>>Ativo</option>
							<option value="INATIVO" <%="INATIVO".equals(request.getParameter("statusMediador")) ? "selected" : ""%>>Inativo</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Numero de Mediadores <span class="red">*</span></label> 
						<input class="form-control" id="numero" name="numero" value="1" type="number"  maxlength="2">
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Turno(s): <span class="red">*</span></label> <div id="turno" name="turno" required>
							<input type="checkbox" value="MANHÃ" <%="MANHÃ".equals(request.getParameter("turno")) ? "selected" : ""%>> Manhã
							<input type="checkbox" value="TARDE" <%="TARDE".equals(request.getParameter("turno")) ? "selected" : ""%>> Tarde
							<input type="checkbox" value="NOITE" <%="NOITE".equals(request.getParameter("turno")) ? "selected" : ""%>> Noite
						</div>
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
				<input class="btn btn-danger limparUser pull-left" type="reset"  value="Limpar"> 
				<input class="btn btn-primary addUser pull-right"   type="submit" value="Cadastrar">
			</div>

		</form>

	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
