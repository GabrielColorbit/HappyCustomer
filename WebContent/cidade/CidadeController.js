var myControllers = angular.module('CidadeControllers',[]);

myControllers.controller('ListarCidadeController', function($scope,$http) {
	$scope.Titulo = "Cidades";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
		.success(function(data) {
			$scope.cidades = data["cidade"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetCidadeController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Cidade";

	if($routeParams.cidadeId){
		$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
		.success(function(data) {
			$scope.estados = data["estado"];
		});

		$http.get('http://localhost:8080/CRM/rest/restCidade/Editar/'+$routeParams.cidadeId)
		.success(function(data) {
			$scope.cidade = data;
			var cidade =  new Object();
			cidade = $scope.cidade 

		});
	}
});
myControllers.controller('CadastrarCidadeController', function($scope, $routeParams,$http) {
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	$scope.Titulo = "Cadastrar Cidade";
	
});
myControllers.controller('CidadeController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "cidade",
			id : $scope.cidade.id,
			nome : $scope.cidade.nome,
			estado : $scope.cidade.estado

		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restCidade/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Cidade Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	   };
	
});

