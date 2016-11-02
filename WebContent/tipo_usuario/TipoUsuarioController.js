var myControllers = angular.module('TipoUsuarioControllers',[]);

myControllers.controller('ListarTipoUsuarioController', function($scope,$http) {
	$scope.Titulo = "Tipos de Usuário";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
		.success(function(data) {
			$scope.tipoUsuariolist = data["tipoUsuario"];
		});
	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});