var app = angular.module('happyCustomerApp', ['ngRoute']);

app.controller('MainCtrl',
	function MainCtrl() {
		this.header = {};
	});
	
app.controller('MainCtrl',
	function MainCtrl() {
		this.rodape = {};
});
app.config(function ($routeProvider) {
    $routeProvider.
        when('/editar', {templateUrl: 'partials/editar_tipo_contato.html', controller: 'TipoContatoController'}).
//        when('/listar', {templateUrl: 'partials/listar_tipo_contato.html', controller: 'TipoContatoController'}).
        when('/cadastrar', {templateUrl: 'partials/criar_tipo_contato.html', controller: 'TipoContatoController'}).
        otherwise({redirectTo: '/'});
	}).controller('TipoContatoController', function ($scope, StateService) {
        $scope.title = 'Experiments Page';
	    $scope.message = StateService.getMessage();
	    $scope.SelecionarParaEditar = StateService.getMessage();
	    $scope.updateMessage = function (m) {
	        StateService.setMessage(m);
	        
	    };
	    
}).factory('StateService', function () {
    var message = 'Hello Message';
    var getMessage = function () {
        return message;
    };
    var setMessage = function (m) {
        message = m;
    };

    return {
        getMessage: getMessage,
        setMessage: setMessage
    }
});

	
//app.controller('tipocontatoController',
//	function($scope) {
//	//			$scope.listTipoContato = [ {
//	//				id : 1,
//	//				nome : 'Prospect'
//	//			}, {
//	//				id : 2,
//	//				nome : 'Administrador'
//	//			}, {
//	//				id : 3,
//	//				nome : 'Diretor'
//	//			} ];
//	
//		$scope.add = function() {
//			$scope.listTipoContato.push({
//				id : $scope.id,
//				nome : $scope.nome
//			});
//			$scope.id = '';
//			$scope.nome = '';
//		}
//		$scope.edit = function() {
//			var index = getSelectedIndex($scope.id);
//			$scope.listTipoContato[index].id = $scope.id;
//			$scope.listTipoContato[index].nome = $scope.nome;
//	
//		}
//	
//		$scope.selectEdit = function(id) {
//			var index = getSelectedIndex(id);
//			var TipoContato = $scope.listTipoContato[index];
//	
//			$scope.tipoContato.id = TipoContato.id;
//			$scope.tipoContato.nome = TipoContato.nome;
//	
//		};
//	
//		$scope.del = function(id) {
//			var result = confirm('Tem certeza?');
//			if (result === true) {
//				var index = getSelectedIndex(id);
//				$scope.listTipoContato.splice(index, 1);
//			}
//	
//		};
//		function getSelectedIndex(id) {
//			for (var i = 0; i < $scope.listTipoContato.length; i++)
//				if ($scope.listTipoContato[i].id == id)
//					return i;
//			return -1;
//	
//		}
//	
//	});
//

/*
 * Copyright 2016 Google Inc. All Rights Reserved. Use of this source code is
 * governed by an MIT-style license that can be found in the LICENSE file at
 * http://angular.io/license
 */