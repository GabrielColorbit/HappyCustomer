var myControllers = angular.module('TipoUsuarioControllers',[]);

myControllers.controller('ListarTipoUsuarioController', function($scope,$http) {
	$scope.Titulo = "Tipos de Usuário";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
		.success(function(data) {
			$scope.tipoUsuariolist = data["tipoUsuario"];
			$scope.Quantidade = $scope.tipoUsuariolist.length+' Tipos de Usuários Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetTipoUsuarioController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Tipo de Usuário";

	if($routeParams.tipousuarioId){
		$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/Editar/'+$routeParams.tipousuarioId)
		.success(function(data) {
			$scope.tipoUsuario = data;
			var tipoUsuario =  new Object();
			tipoUsuario = $scope.tipoUsuario 

		});
	}
});
myControllers.controller('CadastrarTipoUsuarioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Tipo de Usuário";
	
});
myControllers.controller('TipoUsuarioController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "tipoUsuario",
			id : $scope.tipoUsuario.id,
			nome : $scope.tipoUsuario.nome
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoUsuario/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					
					alert("Tipo de Usuário: "+ $scope.tipoUsuario.nome +". Salvo Com Sucesso!");								
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Este Tipo de Usuário?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restTipoUsuario/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Tipo de Usuário Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Tipo de Usuário Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
		};
	
});