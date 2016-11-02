package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.ComunicadorDAO;
import br.edu.facear.crm.entity.Comunicador;

public class ComunicadorBO implements InterfaceBO<Comunicador> {

	ComunicadorDAO comunicadorDAO = new ComunicadorDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Comunicador comunicador) throws Exception {
		if (comunicador.getNome() == null) {
			throw new Exception("Nome do comunicador � invalido!");
		}
		else if (comunicador.getTipocomunicador() == null) {
			throw new Exception("Selecione um Tipo de Comunicador!");
		}
		comunicadorDAO.Cadastrar(comunicador);
	}

	// ALTERAR
	@Override
	public void Alterar(Comunicador comunicador) throws Exception {
		if (comunicador.getNome() == null) {
			throw new Exception("Nome do comunicador � invalido!");
		}
		else if (comunicador.getTipocomunicador() == null) {
			throw new Exception("Selecione um Tipo de Comunicador!");
		}
		comunicadorDAO.Alterar(comunicador);
	}

	// EXCLUIR
	@Override
<<<<<<< HEAD
	public void Alterar(Comunicador comunicador) throws Exception {
		if(comunicador.getNome() ==  null){
			throw new Exception("Nome Invalido.");
		}
		else if(comunicador.getTipocomunicador() == null){
			throw new Exception("Selecione um Tipo Comunicador");
		}		
		tcdao.Alterar(comunicador);			
=======
	public void Excluir(Comunicador o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Comunicador selecionado � inv�lido!");
		}
		comunicadorDAO.Excluir(o);
>>>>>>> origin/master
	}

	// LISTAR
	@Override
	public List<Comunicador> Listar() throws Exception {
		List<Comunicador> comunicadores = comunicadorDAO.Listar();
		if (comunicadores == null) {
			throw new Exception("Nenhum comunicador cadastrado!");
		}
		return comunicadores;
	}

	// BUSCAR ID
	@Override
	public Comunicador BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Comunicador pesquisado � Inv�lido!");
		} else if (id <= 0) {
			throw new Exception("Comunicador Pesquisado � Inv�lido!");
		}
		return comunicadorDAO.BuscarID(id);
	}
}