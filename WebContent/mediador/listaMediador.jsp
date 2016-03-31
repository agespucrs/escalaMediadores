<%@page import="br.ages.model.Mediador"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalMediador.jsp"></jsp:include>
 		
<div class="panel panel-default">
   			
	<div class="panel-heading panel-heading-custom text-center">Lista de Mediadores</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
        
        <table id="listaMediadores" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>
                    <th style="text-align: center;">ID</th>
                    <th style="text-align: center;">Matricula</th>
					<th style="text-align: center;">Nome</th>
					<th style="text-align: center;">Email</th>
					<th style="text-align: center;">Tipo</th>
					<th style="text-align: center;">Status</th>
					<th data-sortable="false" style="text-align: center; width:10px"></th>
					<th data-sortable="false" style="text-align: center; width:10px"></th>
                </tr>
            </thead>

            <tbody> 
            	<%
					List<Mediador> listaMediadores = (List<Mediador>) request.getAttribute("listMediador");
					for (Mediador med : listaMediadores) {
				%>
				          
            	<tr>
	            	<td align="center"><%=med.getIdMediador()%></td>
	            	<td align="center"><%=med.getMatricula()%></td>
	            	<td align="center"><%=med.getNome()%></td>
	            	<td align="center"><%=med.getEmail()%></td>
	         		<td align="center"><%=med.getTipoMediador().name()%></td>
	            	<td align="center"><%=med.getStatusMediador().name()%></td>
	            	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=med.getIdMediador() %>" data-mediador="<%=med.getNome()%>" 
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=med.getIdMediador() %>" data-mediador="<%=med.getNome()%>" 
            				data-target="#modalExcluir" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a>
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

$(document).ready(function(){
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
});;
</script>