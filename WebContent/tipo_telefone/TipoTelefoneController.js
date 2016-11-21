var myControllers = angular.module('TipoTelefoneControllers',[]);

myControllers.controller('ListarTipoTelefoneController', function($scope,$http) {
	$scope.Titulo = "Tipos de Telefone";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
		.success(function(data) {
			$scope.tipoTelefonelist = data["tipoTelefone"];
			$scope.Quantidade = $scope.tipoTelefonelist.length+' Tipos de Telefones Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoTelefoneController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Telefone";

	if($routeParams.tipotelefoneId){
		$http.get('http://localhost:8080/CRM/rest/restTipoTelefone/Editar/'+$routeParams.tipotelefoneId)
		.success(function(data) {
			$scope.tipoTelefone = data;
			var tipoTelefone =  new Object();
			tipoTelefone = $scope.tipoTelefone

		});
	}
});
myControllers.controller('CadastrarTipoTelefoneController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Telefone";
	
});
myControllers.controller('TipoTelefoneController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoTelefone",
			id : $scope.tipoTelefone.id,
			nome : $scope.tipoTelefone.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoTelefone/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					
					alert("Tipo de Telefone: "+ $scope.tipoTelefone.nome +". Salvo Com Sucesso!");						
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Este Tipo de Telefone?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restTipoTelefone/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Tipo de Telefone Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Tipo de Telefone Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
		};
	
});