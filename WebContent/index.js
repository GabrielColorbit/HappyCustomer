(function(angular) {
	'use strict';

	angular.module('happyCustomerApp', []).controller('MainCtrl',
			function MainCtrl() {
				this.header = {};
			});

	angular.module('happyCustomerApp', []).controller('MainCtrl',
			function MainCtrl() {
				this.rodape = {};
			});
	

	
	angular.module('happyCustomerApp', []).controller('tipocontatoController',
			function($scope) {
//				$scope.listTipoContato = [ {
//					id : 1,
//					nome : 'Prospect'
//				}, {
//					id : 2,
//					nome : 'Administrador'
//				}, {
//					id : 3,
//					nome : 'Diretor'
//				} ];

				$scope.add = function() {
					$scope.listTipoContato.push({
						id : $scope.id,
						nome : $scope.nome
					});
					$scope.id = '';
					$scope.nome = '';
				}
				$scope.edit = function() {
					var index = getSelectedIndex($scope.id);
					$scope.listTipoContato[index].id = $scope.id;
					$scope.listTipoContato[index].nome = $scope.nome;

				}

				$scope.selectEdit = function(id) {
					var index = getSelectedIndex(id);
					var TipoContato = $scope.listTipoContato[index];

					$scope.tipoContato.id = TipoContato.id;
					$scope.tipoContato.nome = TipoContato.nome;

				};

				$scope.del = function(id) {
					var result = confirm('Tem certeza?');
					if (result === true) {
						var index = getSelectedIndex(id);
						$scope.listTipoContato.splice(index, 1);
					}

				};
				function getSelectedIndex(id) {
					for (var i = 0; i < $scope.listTipoContato.length; i++)
						if ($scope.listTipoContato[i].id == id)
							return i;
					return -1;

				}

			});

})(window.angular);
/*
 * Copyright 2016 Google Inc. All Rights Reserved. Use of this source code is
 * governed by an MIT-style license that can be found in the LICENSE file at
 * http://angular.io/license
 */