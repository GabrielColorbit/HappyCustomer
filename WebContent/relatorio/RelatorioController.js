var myControllers = angular.module('RelatorioController',[]);

myControllers.controller('RelatorioAtividadeController', function($scope, $routeParams, $http, $cookies, $window) {
  $scope.Titulo = "Relatórios";

  $scope.idEmpresa = $routeParams.idempresa;
  $scope.BuscarInformacao = function() {
		 var hash = $cookies.get('hash');
		 var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
				}
			}
    $http.get('http://localhost:8080/CRM/rest/restEmpresa/Editar/'+$routeParams.idempresa, config)
		.success(function(data, config) {
			
			$scope.empresa = data;
			$scope.GrahpsTitle =  "Atividades na Empresa: "+$scope.empresa.razaosocial;
			callChartAtividade();
			
		}).error(
			function(data, config) {
				alert(data);
		});

	};
	$scope.BuscarInformacao();
	
});
