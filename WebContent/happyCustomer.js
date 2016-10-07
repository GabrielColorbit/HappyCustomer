(function(angular) {
    'use strict';
	function HappyCustomerController() {
	
	}

	angular.module('happyCustomerApp').component('topo', {
	  templateUrl: 'http://localhost:8080/CRM/header.html',
	  controller: HappyCustomerController,
	  bindings: {}
	});
	angular.module('happyCustomerApp').component('rodape', {
	  templateUrl: 'http://localhost:8080/CRM/footer.html',
	  controller: HappyCustomerController,
	  bindings: {}
	});
	
	
	
	
})(window.angular);

/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/