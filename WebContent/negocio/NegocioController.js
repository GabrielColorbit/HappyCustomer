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
		
//		$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
//		.success(function(data) {
//			$scope.usuarios = data["usuario"];
//		});
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

	if($routeParams.negocioId){
		$http.get('http://localhost:8080/CRM/rest/restNegocio/Editar/'+$routeParams.negocioId)
		.success(function(data) {
			$scope.negocio = data;
			var negocio =  new Object();
			negocio = $scope.negocio 
			$scope.Titulo = "Negócio: "+ negocio.nome;

		});
	}
	
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
	   
	   $scope.EnviarInformacaoItem = function() {
			
			//limpando ids de novos cadastros de itens
			for(var i=0; i <  Object.keys($scope.listItens).length; i ++){
				var x = $scope.listItens[i].id;
				var y = "#";
				if(x.indexOf(y) !== -1){
					$scope.listItens[i].id = null;
				}
			}

			$scope.itens = $scope.listItens;
			
			var parameter = JSON.stringify({
				type : "item",
				id : $scope.item.id,
				produto : $scope.item.produto,
				quantidade : $scope.item.quantidade		
				
//				item : $scope.itens
				
			});
			
			
//			$http.get('http://localhost:8080/CRM/rest/restItem/listarTodos')
//			.success(function(data) {
//				$scope.listItens = data["item"];
//			});
			
			$scope.listItens = [];
			//Genrenciar Itens
		 	$scope.addItem = function(){

		 	 if(validarCamposItem()){
		 		 if($scope.item.id == null){
		 					 autoincrementItem();
		 					 $scope.listItems.push({
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

		 	 }
		 	$scope.selectEditItem = function(id){

		 			 var SelItem = getSelectedItem(id);
		 				 $scope.item = {
		 						"id": SelItem.id,
		 						"produto": SelItem.produto,
		 						"quantidade":SelItem.quantidade
		 				};

		 	 };
		 	 
		 	$scope.delItem = function(id){
		 	 var result = confirm('Você deseja remover o item da lista?');
		 	 if (result === true){
		 		 for(var j = 0; j < $scope.listItens.length;j ++){
		 				 if($scope.listItens[j].id == id){
		 						 $scope.listItens.splice(j, 1);
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
		 	
		 	var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}
				
				$http.post(
						'http://localhost:8080/CRM/rest/restItem/Salvar',
						parameter, config).success(
						function(data, status, headers, config) {
							
							$scope.item = data;
							var item =  new Object();
							item = $scope.item 
									
							alert("Itens Salvo Com Sucesso!");						
							
						}).error(
						function(data, status, header, config) {
							$scope.Resposta = data ;
						});
			   };
	   
});

myControllers.controller('CadastrarNegocioController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Negociação";
	
});
myControllers.controller('NegocioController', function($scope, $routeParams, $http, $location) {
	
//	$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
//	.success(function(data) {
//		$scope.usuarios = data["usuario"];
//	});
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
			
	};
	
});