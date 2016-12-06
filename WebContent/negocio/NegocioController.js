var myControllers = angular.module('NegocioControllers',[]);

//CONTROLER DE NEGÓCIOS
myControllers.controller('ListarNegocioController', function($scope,$http) {
	$scope.Titulo = "Negociações";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restNegocio/listarTodos')
		.success(function(data) {
			$scope.negociolist = data["negocio"];
			$scope.Quantidade = $scope.negociolist.length+' Negociações Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetNegocioController', function($scope, $routeParams, $http, $location, $cookies) {
		$scope.Titulo = 'Editar Negociação'


		var negocio =  new Object();
		
		var hash = $cookies.get('hash');
		var config = {
			 headers : {
				 'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
			 }
		 }
		 $http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos',config)
	 	.success(function(data, config) {
	 		$scope.usuarios = data["usuario"];
	 	});
		$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
		.success(function(data) {
			$scope.contatos = data["contato"];
		});
		$http.get('http://localhost:8080/CRM/rest/restCollections/situacao', config)
		 .success(function(data, config) {
			 $scope.situacoes = data["situacao"];
		 });
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
		.success(function(data) {
			$scope.empresas = data["empresa"];
		});
		$http.get('http://localhost:8080/CRM/rest/restProduto/listarTodos')
		.success(function(data) {
			$scope.produtos = data["produto"];
		});	
		
	if($routeParams.negocioId){
		$http.get('http://localhost:8080/CRM/rest/restNegocio/Editar/'+$routeParams.negocioId)
		.success(function(data) {
			$scope.negocio = data;
		
			negocio = $scope.negocio
			$scope.Titulo = "Negociação: "+ negocio.nome;
			
			$scope.listItens=[];
			$scope.listItens = negocio.itens_negocio;

			//validação de array de itens
			if($scope.negocio.itens_negocio){
				if($scope.negocio.itens_negocio.constructor == Array){
						$scope.listItens = $scope.negocio.itens_negocio;
				}else{
					$scope.listItens = [];
					var item = $scope.negocio.itens_negocio;
					$scope.listItens.push(item);
				}
			}
			else{//caso nao exista
				$scope.listItens = [];
			}
			//calcula total de negocio
			$scope.Calcular = function(){
				if($scope.listItens){
					
					var total = 0;
					for(var x in $scope.listItens){
						var item = $scope.listItens[x];
						var subtotal = item.quantidade * item.produto.preco;
						total = total+ subtotal;
					}
					total = Math.round(total * 100) / 100;
					$scope.total = "Total: R$"+total;
					
					$scope.negocio.valor = total;
				}
			}
			$scope.Calcular();
			
			
		});
		
	}
	
	$scope.EnviarInformacaoNegocio = function() {		

		//limpando ids de novos cadastros de itens
		for(var i=0; i <  Object.keys($scope.listItens).length; i ++){
			var x = $scope.listItens[i].id;
			var y = "#";
			if(x.indexOf(y) !== -1){
				$scope.listItens[i].id = null;
			}
		}
		
		$scope.negocio.itens_negocio =  $scope.listItens;
		
		var parameter = JSON.stringify({
			type : "negocio",
			id : $scope.negocio.id,
			nome : $scope.negocio.nome,
			usuarioresponsavel : $scope.negocio.usuarioresponsavel,
			empresa : $scope.negocio.empresa,
			contato : $scope.negocio.contato,
			data : $scope.negocio.data,
			valor : $scope.negocio.valor,
			situacao : $scope.negocio.situacao,
			
			itens_negocio : $scope.negocio.itens_negocio
			
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
							
					alert("Negociação: "+ $scope.negocio.nome +". Salvo Com Sucesso!");
					
					$location.path("/Negocio");
					
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
			   
				//Genrenciar Itens
			 	$scope.addItem = function(){

			 	 if(validarCamposItem()){
			 		 if($scope.item.id == null){
			 					 autoincrementItem();
			 					 $scope.listItens.push({
			 							 id: $scope.item.id , produto:$scope.item.produto, quantidade:$scope.item.quantidade
			 						 });
			 					 $scope.item = { "id": null,"produto": '',"quantidade":''};
			 				 }else{
			 						 var index = getSelectedIndexItem($scope.item.id);

			 						 $scope.listItens[index].produto = $scope.item.produto;
			 						 $scope.listItens[index].quantidade = $scope.item.quantidade;
			 						 $scope.item = {
			 									"id": null,
			 									"produto": '',
			 									"quantidade":''
			 						};
			 				 }
			 	 }
			 	$scope.Calcular();
			 	 }
			 	$scope.selectEditItem = function(id){

			 			 var SelItem = getSelectedItem(id);
			 				 $scope.item = {
			 						"id": SelItem.id,
			 						"produto": SelItem.produto,
			 						"quantidade": SelItem.quantidade
			 				};
			 				$scope.Calcular();
			 	 };
			 	 
			 	$scope.delItem = function(id){
			 	 var result = confirm('Você deseja remover o item da lista?');
			 	 if (result === true){
			 		 for(var j = 0; j < $scope.listItens.length;j ++){
			 				 if($scope.listItens[j].id == id){
			 						 $scope.listItens.splice(j, 1);
			 						$scope.Calcular();
			 				 }
			 		 }
			 	 }
			 	};
			 	function getSelectedItem(id){
			 		 for(var i=0; i <  Object.keys($scope.listItens).length; i ++)
			 			 if($scope.listItens[i].id == id)
			 				 return $scope.listItens[i];
			 		 return 1;

			 	}
			 	function getSelectedIndexItem(id){
			 		 for(var i=0; i <  Object.keys($scope.listItens).length; i ++)
			 			 if($scope.listItens[i].id == id)
			 				 return i;
			 		 return 1;
			 	}
			 	function autoincrementItem(){
			 		 if($scope.listItens){
			 			 $scope.item.id ="#"+Object.keys($scope.listItens).length;
			 		 }else{
			 			 $scope.item.id ="#"+1;
			 		 }

			 	 }
			 	function validarCamposItem(){
			 			 var i;
			 			 if($scope.item){
			 					 if(! $scope.item.produto ){
			 						 alert("Favor selecionar um Produto.");
			 						 i = false;
			 					 }else if(! $scope.item.quantidade){
			 						 alert("Preencha o campo Quantidade.");
			 					 }else{
			 						 i = true
			 					 }
			 		 }else{
			 			 alert("Favor preencher os campos Produto e Quantidade.");
			 			 i = false;
			 		 }
			 			 return i;
			 	}
	   
});

myControllers.controller('CadastrarNegocioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negociação";
	
});
myControllers.controller('NegocioController', function($scope, $routeParams, $http, $location, $cookies) {
	
	var hash = $cookies.get('hash');
	var config = {
		 headers : {
			 'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
		 }
	 }
	 $http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos',config)
 	.success(function(data, config) {
 		$scope.usuarios = data["usuario"];
 	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/situacao', config)
	 .success(function(data, config) {
		 $scope.situacoes = data["situacao"];
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
			data : $scope.negocio.data,
			situacao : $scope.negocio.situacao,
			itens_negocio : $scope.negocio.itens_negocio
			
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
							
					alert("Negociação: "+ $scope.negocio.nome +". Salvo Com Sucesso!");
					
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