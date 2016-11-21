var myControllers = angular.module('TipoAtividadeControllers',[]);

myControllers.controller('ListarTipoAtividadeController', function($scope,$http) {
	$scope.Titulo = "Tipos de Atividade";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoAtividade/listarTodos')
		.success(function(data) {
			$scope.tipoAtividadelist = data["tipoAtividade"];
			$scope.Quantidade = $scope.tipoAtividadelist.length+' Tipos de Atividades Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoAtividadeController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Atividade";

	if($routeParams.tipoatividadeId){
		$http.get('http://localhost:8080/CRM/rest/restTipoAtividade/Editar/'+$routeParams.tipoatividadeId)
		.success(function(data) {
			$scope.tipoAtividade = data;
			var tipoatividade =  new Object();
			tipoAtividade = $scope.tipoAtividade

		});
	}
});
myControllers.controller('CadastrarTipoAtividadeController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Atividade";
	
});
myControllers.controller('TipoAtividadeController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoAtividade",
			id : $scope.tipoAtividade.id,
			nome : $scope.tipoAtividade.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoAtividade/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					
					alert("Tipo de Atividade: "+ $scope.tipoAtividade.nome +". Salvo Com Sucesso!");					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Este Tipo de Atividade?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restTipoAtividade/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Tipo de Atividade Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Tipo de Atividade Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
	   };
	
});