
	function HappyCustomerController() {

	}

	angular.module('happyCustomerApp').component('topo', {
		templateUrl : 'http://localhost:8080/CRM/header.html',
		controller : HappyCustomerController,
		bindings : {}
	});
	angular.module('happyCustomerApp').component('rodape', {
		templateUrl : 'http://localhost:8080/CRM/footer.html',
		controller : HappyCustomerController,
		bindings : {}
	});


