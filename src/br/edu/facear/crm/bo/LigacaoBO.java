package br.edu.facear.crm.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import br.edu.facear.crm.dao.LigacaoDAO;
import br.edu.facear.crm.entity.Atividade;
import br.edu.facear.crm.entity.Contato;
import br.edu.facear.crm.entity.Empresa;
import br.edu.facear.crm.entity.Ligacao;
import br.edu.facear.crm.entity.TipoLigacao;
import br.edu.facear.crm.entity.Usuario;

public class LigacaoBO implements InterfaceBO<Ligacao>{
	LigacaoDAO ldao =  new LigacaoDAO();
	@Override
	public void Cadastrar(Ligacao o) throws Exception {
		if(o.getContato() == null ||
   		   o.getUsuario() == null ||
    	   o.getContato() == null ||
		   o.getEmpresa() == null ||
		   o.getDuracao() == null ||
		   o.getData() == null ||
		   o.getTipoligacao() == null ||
		   o.getResumo() == null ){
				throw new Exception("Preencher todos os campos da ligacao");
			}
		
			ldao.Cadastrar(o);						
			
	}

	@Override
	public List<Ligacao> Listar() throws Exception {
		List<Ligacao> l = ldao.Listar();
		if(l == null){
			throw new Exception("Nenhuma ligacão cadastrada");
		}
		return l;
	}

	@Override
	public void Alterar(Ligacao o) throws Exception {
		if(o.getContato() == null ||
   		   o.getUsuario() == null ||
    	   o.getContato() == null ||
		   o.getEmpresa() == null ||
		   o.getDuracao() == null ||
		   o.getData() == null ||
		   o.getTipoligacao() == null ||
		   o.getResumo() == null ){
				throw new Exception("Preencher todos os campos da ligacao");
			}
		
			ldao.Alterar(o);				
	}

	@Override
	public Ligacao BuscarID(Long id) throws Exception {
		if(id == null) {
			throw new Exception("Ligacao pesquisada é inválida");
		}
		else if(id <= 0) {
			throw new Exception("Ligacao pesquisado é inválida");
		}
		return ldao.BuscarID(id);
	}

	@Override
	public void Excluir(Ligacao o) throws Exception {
		if(o == null) {
			throw new Exception("Ligacao Selecionada é inválida.");
		}		
		ldao.Excluir(o);		
	}

}
