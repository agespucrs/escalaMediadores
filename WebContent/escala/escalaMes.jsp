<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.model.Usuario"%>
<%@page import="br.ages.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<div class="panel panel-default panel-addUser">

	<div class="panel-heading panel-heading-custom text-center">Cadastro
		de escala Mensal</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<div class="table-responsive">

			<form method="post" action="#">
				<div class="form-group">
					<div class="row">
						<input type="text" id="exemplo" class="form-control">
					</div>
				</div>

				<div class="form-group"></div>

				<div class="form-group"></div>

				<div class="form-group"></div>

				<div class="text-center">
					<input class="btn btn-primary addUser" type="submit"
						value="BRBRBRBR">
				</div>

			</form>
		</div>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>

<script>
	$(document).ready(function(){
		$('#exemplo').datepicker({
            format: "dd/mm/yyyy",
            language: "pt-BR"
        });
	});
</script>