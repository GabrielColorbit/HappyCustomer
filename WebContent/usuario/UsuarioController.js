var myControllers = angular.module('UsuarioControllers',[]);



myControllers.controller('ListarUsuarioController', function($scope,$http) {
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
			$scope.usuario = data;
			var usuario=  new Object();
			usuario = $scope.usuario

		});
	}
});
myControllers.controller('CadastrarUsuarioController', function($scope, $routeParams,$http) {



	$scope.Resposta = 'Preencher campos de cadastro';

	$scope.Titulo = "Cadastrar Tipo de Contato";

});
myControllers.controller('UsuarioController', function($scope, $routeParams,$http) {

	
	$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
	.success(function(data) {
		$scope.usuarios = data["usuario"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/genders')
	.success(function(data) {
		$scope.generos = data["genero"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/status')
	.success(function(data) {
		$scope.statuslist = data["status"];
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
	$http.get('http://localhost:8080/CRM/rest/restTelefone/listarTodos')
	.success(function(data) {
		$scope.telefones = data["telefone"];
	});
    $scope.usuario = {
    		datanascimento: new Date(1990, 11, 28, 14, 57)
    };
	
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
			endereco : $scope.usuario.endereco,
			numero : $scope.usuario.numero,
			complemento: $scope.usuario.complemento,
			bairro: $scope.usuario.bairro,
			status: $scope.usuario.status,
			cep : $scope.usuario.cep


		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(
				'http://localhost:8080/CRM/rest/restUsuario/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Usuário '+$scope.usuario.nome+' Salvo com Sucesso!';


				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	   };
	   
	   //crud in view
	   
		$http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
		.success(function(data) {
			$scope.tipostelefone = data["tipoTelefone"];
		});
       $scope.UserTelefones = [];
       $scope.addTelefone = function () {
           $scope.UserTelefones.push($scope.telefone);
       }
       $scope.removeTelefone= function (telefone) {
           
           var index=$scope.UserTelefones.indexOf(telefone)
           $scope.UserTelefones.splice(index,1);     
       }
	   
	   

});
