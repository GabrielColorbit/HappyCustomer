var myControllers = angular.module('TipoEmpresaControllers',[]);

myControllers.controller('ListarTipoEmpresaController', function($scope,$http) {
	$scope.Titulo = "Tipo de Empresa";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoEmpresa/listarTodos')
		.success(function(data) {
			$scope.tipoEmpresalist = data["tipoEmpresa"];
			$scope.Quantidade = $scope.tipoEmpresalist.length+' Tipos de Empresas Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoEmpresaController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Empresa";

	if($routeParams.tipoempresaId){
		$http.get('http://localhost:8080/CRM/rest/restTipoEmpresa/Editar/'+$routeParams.tipoempresaId)
		.success(function(data) {
			$scope.tipoEmpresa = data;
			var tipoEmpresa =  new Object();
			tipoEmpresa = $scope.tipoEmpresa

		});
	}
});
myControllers.controller('CadastrarTipoEmpresaController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Empresa";
	
});
myControllers.controller('TipoEmpresaController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoEmpresa",
			id : $scope.tipoEmpresa.id,
			nome : $scope.tipoEmpresa.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoEmpresa/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'TipoEmpresa ('+$scope.tipoEmpresa.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restTipoEmpresa/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Tipo de Empresa Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});