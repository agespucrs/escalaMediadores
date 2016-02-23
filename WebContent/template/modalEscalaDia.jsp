
<script>
	$(document)
			.ready(
					function() {
						$('#modalGerarEscala')
								.on(
										'show.bs.modal',
										function(event) {
											var botao = $(event.relatedTarget);
											var dataEscla = botao
													.data('escala');
											var id = botao.data('id');

											$(this).find('.modal-title').text(
													'Gerar Nova Escala');
											$(this).find('#modal-descricao')
													.text(
															'Gerar Nova Escala para '
																	+ dataEscala);

											$('#formEditar')
													.attr('action',
															"main?acao=gerarEscala&data = dataEscala");
										});
					});
	$(document)
			.ready(
					function() {
						$('#modalEditar')
								.on(
										'show.bs.modal',
										function(event) {
											var botao = $(event.relatedTarget);
											var mediador = botao
													.data('mediador');
											var id = botao.data('id');

											$(this).find('.modal-title').text(
													'Alterar Mediador');
											$(this).find('#modal-descricao')
													.text(
															'Escolha o novo Mediador para  alterar o Mediador: '
																	+ mediador);

											$('#formGerarEscala')
													.attr('action',
															"main?acao=alterarMediador&mediador = novoMediador");
										});
					});
</script>


<div class="modal fade" id="modalEditar" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header modal-ages">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"></h4>
			</div>

			<div class="modal-body">
				<p id="modal-descricao"></p>

				<form action="" method="post" id="formEditar">
					<div class="form-group">
						<div class="row">
							<div class="col-sm-6">
								<label class="form-label ages">Novo Mediador:</label> <select class="form-control" id="novoMediador" name="novoMediador" required>
									<option value="1">Tim Maia</option>
									<option value="2">Elis Regina</option>
									<option value="3">Dinho Ouro Preto</option>
									<option value="3">Raul Seixas</option>
									<option value="3">Renato Russo</option>
								</select>
							</div>
							<div class="col-sm-6">
								<label class="form-label ages">Turno:</label> <select class="form-control" id="novoMediador" name="novoMediador" required>
									<option value="1">Manhã</option>
									<option value="2">Almoço</option>
									<option value="3">Tarde</option>
								</select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Alterar</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>
<div class="modal fade" id="modalGerarEscala" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header modal-ages">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"></h4>
			</div>

			<div class="modal-body">
				<p id="modal-descricao"></p>

				<form action="" method="post" id="formGerarEscala">
					<!-- <div class="form-group">
						<div class="row">
							<div class="col-sm-6">
								<label class="form-label ages">Novo Data:</label> 
								<input type="date" class="form-control" id="novoData" name="novaData" required>
							</div>
						</div>
					</div> -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Gerar</button>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>

