var myControllers = angular.module('HeaderControllers',[]);
myControllers.controller('headerController', function( $scope, $routeParams, $http,  $cookies, $location, $window, $compile) {
	$scope.getUsuarioLogado = function(){
		$scope.usuarioLogado = $cookies.getObject('usuarioLogado');

		if($scope.usuarioLogado){
			$scope.menuStatus = "logado";
		}else{
			$scope.menuStatus = "deslogado";
		}



	}
	$scope.getUsuarioLogado();


   $scope.Logout = function(){
	   $cookies.remove("hash");
	   $cookies.remove("usuarioLogado");
	   $location.path('/Login');
		$scope.getUsuarioLogado();

   };
});
