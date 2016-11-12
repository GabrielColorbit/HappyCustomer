var myControllers = angular.module('AtividadeControllers',[]);

myControllers.controller('ListarAtividadeController', function($scope,$http) {
	$scope.Titulo = "Atividades";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restAtividade/listarTodos')
		.success(function(data) {
			$scope.atividadelist = data["atividade"];
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetAtividadeController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Atividade";

	if($routeParams.atividadeId){
		$http.get('http://localhost:8080/CRM/rest/restAtividade/Editar/'+$routeParams.atividadeId)
		.success(function(data) {
			$scope.atividade = data;
			var atividade =  new Object();
			atividade = $scope.atividade 

		});
	}
});
myControllers.controller('CadastrarAtividadeController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Atividade";
	
});
myControllers.controller('AtividadeController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			
			type : "atividade",
			id : $scope.atividade.id,
			usuarioresponsavel : $scope.atividade.usuarioresponsavel,
			empresa : $scope.atividade.empresa,
			contato : $scope.atividade.contato,
			tipoatividade : $scope.atividade.tipoatividade,
					
			nome : $scope.atividade.nome,
			datacadastro : $scope.atividade.datacadastro,
			datainicio : $scope.atividade.datainicio,
			datafim : $scope.atividade.datafim,
			descricao : $scope.atividade.descricao,
			situacao: $scope.atividade.situacao,			
			
			comunicadores_atividade : $scope.atividade.comunicadores_atividade

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restAtividade/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Atividade ('+$scope.atividade.nome+') Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restAtividade/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Atividade Excluída com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});