var myControllers = angular.module('AtividadeControllers',[]);

myControllers.controller('ListarAtividadeController', function($scope,$http) {
	$scope.Titulo = "Atividades";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restAtividade/listarTodos')
		.success(function(data) {
			$scope.atividades = data["atividade"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});

myControllers.controller('GetAtividadeController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Atividade";
	if($routeParams.atividadeId){
		$http.get('http://localhost:8080/CRM/rest/restAtividade/Editar/'+$routeParams.atividadeId)
		.success(function(data) {
			$scope.atividade = data;
			var atividade =  new Object();
			atividade = $scope.atividade

		});
	}
});