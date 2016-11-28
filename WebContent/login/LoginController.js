var myControllers = angular.module('LoginControllers',[]);

myControllers.controller('LoginController', function( $scope, $routeParams, $http, $cookies,$location,$window,  $timeout,$route) {


	   $scope.Login = function() {

		var parameter = JSON.stringify({
			type : "usuario",
			login : $scope.usuario.login,
			senha : $scope.usuario.senha
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post('http://localhost:8080/CRM/rest/restLogin/AutenticacaoUsuario', parameter, config).success(
				function(data, status, headers, config) {
					if(data.indexOf("Login ou senha incorreta") != -1 ){
						$scope.responseFromLogin = data;
					}else{
					  var hash = data;
					  $cookies.put("hash", hash);
					  $scope.LoadUser(hash);
					}
				}).error(
				function(data, status, header, config) {
					alert(data);
				});
	   };
	   $scope.LoadUser = function(hash){

		   $http.get('http://localhost:8080/CRM/rest/restLogin/LoadUser/'+hash  ).success
			  (function(data) {

						if(data.id){
							$cookies.putObject('usuarioLogado',data);
							$scope.usuarioLogado = $cookies.getObject('usuarioLogado');
							$scope.responseFromLogin = "Olá "+$scope.usuarioLogado.nome+" bem vindo ao sistema Happy Customer :)";
							$('.loading').addClass('uil-reload-css');
							var goHome = function(){
								$location.path('/Home');
								var scope = angular.element( document.getElementById("mainNav")).scope();
							    scope.$apply(function () {
							        scope.getUsuarioLogado();
							    });
							}
							$timeout(goHome, 1600)


						}else{
							$scope.responseFromLogin = "Login ou senha incorretos."
						}


		  	});
	   };

});
