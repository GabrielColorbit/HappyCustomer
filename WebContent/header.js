var myControllers = angular.module('HeaderControllers',[]);
myControllers.controller('headerController', function( $scope, $routeParams, $http,  $cookies, $location,$window) {

  $scope.usuarioLogado = $cookies.getObject('usuarioLogado');

   $scope.Logout = function(){
	   $cookies.remove("hash");
	   $cookies.remove("usuarioLogado");
	   $location.path('/Login');
	   $window.location.reload();
   };
});

