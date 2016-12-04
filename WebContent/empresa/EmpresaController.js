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
myControllers.controller('GetEmpresaController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location, $cookies) {
	$scope.Titulo = "Editar Empresa";
	var empresa =  new Object();
	
	if($routeParams.empresaId){
		$http.get('http://localhost:8080/CRM/rest/restEmpresa/Editar/'+$routeParams.empresaId, config)
		.success(function(data) {
			$scope.empresa = data;		
			empresa = $scope.empresa
			$scope.foto = {
					"id":$scope.empresa.idfoto
			}
			
			$scope.empresa.datacadastro = $filter('date')(empresa.datacadastro, "yyyy-MM-dd");

			//validação de array de telefones
			if($scope.empresa.telefones_empresa){
				if($scope.empresa.telefones_empresa.constructor == Array){
						$scope.listTelefones = $scope.empresa.telefones_empresa;
				}else{
					$scope.listTelefones = [];
					var telefone = $scope.empresa.telefones_empresa;
					$scope.listTelefones.push(telefone);
				}
			}
			else{
				$scope.listTelefones = [];
			}



			//validação de array de comunicadores
			if($scope.empresa.comunicadores_empresa){//caso o array existe
					if($scope.empresa.comunicadores_empresa.constructor == Array){//caso seja um array de objetos
						$scope.listComunicadores = $scope.empresa.comunicadores_empresa;
					}else{//caso seja um objeto apenas
						$scope.listComunicadores = [];
						var comunicador = $scope.empresa.comunicadores_empresa;
		 				$scope.listComunicadores.push(comunicador);
					}
			}else{//caso nao exista
				$scope.listComunicadores = [];
			}

			if($scope.empresa.contatos){
				if($scope.empresa.contatos.constructor == Array){
					$scope.listContatos = $scope.empresa.contatos;
				}else{
					$scope.listContatos = [];
					var contato = $scope.empresa.contatos;
					$scope.listContatos.push(contato);
				}
			}else{
				$scope.listContatos = [];
			}



		});
		 $scope.upload = function (dataUrl, name) {
			 
				
		        Upload.upload({
		            url: 'http://localhost:8080/CRM/rest/restEmpresa/upload',
		            data: {
		                file: Upload.dataUrltoBlob(dataUrl, name)
		            },
		        }).success(function(data) {
		        	
		        	var foto = data;
		        	
		        	$scope.foto = foto;
		        	$scope.RetornaImagemBase64(foto.id);
		        	
					
		    	}).error(
					function(data) {
						$scope.Resposta = "Erro ao enviar imagem: "+data;							
				});
		    }
			$scope.RetornaImagemBase64 = function (idimage){
				
				//pegando foto de contato cadastrada temporariamente
				 $http.get('http://localhost:8080/CRM/rest/restFoto/RetornaImagemBase64/'+idimage)
				.success(function(data) {
					document.getElementById("ItemPreview").src = "data:image/png;base64,"+data;
				});
				
			}		
		 
			
	}
	
	
    // aqui listando o atributos de outras telas
	
	var hash = $cookies.get('hash');
	var config = {
		 headers : {
			 'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
		 }
	 }
	 $http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos',config)
 	.success(function(data, config) {
 		$scope.usuarios = data["usuario"];
 	});
	
	$http.get('http://localhost:8080/CRM/rest/restTipoEmpresa/listarTodos')
	.success(function(data) {

		$scope.tiposempresa = data["tipoEmpresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/status')
	.success(function(data) {
		$scope.statuslist = data["status"];
	});
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
	.success(function(data) {
		$scope.cidades = data["cidade"];
	});
	$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
	.success(function(data) {
		$scope.contatos = data["contato"];
	});
  $http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
 	.success(function(data) {
 		$scope.tipostelefone = data["tipoTelefone"];
 	});

		$scope.EnviarInformacao = function() {
				//limpando ids de novos cadastros de telefone
				for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
					var x = $scope.listTelefones[i].id;
					var y = "#";
					if(x.indexOf(y) !== -1){
							$scope.listTelefones[i].id = null;
					}
				}
				//limpando ids de novos cadastros de comunicadores
				for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++){
					var x = $scope.listComunicadores[i].id;
					var y = "#";
					if(x.indexOf(y) !== -1){
						$scope.listComunicadores[i].id = null;
					}
				}

				$scope.empresa.telefones_empresa =  $scope.listTelefones;
				$scope.empresa.comunicadores_empresa = $scope.listComunicadores;
				$scope.empresa.contatos =  $scope.listContatos;
				
				var parameter = JSON.stringify({

					type : "empresa",
					id : $scope.empresa.id,
					usuarioresponsavel : $scope.empresa.usuarioresponsavel,
					tipoempresa : $scope.empresa.tipoempresa,
					datacadastro : $scope.empresa.datacadastro,
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
					comunicadores_empresa : $scope.empresa.comunicadores_empresa,
					contatos : $scope.empresa.contatos,
					
					idfoto : $scope.foto.id
				});
				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}

				$http.post( 'http://localhost:8080/CRM/rest/restEmpresa/Salvar', parameter, config).success(
				function(data, status, headers, config) {
						alert( 'Empresa "'+$scope.empresa.razaosocial+'" Salva com Sucesso!');
						$location.path("/Empresa");

				}).error(
				function(data, status, header, config) {
					$scope.Resposta = data ;
				});
	   };



//Genrenciar Telefones
$scope.addTelefone = function(){

	if(validarCamposTelefone()){
		if($scope.telefone.id == null){
 				autoincrementTelefone();
 				$scope.listTelefones.push({
 	  				id: $scope.telefone.id ,numero:$scope.telefone.numero, tipotelefone:$scope.telefone.tipotelefone
 	  			});
					$scope.telefone = { "id": null,"numero": '',"tipotelefone":''};
 			}else{
 	  			var index = getSelectedIndexTelefone($scope.telefone.id);

 	  			$scope.listTelefones[index].tipotelefone = $scope.telefone.tipotelefone;
 	  			$scope.listTelefones[index].numero = $scope.telefone.numero;
 	 				$scope.telefone = {
                "id": null,
                "numero": '',
                "tipotelefone":''
          };
 			}
	}

	}
$scope.selectEditTelefone = function(id){

			var SelFone = getSelectedTelefone(id);
 			$scope.telefone = {
          "id": SelFone.id,
          "numero": SelFone.numero,
          "tipotelefone":SelFone.tipotelefone
      };

	};
$scope.delTelefone = function(id){
	var result = confirm('Você deseja remover o telefone da lista?');
	if (result === true){
		for(var j = 0; j < $scope.listTelefones.length;j ++){
				if($scope.listTelefones[j].id == id){
						$scope.listTelefones.splice(j, 1);
				}
		}
	}
};
function getSelectedTelefone(id){
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
			if($scope.listTelefones[i].id == id)
				return $scope.listTelefones[i];
		return 1;

}
function getSelectedIndexTelefone(id){
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
			if($scope.listTelefones[i].id == id)
				return i;
		return 1;
}
function autoincrementTelefone(){
		if($scope.listTelefones){
			$scope.telefone.id ="#"+Object.keys($scope.listTelefones).length;
		}else{
			$scope.telefone.id ="#"+1;
		}

	}
function validarCamposTelefone(){
   	var i;
   	if($scope.telefone){
					if(! $scope.telefone.numero ){
						alert("O campo número de telefone está vázio, favor preencher o campo.");
						i = false;
					}else if(! $scope.telefone.tipotelefone){
						alert("O campo tipo de telefone está vázio, favor preencher o campo.");
					}else{
						i = true
					}
		}else{
			alert("Favor preencher os campos Número e Tipo de Telefone");
			i = false;
		}
   	return i;
}

//Listar tipos de comunicadores
$http.get('http://localhost:8080/CRM/rest/restTipoComunicador/listarTodos')
.success(function(data) {
	$scope.tiposcomunicador = data["tipoComunicador"];
});

//Genrenciar comunicadores
$scope.addComunicador = function(){

	if(validarCamposComunicador()){
		if($scope.comunicador.id == null){
 				autoincrementComunicador();
 				$scope.listComunicadores.push({
 	  				id: $scope.comunicador.id ,
						nome:$scope.comunicador.nome,
						tipocomunicador:$scope.comunicador.tipocomunicador
 	  			});
					$scope.comunicador = { "id": null,"nome": '',"tipocomunicador":''};

 			}else{
 	  			var index = getSelectedIndexComunicador($scope.comunicador.id);
 	  			$scope.listComunicadores[index].tipocomunicador = $scope.comunicador.tipocomunicador;
 	  			$scope.listComunicadores[index].nome = $scope.comunicador.nome;
					$scope.comunicador = {
								"id": null,
								"nome": '',
								"tipocomunicador":''
					};
 			}
	}
}
$scope.selectEditComunicador = function(id){
			var SelComunicador = getSelectedComunicador(id);
			$scope.comunicador = {
					"id": SelComunicador.id,
					"nome": SelComunicador.nome,
					"tipocomunicador":SelComunicador.tipocomunicador
			};
};
$scope.delComunicador = function(id){
	var result = confirm('Tem certeza?');
		if (result === true){
			for(var j = 0; j < $scope.listComunicadores.length;j ++){
		   		if($scope.listComunicadores[j].id == id){
						$scope.listComunicadores.splice(j, 1);
		   		}
		   	}
		}
};
function getSelectedIndexComunicador(id){
	for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++)
		if($scope.listComunicadores[i].id == id)
			return i;
	return 1;

}
function autoincrementComunicador(){
	if($scope.listComunicadores){
			$scope.comunicador.id = "#"+Object.keys($scope.listComunicadores).length;
	}else{
			$scope.comunicador.id = "#"+1;
	}

}
function validarComunicador(){
   	var i;
   	if($scope.comunicador){
			if(! $scope.comunicador.nome ){
				alert("O campo nome de comunicador está vázio, favor preencher o campo.");
			i = false;

		}else if(! $scope.comunicador.tipocomunicador){
			alert("Selecione um tipo de comunicador para continuar.");
		}else{
			i = true
		}
	}else{
		alert("Favor preencher os campos Nome e Tipo de Comunicador");
			i = false;
		}
   	return i;
}
function getSelectedComunicador(id){
	for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++)
		if($scope.listComunicadores[i].id == id)
			return $scope.listComunicadores[i];
	return 1;
}
function getSelectedIndexComunicador(id){
		for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++)
			if($scope.listComunicadores[i].id == id)
				return i;
		return 1;
}
function validarCamposComunicador(){
   	var i;
   	if($scope.comunicador){
					if(! $scope.comunicador.nome ){
						alert("O campo nome do comunicador está vázio, favor preencher o campo.");
						i = false;
					}else if(! $scope.comunicador.tipocomunicador){
						alert("O campo tipo de comunicador está vázio, favor preencher o campo.");
					}else{
						i = true
					}
		}else{
			alert("Favor preencher os campos nome comunicador  e Tipo de comunicador");
			i = false;
		}
   	return i;
 }


