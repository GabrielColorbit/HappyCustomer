var myControllers = angular.module('NegocioControllers',[]);

myControllers.controller('ListarNegocioController', function($scope,$http) {
	$scope.Titulo = "Negócios";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restNegocio/listarTodos')
		.success(function(data) {
			$scope.negociolist = data["negocio"];
			$scope.Quantidade = $scope.negociolist.length+' Negócios Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetNegocioController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Negócio";

	if($routeParams.negocioId){
		$http.get('http://localhost:8080/CRM/rest/restNegocio/Editar/'+$routeParams.origemcontatoId)
		.success(function(data) {
			$scope.negocio = data;
			var negocio =  new Object();
			negocio = $scope.negocio 

		});
	}
});
myControllers.controller('CadastrarNegocioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negócio";
	
});
myControllers.controller('NegocioController', function($scope, $routeParams,$http) {
	
	$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
	.success(function(data) {
		$scope.empresas = data["empresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
	.success(function(data) {
		$scope.produtos = data["produto"];
	});
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "negocio",
			id : $scope.negocio.id,
			nome : $scope.negocio.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restNegocio/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Negócio ('+$scope.negocio.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restNegocio/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Negócio Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});