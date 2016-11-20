var myControllers = angular.module('ContatoControllers',[]);

myControllers.controller('ListarContatoController', function($scope,$http) {
	$scope.Titulo = "Contatos";
	$scope.BuscarInformacao = function() {
		$http.get('http://localhost:8080/CRM/rest/restContato/listarTodos')
		.success(function(data) {
			$scope.contatolist = data["contato"];
		});
	};
	$scope.BuscarInformacao();
	
	$scope.ordenar = function(keyname){
        $scope.sortKey = keyname;
        $scope.reverse = !$scope.reverse;
    };
});
myControllers.controller('GetContatoController', function($scope, $rootScope, $routeParams,$http, Upload, $timeout) {
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
			
			$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
			.success(function(data) {
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
				
				for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
					$scope.listTelefones[i].id = null;			
				}
				
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
							$scope.Resposta = 'Contato ('+$scope.contato.nome+') Salvo com Sucesso!';
							
							
						}).error(
						function(data, status, header, config) {
							$scope.Resposta = data ;
						});
			   };

	}
});
myControllers.controller('CadastrarContatoController', function($scope, $routeParams,$http) {
	
	$scope.Titulo = "Cadastrar Contato";
	
});
myControllers.controller('ContatoController', function($scope, $routeParams,$http, Upload, $timeout) {
	
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
	
	$http.get('http://localhost:8080/CRM/rest/restUsuario/listarTodos')
	.success(function(data) {
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
		
		for(var i=0; i <  Object.keys($scope.listTelefones).length; i ++){
			$scope.listTelefones[i].id = null;			
		}
		
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
	   $scope.Excluir = function(id){
		   if(id){
				
				$http.post('http://localhost:8080/CRM/rest/restContato/Excluir/'+id)
					.success(
					function(data, status) {
					
						$scope.BuscarInformacao();
						alert( 'Contato: '+$scope.contato.nome+'. Excluído Com Sucesso!')
						
					}).error(
					function(data, status) {
						$scope.Resposta = data ;
					});
		
			   };
			
			};
			
			 //crud in view


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

});