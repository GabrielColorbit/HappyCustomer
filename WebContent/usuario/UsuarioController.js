var myControllers = angular.module('UsuarioControllers',[]);




myControllers.controller('ListarUsuarioController', function($scope,$http,$cookies) {
	$scope.Titulo = "Usuários";
	$scope.BuscarInformacao = function() {
		 var hash = $cookies.get('hash');
		 var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
				}
			}
		$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos',config)
		.success(function(data, config) {
			$scope.usuariolist = data["usuario"];
			$scope.Quantidade = $scope.usuariolist.length+' Usuários Encontradas!' ;
		}).error(
			function(data, config) {
				console.log(data);
			});

	};
	$scope.BuscarInformacao();
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetUsuarioController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location,$cookies,$window) {
	$scope.Titulo = "Editar Usuário";
	var usuario =  new Object();

	if($routeParams.usuarioId){
	 var hash = $cookies.get('hash');
	 var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
			}
		}
		$http.get('http://localhost:8080/CRM/rest/restUsuario/Editar/'+$routeParams.usuarioId, config)
		.success(function(data) {
			$scope.usuario = data;
			usuario = $scope.usuario;
			$scope.foto = {
					"id":$scope.usuario.idfoto
			}

			$scope.listTelefones=[];
			$scope.listTelefones = usuario.telefones_usuario;


			//validação de array de telefones
			if($scope.usuario.telefones_usuario){
				if($scope.usuario.telefones_usuario.constructor == Array){
						$scope.listTelefones = $scope.usuario.telefones_usuario;
				}else{
					$scope.listTelefones = [];
					var telefone = $scope.usuario.telefones_usuario;
					$scope.listTelefones.push(telefone);
				}
			}
			else{
				$scope.listTelefones = [];
			}

			//validação de array de comunicadores
			if($scope.usuario.comunicadores_usuario){//caso o array existe
					if($scope.usuario.comunicadores_usuario.constructor == Array){//caso seja um array de objetos
						$scope.listComunicadores = $scope.usuario.comunicadores_usuario;
					}else{//caso seja um objeto apenas
						$scope.listComunicadores = [];
						var comunicador = $scope.usuario.comunicadores_usuario;
		 				$scope.listComunicadores.push(comunicador);
					}
			}else{//caso nao exista
				$scope.listComunicadores = [];
			}


		});

	}

	
	//aqui que pega a foto , onde ta fazendo o upload , passando o endereço
	 $scope.upload = function (dataUrl, name) {


	        Upload.upload({
	            url: 'http://localhost:8080/CRM/rest/restUsuario/upload',
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

			//pegando foto de usuario cadastrada temporariamente
			 $http.get('http://localhost:8080/CRM/rest/restFoto/RetornaImagemBase64/'+idimage)
			.success(function(data) {
				document.getElementById("ItemPreview").src = "data:image/png;base64,"+data;
			});

		}




		$http.get('http://localhost:8080/CRM/rest/restCollections/genders')
		.success(function(data) {
			$scope.generos = data["genero"];
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
		$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
		.success(function(data) {
			$scope.tiposusuario = data["tipoUsuario"];
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

			$scope.usuario.telefones_usuario =  $scope.listTelefones;
			$scope.usuario.comunicadores_usuario = $scope.listComunicadores;

			var parameter = JSON.stringify({

				type : "usuario",
				id : $scope.usuario.id,
				nome : $scope.usuario.nome,
				tipousuario : $scope.usuario.tipousuario,
				cidade : $scope.usuario.cidade,
				login : $scope.usuario.login,
				senha : $scope.usuario.senha,
				cpf : $scope.usuario.cpf,
				genero : $scope.usuario.genero,
				cargo : $scope.usuario.cargo,
				datanascimento : $scope.usuario.datanascimento,
				datacadastro : $scope.usuario.datacadastro,
				endereco : $scope.usuario.endereco,
				numero : $scope.usuario.numero,
				complemento: $scope.usuario.complemento,
				bairro: $scope.usuario.bairro,
				status: $scope.usuario.status,
				cep : $scope.usuario.cep,

				telefones_usuario : $scope.usuario.telefones_usuario,
				comunicadores_usuario : $scope.usuario.comunicadores_usuario,

				idfoto : $scope.foto.id

			});
			 var hash = $cookies.get('hash');
			 var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
					}
				}

			$http.post(
					'http://localhost:8080/CRM/rest/restUsuario/Salvar',
					parameter, config).success(
					function(data, status, headers, config) {

						alert( 'Usuário '+$scope.usuario.nome+' Salvo com Sucesso!');
						var usuarioLogado = $scope.usuario;
						 if(usuarioLogado.id = $scope.usuario.id){

							   var parameter = JSON.stringify({
									type : "usuario",
									login : usuarioLogado.login ,
									senha : usuarioLogado.senha
								});
								var config = {
									headers : {
										'Content-Type' : 'application/json;charset=utf-8;'
									}
								}

								$http.post('http://localhost:8080/CRM/rest/restLogin/AutenticacaoUsuario', parameter, config).success(
								function(data, status, headers, config) {
									  var hash = data;
									  $cookies.put("hash", hash);
									  $scope.LoadUser(hash);
								})
							    $scope.LoadUser = function(hash){
									   $http.get('http://localhost:8080/CRM/rest/restLogin/LoadUser/'+hash  ).success
										  (function(data) {
											if(data.id){
												$cookies.putObject('usuarioLogado',data);
												$scope.usuarioLogado = $cookies.getObject('usuarioLogado');

											}else{
												$scope.responseFromLogin = "Login ou senha incorretos."
											}

									  	});
								   };
								

								
							 
							   //atualiza informações usuario logado
							   var hash = $cookies.get("hash");
							   $http.get('http://localhost:8080/CRM/rest/restLogin/LoadUser/'+hash  ).success
								  (function(data) {
										  var hash = data;
										   
										  
										  
										  
										  $location.path('/Usuario');
										  $window.location.reload();
							  	});
							 
						 }
						 

						
						

					}).error(
					function(data, status, header, config) {
						$scope.Resposta = "Data: " + data + "<hr />status: "
								+ status + "<hr />headers: " + header
								+ "<hr />config: " + config;
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

});
myControllers.controller('CadastrarUsuarioController', function($scope, $rootScope, $routeParams,$http) {

	$scope.Titulo = "Cadastrar Usuário";

});
myControllers.controller('UsuarioController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location,$cookies) {
	 $scope.upload = function (dataUrl, name) {

        Upload.upload({
            url: 'http://localhost:8080/CRM/rest/restUsuario/upload',
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



     //carregando o list é aqui.
	$http.get('http://localhost:8080/CRM/rest/restCollections/genders')
	.success(function(data) {
		$scope.generos = data["genero"];
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
	$http.get('http://localhost:8080/CRM/rest/restTipoUsuario/listarTodos')
	.success(function(data) {
		$scope.tiposusuario = data["tipoUsuario"];
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

		$scope.usuario.telefones_usuario =  $scope.listTelefones;
		$scope.usuario.comunicadores_usuario = $scope.listComunicadores;

		var parameter = JSON.stringify({
			type : "usuario",
			id : $scope.usuario.id,
			nome : $scope.usuario.nome,
			tipousuario : $scope.usuario.tipousuario,
			cidade : $scope.usuario.cidade,
			login : $scope.usuario.login,
			senha : $scope.usuario.senha,
			cpf : $scope.usuario.cpf,
			genero : $scope.usuario.genero,
			cargo : $scope.usuario.cargo,
			datanascimento : $scope.usuario.datanascimento,
			datacadastro : $scope.usuario.datacadastro,
			endereco : $scope.usuario.endereco,
			numero : $scope.usuario.numero,
			complemento: $scope.usuario.complemento,
			bairro: $scope.usuario.bairro,
			status: $scope.usuario.status,
			cep : $scope.usuario.cep,

			telefones_usuario : $scope.usuario.telefones_usuario,
			comunicadores_usuario : $scope.usuario.comunicadores_usuario,

			idfoto : $scope.foto.id


		});
		 var hash = $cookies.get('hash');
		 var config = {
				headers : {
					'Content-Type' : 'application/json;charset=utf-8;','hash' : hash
				}
			}

		$http.post(
				'http://localhost:8080/CRM/rest/restUsuario/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {

					alert( 'Usuário '+$scope.usuario.nome+' Salvo com Sucesso!');

				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	   };


		 $http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
	 	.success(function(data) {
	 		$scope.tipostelefone = data["tipoTelefone"];
	 	});
		 $scope.listTelefones = [];
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
 			$scope.listComunicadores = [];
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

 			//EXCLUIR USUÁRIO
		 	 $scope.Excluir = function(id){

		 		 var result = confirm("Tem Certeza Que Deseja Excluir Este Usuário?");
		 			if (result === true){
		 				if(id){

		 					$http.post('http://localhost:8080/CRM/rest/restUsuario/Excluir/'+id)
		 						.success(
		 						function(data, status) {
		 							alert("Usuário Excluído Com Sucesso!");
		 							$scope.BuscarInformacao();

		 						}).error(
		 						function(data, status) {
		 							$scope.Resposta = data ;
		 						});
		 				   };
		 			}
		 			else{
		 				alert("Usuáario Conservado Com Sucesso!");
		 				$scope.BuscarInformacao();
		 			}

		 		};

});
