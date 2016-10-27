package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CidadeDAO;
import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.entity.Cidade;

public class CidadeBO implements InterfaceBO<Cidade>{
	CidadeDAO cDAO = new CidadeDAO();
	@Override
	public void Cadastrar(Cidade cidade) throws Exception {
			
//		valida��o de campos vazios

		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade � Invalido");
		}		
		else if(cidade.getNome() == null) {
			throw new Exception("Estado � Invalido");
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
			throw new Exception("Nome da Cidade � Invalido");
		}
		else if(cidade.getNome() == null) {
			throw new Exception("Nome Estado � Invalido");
		}
		cDAO.Alterar(cidade);		
	}

	@Override
	public Cidade BuscarID(Long id) throws Exception{
		if(id == null) {
			throw new Exception("Cidade Pesquisada � Inv�lida");
		}
		else if(id <= 0) {
			throw new Exception("Cidade Pesquisada � Inv�lida");
		}
		
		return cDAO.BuscarID(id);
	}

	@Override
	public void Excluir(Cidade cidade) throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Cidade selecionada � inv�lida");
		}		
		cDAO.Excluir(cidade);		
	}

}
