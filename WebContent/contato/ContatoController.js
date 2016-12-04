var myControllers = angular.module('ContatoControllers',[]);

myControllers.controller('ListarContatoController', function($scope,$http) {
	$scope.Titulo = "Contatos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
		.success(function(data) {
			$scope.contatolist = data["contato"];
			$scope.Quantidade = $scope.contatolist.length+' Contatos Encontrados!' ;
		});
	};
	$scope.BuscarInformacao();

	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetContatoController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location, $cookies) {
	$scope.Titulo = "Editar Contato";
	var contato =  new Object();

	if($routeParams.contatoId){
		$http.get('http://localhost:8080/CRM/rest/restContato/Editar/'+$routeParams.contatoId)
		.success(function(data) {
			$scope.contato = data;
			contato = $scope.contato
			$scope.foto = {
					"id":$scope.contato.idfoto
			}

			$scope.listTelefones=[];
			$scope.listTelefones = contato.telefones_contato;

			//validação de array de telefones
			if($scope.contato.telefones_contato){
				if($scope.contato.telefones_contato.constructor == Array){
						$scope.listTelefones = $scope.contato.telefones_contato;
				}else{
					$scope.listTelefones = [];
					var telefone = $scope.contato.telefones_contato;
					$scope.listTelefones.push(telefone);
				}
			}
			else{//caso nao exista
				$scope.listTelefones = [];
			}

			//validação de array de comunicadores
			if($scope.contato.comunicadores_contato){//caso o array existe
					if($scope.contato.comunicadores_contato.constructor == Array){//caso seja um array de objetos
						$scope.listComunicadores = $scope.contato.comunicadores_contato;
					}else{//caso seja um objeto apenas
						$scope.listComunicadores = [];
						var comunicador = $scope.contato.comunicadores_contato;
		 				$scope.listComunicadores.push(comunicador);
					}
			}else{//caso nao exista
				$scope.listComunicadores = [];
			}

		});
		 $scope.upload = function (dataUrl, name) {


		        Upload.upload({
		            url: 'http://localhost:8080/CRM/rest/restContato/upload',
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
			
			$http.get('http://localhost:8080/CRM/rest/restTipoContato/listarTodos')
			.success(function(data) {

				$scope.tiposcontato = data["tipoContato"];
			});
			$http.get('http://localhost:8080/CRM/rest/restOrigemContato/listarTodos')
			.success(function(data) {

				$scope.origenscontato = data["origemContato"];
			});
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

				$scope.contato.telefones_contato =  $scope.listTelefones;
				$scope.contato.comunicadores_contato = $scope.listComunicadores;

				var parameter = JSON.stringify({

					type : "contato",
					id : $scope.contato.id,
					usuarioresponsavel : $scope.contato.usuarioresponsavel,
					tipocontato : $scope.contato.tipocontato,
					origemcontato : $scope.contato.origemcontato,
					cidade : $scope.contato.cidade,

					nome : $scope.contato.nome,
					datacadastro : $scope.contato.datacadastro,
					datanascimento : $scope.contato.datanascimento,
					cpf : $scope.contato.cpf,
					endereco : $scope.contato.endereco,
					numero : $scope.contato.numero,
					complemento: $scope.contato.complemento,
					cep : $scope.contato.cep,
					bairro: $scope.contato.bairro,
					genero : $scope.contato.genero,
					cargo : $scope.contato.cargo,
					status: $scope.contato.status,

					telefones_contato : $scope.contato.telefones_contato,
					comunicadores_contato : $scope.contato.comunicadores_contato,

					idfoto : $scope.foto.id

				});

				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}

				$http.post(
						'http://localhost:8080/CRM/rest/restContato/Salvar',
						parameter, config).success(
						function(data, status, headers, config) {

							alert( 'Contato '+$scope.contato.nome+' Salvo com Sucesso!')


						}).error(
						function(data, status, header, config) {
							$scope.Resposta = data ;
						});
			   };
			   
			   //Listar tipos de telefone
			   $http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
			   .success(function(data) {
			   	$scope.tipostelefone = data["tipoTelefone"];
			   });

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

	}
});
myControllers.controller('CadastrarContatoController', function($scope, $routeParams,$http) {

	$scope.Titulo = "Cadastrar Contato";

});
myControllers.controller('ContatoController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout, $filter, $location, $cookies) {

	 $scope.upload = function (dataUrl, name) {

	        Upload.upload({
	            url: 'http://localhost:8080/CRM/rest/restContato/upload',
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
	
	$http.get('http://localhost:8080/CRM/rest/restTipoContato/listarTodos')
	.success(function(data) {

		$scope.tiposcontato = data["tipoContato"];
	});
	$http.get('http://localhost:8080/CRM/rest/restOrigemContato/listarTodos')
	.success(function(data) {

		$scope.origenscontato = data["origemContato"];
	});
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
	$http.get('http://localhost:8080/CRM/rest/restTipoTelefone/listarTodos')
		.success(function(data) {
			$scope.tipostelefone = data["tipoTelefone"];
		});
	$http.get('http://localhost:8080/CRM/rest/restTipoComunicador/listarTodos')
		.success(function(data) {
			$scope.tiposcomunicador = data["tipoComunicador"];
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

		$scope.contato.telefones_contato =  $scope.listTelefones;
		$scope.contato.comunicadores_contato = $scope.listComunicadores;

		var parameter = JSON.stringify({

			type : "contato",
			id : $scope.contato.id,
			usuarioresponsavel : $scope.contato.usuarioresponsavel,
			tipocontato : $scope.contato.tipocontato,
			origemcontato : $scope.contato.origemcontato,
			cidade : $scope.contato.cidade,
			nome : $scope.contato.nome,
			datacadastro : $scope.contato.datacadastro,
			datanascimento : $scope.contato.datanascimento,
			cpf : $scope.contato.cpf,
			endereco : $scope.contato.endereco,
			numero : $scope.contato.numero,
			complemento: $scope.contato.complemento,
			cep : $scope.contato.cep,
			bairro: $scope.contato.bairro,
			genero : $scope.contato.genero,
			cargo : $scope.contato.cargo,
			status: $scope.contato.status,

			telefones_contato : $scope.contato.telefones_contato,
			comunicadores_contato : $scope.contato.comunicadores_contato,

			idfoto : $scope.foto.id

		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(
				'http://localhost:8080/CRM/rest/restContato/Salvar',
				parameter, config).success(
				function(data, status, headers, config) {

					alert( 'Contato '+$scope.contato.nome+' Salvo com Sucesso!')


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
		 	
		 	//EXCLUIR CONTATO
		 	 $scope.Excluir = function(id){
		 		 
		 		 var result = confirm("Tem Certeza Que Deseja Excluir Este Contato?");
		 			if (result === true){
		 				if(id){
		 					
		 					$http.post('http://localhost:8080/CRM/rest/restContato/Excluir/'+id)
		 						.success(
		 						function(data, status) {
		 							alert("Contato Excluído Com Sucesso!");
		 							$scope.BuscarInformacao();
		 							
		 						}).error(
		 						function(data, status) {
		 							$scope.Resposta = data ;
		 						});
		 				   };
		 			}
		 			else{
		 				alert("Contato Conservado Com Sucesso!");
		 				$scope.BuscarInformacao();
		 			}

		 		};

		 });
