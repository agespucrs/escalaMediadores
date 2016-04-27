var errors = {matriculaError: false, emailError: false, cpfError: false, nomeError: false};

$(document).ready(function(){
	
	$("#cpf").mask("999.999.999-99");
	
	function mostraMensagem(){
		for(var s in errors){
			if(errors[s] == true){
				$('.erro-msg').show();
				return true;
			};
		};
		
		$('.erro-msg').hide();
	};
	
	function TestaCPF(strCPF) {
		
		var Soma; 
		var Resto; 
		Soma = 0; 
		if (strCPF == "00000000000") return false; 
		for (i=1; i<=9; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i); 
		Resto = (Soma * 10) % 11;
		
		if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		if (Resto != parseInt(strCPF.substring(9, 10)) ) return false; 
		Soma = 0;
		
		for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i); 
		Resto = (Soma * 10) % 11; if ((Resto == 10) || (Resto == 11)) Resto = 0; 
		if (Resto != parseInt(strCPF.substring(10, 11) ) ) return false; 
		return true; 
	}
	
	$("#matricula").focusout(function(){
		$(this).popover('hide');
		if(!($(this).val().length >= 5 && $(this).val().length <= 9)){
			errors['matriculaError'] = true;
			$(this).addClass("erroCampos");
			mostraMensagem();
		}
	});
	
	$("#matricula").focus(function(){
		$(this).popover('show');
		errors['matriculaError'] = false;
		$(this).removeClass("erroCampos");
		mostraMensagem();
	});
	
	$("#form").submit(function() {
		//$("#cpf").unmask();
		$("#cpf").mask("99999999999");
		
	});
	
	$("#cpf").focusout(function(){
		var strCPF = $("#cpf").val().replace(/\./g,'').replace('-','');
		if(!TestaCPF(strCPF)){
			errors['cpfError'] = true;
			$(this).addClass("erroCampos");	
			mostraMensagem();
		}
	});
	
	$("#cpf").focus(function(){
		errors['cpfError'] = false;
		$(this).removeClass("erroCampos");
		mostraMensagem();
	});
	
	$('#nome').focusout(function(){
		if($(this).val().length <= 2){	
			errors['nomeError'] = true;
			$(this).addClass("erroCampos");
			mostraMensagem();
		};
	});
	
	$('#nome').focus(function(){
		errors['nomeError'] = false;
		$(this).removeClass("erroCampos");
		mostraMensagem();
	});
	
	$("#email").focusout(function(){
		var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		var email = $("#email").val();
		if(!filtro.test(email)){
			errors['emailError'] = true;
			$(this).addClass("erroCampos");
			mostraMensagem();
		}
	});
	
	$("#email").focus(function(){
		errors['emailError'] = false;
		$(this).removeClass("erroCampos");
		mostraMensagem();
	});
	
});