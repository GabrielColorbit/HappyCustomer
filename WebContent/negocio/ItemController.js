var myControllers = angular.module('ItemControllers',[]);

myControllers.controller('ListarItemController', function($scope,$http) {
	$scope.Titulo = "Items";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restItem/listarTodos')
		.success(function(data) {
			$scope.items = data["item"];
		});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});

myControllers.controller('GetItemController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Item";
	if($routeParams.itemId){
		$http.get('http://localhost:8080/CRM/rest/restItem/Editar/'+$routeParams.itemId)
		.success(function(data) {
			$scope.item = data;
			var item =  new Object();
			item = $scope.item

		});
	}
});