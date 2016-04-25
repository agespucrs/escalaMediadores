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
		de Escala Mensal</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

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
				<div class="row">
					<div class="col-sm-8">
						<label class="form-label ages">Selecione o mês: </label> <select
							class="form-control" id="mesSelecionado">
							<option disabled selected value></option>
						</select>
					</div>
					<div class="col-sm-4 pull-right">
						<label class="form-label ages">Selecione o Ano: </label> <select
							class="form-control" id="anoSelecionado">
							<option disabled selected value></option>
						</select>
					</div>
				</div>
				<div class="col-sm-6 pull-right">
					<div class="row">
						<div class="text-center pull-right">
						<br>
							<input class="btn btn-primary gerarEscalaMensal" type="button" value="Gerar Datas Folga">
						</div>
					</div>
				</div>
				<div class="userData">
					<div class="row">
						<div class="col-sm-8">
							<label class="form-label ages">Nome:</label> <input
								class="form-control" id="nomeMediador" value="Cássio Trindade"
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
							<div class="checkbox">
								<label><input type="checkbox" value="" id="feriasMed">O
									mediador está de férias</label>
							</div>
							<div class="datepicker"></div>
						</div>
						<div class="col-sm-3 campoNoFinalDireita">
							<div class="row">
								<div class="text-center pull-right">
									<input class="btn btn-primary gerarEscala" type="submit"
										value="Salvar">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="/template/foot.jsp"></jsp:include>

<script>
	$(document).ready(function() {
		
		// Função para listar anos
		
		function listYears(){
			for(i = 2016; i <= 2100; i++){
				$('#anoSelecionado').append($('<option>', {
					value: i,
					text: i
				}));
			};
		};
		
		function listMonths(){
			var monthNames = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
			                  "Setembro", "Outubro", "Novembro", "Dezembro"];
			for(i = 0; i < monthNames.length; i++){
				$('#mesSelecionado').append($('<option>', {
					value: i,
					text: monthNames[i]
				}));
			};
		};
		
		
		// Inicializações
		listMonths();
		listYears();
		var date = new Date();
		var startDate;
		var endDate;
		
		$('.userData').hide();
		$('.gerarEscala').prop("disabled", true);
		$('.gerarEscalaMensal').prop("disabled", true);
		
		// Validações para enable do botão
		var habilitaBotao = {mediador: false, mes: false, ano: false};
		
		$('#mediadorSelecionado').change(function(){
			habilitaBotao['mediador'] = true;
			habilitaBotaoValida();
		});
		
		$('#mesSelecionado').change(function(){
			habilitaBotao['mes'] = true;
			habilitaBotaoValida();
		});
		
		$('#anoSelecionado').change(function(){
			habilitaBotao['ano'] = true;
			habilitaBotaoValida();
		});
		
		function habilitaBotaoValida(){
			var habilita;
			for(var s in habilitaBotao){
				if(habilitaBotao[s] == false){
					habilita = false;
					break;
				};
			};
			
			if(habilita == null){
				$('.gerarEscalaMensal').prop("disabled", false);
			};
		};
		
		function startDatePicker(startDate, endDate){
			$('.datepicker').datepicker({
				multidate: true,
				language: "pt-BR",
				format: "dd/mm/YY",
				daysOfWeekDisabled : "1",
				maxViewMode: "days",
				startDate: startDate,
				endDate: endDate
			});
		};
		
		// EventHandler do Botao
			$('.gerarEscalaMensal').click(function(){
				$('.userData').show();
				$('.gerarEscalaMensal').hide();
				startDate = new Date(date.getFullYear(), parseInt($('#mesSelecionado').val()), 1);
				endDate = new Date(date.getFullYear(), parseInt($('#mesSelecionado').val())+1, 0);
				console.log(startDate);
				console.log(endDate);
				startDatePicker(startDate, endDate);
			});

		
		// EventHandler do Datepicker

		$('.datepicker').on("changeDate", function() {
			$('.gerarEscala').prop("disabled", false);
		});
		
		$('#feriasMed').change(function(){
			if($(this).prop('checked')){
				$('.datepicker').data('datepicker').clearDates();
				var arrayDates = [];
				for(i = 0; i <= endDate.getDate(); i++){
					var auxDate = new Date(startDate.getFullYear(), startDate.getMonth(), i);
					if((auxDate.getDay() != 1)){
						arrayDates.push(auxDate);
					}
				};
				$('.datepicker').data('datepicker').setDates(arrayDates);
			} else {
				$('.datepicker').data('datepicker').destroy();
				startDatePicker(startDate, endDate);
			};
		});
	});
</script>