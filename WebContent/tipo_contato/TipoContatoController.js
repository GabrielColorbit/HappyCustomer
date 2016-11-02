var myControllers = angular.module('TipoContatoControllers',[]);

myControllers.controller('ListarTipoContatoController', function($scope,$http) {
	$scope.Titulo = "Tipos de Contato";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoContato/listarTodos')
		.success(function(data) {
			$scope.tipoContatolist = data["tipoContato"];
		});
	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoContatoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Contato";

	if($routeParams.tipocontatoId){
		$http.get('http://localhost:8080/CRM/rest/restTipoContato/Editar/'+$routeParams.tipocontatoId)
		.success(function(data) {
			$scope.tipoContato = data;
			var tipoContato =  new Object();
			tipoContato = $scope.tipoContato 

		});
	}
});
myControllers.controller('CadastrarTipoContatoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Contato";
	
});
myControllers.controller('TipoContatoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoContato",
			id : $scope.tipoContato.id,
			nome : $scope.tipoContato.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoContato/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Tipo Contato Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	
});

