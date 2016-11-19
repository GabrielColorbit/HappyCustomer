var myControllers = angular.module('EmpresaControllers',[]);

myControllers.controller('ListarEmpresaController', function($scope,$http) {
	$scope.Titulo = "Empresas";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
		.success(function(data) {
			$scope.empresalist = data["empresa"];
			$scope.Quantidade = $scope.empresalist.length+' Empresas Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetEmpresaController', function($scope, $routeParams,$http, $filter) {
	$scope.Titulo = "Editar Empresa";

	if($routeParams.empresaId){
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/Editar/'+$routeParams.empresaId)
		.success(function(data) {
			$scope.empresa = data;
			var empresa =  new Object();
			empresa = $scope.empresa 
			$scope.empresa.datacadastro = $filter('date')(empresa.datacadastro, "yyyy-MM-dd");
		});
	}
});
myControllers.controller('CadastrarEmpresaController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Empresa";
	
});
myControllers.controller('EmpresaController', function($scope, $routeParams,$http) {
	
	$http.get('http://localhost:8080/CRM/rest/restTipoEmpresa/listarTodos')
	.success(function(data) {
		
		$scope.tiposempresa = data["tipoEmpresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/status')
	.success(function(data) {
		$scope.statuslist = data["status"];
	});
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
	.success(function(data) {
		$scope.cidades = data["cidade"];
	});
	$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
	.success(function(data) {
		$scope.contatos = data["contato"];
	});
	$scope.EnviarInformacao = function() {
		
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
			$scope.listTelefones[i].id = null;			
		}
		for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++){
			$scope.listComunicadores[i].id = null;			
		}
		
		
		$scope.empresa.telefones_empresa =  $scope.listTelefones;
		$scope.empresa.comunicadores_empresa = $scope.listComunicadores;
		$scope.empresa.contatos_empresa =  $scope.listContatos;
		var parameter = JSON.stringify({
			
			type : "empresa",
			id : $scope.empresa.id,
			tipoempresa : $scope.empresa.tipoempresa,
			datacadastro : $scope.empresa.datacadastro,
			cidade : $scope.empresa.cidade,
			razaosocial : $scope.empresa.razaosocial,
			cnpj : $scope.empresa.cnpj,
			inscricaoestadual : $scope.empresa.inscricaoestadual,
			endereco : $scope.empresa.endereco,
			numero : $scope.empresa.numero,
			complemento: $scope.empresa.complemento,
			cep : $scope.empresa.cep,
			bairro: $scope.empresa.bairro,
			ramo : $scope.empresa.ramo,
			site : $scope.empresa.site,
			status: $scope.empresa.status,			
			telefones_empresa : $scope.empresa.telefones_empresa,
			comunicadores_empresa : $scope.empresa.comunicadores_empresa,
			contatos_empresa : $scope.empresa.contatos_empresa
		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restEmpresa/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Empresa ('+$scope.empresa.nome+') Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   
	   //TiposTelefone
	   $http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
  		.success(function(data) {
  			$scope.tipostelefone = data["tipoTelefone"];
  		});
     
		$scope.listTelefones=[];
		$scope.add = function(){
			
			if(validarCampos()){
				if($scope.telefone.id == null){
		 				autoincrement();
		 				$scope.listTelefones.push({
		 	  				id: $scope.telefone.id ,numero:$scope.telefone.numero, tipotelefone:$scope.telefone.tipotelefone
		 	  			});
		 			}else{
		 	  			var index =$scope.telefone.id;
		 	  			$scope.listTelefones[index].tipotelefone = $scope.telefone.tipotelefone;
		 	  			$scope.listTelefones[index].numero = $scope.telefone.numero;
		 			}
	 				$scope.telefone.id = null;
	 	  		 	$scope.telefone.tipotelefone = '';
	 	  			$scope.telefone.numero = '';
			} 			
 			
 		}

 		$scope.selectEdit = function(id){
			var Telefone = $scope.listTelefones[id];
			$scope.telefone.id = Telefone.id;
			$scope.telefone.tipotelefone = Telefone.tipotelefone;
			$scope.telefone.numero = Telefone.numero;
 		};
		$scope.del = function(id){
			var result = confirm('Tem certeza?');
			if (result === true){
				$scope.listTelefones.splice(id, 1);
			}
		};
 		function getSelectedIndex(id){
 			for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
 				if($scope.listTelefone[i].id == id)
 					return i;
 			return 1;
					
 		}
 		function autoincrement(){
 			$scope.telefone.id = Object.keys($scope.listTelefones).length;
 		}
       function validarCampos(){
       	var i;
       	if($scope.telefone){
				if(! $scope.telefone.numero ){
					alert("O campo número de telefone está vázio, favor preencher o campo.");
					i = false;
				}else if(! $scope.telefone.tipotelefone){
					alert("O campo tipo de telefone está vázio, favor preencher o campo.");
				}else{
					i = true
				}
			}else{
				alert("Favor preencher os campos Número e Tipo de Telefone");
				i = false;
			}
       	return i;
       }
	   
       
       //COMUNICADORES
	   $http.get('http://localhost:8080/CRM/rest/restTipoComunicador/listarTodos')
  		.success(function(data) {
  			$scope.tiposcomunicador = data["tipoComunicador"];
  		});
     
		$scope.listTelefones=[];
		$scope.add = function(){
			
			if(validarCampos()){
				if($scope.telefone.id == null){
		 				autoincrement();
		 				$scope.listTelefones.push({
		 	  				id: $scope.telefone.id ,numero:$scope.telefone.numero, tipotelefone:$scope.telefone.tipotelefone
		 	  			});
		 			}else{
		 	  			var index =$scope.telefone.id;
		 	  			$scope.listTelefones[index].tipotelefone = $scope.telefone.tipotelefone;
		 	  			$scope.listTelefones[index].numero = $scope.telefone.numero;
		 			}
	 				$scope.telefone.id = null;
	 	  		 	$scope.telefone.tipotelefone = '';
	 	  			$scope.telefone.numero = '';
			} 			
 			
 		}

 		$scope.selectEdit = function(id){
			var Telefone = $scope.listTelefones[id];
			$scope.telefone.id = Telefone.id;
			$scope.telefone.tipotelefone = Telefone.tipotelefone;
			$scope.telefone.numero = Telefone.numero;
 		};
		$scope.del = function(id){
			var result = confirm('Tem certeza?');
			if (result === true){
				$scope.listTelefones.splice(id, 1);
			}
		};
 		function getSelectedIndex(id){
 			for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
 				if($scope.listTelefone[i].id == id)
 					return i;
 			return 1;
					
 		}
 		function autoincrement(){
 			$scope.telefone.id = Object.keys($scope.listTelefones).length;
 		}
       function validarCampos(){
       	var i;
       	if($scope.telefone){
				if(! $scope.telefone.numero ){
					alert("O campo número de telefone está vázio, favor preencher o campo.");
					i = false;
					
				}else if(! $scope.telefone.tipotelefone){
					alert("O campo tipo de telefone está vázio, favor preencher o campo.");
				}else{
					i = true
				}
			}else{
				alert("Favor preencher os campos Número e Tipo de Telefone");
				i = false;
			}
       	return i;
       }
       
       
	   
       
       //EXCLUIR EMPRESA
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restEmpresa/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Empresa Excluída com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
		   };
		
		};
	
	
//Genrenciar comunicadores
$scope.listComunicadores=[];
$scope.addComunicador = function(){
	
	if(validarComunicador()){
		if($scope.comunicador.id == null){
 				autoincrementComunicador();
 				$scope.listComunicadores.push({
 	  				id: $scope.comunicador.id ,nome:$scope.comunicador.nome, tipocomunicador:$scope.comunicador.tipocomunicador
 	  			});
 			}else{
 	  			var index =$scope.comunicador.id;
 	  			$scope.listComunicadores[index].tipocomunicador = $scope.comunicador.tipocomunicador;
 	  			$scope.listComunicadores[index].nome = $scope.comunicador.nome;
 			}
			$scope.comunicador.id = null;
  		 	$scope.comunicador.tipocomunicador = '';
  			$scope.comunicador.nome = '';
	} 			
	
}

$scope.selectEditComunicador = function(id){
	var Comunicador = $scope.listComunicadores[id];
	$scope.comunicador.id = Comunicador.id;
	$scope.comunicador.tipocomunicador = Comunicador.tipocomunicador;
	$scope.comunicador.nome = Comunicador.nome;
};
$scope.delComunicador = function(id){
	var result = confirm('Tem certeza?');
		if (result === true){
			$scope.listComunicadores.splice(id, 1);
		}
	};
	function getSelectedIndexComunicador(id){
		for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++)
			if($scope.listComunicadores[i].id == id)
				return i;
		return 1;
				
	}
	function autoincrementComunicador(){
		$scope.comunicador.id = Object.keys($scope.listComunicadores).length;
	}
   function validarComunicador(){
   	var i;
   	if($scope.comunicador){
			if(! $scope.comunicador.nome ){
				alert("O campo nome de comunicador está vázio, favor preencher o campo.");
			i = false;
			
		}else if(! $scope.comunicador.tipocomunicador){
			alert("Selecione um tipo de comunicador para continuar.");
		}else{
			i = true
		}
	}else{
		alert("Favor preencher os campos Nome e Tipo de Comunicador");
			i = false;
		}
   	return i;
   }		
		
//Gerenciador de contatos
$scope.listContatos=[];
$scope.addContato = function(){
  if(validarContatos($scope.contato) === true){
	  $scope.listContatos.push( $scope.contato);  
  }
}

$scope.delContato = function(id){
	var result = confirm('Você deseja excluir um contato da lista?');
	if (result === true){
		for(var j = 0; j < $scope.listContatos.length;j ++){
	   		if($scope.listContatos[j].id == id){
	   			$scope.listContatos.splice(j, 1);
	   		} 
	   	}
	}
   	
};
function validarContatos(contato){
	var v = 0;
	var f = 0;
   	if($scope.listContatos.length > 0){
   		for(var j = 0; j < $scope.listContatos.length;j ++){
   	   		if($scope.listContatos[j].id == contato.id){
   	   			alert(contato.nome +" já foi adicionado a lista de contatos, favor selecionar outro.");
   	   			f = 1;
   	   		}
   	   	}
   	}
   	
   	if(f > 0){
   		return false
   	}else{return true}
   }	
		
		
});