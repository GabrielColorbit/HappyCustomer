var myControllers = angular.module('NegocioControllers',[]);

myControllers.controller('ListarNegocioController', function($scope,$http) {
	$scope.Titulo = "Negócios";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restNegocio/listarTodos')
		.success(function(data) {
			$scope.negociolist = data["negocio"];
			$scope.Quantidade = $scope.negociolist.length+' Negócios Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetNegocioController', function($scope, $routeParams,$http) {
	$scope.Titulo = 'Editar Negócio'

	if($routeParams.negocioId){
		$http.get('http://localhost:8080/CRM/rest/restNegocio/Editar/'+$routeParams.negocioId)
		.success(function(data) {
			$scope.negocio = data;
			var negocio =  new Object();
			negocio = $scope.negocio 

		});
	}
});
myControllers.controller('CadastrarNegocioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negócio";
	
});
myControllers.controller('NegocioController', function($scope, $routeParams,$http) {
	
	$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
	.success(function(data) {
		$scope.empresas = data["empresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
	.success(function(data) {
		$scope.produtos = data["produto"];
	});
	
	$scope.EnviarInformacaoNegocio = function() {
		
		var parameter = JSON.stringify({
			type : "negocio",
			id : $scope.negocio.id,
			nome : $scope.negocio.nome,
			empresa : $scope.negocio.empresa,
			data : $scope.negocio.data
			
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restNegocio/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Negócio ('+$scope.negocio.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restNegocio/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Negócio Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
			
			
	
});

myControllers.controller('ListarItemController', function($scope,$http) {
	$scope.Titulo = "Itens";
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
	
	$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
	.success(function(data) {
		$scope.produtos = data["produto"];
	});
	
	$scope.EnviarInformacaoItem = function() {
		
		var parameter = JSON.stringify({
			type : "item",
			id : $scope.item.id,			
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