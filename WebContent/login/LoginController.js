var myControllers = angular.module('LoginControllers',[]);

myControllers.controller('LoginController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "Login",
			login : $scope.usuario.login,
			senha : $scope.usuario.senha
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restLogin/Logar',
				parameter, config).success(
				function(data, status, headers, config) {

					alert("Usuário: "+ $scope.usuario.nome +". Logado Com Sucesso!");
					
				}).error(
				function(data, status, header, config) {
					alert("Usuário Não Cadastrado!");
				});
				$scope.BuscarInformacao();
	   };
	
});