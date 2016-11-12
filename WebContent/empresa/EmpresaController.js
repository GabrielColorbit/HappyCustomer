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
myControllers.controller('GetEmpresaController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Empresa";

	if($routeParams.empresaId){
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/Editar/'+$routeParams.empresaId)
		.success(function(data) {
			$scope.empresa = data;
			var empresa =  new Object();
			empresa = $scope.empresa 

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
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			
			type : "empresa",
			id : $scope.empresa.id,
			tipoempresa : $scope.empresa.tipoempresa,
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
			comunicadores_empresa : $scope.empresa.comunicadores_empresa

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
	   
	   //TELEFONES
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
       
       
     //CONTATOS
	   $http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
  		.success(function(data) {
  			$scope.contatos = data["contato"];
  		});
	   
       
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
	
});