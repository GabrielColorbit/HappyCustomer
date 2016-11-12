var myControllers = angular.module('ContatoControllers',[]);

myControllers.controller('ListarContatoController', function($scope,$http) {
	$scope.Titulo = "Contatos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
		.success(function(data) {
			$scope.contatolist = data["contato"];
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetContatoController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Contato";

	if($routeParams.contatoId){
		$http.get('http://localhost:8080/CRM/rest/restContato/Editar/'+$routeParams.contatoId)
		.success(function(data) {
			$scope.contato = data;
			var contato =  new Object();
			contato = $scope.contato 

		});
	}
});
myControllers.controller('CadastrarContatoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Contato";
	
});
myControllers.controller('ContatoController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			
			type : "contato",
			id : $scope.contato.id,
			usuarioresponsavel : $scope.contato.usuarioresponsavel,
			tipocontato : $scope.contato.tipocontato,
			origemcontato : $scope.contato.origemcontato,
			cidade : $scope.contato.cidade,
					
			nome : $scope.contato.nome,
			datanascimento : $scope.contato.datanascimento,
			cpf : $scope.contato.cpf,
			endereco : $scope.contato.endereco,
			numero : $scope.contato.numero,
			complemento: $scope.contato.complemento,
			cep : $scope.contato.cep,
			bairro: $scope.contato.bairro,
			genero : $scope.contato.genero,
			cargo : $scope.contato.cargo,
			status: $scope.contato.status,			
			
			telefones_contato : $scope.contato.telefones_contato,
			comunicadores_contato : $scope.contato.comunicadores_contato

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restContato/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Contato ('+$scope.contato.nome+') Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restContato/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Contato Excluído com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});