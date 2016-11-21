var myControllers = angular.module('OrigemContatoControllers',[]);

myControllers.controller('ListarOrigemContatoController', function($scope,$http) {
	$scope.Titulo = "Origens de Contato";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restOrigemContato/listarTodos')
		.success(function(data) {
			$scope.origemContatolist = data["origemContato"];
			$scope.Quantidade = $scope.origemContatolist.length+' Origens de Contatos Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetOrigemContatoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Origem de Contato";

	if($routeParams.origemcontatoId){
		$http.get('http://localhost:8080/CRM/rest/restOrigemContato/Editar/'+$routeParams.origemcontatoId)
		.success(function(data) {
			$scope.origemContato = data;
			var origemContato =  new Object();
			origemContato = $scope.origemContato 

		});
	}
});
myControllers.controller('CadastrarOrigemContatoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Origem de Contato";
	
});
myControllers.controller('OrigemContatoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "origemContato",
			id : $scope.origemContato.id,
			nome : $scope.origemContato.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restOrigemContato/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {

					alert("Origem de Contato: "+ $scope.origemContato.nome +". Salvo Com Sucesso!");
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
				$scope.BuscarInformacao();
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Este Origem de Contato?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restOrigemContato/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Origem de Contato Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Origem de Contato Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
			
		};
	
});