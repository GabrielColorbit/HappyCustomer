var myControllers = angular.module('UsuarioControllers',[]);



myControllers.controller('ListarUsuarioController', function($scope,$http, svc) {
	$scope.Titulo = "Usuários";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
		.success(function(data) {
			$scope.usuarios = data["usuario"];
		});
		$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
		.success(function(data) {
			$scope.estados = data["estado"];
		});
		$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
		.success(function(data) {
			$scope.cidades = data["cidade"];
		});
		$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
		.success(function(data) {
			$scope.tiposusuario = data["tipousuario"];
		});
	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetUsuarioController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Usuário";
	if($routeParams.tipocontatoId){
		$http.get('http://localhost:8080/CRM/rest/restUsuario/Editar/'+$routeParams.tipocontatoId)
		.success(function(data) {
			$scope.tipoContato = data;
			var tipoContato =  new Object();
			tipoContato = $scope.tipoContato 

		});
	}
});
myControllers.controller('CadastrarUsuarioController', function($scope, $routeParams,$http) {



	
	$scope.Titulo = "Cadastrar Tipo de Contato";
	
});
myControllers.controller('UsuarioController', function($scope, $routeParams,$http) {
	$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
	.success(function(data) {
		$scope.usuarios = data["usuario"];
	});
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
	.success(function(data) {
		$scope.cidades = data["cidade"];
	});
	$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
	.success(function(data) {
		$scope.tiposusuario = data["tipoUsuario"];
	});
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			type : "usuario",
			id : $scope.usuario.id,
			nome : $scope.usuario.nome,
			tipousuario : $scope.usuario.tipousuario,
			cidade : $scope.cidade,
			telefones: $scope.telefones,
			email : $scope.email,
			senha : $scope.senha,
			cpf : $scope.cpf,
			genero : $scope.genero,
			cargo : $scope.cargo,
			datanascimento : $scope.datanascimento,
			endereco : $scope.endereco,
			numero : $scope.numero,
			cep : $scope.cep
			
			
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restTipoContato/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Tipo Contato Salvo com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	   };
	
});

