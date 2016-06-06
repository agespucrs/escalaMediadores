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
					<input class="btn pavimentos" type="button" id="pavimento1"
						value="Primeiro" /> <input class="btn pavimentos" type="button"
						id="pavimento2" value="Segundo" /> <input class="btn pavimentos"
						type="button" id="pavimento3" value="Terceiro" />
				</div>
				<br class="clear">
				<div class="row">
					<div class="col-sm-2">
						<label class="form-label ages col-sm-2">Turnos</label>
					</div>
					<input class="btn turnos" type="button" id="manha" value="Manh�" />
					<input class="btn turnos" type="button" id="almoco" value="Almo�o" />
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
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 1,
					"Pavimento" : 1
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 2",
					"Turno" : 2,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 2",
					"Turno" : 2,
					"Pavimento" : 1
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 2",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {

					"Mediador" : "Z�zinho",
					"Area" : "Area 6",
					"Turno" : 2,
					"Pavimento" : 3
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 1",
					"Turno" : 3,
					"Pavimento" : 2
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 5",
					"Turno" : 1,
					"Pavimento" : 1
				}, {
					"Mediador" : "Z�zinho",
					"Area" : "Area 4",
					"Turno" : 1,
					"Pavimento" : 3
				}, {
					"Mediador" : "Z�zinho",
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
						name : "�rea",
						title : "�rea",
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
						lengthMenu : "Mostrando _MENU_ registros por p�gina",
						zeroRecord : "Sem registros - sorry",
						info : "Mostrando _PAGE_ de _PAGES_ p�ginas",
						infoEmpty : "Nenhum registros encontrados!",
						infoFiltered : "(Filtrado _MAX_ do total deregistros)",
						search : "Busca",
						paginate : {
							first : "Primeiro",
							last : "�ltimo",
							next : "Pr�ximo",
							previous : "Anterior"
						},
					},
					paging : false,
					scrollY : 400
				});
				getTomorrowDay($("#escalaDate"))
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
						});

				function getTomorrowDay(element) {
					// Valor em milisegundos para ser adicionado ao dia atual e gerar o proximo dia
					var getTomorrow = 24 * 60 * 60 * 1000;
					var tomorrow;
					
					// Pega o dia atual
					var today = new Date();
					// Pega o dia da semana do dia atual
					var weekDay = today.getDay();
					// Verifica se o dia da semana � Domingo pois o museu n�o abre domingo
					if (weekDay == 0) {
						// Se for domingo, ao inves de se adicionar um dia ao dia atual, se adiciona 2
						getTomorrow = getTomorrow * 2;
					}
					// Define o proximo dia para ser o dia atual + os dias necessarios at� o proximo dia a ser gerado
					tomorrow = new Date(today.getTime() + getTomorrow);

					// Cria o elemento option com o valor do proximo dia a ser gerada a esca�a
					var option = $("<option>").val(dataFormatada(tomorrow)).text(dataFormatada(tomorrow))

					// Adiciona a option ao select
					element.append(option)
				}
				
				//Formata um objeto data em JS para que apare�a como uma string dd/mm/yyyy
				function dataFormatada(data){
				    var dia = data.getDate();
				    if (dia.toString().length == 1)
				      dia = "0"+dia;
				    var mes = data.getMonth()+1;
				    if (mes.toString().length == 1)
				      mes = "0"+mes;
				    var ano = data.getFullYear();  
				    return dia+"/"+mes+"/"+ano;
				}
			});
</script>