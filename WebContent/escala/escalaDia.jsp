<%@page import="br.ages.model.Usuario"%>
<%@page import="java.util.List"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalEscalaDia.jsp"></jsp:include>
 		
<div class="panel panel-default panel-escalaDia" id="panelEscala">
	<jsp:include page="/template/msg.jsp"></jsp:include>
	<div class="panel-heading panel-heading-custom">Escala Dia</div>
   	<div class="panel-body" id="panelBody">
		<div class="row">
		<div class="col-sm-6">
			<div class="col-sm-12">
				<label class="form-label ages col-sm-2">Pavimentos</label> 
				<input class="btn" type="button" id="pavimento1" value="Primeiro" /> 
				<input class="btn" type="button" id="pavimento2" value="Segundo" /> 
				<input class="btn" type="button" id="pavimento3" value="Terceiro" />
			</div>
			<br class="clear">
			<br>
			<div class="col-sm-12">
				<label class="form-label ages col-sm-2">Turnos</label> 
				<input class="btn" type="button" id="manha" value="Manhã" />
				<input class="btn" type="button" id="almoco" value="Almoço" />
				<input class="btn" type="button" id="tarde" value="Tarde" /> 
			</div>
			</div>
			<div class="col-sm-4">
				<label>Data Escala: 01/07/2016</label><br> <label>Turno MANHÃ</label>
				<form action="" method="post">
		        <button id="btnGera" name="btnGera" class="btn " data-toggle="modal" data-id="1" data-escala="01/07/2015" 
		            data-target="#modalGerarEscala">Gerar Nova Escala</button>
		        </form>
			</div>
			<!-- 
			<div class="col-sm-2 pull-right">
				<label class="form-label ages">Turno </label> <select id="turno" name="turno">
					<option value="manha">Manhã</option>
					<option value="tarde">Tarde</option>
					<option value="almoco">Almoço</option>
				</select>
			</div>-->
		</div>
		<div id="pavimentos" class="pavimento"  >
   			<!-- imagem pavimento um -->
	        <div id="umPavimento" class="pavimentoUm">
	        	<div class="area1" id="area1">1</div>
	        	<div class="area2" id="area2">2</div>
	        	<div class="area3" id="area3">3</div>
	        	<div class="area4" id="area4">4</div>
	        	<div class="area5" id="area5">5</div>
	        	<div class="area6" id="area6">6 - Elis</div>
	        	<div class="area7" id="area7">7 - Tim</div>
	        	<div class="area8" id="area8">8 - Chico</div>
	        	<div class="area9" id="area9">9-Roberto</div>
	        	<div class="area10" id="area10">10</div>
	        	<div class="area11" id="area11">11</div>
			</div>	        
	        <!-- tabela pavimento um -->
        	<div class="tabelaPavimentoUm table-responsive" id="tabelaPavimentoUm" >
		        <table id="listaEscalaUm" class="table table-responsive table-striped table-hover table-condensed table-bordered">
		            <thead>
		                <tr>
		                    <th style="text-align: center;">Area</th>
							<th style="text-align: center;">Mediador</th>
							<th style="text-align: center;"></th>
						</tr>
		            </thead>
		            <tbody> 
		            	<tr>
			            	<td>1- Bilheteria</td>
			            	<td>s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="1" data-mediador="" 
		            				data-target="#modalEditar" title="Alterar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>2 - Entrada Principal</td>
			            	<td>s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="2" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>3 - Recepção</td>
			            	<td >s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>4 - Loja 1</td>
			            	<td >s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>5 - Aniversário Genial</td>
			            	<td >s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>6 - Exposições Temporarias</td>
			            	<td>Elis Regina</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="1" data-mediador="Elis Regina" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>7 - Mundo da Criança</td>
			            	<td>Tim Maia</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>8 - Aquários e Terrários</td>
			            	<td>Chico Buarque</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>9 - Educação Ambiental</td>
			            	<td>Roberto Carlos</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>10 - Bilheteria 2</td>
			            	<td >s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            	<tr>
			            	<td>11 - Entrada Prédio 40</td>
			            	<td >s/m</td>
			            	<td>
								<form action="" method="post">
		            				<a href="" data-toggle="modal" data-id="" data-mediador="" 
		            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
		            			</form>
           					</td>
			            </tr>
		            </tbody>
		        </table> 
			</div>
			<!-- imagem pavimento dois -->
	        <div  id="doisPavimento" hidden="" class="pavimentoDois">
	        	<div id="area16" class="area16">16 - Raul</div>
	        	<div id="area" class="area"></div>
	        	<div id="area" class="area"></div>
	        </div>
	        <!-- tabela pavimento dois -->
        	<div class="tabelaPavimentoDois table-responsive" id="tabelaPavimentoDois" hidden="">
				<table id="listaEscalaDois" class="table table-responsive table-striped table-hover table-condensed table-bordered">
					<thead>
						<tr>
							<th style="text-align: center;">Area</th>
							<th style="text-align: center;">Mediador</th>
							<th style="text-align: center;"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>16- Biodiversidade</td>
							<td>Raul Seixas</td>
							<td>
								<form action="" method="post">
									<a href="" data-toggle="modal" data-id="19" data-mediador="Rau Seixas" data-target="#modalEditar" title="Alterar"> <i
										class="glyphicon glyphicon-pencil"></i></a>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- imagem pavimento tres -->
			<div id="tresPavimento" hidden="" class="pavimentoTres">
	        	<div id="area22" class="area22">22-Mariza</div>
	        	<div id="area" class="area"></div>
	        	<div id="area" class="area"></div>
	        </div>
	         <!-- tabela pavimento tres -->
        	<div class="tabelaPavimentoTres table-responsive" id="tabelaPavimentoTres" hidden="">
        	<table id="listaEscalaTres" class="table table-responsive table-striped table-hover table-condensed table-bordered">
					<thead>
						<tr>
							<th style="text-align: center;">Area</th>
							<th style="text-align: center;">Mediador</th>
							<th style="text-align: center;"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>22 - Matéria E Energia</td>
							<td>Mariza Monte</td>
							<td>
								<form action="" method="post">
									<a href="" data-toggle="modal" data-id="43" data-mediador="Mariza Monte" data-target="#modalEditar" title="Alterar"> <i
										class="glyphicon glyphicon-pencil"></i></a>
								</form>
							</td>
						</tr>
					</tbody>
				</table>
        	</div>
		</div>
 	</div>
