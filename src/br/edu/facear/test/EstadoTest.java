package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Estado;
import br.edu.facear.facade.FacadeHappyCustomer;

public class EstadoTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	
	// CADASTRAR
	@Test
	public void testCadastrarEstado() throws Exception {
		
		String nome = null;
		
		for(int i = 0; i<27; i++){
			
			if(i == 0){
				nome = "Paraná";
			}
			else if(i == 1){
				nome = "Alagoas";
			}
			else if(i == 2){
				nome = "Amapá";
			}
			else if(i == 3){
				nome = "Amazonas";
			}
			else if(i == 4){
				nome = "Bahia";
			}
			else if(i == 5){
				nome = "Ceará";
			}
			else if(i == 6){
				nome = "Distrito Federal";
			}
			else if(i == 7){
				nome = "Espírito Santo";
			}
			else if(i == 8){
				nome = "Goiás";
			}
			else if(i == 9){
				nome = "Maranhão";
			}
			else if(i == 10){
				nome = "Mato Grosso";
			}
			else if(i == 11){
				nome = "Mato Grosso do Sul";
			}
			else if(i == 12){
				nome = "Minas Gerais";
			}
			else if(i == 13){
				nome = "Pará";
			}
			else if(i == 14){
				nome = "Paraíba";
			}
			else if(i == 15){
				nome = "Paraná";
			}
			else if(i == 16){
				nome = "Pernambuco";
			}
			else if(i == 17){
				nome = "Piauí";
			}
			else if(i == 18){
				nome = "Rio de Janeiro";
			}
			else if(i == 19){
				nome = "Rio Grande do Norte";
			}
			else if(i == 20){
				nome = "Rio Grande do Sul";
			}
			else if(i == 21){
				nome = "Rondônia";
			}
			else if(i == 22){
				nome = "Roraima";
			}
			else if(i == 23){
				nome = "Santa Catarina";
			}
			else if(i == 24){
				nome = "São Paulo";
			}
			else if(i == 25){
				nome = "Sergipe";
			}
			else if(i == 26){
				nome = "Tocantins";
			}
			
			Estado Estado = new Estado();
			Estado.setNome(nome);
			Estado.setPais("Brasil");
			facade.CadastrarEstado(Estado);
			
			Assert.assertEquals(true, Estado.getId() != null);
		}	
	}

	// ALTERAR
	// @Test
	public void testAterarEstado() throws Exception {
		Estado Estado = facade.BuscarEstadoPorId(2l);
		Estado.setNome("Santa Catarina");
		Estado.setPais("Brasil");
		facade.AlterarEstado(Estado);
		Assert.assertEquals(true, Estado.getNome().equals("Santa Catarina"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirEstado() throws Exception {
		Estado Estado = facade.BuscarEstadoPorId(1l);
		facade.ExcluirEstado(Estado);
		// Estado = facade.BuscarEstadoPorId(1l);
		// Assert.assertEquals(true, Estado.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarEstado() throws Exception {
		List<Estado> Estado = new ArrayList<Estado>();
		Estado = facade.ListarEstado();
		Assert.assertEquals(true, Estado.size() > 0);
		System.out.println("ESTADO(S) CADASTRADO(S)");
		for (Estado Estado2 : Estado) {
			System.out
					.println("Id: " + Estado2.getId() + "  Nome: " + Estado2.getNome() + "País: " + Estado2.getPais());
		}
	}
}