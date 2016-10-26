package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.EmpresaDAO;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;

public class EmpresaBO implements InterfaceBO<Empresa>{
	EmpresaDAO edao  =  new EmpresaDAO();
	//carioa
	@Override
	public void Cadastrar(Empresa o) throws Exception {
		if(o.getTipoempresa() == null ||
		   o.getCidade() == null ||
   		   o.getTelefones() == null ||
    	   o.getContatos() == null ||
		   o.getNome() == null ||
		   o.getCnpj() == null ||
		   o.getDatacadastro() == null ||
		   o.getStatus() == null ||
		   o.getRamo() == null ||
		   o.getSite() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null 	    ){
				throw new Exception("Preencher todos os campos da empresa");
			}
			edao.Cadastrar(o);				
	
	}

	@Override
	public List<Empresa> Listar() throws Exception {
		List<Empresa> e = edao.Listar();
		if(e == null){
			throw new Exception("Nenhuma empresa cadastrado");
		}
		return e;
	}

	@Override
	public void Alterar(Empresa o) throws Exception {
		if(o.getTipoempresa() == null ||
		   o.getCidade() == null ||
		   o.getTelefones() == null ||
		   o.getContatos() == null ||
		   o.getNome() == null ||
		   o.getCnpj() == null ||
		   o.getDatacadastro() == null ||
		   o.getStatus() == null ||
		   o.getRamo() == null ||
		   o.getSite() == null ||
		   o.getEndereco() == null ||
		   o.getNumero() == null ||
		   o.getCep() == null 	    ){
				throw new Exception("Preencher todos os campos da empresa");
			}
			edao.Alterar(o);				
	}

	@Override
	public Empresa BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Empresa pesquisada é inválida");
		}
		else if(id <= 0) {
			throw new Exception("Empresa pesquisado é inválida");
		}
		return edao.BuscarID(id);

	}

	@Override
	public void Excluir(Empresa o) throws Exception {
		if(o.getNome() == null) {
			throw new Exception("Empresa Selecionada é inválida.");
		}		
		edao.Excluir(o);		
	}

}
