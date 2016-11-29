function HappyCustomerController() {}
app.component('topo', {
	templateUrl : 'http://localhost:8080/CRM/header.html',
	controller : HappyCustomerController,
	bindings : {}
});
app.component('rodape', {
	templateUrl : 'http://localhost:8080/CRM/footer.html',
	controller : HappyCustomerController,
	bindings : {}
});


