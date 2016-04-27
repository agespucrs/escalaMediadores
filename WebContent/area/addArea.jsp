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

		<form method="post" action="main?acao=addArea">

			<div class="form-group">
				<div class="row">
					<div class="col-sm-4">
						<label class="form-label ages">Numero: <span class="red">*</span></label> 
						<input class="form-control" id="numero" name="numero"	value="${param.numero}" type="text" maxlength="9" required>
					</div>
					<div class="col-sm-8">
						<label class="form-label ages">Nome: <span class="red">*</span></label> 
						<input class="form-control" id="nome" name="nome" value="${param.nome}" type="text"	maxlength="120" required>
					</div>
				</div>
				<label class="form-label ages">Observação:</label> 
				<input class="form-control" id="observacao" name="observacao" value="${param.observacao}" type="text" maxlength="120">

				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Pavimento: <span class="red">*</span></label> <select class="form-control" id="pavimento" name="pavimento"
							required>
							<option value="PRIMEIRO" <%="PRIMEIRO".equals(request.getParameter("pavimento")) ? "selected" : ""%>>Primeiro</option>
							<option value="SEGUNDO" <%="SEGUNDO".equals(request.getParameter("pavimento")) ? "selected" : ""%>>Segundo</option>
							<option value="TERCEIRO" <%="TERCEIRO".equals(request.getParameter("pavimento")) ? "selected" : ""%>>Terceiro</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Status: <span class="red">*</span></label> <select class="form-control" id="status_area" name="status_area" required>
							<option value="ATIVO" <%="ATIVO".equals(request.getParameter("status_area")) ? "selected" : ""%>>Ativo</option>
							<option value="INATIVO" <%="INATIVO".equals(request.getParameter("status_area")) ? "selected" : ""%>>Inativo</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<label class="form-label ages">Tipo: <span class="red">*</span></label> 
						<select class="form-control" id="tipo_area" name="tipo_area" required>
							<option value="UM" <%="UM".equals(request.getParameter("tipo_area")) ? "selected" : ""%>>Um</option>
							<option value="DOIS" <%="DOIS".equals(request.getParameter("tipo_area")) ? "selected" : ""%>>Dois</option>
						</select>
					</div>
					<div class="col-sm-6">
						<label class="form-label ages">Numero de Mediadores: <span class="red">*</span></label> 
						<input class="form-control" id="numero_mediadores" name="numero_mediadores" value="1" type="text"  maxlength="2">
					</div>
				</div>
				<div class="row">					
					<div class="col-sm-6">
						<label class="form-label ages">Data Cadastro: <span class="red">*</span></label> 
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
