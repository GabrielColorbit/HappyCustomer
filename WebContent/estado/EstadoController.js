var myControllers = angular.module('EstadoControllers',[]);

myControllers.controller('ListarEstadoController', function($scope,$http) {
	$scope.Titulo = "Estados";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
		.success(function(data) {
			$scope.estadolist = data["estado"];
			$scope.Quantidade = $scope.estadolist.length+' Estado Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetEstadoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Estado";

	if($routeParams.estadoId){
		$http.get('http://localhost:8080/CRM/rest/restEstado/Editar/'+$routeParams.estadoId)
		.success(function(data) {
			$scope.estado = data;
			var estado =  new Object();
			estado = $scope.estado 

		});
	}
});
myControllers.controller('CadastrarEstadoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Estado";
	
});
myControllers.controller('EstadoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "estado",
			id : $scope.estado.id,
			nome : $scope.estado.nome,
			pais : $scope.estado.pais
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restEstado/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					
					alert("Estado: "+ $scope.estado.nome +" - Páis: "+ $scope.estado.pais +". Salvo Com Sucesso!");				
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){

		   var result = confirm("Tem Certeza Que Deseja Excluir Este Estado?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restEstado/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Estado Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Estado Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
		};
	
});