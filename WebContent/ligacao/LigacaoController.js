var myControllers = angular.module('LigacaoControllers',[]);

myControllers.controller('ListarLigacaoController', function($scope,$http) {
	$scope.Titulo = "Ligacaos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restLigacao/listarTodos')
		.success(function(data) {
			$scope.ligacaos = data["ligacao"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});

myControllers.controller('GetLigacaoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Ligacao";
	if($routeParams.ligacaoId){
		$http.get('http://localhost:8080/CRM/rest/restLigacao/Editar/'+$routeParams.ligacaoId)
		.success(function(data) {
			$scope.ligacao = data;
			var ligacao =  new Object();
			ligacao = $scope.ligacao

		});
	}
});