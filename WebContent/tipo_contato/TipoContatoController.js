var myControllers = angular.module('TipoContatoControllers',[]);

myControllers.controller('ListarTipoContatoController', function($scope,$http) {
	$scope.Titulo = "Tipos de Contatos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoContato/listarTodos')
		.success(function(data) {
			$scope.tipoContatolist = data["tipoContato"];
			$scope.Quantidade = $scope.tipoContatolist.length+' Tipos de Contatos Encontrados!' ;
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
			type : "origemContato",
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
					$scope.Resposta = 'TipoContato ('+$scope.tipoContato.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restTipoContato/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Tipo de Contato Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});