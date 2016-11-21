var myControllers = angular.module('NegocioControllers',[]);

//CONTROLER DE NEGÓCIOS
myControllers.controller('ListarNegocioController', function($scope,$http) {
	$scope.Titulo = "Negociações";
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
	$scope.Titulo = 'Editar Negociação'

	if($routeParams.negocioId){
		$http.get('http://localhost:8080/CRM/rest/restNegocio/Editar/'+$routeParams.negocioId)
		.success(function(data) {
			$scope.negocio = data;
			var negocio =  new Object();
			negocio = $scope.negocio 
			$scope.Titulo = "Negócio: "+ negocio.nome;

		});
	}
});
myControllers.controller('CadastrarNegocioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negociação";
	
});
myControllers.controller('NegocioController', function($scope, $routeParams, $http, $location) {
	
	$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
	.success(function(data) {
		$scope.usuarios = data["usuario"];
	});
	$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
	.success(function(data) {
		$scope.contatos = data["contato"];
	});
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
			usuarioresponsavel : $scope.negocio.usuarioresponsavel,
			empresa : $scope.negocio.empresa,
			contato : $scope.negocio.contato,
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
					$scope.negocio = data;
					var negocio =  new Object();
					negocio = $scope.negocio 
							
					alert("Negócio: "+ $scope.negocio.nome +". Salvo Com Sucesso!");
	
					$location.path('/Negocio/Editar/'+negocio.id)
					
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Esta Negociação?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restNegocio/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Negociação Excluída Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Negociação Conservada Com Sucesso!");
				$scope.BuscarInformacao();
			}
			
		};
			
			
	
});


//CONTROLER DE ITENS
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

		   var result = confirm("Tem Certeza Que Deseja Excluir Este Item?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restItem/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Item Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Item Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
			
		};
	
});