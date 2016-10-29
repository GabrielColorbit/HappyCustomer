package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CidadeDAO;
import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.entity.Cidade;

public class CidadeBO implements InterfaceBO<Cidade>{
	CidadeDAO cDAO = new CidadeDAO();
	@Override
	public void Cadastrar(Cidade cidade) throws Exception {
			


		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade é Invalido");
		}		
		else if(cidade.getEstado() ==  null){
			throw new Exception("Selecione um estado.");
		}
		
		
		
		cDAO.Cadastrar(cidade);
		
		
	}

	@Override
	public List<Cidade> Listar() throws Exception{
		List<Cidade> cidades = cDAO.Listar();
		if(cidades == null){
			throw new Exception("Nenhumma cidade cadastrada");
		}
		return cidades;
	}

	@Override
	public void Alterar(Cidade cidade)  throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade é Invalido");
		}
		else if(cidade.getEstado() == null) {
			throw new Exception("Nome Estado é Invalido");
		}
		
		
		cDAO.Alterar(cidade);		
	}

	@Override
	public Cidade BuscarID(Long id) throws Exception{
		if(id == null) {
			throw new Exception("Cidade Pesquisada é Inválida");
		}
		else if(id <= 0) {
			throw new Exception("Cidade Pesquisada é Inválida");
		}
		
		return cDAO.BuscarID(id);
	}

	@Override
	public void Excluir(Cidade cidade) throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Cidade selecionada é inválida");
		}		
		cDAO.Excluir(cidade);		
	}

}
