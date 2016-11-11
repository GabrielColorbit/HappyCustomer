var myControllers = angular.module('LigacaoControllers',[]);

myControllers.controller('ListarLigacaoController', function($scope,$http) {
	$scope.Titulo = "Ligacões";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restLigacao/listarTodos')
		.success(function(data) {
			$scope.ligacaolist = data["ligacao"];
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetLigacaoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Ligacao";

	if($routeParams.ligacaoId){
		$http.get('http://localhost:8080/CRM/rest/restLigacao/Editar/'+$routeParams.ligacaoId)
		.success(function(data) {
			$scope.ligacao = data;
			var ligacao =  new Object();
			ligacao = $scope.ligacao 

		});
	}
});
myControllers.controller('CadastrarLigacaoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Ligacao";
	
});
myControllers.controller('LigacaoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			
			type : "ligacao",
			id : $scope.ligacao.id,
			usuarioresponsavel : $scope.ligacao.usuarioresponsavel,
			empresa : $scope.ligacao.empresa,
			contato : $scope.ligacao.contato,
			tipoligacao : $scope.ligacao.tipoligacao,
					
			nome : $scope.ligacao.nome,
			datacadastro : $scope.ligacao.datacadastro,
			datainicio : $scope.ligacao.datainicio,
			datafim : $scope.ligacao.datafim,
			descricao : $scope.ligacao.descricao,
			situacao: $scope.ligacao.situacao,			
			
			comunicadores_ligacao : $scope.ligacao.comunicadores_ligacao

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restLigacao/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Ligacao ('+$scope.ligacao.nome+') Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restLigacao/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Ligacao Excluída com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});