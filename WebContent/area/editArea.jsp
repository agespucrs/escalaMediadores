<%@page import="br.ages.util.Util"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.model.AreaConhecimento"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%AreaConhecimento area = (AreaConhecimento) request.getAttribute("area"); %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="panel panel-primary panel-addUser">
    		
		<div class="panel-heading text-center">
			Editar Usuário
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=editaArea">
                	<input class="form-control" type="hidden" id="idArea" name="idArea" value="<%=area.getIdAreaConhecimento()%>">
               		<div class="form-group">
			           	<label class="form-label ages">Número:</label>
			           	<input class="form-control" id="numero" name="numero" value="<%=area.getNumero() %>" type="text" maxlength="6" readonly>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Nome: <span class="red">*</span></label>
			           	<input class="form-control" id="nome" name="nome" value="<%=area.getNome() %>" type="text" maxlength="120" required>
		            </div>

					<div class="form-group">
			           	<label class="form-label ages">Pavimento: <span class="red">*</span></label>
			           	<select class="form-control" id="pavimento" name="pavimento" required>
                            <option value="PRIMEIRO" <%= "PRIMEIRO".equals(area.getPavimento().name()) ? "selected" : "" %>>Primeiro</option>
			           		<option value="SEGUNDO" <%= "SEGUNDO".equals(area.getPavimento().name()) ? "selected" : "" %>>Segundo</option>
			           		<option value="TERCEIRO" <%= "TERCEIRO".equals(area.getPavimento().name()) ? "selected" : "" %>>Terceiro</option>
		           		</select>
		            </div>
                    
					<div class="form-group">
			           	<label class="form-label ages">Status: <span class="red">*</span></label>
			           	<select class="form-control" id="statusArea" name="statusArea" required>
                            <option value="ATIVO" <%= "ATIVO".equals(area.getPavimento().name()) ? "selected" : "" %>>Ativo</option>
			           		<option value="INATIVO" <%= "INATIVO".equals(area.getPavimento().name()) ? "selected" : "" %>>Inativo</option>			           		
		           		</select>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Status: <span class="red">*</span></label>
			           	<select class="form-control" id="tipoArea" name="tipoArea" required>
                            <option value="UM" <%= "UM".equals(area.getTipoArea().name()) ? "selected" : "" %>>Um</option>
			           		<option value="DOIS" <%= "DOIS".equals(area.getTipoArea().name()) ? "selected" : "" %>>Dois</option>			           		
		           		</select>
		            </div>
				
					<div class="form-group">
			           	<label class="form-label ages">Número de Mediadores: <span class="red">*</span></label>
			           	<input class="form-control" id="numeroMediadores" name="numeroMediadores" value="<%=area.getNumeroMediadores() %>" type="text" maxlength="25" required>
		            </div>
                    
                    <div class="form-group">
			           	<label class="form-label ages">Observação: <span class="red">*</span></label>			           	
			           	<input class="form-control" id="observacao" name="observacao" value="<%=area.getObservacao() %>" type="text" maxlength="255">
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Data de cadastro: <span class="red">*</span></label>
			           	<input class="form-control" value="<%=Util.dateToString(area.getDataCadastro()) %>" type="text" readonly>
			           	<input class="form-control" id="dataCadastro" name="dataCadastro" value="<%=area.getDataCadastro() %>" type="hidden" maxlength="12" readonly>
		            </div>
                    
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparUser pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-primary addUser pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>