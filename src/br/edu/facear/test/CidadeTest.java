package br.edu.facear.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Estado;
import br.edu.facear.facade.FacadeHappyCustomer;

public class CidadeTest {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();

	// CADASTRAR
	@Test
	public void testCadastrarCidade() throws Exception {

		String nome = null;
		Long estado = 0l;
		
		for(int i = 0; i<29; i++){
			
			if(i == 0){
				nome = "Rio Branco";
				estado = 1l;
			}
			else if(i == 1){
				nome = "Maceió";
				estado = 2l;
			}
			else if(i == 2){
				nome = "Macapá";
				estado = 3l;
			}
			else if(i == 3){
				nome = "Manaus";
				estado = 4l;
			}
			else if(i == 4){
				nome = "Salvador";
				estado = 5l;
			}
			else if(i == 5){
				nome = "Fortaleza";
				estado = 6l;
			}
			else if(i == 6){
				nome = "Brasília";
				estado = 7l;
			}
			else if(i == 7){
				nome = "Vitória";
				estado = 8l;
			}
			else if(i == 8){
				nome = "Goiânia";
				estado = 9l;
			}
			else if(i == 9){
				nome = "São Luís";
				estado = 10l;
			}
			else if(i == 10){
				nome = "Cuiabá";
				estado = 11l;
			}
			else if(i == 11){
				nome = "Campo Grande";
				estado = 12l;
			}
			else if(i == 12){
				nome = "Belo Horizonte";
				estado = 13l;
			}
			else if(i == 13){
				nome = "Belém";
				estado = 14l;
			}
			else if(i == 14){
				nome = "João Pessoa";
				estado = 15l;
			}
			else if(i == 15){
				nome = "Curitiba";
				estado = 16l;
			}
			else if(i == 16){
				nome = "Recife";
				estado = 17l;
			}
			else if(i == 17){
				nome = "Teresina";
				estado = 18l;
			}
			else if(i == 18){
				nome = "Rio de Janeiro";
				estado = 19l;
			}
			else if(i == 19){
				nome = "Natal";
				estado = 20l;
			}
			else if(i == 20){
				nome = "Porto Alegre";
				estado = 21l;
			}
			else if(i == 21){
				nome = "Porto Velho";
				estado = 22l;
			}
			else if(i == 22){
				nome = "Boa Vista";
				estado = 23l;
			}
			else if(i == 23){
				nome = "Florianópolis";
				estado = 24l;
			}
			else if(i == 24){
				nome = "São Paulo";
				estado = 25l;
			}
			else if(i == 25){
				nome = "Aracaju";
				estado = 26l;
			}
			else if(i == 26){
				nome = "Palmas";
				estado = 27l;
			}
			else if(i == 27){
				nome = "Araucária";
				estado = 16l;
			}
			else if(i == 28){
				nome = "Quitandinha";
				estado = 16l;
			}
		
			Cidade Cidade = new Cidade();
			Estado Estado = new Estado();
			Cidade.setNome(nome);
			Estado.setId(estado);
			Cidade.setEstado(Estado);
			facade.CadastrarCidade(Cidade);
			Assert.assertEquals(true, Cidade.getId() != null && Cidade.getEstado() != null);
			
		}
	}

	// ALTERAR
	// @Test
	public void testAterarCidade() throws Exception {
		
		Cidade Cidade = facade.BuscarCidadePorId(1l);
		Cidade.setNome("Guarulhos");
		//Estado.setId(2l);
		//Cidade.setEstado(Estado);
		facade.AlterarCidade(Cidade);
		Assert.assertEquals(true, Cidade.getNome().equals("Guarulhos"));
	}

	// EXCLUIR
	// @Test
	public void testExcluirCidade() throws Exception {
		Cidade Cidade = facade.BuscarCidadePorId(1l);
		facade.ExcluirCidade(Cidade);
		// Cidade = facade.BuscarCidadePorId(1l);
		// Assert.assertEquals(true, Cidade.getId() == null);
	}

	// LISTAR
	// @Test
	public void testListarCidade() throws Exception {
		List<Cidade> Cidade = new ArrayList<Cidade>();
		Cidade = facade.ListarCidade();
		Assert.assertEquals(true, Cidade.size() > 0);
		System.out.println("CIDADE(S) CADASTRADA(S)");
		for (Cidade Cidade2 : Cidade) {
			System.out.println("Id: " + Cidade2.getId() + "  Nome: " + Cidade2.getNome() + "  Tipo Estado:"
					+ Cidade2.getEstado().getNome());
		}
	}
}