package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.CidadeDAO;
import br.edu.facear.crm.dao.CrmException;
import br.edu.facear.crm.entity.Cidade;

public class CidadeBO implements InterfaceBO<Cidade>{
	CidadeDAO cDAO = new CidadeDAO();
	@Override
	public void salvar(Cidade cidade) throws Exception {
			
//		validação de campos vazios

		if(cidade.getNome() == null) {
			throw new Exception("Nome da Cidade é Invalido");
		}		
		else if(cidade.getEstado().getNome() == null) {
			throw new Exception("Estado é Invalido");
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
			throw new Exception("Nome da Cidade é Invalido");
		}
		else if(cidade.getEstado().getNome() == null) {
			throw new Exception("Nome Estado é Invalido");
		}
		cDAO.editar(cidade);		
	}

	@Override
	public Cidade getObjectById(Long id) throws Exception{
		if(id == null) {
			throw new Exception("Cidade Pesquisada é Inválida");
		}
		else if(id <= 0) {
			throw new Exception("Cidade Pesquisada é Inválida");
		}
		
		return cDAO.getObjectById(id);
	}

	@Override
	public void excluir(Cidade cidade) throws Exception {
		if(cidade.getNome() == null) {
			throw new Exception("Cidade selecionada é inválida");
		}		
		cDAO.excluir(cidade);		
	}

}
