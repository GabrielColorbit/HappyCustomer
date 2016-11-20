var myControllers = angular.module('TipoComunicadorControllers',[]);

myControllers.controller('ListarTipoComunicadorController', function($scope,$http) {
	$scope.Titulo = "Tipos de Comunicador";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoComunicador/listarTodos')
		.success(function(data) {
			$scope.tipoComunicadorlist = data["tipoComunicador"];
			$scope.Quantidade = $scope.tipoComunicadorlist.length+' Tipos de Comunicadores Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoComunicadorController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Comunicador";

	if($routeParams.tipocomunicadorId){
		$http.get('http://localhost:8080/CRM/rest/restTipoComunicador/Editar/'+$routeParams.tipocomunicadorId)
		.success(function(data) {
			$scope.tipoComunicador = data;
			var tipoComunicador =  new Object();
			tipoComunicador = $scope.tipoComunicador

		});
	}
});
myControllers.controller('CadastrarTipoComunicadorController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Comunicador";
	
});
myControllers.controller('TipoComunicadorController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoComunicador",
			id : $scope.tipoComunicador.id,
			nome : $scope.tipoComunicador.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoComunicador/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
				
					alert("Tipo de Comunicador: "+ $scope.tipoComunicador.nome +". Salvo Com Sucesso!");							
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restTipoComunicador/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Tipo Comunicador Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});