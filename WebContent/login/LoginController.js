var myControllers = angular.module('LoginControllers',[]);

myControllers.controller('LoginController', function( $scope, $routeParams, $http,  $cookies,$location,$window) {


	
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

				  var now = new Date();
				  now.setDate(now.getDate() + (60 * 1000));
			  
				  var hash = data;
		          
				  $scope.usuario;
			  		
				  $cookies.put("hash", hash, {
		             expires: now
		          });
				  $scope.LoadUser(hash);

				}).error(
				function(data, status, header, config) {
					alert(data);
				});
	   };
	   $scope.LoadUser = function(hash){
		   
		   $http.get('http://localhost:8080/CRM/rest/restLogin/LoadUser/'+hash  ).success
			  (function(data) {
					  var now = new Date();
					  now.setDate(now.getDate() + (60 * 1000));
				  
					  var hash = data;
			          
					  $scope.usuario;
				  		
					  $cookies.put("hash", hash, {
			             expires: now
			          });				  
					  $cookies.putObject('usuarioLogado',data, {
				             expires: now
			          });
					  $scope.usuarioLogado = $cookies.getObject('usuarioLogado');
					  alert('Login efetuado como: '+$scope.usuarioLogado.nome)
					  $location.path('/');
					  $window.location.reload();
		  	});
	   };

});
