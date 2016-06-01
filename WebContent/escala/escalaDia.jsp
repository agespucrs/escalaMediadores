<%@page import="br.ages.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalEscalaDia.jsp"></jsp:include>
<div class="panel panel-default panel-escalaDia" id="panelEscala">
	<jsp:include page="/template/msg.jsp"></jsp:include>
	<div class="panel-heading panel-heading-custom">Escala Dia</div>
	<div class="panel-body" id="panelBody">
		<div class="row">
			<div class="col-sm-8">
				<div class="row">
					<div class="col-sm-2">
						<label class="form-label ages col-sm-2">Pavimentos</label>
					</div>
					<input class="btn pavimentos" type="button" id="pavimento1"	value="Primeiro" /> 
					<input class="btn pavimentos" type="button" id="pavimento2" value="Segundo" /> 
					<input class="btn pavimentos" type="button" id="pavimento3" value="Terceiro" />
				</div>
				<br class="clear">
				<div class="row">
					<div class="col-sm-2">
						<label class="form-label ages col-sm-2">Turnos</label>
					</div>
					<input class="btn turnos" type="button" id="manha" value="Manhã" />
					<input class="btn turnos" type="button" id="almoco" value="Almoço" />
					<input class="btn turnos" type="button" id="tarde" value="Tarde" />
				</div>
				<br class="clear">
				<div class="row">
					<div class="col-sm-2">
						<label class="form-label ages col-sm-2">Dia</label>
					</div>
					<div class="col-sm-5 row">
						<select class="form-control" id="escalaDate">
							<option id="today" value=""></option>
							<option id="tomorrow" value=""></option>
						</select>
					</div>
				</div>
				<br class="clear">
				<div class="col-sm-12">
					<form action="" method="post">
						<button id="btnGera" name="btnGera" class="btn "
							data-toggle="modal" data-id="1" data-escala="01/07/2015"
							data-target="#modalGerarEscala">Gerar Nova Escala</button>
					</form>
				</div>
				<div>
					<table id="tabelaEscala"
						class="table table-striped table-bordered dataTable">
					</table>
				</div>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</div>
<jsp:include page="../template/foot.jsp"></jsp:include>
<script>
	$(document).ready(
			function() {
				var data = [ {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 1,
					"Pavimento" : 1
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 2",
					"Turno" : 2,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 2",
					"Turno" : 2,
					"Pavimento" : 1
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 2",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {

					"Mediador" : "Zézinho",
					"Area" : "Area 6",
					"Turno" : 2,
					"Pavimento" : 3
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 5",
					"Turno" : 1,
					"Pavimento" : 1
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 4",
					"Turno" : 1,
					"Pavimento" : 3
				}, {
					"Mediador" : "Zézinho",
					"Area" : "Area 3",
					"Turno" : 1,
					"Pavimento" : 1
				} ]

				var table = $('#tabelaEscala').DataTable({
					dom : "t",
					data : data,
					columns : [ {
						name : "Mediador",
						title : "Mediador",
						data : "Mediador",
					}, {
						name : "Área",
						title : "Área",
						data : "Area",
					}, {
						name : "Turno",
						title : "Turno",
						data : "Turno",
					}, {
						name : "Pavimento",
						title : "Pavimento",
						data : "Pavimento",
						bVisible : false
					} ],
					language : {
						lengthMenu : "Mostrando _MENU_ registros por página",
						zeroRecord : "Sem registros - sorry",
						info : "Mostrando _PAGE_ de _PAGES_ páginas",
						infoEmpty : "Nenhum registros encontrados!",
						infoFiltered : "(Filtrado _MAX_ do total deregistros)",
						search : "Busca",
						paginate : {
							first : "Primeiro",
							last : "Último",
							next : "Próximo",
							previous : "Anterior"
						},
					},
					paging : false,
					scrollY : 400
				});
				$(".turnos").on(
						"click",
						function() {
							if ($(this).hasClass("selected")) {
								$(this).removeClass("btn-primary");
								table.columns(2).search("").draw();
							} else {
								$(".turnos").removeClass("btn-primary");
								$(this).addClass("btn-primary")
								var turno = this.id;
								turno = turno == "manha" ? 1
										: (turno == "almoco" ? 2 : 3);
								table.columns(2).search(turno).draw();
							}
							$(this).toggleClass("selected");
						})
				$(".pavimentos").on(
						"click",
						function() {
							if ($(this).hasClass("selected")) {
								$(this).removeClass("btn-primary");
								table.columns(3).search("").draw();
							} else {
								$(".pavimentos").removeClass("btn-primary");
								$(this).addClass("btn-primary")
								var pavimento = this.id;
								pavimento = pavimento == "pavimento1" ? 1
										: (pavimento == "pavimento2" ? 2 : 3);
								table.columns(3).search(pavimento).draw();
							}
							$(this).toggleClass("selected");
						})
			});
</script>