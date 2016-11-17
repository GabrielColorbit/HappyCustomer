var myControllers = angular.module('LigacaoControllers',[]);

myControllers.controller('ListarLigacaoController', function($scope,$http) {
	$scope.Titulo = "Ligações";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restLigacao/listarTodos')
		.success(function(data) {
			$scope.ligacaolist = data["ligacao"];
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetLigacaoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Ligação";

	if($routeParams.ligacaoId){
		$http.get('http://localhost:8080/CRM/rest/restLigacao/Editar/'+$routeParams.ligacaoId)
		.success(function(data) {
			$scope.ligacao = data;
			var ligacao =  new Object();
			ligacao = $scope.ligacao 

		});
	}
});
myControllers.controller('CadastrarLigacaoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Ligação";
	
});
myControllers.controller('LigacaoController', function($scope, $routeParams,$http) {
	
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
	$http.get('http://localhost:8080/CRM/rest/restCollections/tipoligacao')
	.success(function(data) {
		$scope.tiposligacao = data["tipoLigacao"];
	});
	$http.get('http://localhost:8080/CRM/rest/restTelefone/listarTodos')
	.success(function(data) {
		$scope.telefones = data["telefone"];
	});
	
	
	$scope.EnviarInformacao = function() {		
		
		var parameter = JSON.stringify({
			
			type : "ligacao",
			id : $scope.ligacao.id,
			usuarioresponsavel : $scope.ligacao.usuarioresponsavel,
			contato : $scope.ligacao.contato,
			empresa : $scope.ligacao.empresa,
			telefone : $scope.ligacao.telefone,
			tipoligacao : $scope.ligacao.tipoligacao,
					
			data : $scope.ligacao.data,
			duracao : $scope.ligacao.duracao,
			resumo: $scope.ligacao.resumo		

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restLigacao/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Ligacao ('+$scope.ligacao.nome+') Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restLigacao/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Ligacao Excluída com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});