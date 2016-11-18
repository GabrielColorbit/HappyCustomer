var myControllers = angular.module('ItemControllers',[]);

myControllers.controller('ListarItemController', function($scope,$http) {
	$scope.Titulo = "Items";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restItem/listarTodos')
		.success(function(data) {
			$scope.listItens = data["item"];
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

myControllers.controller('CadastrarItemController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negócio";
	
});
myControllers.controller('ItemController', function($scope, $routeParams,$http) {
	
	$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
	.success(function(data) {
		$scope.empresas = data["empresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
	.success(function(data) {
		$scope.produtos = data["produto"];
	});
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "item",
			id : $scope.item.id,
			nome : $scope.item.nome,
			empresa : $scope.item.empresa,
			data : $scope.item.data,
			
			produto : $scope.item.produto,
			quantidade : $scope.item.quantidade
			
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restItem/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Item ('+$scope.item.produto.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restItem/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Item Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});