//Gerenciador de contatos
$scope.addContato = function(){
	if(validarCamposContato()){
	  $scope.listContatos.push( $scope.contato);
  }
}
$scope.delContato = function(id){
	var result = confirm('Você deseja excluir um contato da lista?');
	if (result === true){
		var indexListContato = getSelectedIndexContato(id);
		for(var j = 0; j < $scope.listContatos.length;j ++){
	   		if(indexListContato == j){
	   			$scope.listContatos.splice(j, 1);
	   		}
	   	}
	}
};
function getSelectedIndexContato(id){
		for(var i=0; i <  Object.keys($scope.listContatos).length; i ++){
			if($scope.listContatos[i].id == id){
				return i;
			}
		}
}
function validarCamposContato(){
	var v = 0;
	var f = 0;
	if($scope.contato){
		if($scope.listContatos.length > 0){
	   		for(var j = 0; j < $scope.listContatos.length;j ++){
	   	   		if($scope.listContatos[j].id == $scope.contato.id){
	   	   			alert($scope.contato.nome +" já foi adicionado a lista de contatos, favor selecionar outro.");
	   	   			f = 1;
	   	   		}
	   	   	}
	   	}
	}
   	else{
   		alert("Selecione contato para antes de salvar.");
   	}

   	if(f > 0){
   		return false
   	}else{return true}
   }


});

