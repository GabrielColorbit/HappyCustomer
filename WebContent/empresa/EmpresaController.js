var myControllers = angular.module('EmpresaControllers',[]);

myControllers.controller('ListarEmpresaController', function($scope,$http) {
	$scope.Titulo = "Empresas";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/listarTodos')
		.success(function(data) {
			$scope.empresalist = data["empresa"];
			$scope.Quantidade = $scope.empresalist.length+' Empresas Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetEmpresaController', function($scope, $routeParams,$http) {
	$scope.Titulo = "Editar Empresa";

	if($routeParams.empresaId){
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/Editar/'+$routeParams.empresaId)
		.success(function(data) {
			$scope.empresa = data;
			var empresa =  new Object();
			empresa = $scope.empresa 

		});
	}
});
myControllers.controller('CadastrarEmpresaController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Empresa";
	
});
myControllers.controller('EmpresaController', function($scope, $routeParams,$http) {
	
	$scope.EnviarInformacao = function() {
		
		var parameter = JSON.stringify({
			
			type : "empresa",
			id : $scope.empresa.id,
			usuarioresponsavel : $scope.empresa.usuarioresponsavel,
			tipoempresa : $scope.empresa.tipoempresa,
			cidade : $scope.empresa.cidade,
			
			razaosocial : $scope.empresa.razaosocial,
			cnpj : $scope.empresa.cnpj,
			inscricaoestadual : $scope.empresa.inscricaoestadual,
			endereco : $scope.empresa.endereco,
			numero : $scope.empresa.numero,
			complemento: $scope.empresa.complemento,
			cep : $scope.empresa.cep,
			bairro: $scope.empresa.bairro,
			ramo : $scope.empresa.ramo,
			site : $scope.empresa.site,
			status: $scope.empresa.status,			
			
			telefones_empresa : $scope.empresa.telefones_empresa,
			comunicadores_empresa : $scope.empresa.comunicadores_empresa

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}
		
		$http.post(
				'http://localhost:8080/CRM/rest/restEmpresa/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Empresa ('+$scope.empresa.nome+') Salva com Sucesso!';
					
					
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restEmpresa/Excluir/'+id)
					.success(
					function(data, status) {
						$scope.Resposta = 'Empresa Excluída com Sucesso!';
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
			
			};
	
});