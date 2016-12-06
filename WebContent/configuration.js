var app = angular.module('happyCustomerApp', [
	'ngRoute',
	'angularUtils.directives.dirPagination',
	'angularFileUpload',
	'ngFileUpload',
	'ngImgCrop',
	'ngCookies',
	'UsuarioControllers',
	'TipoContatoControllers',
	'CidadeControllers',
	'TipoUsuarioControllers',
	'OrigemContatoControllers',
	'TipoAtividadeControllers',
	'TipoTelefoneControllers',
	'TipoComunicadorControllers',
	'TipoEmpresaControllers',
	'EstadoControllers',
	'ProdutoControllers',
	'NegocioControllers',
	'EmpresaControllers',
	'ContatoControllers',
	'AtividadeControllers',
	'LigacaoControllers',
	'LoginControllers',
	'HeaderControllers',
	'amChartsDirective',
	'RelatorioController',
	'HomeControllers'


]);


app.controller('MainCtrl', function MainCtrl($scope, $cookies) {
	this.header = {};


});

app.controller('MainCtrl',
	function MainCtrl($scope) {
		this.rodape = {};
});




app.config(function ($routeProvider) {


	var myControllers = angular.module('SessionControllers',[]);


    $routeProvider.
		//Paths of Home
    	when('/Home/', {templateUrl: 'home/home.html',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
    	}).

    	//Paths of Tipo Contato
        when('/TipoContato/Editar/:tipocontatoId', {templateUrl: 'tipo_contato/partials/editar_tipo_contato.html', controller: 'GetTipoContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoContato', {templateUrl: 'tipo_contato/partials/listar_tipo_contato.html', controller: 'ListarTipoContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoContato/Cadastrar', {templateUrl: 'tipo_contato/partials/criar_tipo_contato.html', controller:'CadastrarTipoContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Usuario
        when('/Usuario/Editar/:usuarioId', {templateUrl: 'usuario/partials/editar_usuario.html', controller: 'GetUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Usuario', {templateUrl: 'usuario/partials/listar_usuario.html', controller: 'ListarUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Usuario/Cadastrar', {templateUrl: 'usuario/partials/criar_usuario.html', controller:'CadastrarUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Telefone
        when('/Telefone/Editar/:telefoneId', {templateUrl: 'telefone/partials/editar_telefone.html', controller: 'GetTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Telefone', {templateUrl: 'telefone/partials/listar_telefone.html', controller: 'ListarTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Telefone/Cadastrar', {templateUrl: 'telefone/partials/criar_telefone.html', controller:'CadastrarTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Cidade
        when('/Cidade/Editar/:cidadeId', {templateUrl: 'cidade/partials/editar_cidade.html', controller: 'GetCidadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Cidade', {templateUrl: 'cidade/partials/listar_cidade.html', controller: 'ListarCidadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Cidade/Cadastrar', {templateUrl: 'cidade/partials/criar_cidade.html', controller:'CadastrarCidadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Tipo Usuário                                                                                        chama o metodo
        when('/TipoUsuario/Editar/:tipousuarioId', {templateUrl: 'tipo_usuario/partials/editar_tipo_usuario.html', controller: 'GetTipoUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoUsuario', {templateUrl: 'tipo_usuario/partials/listar_tipo_usuario.html', controller: 'ListarTipoUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoUsuario/Cadastrar', {templateUrl: 'tipo_usuario/partials/criar_tipo_usuario.html', controller:'CadastrarTipoUsuarioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Origem Contato
        when('/OrigemContato/Editar/:origemcontatoId', {templateUrl: 'origem_contato/partials/editar_origem_contato.html', controller: 'GetOrigemContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/OrigemContato', {templateUrl: 'origem_contato/partials/listar_origem_contato.html', controller: 'ListarOrigemContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/OrigemContato/Cadastrar', {templateUrl: 'origem_contato/partials/criar_origem_contato.html', controller:'CadastrarOrigemContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Tipo Atividade
        when('/TipoAtividade/Editar/:tipoatividadeId', {templateUrl: 'tipo_atividade/partials/editar_tipo_atividade.html', controller: 'GetTipoAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoAtividade', {templateUrl: 'tipo_atividade/partials/listar_tipo_atividade.html', controller: 'ListarTipoAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoAtividade/Cadastrar', {templateUrl: 'tipo_atividade/partials/criar_tipo_atividade.html', controller:'CadastrarTipoAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Tipo Telefone
        when('/TipoTelefone/Editar/:tipotelefoneId', {templateUrl: 'tipo_telefone/partials/editar_tipo_telefone.html', controller: 'GetTipoTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoTelefone', {templateUrl: 'tipo_telefone/partials/listar_tipo_telefone.html', controller: 'ListarTipoTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoTelefone/Cadastrar', {templateUrl: 'tipo_telefone/partials/criar_tipo_telefone.html', controller:'CadastrarTipoTelefoneController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Tipo Comunicador
        when('/TipoComunicador/Editar/:tipocomunicadorId', {templateUrl: 'tipo_comunicador/partials/editar_tipo_comunicador.html', controller: 'GetTipoComunicadorController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoComunicador', {templateUrl: 'tipo_comunicador/partials/listar_tipo_comunicador.html', controller: 'ListarTipoComunicadorController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoComunicador/Cadastrar', {templateUrl: 'tipo_comunicador/partials/criar_tipo_comunicador.html', controller:'CadastrarTipoComunicadorController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Tipo Empresa
        when('/TipoEmpresa/Editar/:tipoempresaId', {templateUrl: 'tipo_empresa/partials/editar_tipo_empresa.html', controller: 'GetTipoEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoEmpresa', {templateUrl: 'tipo_empresa/partials/listar_tipo_empresa.html', controller: 'ListarTipoEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/TipoEmpresa/Cadastrar', {templateUrl: 'tipo_empresa/partials/criar_tipo_empresa.html', controller:'CadastrarTipoEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Produto
        when('/Produto/Editar/:produtoId', {templateUrl: 'produto/partials/editar_produto.html', controller: 'GetProdutoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Produto', {templateUrl: 'produto/partials/listar_produto.html', controller: 'ListarProdutoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Produto/Cadastrar', {templateUrl: 'produto/partials/criar_produto.html', controller:'CadastrarProdutoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Estado
        when('/Estado/Editar/:estadoId', {templateUrl: 'estado/partials/editar_estado.html', controller: 'GetEstadoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Estado', {templateUrl: 'estado/partials/listar_estado.html', controller: 'ListarEstadoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Estado/Cadastrar', {templateUrl: 'estado/partials/criar_estado.html', controller:'CadastrarEstadoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Negocio
        when('/Negocio/Editar/:negocioId', {templateUrl: 'negocio/partials/editar_negocio.html', controller: 'GetNegocioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Negocio', {templateUrl: 'negocio/partials/listar_negocio.html', controller: 'ListarNegocioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Negocio/Cadastrar', {templateUrl: 'negocio/partials/criar_negocio.html', controller:'CadastrarNegocioController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Empresa
        when('/Empresa/Editar/:empresaId', {templateUrl: 'empresa/partials/editar_empresa.html', controller: 'GetEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Empresa', {templateUrl: 'empresa/partials/listar_empresa.html', controller: 'ListarEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Empresa/Cadastrar', {templateUrl: 'empresa/partials/criar_empresa.html', controller:'CadastrarEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Contato
        when('/Contato/Editar/:contatoId', {templateUrl: 'contato/partials/editar_contato.html', controller: 'GetContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Contato', {templateUrl: 'contato/partials/listar_contato.html', controller: 'ListarContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Contato/Cadastrar', {templateUrl: 'contato/partials/criar_contato.html', controller:'CadastrarContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Atividade
        when('/Atividade/Editar/:atividadeId', {templateUrl: 'atividade/partials/editar_atividade.html', controller: 'GetAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Atividade', {templateUrl: 'atividade/partials/listar_atividade.html', controller: 'ListarAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Atividade/Cadastrar', {templateUrl: 'atividade/partials/criar_atividade.html', controller:'CadastrarAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

        //Paths of Ligacao
        when('/Ligacao/Editar/:ligacaoId', {templateUrl: 'ligacao/partials/editar_ligacao.html', controller: 'GetLigacaoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Ligacao', {templateUrl: 'ligacao/partials/listar_ligacao.html', controller: 'ListarLigacaoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/Ligacao/Cadastrar', {templateUrl: 'ligacao/partials/criar_ligacao.html', controller:'CadastrarLigacaoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).

		when('/Ligacao/Cadastrar', {templateUrl: 'ligacao/partials/criar_ligacao.html', controller:'CadastrarLigacaoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
		}).

        //Paths of Login
        when('/Login', {templateUrl: 'login/login.html', controller:'LoginController'}).

        //Paths of Relatorio
        when('/RelatorioAtividades/:idempresa', {templateUrl: 'relatorio/atividade/atividade.html', controller:'RelatorioAtividadeController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
		when('/RelatorioNegocioEmpresa', {templateUrl: 'relatorio/negocio/negocioempresa.html', controller:'RelatorioNegocioEmpresaController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/RelatorioNegocioContato', {templateUrl: 'relatorio/negocio/negociocontato.html', controller:'RelatorioNegocioContatoController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        when('/AtividadesPorStatus', {templateUrl: 'relatorio/atividade/atividadeporstatus.html', controller:'AtividadePorStatusController',
    	    resolve:{
    	        "check":function($cookies, $location ){
    	        	var hash = $cookies.get('hash');
    				if(!hash){
    					alert("É preciso estar logado para acessar esta página");
    					$location.path('/Login');
    				}
    	        }
    	    }
        }).
        
        //Paths of Home
        otherwise({redirectTo: '/Home'});
});
