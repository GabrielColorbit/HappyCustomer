var myControllers = angular.module('HeaderControllers',[]);
myControllers.controller('headerController', function( $scope, $routeParams, $http,  $cookies, $location, $window, $compile) {
	$scope.getUsuarioLogado = function(){
		$scope.usuarioLogado = $cookies.getObject('usuarioLogado');

		if($scope.usuarioLogado){
			
			$scope.menuStatus = "logado";
			
			if($scope.usuarioLogado.tipousuario.nome == "Administrador"){
				$scope.menuTipoUsuario = "Administrador";
				//atualiza menu com tipo de usuario
				setTimeout(function(){
					var data = $( ".navbar-nav" ).attr("data-userType" );
					console.log(data);
					$(".nav > li").hide();
					$("."+data).fadeIn("fast");
				}, 200);

				
			}else if($scope.usuarioLogado.tipousuario.nome == "Operador"){
				$scope.menuTipoUsuario = "Operador";
				//atualiza menu com tipo de usuario
				setTimeout(function(){
					var data = $( ".navbar-nav" ).attr("data-userType" );
					console.log(data);
					$(".nav > li").hide();
					$("."+data).fadeIn("fast");
					
				}, 200);

			}

			
						
			
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

