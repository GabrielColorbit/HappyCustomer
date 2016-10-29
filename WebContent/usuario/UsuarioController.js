var myControllers = angular.module('UsuarioControllers',[]);



myControllers.controller('ListarUsuarioController', function($scope,$http, svc) {
	$scope.Titulo = "Usuários";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
		.success(function(data) {
			$scope.usuarios = data["usuario"];
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


	$http.get('http://localhost:8080/CRM/rest/restGenero/listarTodos')
	.success(function(data) {
		$scope.generos = data["genero"];
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
			cidade : $scope.usuario.cidade,
			telefones: $scope.usuario.telefones,
			email : $scope.usuario.email,
			senha : $scope.usuario.senha,
			cpf : $scope.usuario.cpf,
			genero : $scope.usuario.genero,
			cargo : $scope.usuario.cargo,
			datanascimento : $scope.usuario.datanascimento,
			endereco : $scope.usuarioendereco,
			numero : $scope.usuario.numero,
			cep : $scope.usuario.cep


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
