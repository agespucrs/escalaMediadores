<%@page import="br.ages.model.AreaConhecimento"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<%-- <jsp:include page="../template/modal.jsp"></jsp:include> --%>

<div class="panel panel-default">

	<div class="panel-heading panel-heading-custom text-center">Lista
		de Áreas do Conhecimento</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>
		<div class="table-responsive">

			<table id="listaAreas"
				class="table table-responsive table-striped table-hover table-condensed table-bordered">

				<thead>
					<tr>
						<th style="text-align: center;">Numero</th>
						<th style="text-align: center;">Nome</th>
						<th style="text-align: center;">Pavimento</th>
						<th style="text-align: center;">Nº Mediadores</th>
						<th data-sortable="false" style="text-align: center; width: 10px"></th>
						<th data-sortable="false" style="text-align: center; width: 10px"></th>
					</tr>
				</thead>

				<tbody>
					<%
						List<AreaConhecimento> listaArea = (List<AreaConhecimento>) request.getAttribute("listAreas");
						for (AreaConhecimento area : listaArea) {
					%>
					<tr>
						<td align="center"><%=area.getNumero()%></td>
						<td align="center"><%=area.getNome()%></td>
						<td align="center"><%=area.getPavimento().name()%></td>
						<td align="center"><%=area.getNumeroMediadores()%></td>
						<td align="center">
							<form action="" method="post">
								<a href="" data-toggle="modal"
									data-id="<%=area.getIdAreaConhecimento()%>"
									data-usuario="<%=area.getNome()%>" data-target="#modalEditar"
									title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
							</form>
						</td>
						<td align="center">
							<form action="" method="post">
								<a href="" data-toggle="modal"
									data-id="<%=area.getIdAreaConhecimento()%>"
									data-usuario="<%=area.getNome()%>" data-target="#modalExcluir"
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
<jsp:include page="../template/foot.jsp"></jsp:include>
<script>
	$(document).ready(function() {
		$('#listaAreas').dataTable({
			"language" : {
				"lengthMenu" : "Mostrando _MENU_ registros por página",
				"zeroRecords" : "Sem registros - sorry",
				"info" : "Mostrando _PAGE_ de _PAGES_ páginas",
				"infoEmpty" : "Nenhum registros encontrados!",
				"infoFiltered" : "(Filtrado _MAX_ do total deregistros)",
				"search" : "Busca",
				"paginate" : {
					"first" : "Primeiro",
					"last" : "Último",
					"next" : "Próximo",
					"previous" : "Anterior"
				},
			}
		});
	});
	;
	/* $(document).ready(function() {
	 var fontSize =$('#listaAreas tbody tr:first').css('font-size');
	 alert(fontSize);
	 $('#listaAreas tbody tr:even').css({
	 'background-color': '#dddddd',
	 'color': '#fff',
	 'font-size': '11pt',
	 'line-height': '2.5em'
	 });
	 }); */
</script>