var app = angular.module('happyCustomerApp', [
	'ngRoute', 
	'angularUtils.directives.dirPagination',
	'TipoContatoControllers'
]);

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
		//Paths of Home 
    	when('/Home/', {templateUrl: 'home/home.html'}).
    
    	//Paths of Tipo Contato    
        when('/TipoContato/Editar/:tipocontatoId', {templateUrl: 'tipo_contato/partials/editar_tipo_contato.html', controller: 'GetTipoContatoController'}).
        when('/TipoContato', {templateUrl: 'tipo_contato/partials/listar_tipo_contato.html', controller: 'ListarTipoContatoController'}).
        when('/TipoContato/Cadastrar', {templateUrl: 'tipo_contato/partials/criar_tipo_contato.html', controller:'CadastrarTipoContatoController'}).
        //Paths of Tipo Contato
        otherwise({redirectTo: '/Home'});
});