myControllers.controller('CadastrarEmpresaController', function($scope, $routeParams,$http) {

	$scope.Titulo = "Cadastrar Empresa";

});


myControllers.controller('CadastrarEmpresaController', function($scope, $routeParams,$http) {

$scope.Titulo = "Cadastrar Empresa";

});
myControllers.controller('EmpresaController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location, $cookies) {
	
	 $scope.upload = function (dataUrl, name) {

	        Upload.upload({
	            url: 'http://localhost:8080/CRM/rest/restEmpresa/upload',
	            data: {
	                file: Upload.dataUrltoBlob(dataUrl, name)
	            },
	        }).success(function(data) {

	        	var foto = data;

	        	$scope.foto = foto;
	        	$scope.RetornaImagemBase64(foto.id);

	    	}).error(
				function(data) {
					$scope.Resposta = "Erro ao enviar imagem: "+data;
			});
	    }
		$scope.RetornaImagemBase64 = function (idimage){

			//pegando foto de usuario cadastrada temporareamente
			 $http.get('http://localhost:8080/CRM/rest/restFoto/RetornaImagemBase64/'+idimage)
			.success(function(data) {
				document.getElementById("ItemPreview").src = "data:image/png;base64,"+data;
			});

		}
		
	var hash = $cookies.get('hash');
	var config = {
		 headers : {
			 'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
		 }
	 }
	 $http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos',config)
 	.success(function(data, config) {
 		$scope.usuarios = data["usuario"];
 	});
	$http.get('http://localhost:8080/CRM/rest/restTipoEmpresa/listarTodos')
	.success(function(data) {
	
		$scope.tiposempresa = data["tipoEmpresa"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCollections/status')
	.success(function(data) {
		$scope.statuslist = data["status"];
	});
	$http.get('http://localhost:8080/CRM/rest/restEstado/listarTodos')
	.success(function(data) {
		$scope.estados = data["estado"];
	});
	$http.get('http://localhost:8080/CRM/rest/restCidade/listarTodos')
	.success(function(data) {
		$scope.cidades = data["cidade"];
	});
	$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
	.success(function(data) {
		$scope.contatos = data["contato"];
	});
	$scope.EnviarInformacao = function() {

		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
			$scope.listTelefones[i].id = null;
		}
		for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++){
			$scope.listComunicadores[i].id = null;
		}
		
		//limpando ids de novos cadastros de telefone
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
			var x = $scope.listTelefones[i].id;
			var y = "#";
			if(x.indexOf(y) !== -1){
					$scope.listTelefones[i].id = null;
			}
		}
		//limpando ids de novos cadastros de comunicadores
		for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++){
			var x = $scope.listComunicadores[i].id;
			var y = "#";
			if(x.indexOf(y) !== -1){
				$scope.listComunicadores[i].id = null;
			}
		}

		$scope.empresa.telefones_empresa =  $scope.listTelefones;
		$scope.empresa.comunicadores_empresa = $scope.listComunicadores;
		$scope.empresa.contatos =  $scope.listContatos;
		
		var parameter = JSON.stringify({

			type : "empresa",
			id : $scope.empresa.id,
			usuarioresponsavel : $scope.empresa.usuarioresponsavel,
			tipoempresa : $scope.empresa.tipoempresa,
			datacadastro : $scope.empresa.datacadastro,
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
			comunicadores_empresa : $scope.empresa.comunicadores_empresa,
			contatos : $scope.empresa.contatos,
			
			idfoto : $scope.foto.id
		});
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post( 'http://localhost:8080/CRM/rest/restEmpresa/Salvar', parameter, config).success(
		function(data, status, headers, config) {
				alert( 'Empresa "'+$scope.empresa.razaosocial+'" Salva com Sucesso!');
				$location.path("/Empresa");

		}).error(
		function(data, status, header, config) {
			$scope.Resposta = data ;
		});
	};

	 //TiposTelefone
	 $http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
		.success(function(data) {
			$scope.tipostelefone = data["tipoTelefone"];
		});

	$scope.listTelefones=[];
	$scope.add = function(){

		if(validarCampos()){
			if($scope.telefone.id == null){
					autoincrement();
					$scope.listTelefones.push({
							id: $scope.telefone.id ,numero:$scope.telefone.numero, tipotelefone:$scope.telefone.tipotelefone
						});
				}else{
						var index =$scope.telefone.id;
						$scope.listTelefones[index].tipotelefone = $scope.telefone.tipotelefone;
						$scope.listTelefones[index].numero = $scope.telefone.numero;
				}
				$scope.telefone.id = null;
					$scope.telefone.tipotelefone = '';
					$scope.telefone.numero = '';
		}

	}

	$scope.selectEdit = function(id){
		var Telefone = $scope.listTelefones[id];
		$scope.telefone.id = Telefone.id;
		$scope.telefone.tipotelefone = Telefone.tipotelefone;
		$scope.telefone.numero = Telefone.numero;
	};
	$scope.del = function(id){
		var result = confirm('Tem certeza?');
		if (result === true){
			$scope.listTelefones.splice(id, 1);
		}
	};
	function getSelectedIndex(id){
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
			if($scope.listTelefone[i].id == id)
				return i;
		return 1;

	}
	function autoincrement(){
		$scope.telefone.id = Object.keys($scope.listTelefones).length;
	}
		 function validarCampos(){
			var i;
			if($scope.telefone){
			if(! $scope.telefone.numero ){
				alert("O campo número de telefone está vázio, favor preencher o campo.");
				i = false;
			}else if(! $scope.telefone.tipotelefone){
				alert("O campo tipo de telefone está vázio, favor preencher o campo.");
			}else{
				i = true
			}
		}else{
			alert("Favor preencher os campos Número e Tipo de Telefone");
			i = false;
		}
			return i;
		 }


		 //Tipo de Comunicador
	 $http.get('http://localhost:8080/CRM/rest/restTipoComunicador/listarTodos')
		.success(function(data) {
			$scope.tiposcomunicador = data["tipoComunicador"];
		});
