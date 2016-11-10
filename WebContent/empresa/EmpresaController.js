var myControllers = angular.module('EmpresaControllers',[]);

myControllers.controller('ListarEmpresaController', function($scope,$http) {
	$scope.Titulo = "Empresas";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
		.success(function(data) {
			$scope.empresas = data["empresa"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});