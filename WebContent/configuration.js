var app = angular.module('happyCustomerApp', [
	'ngRoute', 
	'angularUtils.directives.dirPagination',
	'UsuarioControllers',
	'TipoContatoControllers',
	'CidadeControllers'
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
        
        //Paths of Usuario    
        when('/Usuario/Editar/:tipocontatoId', {templateUrl: 'usuario/partials/editar_usuario.html', controller: 'GetUsuarioController'}).
        when('/Usuario', {templateUrl: 'usuario/partials/listar_usuario.html', controller: 'ListarUsuarioController'}).
        when('/Usuario/Cadastrar', {templateUrl: 'usuario/partials/criar_usuario.html', controller:'CadastrarUsuarioController'}).
        
        //Paths of Telefone    
        when('/Telefone/Editar/:telefoneId', {templateUrl: 'telefone/partials/editar_telefone.html', controller: 'GetTelefoneController'}).
        when('/Telefone', {templateUrl: 'telefone/partials/listar_telefone.html', controller: 'ListarTelefoneController'}).
        when('/Telefone/Cadastrar', {templateUrl: 'telefone/partials/criar_telefone.html', controller:'CadastrarTelefoneController'}).
        
        //Paths of Telefone    
        when('/Cidade/Editar/:cidadeId', {templateUrl: 'cidade/partials/editar_cidade.html', controller: 'GetCidadeController'}).
        when('/Cidade', {templateUrl: 'cidade/partials/listar_cidade.html', controller: 'ListarCidadeController'}).
        when('/Cidade/Cadastrar', {templateUrl: 'cidade/partials/criar_cidade.html', controller:'CadastrarCidadeController'}).
        
        
        //Paths of Tipo Contato
        otherwise({redirectTo: '/Home'});
});

