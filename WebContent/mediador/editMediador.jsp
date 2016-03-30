<%@page import="br.ages.model.Mediador"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.model.Usuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%Mediador mediador = (Mediador) request.getAttribute("mediador"); %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="panel panel-primary panel-addUser">
    		
		<div class="panel-heading text-center">
			Editar Mediador
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=editMediador">
                	<input class="form-control" type="hidden" id="idMediador" name="idMediador" value="<%=mediador.getIdMediador()%>">
               		<div class="form-group">
			           	<label class="form-label ages">Matrícula:</label>
			           	<input class="form-control" id="matricula" name="matricula" value="<%=mediador.getMatricula() %>" type="text" maxlength="9" readonly>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Nome: <span class="red">*</span></label>
			           	<input class="form-control" id="nome" name="nome" value="<%=mediador.getNome() %>" type="text" maxlength="120" required>
		            </div>

					<div class="form-group">
			           	<label class="form-label ages">CPF:</label>
			           	<input class="form-control" id="cpf" name="cpf" value="<%=mediador.getCpf() %>" type="text" maxlength="120" readonly>
		            </div>
				
					<div class="form-group">
			           	<label class="form-label ages">E-Mail: <span class="red">*</span></label>
			           	<input class="form-control" id="email" name="email" value="<%=mediador.getEmail() %>" type="text" maxlength="120" required>
		            </div>
                    
                    <div class="form-group">
			           	<label class="form-label ages">Tipo: <span class="red">*</span></label>
			           	<input class="form-control" id="tipoMediador" name="tipoMediador" value="<%=mediador.getTipoMediador() %>" type="text" maxlength="4" required>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Status: <span class="red">*</span></label>
			           	<input class="form-control" id="statusMediador" name="statusMediador" value="<%=mediador.getStatusMediador() %>" type="text" maxlength="10" required>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Data de cadastro: <span class="red">*</span></label>
			           	<input class="form-control" id="dataCadastro" name="dataCadastro" value="<%=mediador.getDataCadastro() %>" type="text" maxlength="12" required>
		            </div>		        
                    
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparMediador pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-primary addMediador pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>