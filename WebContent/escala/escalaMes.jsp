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

		<!-- 		<div class="table-responsive"> VERIFICAR COM O CÁSSIO POR QUE TÁ QUEBRANDO O CSS!!!!!-->

		<form method="post" action="#">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-12">
						<label class="form-label ages">Selecione um Mediador: </label> <select
							class="form-control" id="mediadorSelecionado">
							<option disabled selected value default></option>
							<option>Cássio</option>
							<option disabled>Chanin</option>
							<option disabled>Alan</option>
						</select>
					</div>
				</div>
				<div class="userData">
					<div class="row">
						<div class="col-sm-8">
							<label class="form-label ages">Nome:</label> <input
								class="form-control" id="nomeMediador" value="Cássio"
								type="text" readonly="readonly">
						</div>
						<div class="col-sm-4">
							<label class="form-label ages">Matricula:</label> <input
								class="form-control" id="matriculaMediador" value="15905044"
								type="text" readonly="readonly">
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages">Data de Cadastro:</label> <input
								class="form-control" id="dataCadastro" value="09/04/2016"
								type="text" readonly="readonly">
						</div>
						<div class="col-sm-6">
							<label class="form-label ages">CPF: </label> <input
								class="form-control" name="cpf" value="026.208.158-90"
								type="text" readonly="readonly">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-8">
							<label class="form-label ages">Selecione as datas de
								folga:</label>
							<div class="datepicker"></div>
						</div>

						<div class="col-sm-3">
						<br><br><br><br><br><br><br><br><br><br><br><br> <!-- EU ODEIO HTML, ALGUEM FAZ ISSO DIREITO -->
							<div class="text-center pull-right">
								<input class="btn btn-primary gerarEscala" type="submit"
									value="Gerar nova escala">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
<!-- </div> -->

<script>
	$(document).ready(function() {
		$('.userData').hide();
		$('.gerarEscala').prop("disabled", true);

		$("#mediadorSelecionado").change(function() {
			$('.userData').show();
		});

		$('.datepicker').datepicker({
			multidate : true,
			language : "pt-BR",
			format : "dd/mm/YY",
			daysOfWeekDisabled: "0,6",
			// endDate: 
			// startDate:
		});
		
		$('.datepicker').on("changeDate", function(){
			$('.gerarEscala').prop("disabled", false);		
		})
	});
</script>