//EXCLUIR EMPRESA
 $scope.Excluir = function(id){
	 
	 var result = confirm("Tem Certeza Que Deseja Excluir Esta Empresa?");
		if (result === true){
			if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restEmpresa/Excluir/'+id)
					.success(
					function(data, status) {
						alert("Empresa Excluída Com Sucesso!");
						$scope.BuscarInformacao();
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
			   };
		}
		else{
			alert("Empresa Conservada Com Sucesso!");
			$scope.BuscarInformacao();
		}

	};
//Genrenciar Telefones
$scope.listTelefones=[];
$scope.addTelefone = function(){

if(validarCamposTelefone()){
	if($scope.telefone.id == null){
			autoincrementTelefone();
			$scope.listTelefones.push({
					id: $scope.telefone.id ,numero:$scope.telefone.numero, tipotelefone:$scope.telefone.tipotelefone
				});
				$scope.telefone = { "id": null,"numero": '',"tipotelefone":''};
		}else{
				var index = getSelectedIndexTelefone($scope.telefone.id);

				$scope.listTelefones[index].tipotelefone = $scope.telefone.tipotelefone;
				$scope.listTelefones[index].numero = $scope.telefone.numero;
				$scope.telefone = {
							"id": null,
							"numero": '',
							"tipotelefone":''
				};
		}
}

}
$scope.selectEditTelefone = function(id){

		var SelFone = getSelectedTelefone(id);
		$scope.telefone = {
				"id": SelFone.id,
				"numero": SelFone.numero,
				"tipotelefone":SelFone.tipotelefone
		};

};
$scope.delTelefone = function(id){
var result = confirm('Você deseja remover o telefone da lista?');
if (result === true){
	for(var j = 0; j < $scope.listTelefones.length;j ++){
			if($scope.listTelefones[j].id == id){
					$scope.listTelefones.splice(j, 1);
			}
	}
}
};
function getSelectedTelefone(id){
	for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
		if($scope.listTelefones[i].id == id)
			return $scope.listTelefones[i];
	return 1;

}
function getSelectedIndexTelefone(id){
	for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++)
		if($scope.listTelefones[i].id == id)
			return i;
	return 1;
}
function autoincrementTelefone(){
	if($scope.listTelefones){
		$scope.telefone.id ="#"+Object.keys($scope.listTelefones).length;
	}else{
		$scope.telefone.id ="#"+1;
	}

}
function validarCamposTelefone(){
	var i;
	if($scope.telefone){
				if(! $scope.telefone.numero ){
					alert("O campo número de telefone está vázio, favor preencher o campo.");
					i = false;
				}else if(! $scope.telefone.tipotelefone){
					alert("O campo tipo de telefone está vázio, favor preencher o campo.");
				}else{
					i = true
				}
	}else{
		alert("Favor preencher os campos Número e Tipo de Telefone");
		i = false;
	}
	return i;
}

