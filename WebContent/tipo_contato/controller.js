app.controller('TipoContatoController', function($scope,$http) {
		
			$scope.title = "Tipo Contato";
			$scope.BuscarInformacao = function() {
				$http.get('http://localhost:8080/CRM/rest/restTipoContato/listarTodos')
				.success(function(data) {
					$scope.tipoContatolist = data["tipoContato"];
				});
			};
		
			$scope.BuscarInformacao();
		
			
			$scope.SelecionarParaEditar = function(id) {
				
				$http.get('http://localhost:8080/CRM/rest/restTipoContato/Editar/'+id)
				.success(function(data) {
					$scope.tipoContato = data;
					var tipoContato =  new Object();
					tipoContato = $scope.tipoContato 
	
				});
			};	

			
		    $scope.showStudentTable = function(pathurl){
		        console.log(pathurl)
		        $location.path(pathurl)
		    }
	
			$scope.EnviarInformacao = function() {
	
				var parameter = JSON.stringify({
					type : "tipoContato",
					id : $scope.tipoContato.id,
					nome : $scope.tipoContato.nome
				});
	
				var config = {
					headers : {
						'Content-Type' : 'application/json;charset=utf-8;'
					}
				}

				$http.post(
						'http://localhost:8080/CRM/rest/restTipoContato/Salvar',
						parameter, config).success(
						function(data, status, headers, config) {
							$scope.Resposta = 'Tipo Contato Salvo com Sucesso!';
							
							
						}).error(
						function(data, status, header, config) {
							$scope.Resposta = "Data: " + data + "<hr />status: "
									+ status + "<hr />headers: " + header
									+ "<hr />config: " + config;
						});
			   };

	});