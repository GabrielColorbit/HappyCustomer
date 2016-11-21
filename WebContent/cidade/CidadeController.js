var myControllers = angular.module('CidadeControllers',[]);

myControllers.controller('ListarCidadeController', function($scope,$http) {
	$scope.Titulo = "Cidades";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
		.success(function(data) {
			$scope.cidadelist = data["cidade"];
			$scope.Quantidade = $scope.cidadelist.length+' Cidades Encontradas!' ;
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
		$http.get('http://localhost:8080/CRM/rest/restCidade/Editar/'+$routeParams.cidadeId)
		.success(function(data) {
			$scope.cidade = data;
			var cidade =  new Object();
			cidade = $scope.cidade 

		});
	}
});
myControllers.controller('CadastrarCidadeController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Cidade";
	
});
myControllers.controller('CidadeController', function($scope, $routeParams,$http) {
	
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	
	
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

					alert("Cidade: "+ $scope.cidade.nome +" - Estado: "+ $scope.cidade.estado.nome +". Salvo Com Sucesso!");								
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){

		   var result = confirm("Tem Certeza Que Deseja Excluir Esta Cidade?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restCidade/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Cidade Excluída Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Cidade Conservada Com Sucesso!");
				$scope.BuscarInformacao();
			}
			
		};
	
});