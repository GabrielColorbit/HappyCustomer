package br.edu.facear.crm.bo;

import java.util.ArrayList;

import br.edu.facear.crm.dao.EmpresaDAO;
import br.edu.facear.crm.entity.Empresa;

public class EmpresaBO implements InterfaceBO<Empresa> {

	EmpresaDAO empresaDAO = new EmpresaDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Empresa empresa) throws Exception {

		if (empresa.getTipoempresa() == null) {
			throw new Exception("Selecione Tipo Empresa");
		} else if (empresa.getCidade() == null) {
			throw new Exception("Selecione uma cidade .");
		}
		else if (empresa.getCnpj() == null) {
			throw new Exception("Cnpj Informado Invalido .");
		} else if (empresa.getRazaosocial() == null) {
			throw new Exception(" Razão Social Informado Invalido ");
		} else if (empresa.getDatacadastro() == null) {
			throw new Exception(" Data de Cadastro Informado Invalido ");
		} else if (empresa.getStatus() == null) {
			throw new Exception(" Status Informado Invalido ");
		} else if (empresa.getRamo() == null) {
			throw new Exception("Ramo Informado Invalido ");
		} else if (empresa.getSite() == null) {
			throw new Exception(" Site Informado Invalido ");
		} else if (empresa.getEndereco() == null) {
			throw new Exception(" Endereço Informado Invalido ");
		} else if (empresa.getCep() == null) {
			throw new Exception(" Cep Informado Invalido ");
		}
		empresaDAO.Cadastrar(empresa);

	}

	// ALTERAR
	@Override
	public void Alterar(Empresa empresa) throws Exception {

		if (empresa.getTipoempresa() == null) {
			throw new Exception("Selecione Tipo Empresa");
		} else if (empresa.getCidade() == null) {
			throw new Exception("Selecione uma cidade .");
		}
		else if (empresa.getCnpj() == null) {
			throw new Exception("Cnpj Informado Invalido .");
		} else if (empresa.getRazaosocial() == null) {
			throw new Exception(" Razão Social Informado Invalido ");
		} else if (empresa.getDatacadastro() == null) {
			throw new Exception(" Data de Cadastro Informado Invalido ");
		} else if (empresa.getStatus() == null) {
			throw new Exception(" Status Informado Invalido ");
		} else if (empresa.getRamo() == null) {
			throw new Exception("Ramo Informado Invalido ");
		} else if (empresa.getSite() == null) {
			throw new Exception(" Site Informado Invalido ");
		} else if (empresa.getEndereco() == null) {
			throw new Exception(" Endereço Informado Invalido ");
		} else if (empresa.getCep() == null) {
			throw new Exception(" Cep Informado Invalido ");
		}
		empresaDAO.Alterar(empresa);
	}

	// EXCLUIR
	@Override
	public void Excluir(Empresa o) throws Exception {
		if (o.getRazaosocial() == null) {
			throw new Exception("Empresa Selecionada é inválida.");
		}
		empresaDAO.Excluir(o);
	}

	// LISTAR
	@Override
	public ArrayList<Empresa> Listar() throws Exception {
		ArrayList<Empresa> e = empresaDAO.Listar();
		if (e == null) {
			throw new Exception("Nenhuma empresa cadastrado");
		}
		return e;
	}

	// BUSCAR ID
	@Override
	public Empresa BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Empresa pesquisada é inválida");
		} else if (id <= 0) {
			throw new Exception("Empresa pesquisado é inválida");
		}
		return empresaDAO.BuscarID(id);
	}
}