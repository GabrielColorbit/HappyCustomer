package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CidadeDAO;
import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.entity.Cidade;

public class CidadeBO implements InterfaceBO<Cidade>{
	CidadeDAO cDAO = new CidadeDAO();
	@Override
	public void salvar(Cidade cidade) throws Exception {
			
//		valida��o de campos vazios

		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade � Invalido");
		}		
		else if(cidade.getEstado().getNome() == null) {
			throw new Exception("Estado � Invalido");
		}
		cDAO.salvar(cidade);
		
		
	}

	@Override
	public List<Cidade> listar() throws Exception{
		List<Cidade> cidades = cDAO.listar();
		if(cidades == null){
			throw new Exception("Nenhumma cidade cadastrada");
		}
		return cidades;
	}

	@Override
	public void editar(Cidade cidade)  throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade � Invalido");
		}
		else if(cidade.getEstado().getNome() == null) {
			throw new Exception("Nome Estado � Invalido");
		}
		cDAO.editar(cidade);		
	}

	@Override
	public Cidade getObjectById(Long id) throws Exception{
		if(id == null) {
			throw new Exception("Cidade Pesquisada � Inv�lida");
		}
		else if(id <= 0) {
			throw new Exception("Cidade Pesquisada � Inv�lida");
		}
		
		return cDAO.getObjectById(id);
	}

	@Override
	public void excluir(Cidade cidade) throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Cidade selecionada � inv�lida");
		}		
		cDAO.excluir(cidade);		
	}

}
