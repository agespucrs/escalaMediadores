$(document).ready(function(){
	
	$("#cpf").mask("999.999.999-99");
	
	function TestaCPF(strCPF) {		
		$("#cpf").unmask();
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
		if(!($(this).val().length >= 5 && $(this).val().length <= 9)){
			$(this).addClass("erroCampos");
			$(".erro-msg").show();
			validaMatricula = false;
		}
	});
	
	$("#matricula").focus(function(){
		$(this).removeClass("erroCampos");
		$(".erro-msg").hide();
		validaMatricula = true;
	});
	
	$("#cpf").focusout(function(){
		var strCPF = $("#cpf").val().replace(/\./g,'').replace('-','');
		if(!TestaCPF(strCPF)){
			$(this).addClass("erroCampos");
			$(".erro-msg").show();
			validaCPF = false;
		}	
	});
	
	$("#cpf").focus(function(){	
		$(this).removeClass("erroCampos");
		$(".erro-msg").hide();
		validaCPF = true;
	});
	
	$("#email").focusout(function(){
		var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		var email = $("#email").val();
		
		if(!filtro.test(email)){
			$(this).addClass("erroCampos");
			$(".erro-msg").show();
			validaEmail = false;
		}		
	});
	
	$("#email").focus(function(){
		$(this).removeClass("erroCampos");
		$(".erro-msg").hide();
		validaEmail = true;
	});
	
});