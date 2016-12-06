var myControllers = angular.module('HomeControllers',[]);


myControllers.controller('ListarAtividadePorDataController', function($scope,$http,$cookies) {
	$scope.BuscarInformacao = function() {

		$http.get('http://localhost:8080/CRM/rest/restAtividade/listarAtivos')
		.success(function(data, config) {
			
			
			var atividadelist = data["atividade"];
			$scope.atividadelist= [];
			//validação de array de telefones
			if(atividadelist){
				if(atividadelist.constructor == Array){
					$scope.atividadelist = atividadelist;
				}else{
					
					var atividade = atividadelist;
					$scope.atividadelist.push(atividade);
				}
			}
			else{
				$scope.atividadelist = [];
			}
			
			
			$scope.Quantidade = $scope.atividadelist.length+' Atividades Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();

});
myControllers.controller('ListarAtividadePorUsuarioController', function($scope,$http,$cookies) {
	$scope.BuscarInformacao = function() {
		var usuario = $scope.usuarioLogado = $cookies.getObject('usuarioLogado');
		$http.get('http://localhost:8080/CRM/rest/restAtividade/listarAtividadeUsuario/'+ usuario.id)
		.success(function(data, config) {
			var atividadelist = data["atividade"];
			$scope.atividadelist= [];
			//validação de array de telefones
			if(atividadelist){
				if(atividadelist.constructor == Array){
						$scope.atividadelist = atividadelist;
				}else{
					
					var atividade = atividadelist;
					$scope.atividadelist.push(atividade);
				}
			}
			else{
				$scope.atividadelist = [];
			}
			
			
			
			$scope.Quantidade = $scope.atividadelist.length+' Atividades Encontradas!' ;
		});
	};
	$scope.BuscarInformacao();

});
myControllers.controller('NegocioAndamentoController', function($scope,$http, $cookies) {
	$scope.BuscarInformacao = function() {
		var usuario = $scope.usuarioLogado = $cookies.getObject('usuarioLogado');
		$http.get('http://localhost:8080/CRM/rest/restNegocio/listarNegocioPendente/')
		.success(function(data) {
			$scope.negociolist = data["negocio"];
			var negociolist = data["negocio"];
			$scope.negociolist= [];
			//validação de array de telefones
			if(negociolist){
				if(negociolist.constructor == Array){
						$scope.negociolist = negociolist;
				}else{
					
					var negocio = negociolist;
					$scope.negociolist.push(negocio);
				}
			}
			else{
				$scope.negociolist = [];
			}
			
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
