package br.edu.facear.crm.bo;

import java.util.List;

import br.edu.facear.crm.dao.EmpresaDAO;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;

public class EmpresaBO implements InterfaceBO<Empresa>{
	EmpresaDAO edao  =  new EmpresaDAO();
	//car
	@Override
<<<<<<< HEAD
	public void Cadastrar(Empresa empresa) throws Exception {
					

		if(empresa.getTipoempresa() == null) {
			throw new Exception("Selecione Tipo Empresa");
		}		
		else if(empresa.getCidade() ==  null){
			throw new Exception("Selecione uma cidade .");
		}
		else if(empresa.getTelefones() ==  null){
			throw new Exception("Selecione uma telefone .");
		}
		else if(empresa.getContatos() ==  null){
			throw new Exception("Selecione um Contato .");
		}
		else if(empresa.getNome() ==  null){
			throw new Exception(" Nome Informado Invalido .");
		}
		else if(empresa.getCnpj() ==  null){
			throw new Exception("Cnpj Informado Invalido .");
		}
		else if(empresa.getRazaosocial() ==  null){
			throw new Exception(" Razão Social Informado Invalido ");
		}
		else if(empresa.getDatacadastro()==  null){
			throw new Exception(" Data de Cadastro Informado Invalido ");
		}
		else if(empresa.getStatus() ==  null){
			throw new Exception(" Status Informado Invalido ");
		}
		else if(empresa.getRamo() ==  null){
			throw new Exception("Ramo Informado Invalido ");
		}
		else if(empresa.getSite() ==  null){
			throw new Exception(" Site Informado Invalido ");
		}
		else if(empresa.getEndereco() ==  null){
			throw new Exception(" Endereço Informado Invalido ");
		}
		else if(empresa.getCep() ==  null){
			throw new Exception(" Cep Informado Invalido ");
		}
		
		
		
		
		
	        edao.Cadastrar(empresa);
=======
	public void Cadastrar(Empresa o) throws Exception {
		if(o.getTipoempresa() == null ||
		   o.getRazaosocial() == null ||
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
>>>>>>> origin/master
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
<<<<<<< HEAD
	public void Alterar(Empresa empresa) throws Exception {
		
		

if(empresa.getTipoempresa() == null) {
	throw new Exception("Selecione Tipo Empresa");
}		
else if(empresa.getCidade() ==  null){
	throw new Exception("Selecione uma cidade .");
}
else if(empresa.getTelefones() ==  null){
	throw new Exception("Selecione uma telefone .");
}
else if(empresa.getContatos() ==  null){
	throw new Exception("Selecione um Contato .");
}
else if(empresa.getNome() ==  null){
	throw new Exception(" Nome Informado Invalido .");
}
else if(empresa.getCnpj() ==  null){
	throw new Exception("Cnpj Informado Invalido .");
}
else if(empresa.getRazaosocial() ==  null){
	throw new Exception(" Razão Social Informado Invalido ");
}
else if(empresa.getDatacadastro()==  null){
	throw new Exception(" Data de Cadastro Informado Invalido ");
}
else if(empresa.getStatus() ==  null){
	throw new Exception(" Status Informado Invalido ");
}
else if(empresa.getRamo() ==  null){
	throw new Exception("Ramo Informado Invalido ");
}
else if(empresa.getSite() ==  null){
	throw new Exception(" Site Informado Invalido ");
}
else if(empresa.getEndereco() ==  null){
	throw new Exception(" Endereço Informado Invalido ");
}
else if(empresa.getCep() ==  null){
	throw new Exception(" Cep Informado Invalido ");
}



		
		
			edao.Alterar(empresa);				
=======
	public void Alterar(Empresa o) throws Exception {
		if(o.getTipoempresa() == null ||
		   o.getCidade() == null ||
		   o.getRazaosocial() == null ||
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
>>>>>>> origin/master
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
		if(o.getRazaosocial() == null) {
			throw new Exception("Empresa Selecionada é inválida.");
		}		
		edao.Excluir(o);	
	}
}