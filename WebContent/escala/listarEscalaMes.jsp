<%@page import="br.ages.model.EscalaMensalDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="br.ages.model.Ferias"%>
<%@page import="br.ages.model.Mediador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.model.Usuario"%>
<%@page import="br.ages.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="../template/modalEscalaMes.jsp"></jsp:include>

<div class="panel panel-default">

	<div class="panel-heading panel-heading-custom text-center">Lista
		de Escala Mensal</div>
		
		<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>

		<form method="post" action="main?acao=listEscalaMensal">
			<div class="form-group">
				<div class="row">
					<div class="col-sm-8">
						<label class="form-label ages">Selecione o mês: </label> <select
							class="form-control" id="mesSelecionado" name="mesSelecionado">
						</select>
					</div>
					<div class="col-sm-4 pull-right">
						<label class="form-label ages">Selecione o Ano: </label> <select
							class="form-control" id="anoSelecionado" name="anoSelecionado">
						</select>
					</div>
				</div>
				<div class="col-sm-6 pull-right">
					<div class="row">
						<div class="text-center pull-right">
						<br>
							<input class="btn btn-primary gerarEscalaMensal" type="submit" value="Listar">
						</div>
					</div>
				</div>
			</div>			
			</form>
			<div class="userData1">
			<br><br><br>
				<jsp:include page="/template/msg.jsp"></jsp:include>
		        <div class="table-responsive">
		        
		        <table id="listaMediadores" class="table table-responsive table-striped table-hover table-condensed table-bordered">
		
		            <thead>
		                <tr>
		                	<th style="text-align: center;">ID Mediador</th>
		                	<th style="text-align: center;">Nome</th>
		                	<th style="text-align: center;">Dias</th>
							<th data-sortable="false" style="text-align: center; width:10px"></th>
							<th data-sortable="false" style="text-align: center; width:10px"></th>
		                </tr>
		            </thead>
					
					<tbody> 
		            	<%
		            		List<EscalaMensalDTO> ferias = (List<EscalaMensalDTO>)request.getAttribute("listEscalaMes");			         
		            		for(EscalaMensalDTO f : ferias){		            			
		            	%>
		            	<tr>
		            		<td align="center"><%=f.getIdMediador() %></td>
		            		<td align="center"><%=f.getNome() %></td>
		            		<td align="center"><%=f.getDiasFolga() %></td>
		            		<td align="center">
		            			<form action="" method="post">
									<a href="" data-toggle="modal"
										data-id="<%=f.getIdMediador() %>"										 
										data-target="#modalEditar"
										title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
								</form>
		            		
		            		</td>
		            		<td align="center">
								<form action="" method="post">
									<a href="" data-toggle="modal"
										data-id="<%=f.getIdMediador()%>"										
										title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a>
								</form>
							</td>
		            	</tr>		            	
		            	<%
		            		}
		            	%>
					</tbody>
		            
		        </table> 
		</div>
			</div>
		</div>	
	</div>
	<jsp:include page="../template/foot.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		
		$.ajax({
			dataType: "json",
			url: this.href,
			success: function(data){
				alert("VAI POR FaVOR!");
			}
		});
		
		// Variaveis Globais
		var date = new Date();
		var startDate;
		var endDate;
		
		
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
			var actualMonth = date.getMonth();
			for(i = actualMonth; i < monthNames.length; i++){
				$('#mesSelecionado').append($('<option>', {
					value: i,
					text: monthNames[i]
				}));
			};
		};
		
		
		// Inicializações
		listMonths();
		listYears();
		
		$('.userData').hide();
		
		$('#mediadorSelecionado').change(function(){
			$('.userData').hide();
			if($('.datepicker').data('datepicker') != null){
				$('.datepicker').data('datepicker').remove();
			}
			$('#mesSelecionado').prop('disabled', false);
			$('#anoSelecionado').prop('disabled', false);
		});
		
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
				startDate = new Date(parseInt($('#anoSelecionado').val()), parseInt($('#mesSelecionado').val()), 1);
				endDate = new Date(parseInt($('#anoSelecionado').val()), parseInt($('#mesSelecionado').val())+1, 0);
				console.log(startDate);
				console.log(endDate);
				startDatePicker(startDate, endDate);
			});

		
		// EventHandler do Datepicker

		$('.datepicker').on("changeDate", function() {
			$('.gerarEscala').prop("disabled", false);
		});
		
		$('#feriasMed').click(function(){
			$('.datepicker').data('datepicker').clearDates();
			var arrayDates = [];
			for(i = 0; i <= endDate.getDate(); i++){
				var auxDate = new Date(startDate.getFullYear(), startDate.getMonth(), i);
				if((auxDate.getDay() != 1)){
					arrayDates.push(auxDate);
				};
			};
				$('.datepicker').data('datepicker').setDates(arrayDates);
			
		});
	});
	
	$('#listaMediadores').dataTable({
	    "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Sem registros - sorry",
            "info": "Mostrando _PAGE_ de _PAGES_ páginas",
            "infoEmpty": "Nenhum registros encontrados!",
            "infoFiltered": "(Filtrado _MAX_ do total deregistros)",
            "search":"Busca",
           	"paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
	        },
        }
	});
</script>