</div>
<div id="coords" style="background-color: #ff8000;"></div>
<jsp:include page="../template/foot.jsp"></jsp:include>
<script>

$(document).ready(function(){
	$('#listaAreas').dataTable({
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
});
$('#pavimento1').click(function() {
	$('#tresPavimento').hide();
	$('#doisPavimento').hide();
	$('#umPavimento').show();
	$('#tabelaPavimentoTres').hide();
	$('#tabelaPavimentoDois').hide();
	$('#tabelaPavimentoUm').show();
});
$('#pavimento2').click(function() {
	$('#tresPavimento').hide();
	$('#doisPavimento').show();
	$('#umPavimento').hide();
	$('#tabelaPavimentoTres').hide();
	$('#tabelaPavimentoDois').show();
	$('#tabelaPavimentoUm').hide();
});
$('#pavimento3').click(function() {
	$('#tresPavimento').show();
	$('#doisPavimento').hide();
	$('#umPavimento').hide();
	$('#tabelaPavimentoTres').show();
	$('#tabelaPavimentoDois').hide();
	$('#tabelaPavimentoUm').hide();
});
// umPavimento panelEscala
$image = $('#doisPavimento');
imgPos = [
    $image.offset().left + $image.outerWidth(),
    $image.offset().top + $image.outerHeight(),
    $image.offset().left,
    $image.offset().top
];

$image.mousemove(function(e){
  $('#coords').html((e.pageX-imgPos[0]) +', '+ (e.pageY-imgPos[1]));
});
</script>

