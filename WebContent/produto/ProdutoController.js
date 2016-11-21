var myControllers = angular.module('ProdutoControllers',[]);

myControllers.controller('ListarProdutoController', function($scope,$http) {
	$scope.Titulo = "Produtos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
		.success(function(data) {
			$scope.produtolist = data["produto"];
			$scope.Quantidade = $scope.produtolist.length+' Produtos Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetProdutoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Produto";

	if($routeParams.produtoId){
		$http.get('http://localhost:8080/CRM/rest/restProduto/Editar/'+$routeParams.produtoId)
		.success(function(data) {
			$scope.produto = data;
			var produto =  new Object();
			produto = $scope.produto 

		});
	}
});
myControllers.controller('CadastrarProdutoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Produto";
	
});
myControllers.controller('ProdutoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "produto",
			id : $scope.produto.id,
			nome : $scope.produto.nome,
			preco : $scope.produto.preco
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restProduto/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {

					alert("Produto: "+ $scope.produto.nome +" - Preço: R$ "+ $scope.produto.preco +". Salvo Com Sucesso!");					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   
		   var result = confirm("Tem Certeza Que Deseja Excluir Este Produto?");
			if (result === true){
				if(id){
					
					$http.post('http://localhost:8080/CRM/rest/restProduto/Excluir/'+id)
						.success(
						function(data, status) {
							alert("Produto Excluído Com Sucesso!");
							$scope.BuscarInformacao();
							
						}).error(
						function(data, status) {
							$scope.Resposta = data ;
						});
				   };
			}
			else{
				alert("Produto Conservado Com Sucesso!");
				$scope.BuscarInformacao();
			}
			
		};
	
});