//Genrenciar comunicadores
$scope.listComunicadores=[];
$scope.addComunicador = function(){

if(validarComunicador()){
	if($scope.comunicador.id == null){
			autoincrementComunicador();
			$scope.listComunicadores.push({
					id: $scope.comunicador.id ,nome:$scope.comunicador.nome, tipocomunicador:$scope.comunicador.tipocomunicador
				});
		}else{
				var index =$scope.comunicador.id;
				$scope.listComunicadores[index].tipocomunicador = $scope.comunicador.tipocomunicador;
				$scope.listComunicadores[index].nome = $scope.comunicador.nome;
		}
		$scope.comunicador.id = null;
			$scope.comunicador.tipocomunicador = '';
			$scope.comunicador.nome = '';
}

}
$scope.selectEditComunicador = function(id){
var Comunicador = $scope.listComunicadores[id];
$scope.comunicador.id = Comunicador.id;
$scope.comunicador.tipocomunicador = Comunicador.tipocomunicador;
$scope.comunicador.nome = Comunicador.nome;
};
$scope.delComunicador = function(id){
var result = confirm('Tem certeza?');
	if (result === true){
		$scope.listComunicadores.splice(id, 1);
	}
};
function getSelectedIndexComunicador(id){
	for(var i=0; i <  Object.keys($scope.listComunicadores).length; i ++)
		if($scope.listComunicadores[i].id == id)
			return i;
	return 1;

}
function autoincrementComunicador(){
	$scope.comunicador.id = Object.keys($scope.listComunicadores).length;
}
 function validarComunicador(){
	var i;
	if($scope.comunicador){
		if(! $scope.comunicador.nome ){
			alert("O campo nome de comunicador está vázio, favor preencher o campo.");
		i = false;

	}else if(! $scope.comunicador.tipocomunicador){
		alert("Selecione um tipo de comunicador para continuar.");
	}else{
		i = true
	}
}else{
	alert("Favor preencher os campos Nome e Tipo de Comunicador");
		i = false;
	}
	return i;
 }
//Gerenciador de contatos
$scope.listContatos=[];
$scope.addContato = function(){
if(validarContatos($scope.contato) === true){
	$scope.listContatos.push( $scope.contato);
}
}
$scope.delContato = function(id){
var result = confirm('Você deseja remover o  contato da lista?');
if (result === true){
	for(var j = 0; j < $scope.listContatos.length;j ++){
			if($scope.listContatos[j].id == id){
				$scope.listContatos.splice(j, 1);
			}
		}
}

};
function validarContatos(contato){
var v = 0;
var f = 0;
	if($scope.listContatos.length > 0){
		for(var j = 0; j < $scope.listContatos.length;j ++){
				if($scope.listContatos[j].id == contato.id){
					alert(contato.nome +" já foi adicionado a lista de contatos, favor selecionar outro.");
					f = 1;
				}
			}
	}

	if(f > 0){
		return false
	}else{return true}
 }



});