var myControllers = angular.module('TipoTelefoneControllers',[]);


myControllers.controller('ListarTipoTelefoneController', function($scope,$http) {
	$scope.Titulo = "Usuários";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
		.success(function(data) {
			$scope.tipostelefone = data["tipotelefone"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});