package br.edu.facear.crm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.facear.crm.bo.TipoEmpresaBO;
import br.edu.facear.crm.entity.TipoEmpresa;
import br.edu.facear.facade.FacadeHappyCustomer;

@ManagedBean(name = "TipoEmpresaBean")
@RequestScoped
public class TipoEmpresaBean {

	FacadeHappyCustomer facade = new FacadeHappyCustomer();
	private TipoEmpresa tipoempresa = new TipoEmpresa();
	private List<TipoEmpresa> tiposempresas;

	// GETTERS E SETTERS
	public TipoEmpresa getTipoempresa() {
		return tipoempresa;
	}

	public void setTipoempresa(TipoEmpresa tipoempresa) {
		this.tipoempresa = tipoempresa;
	}

	public List<TipoEmpresa> getTiposempresas() {
		return tiposempresas;
	}

	public void setTiposempresas(List<TipoEmpresa> tiposempresas) {
		this.tiposempresas = tiposempresas;
	}

	public List<TipoEmpresa> gettiposempresas() throws Exception {
		return tiposempresas;
	}

	public void settiposempresas(List<TipoEmpresa> tiposempresas) {
		this.tiposempresas = tiposempresas;
	}

	public TipoEmpresaBean() {
		this.tiposempresas = new ArrayList<TipoEmpresa>();
	}

	public Collection<TipoEmpresa> getLista() throws Exception {
		return new TipoEmpresaBO().Listar();
	}

	// SALVAR - CADASTRAR/EXCLUIR
	public String salvar() throws Exception {
		
		// CADASTRAR
		if (tipoempresa.getId() == null || tipoempresa.getId().equals(0l)) {
			if (tipoempresa.getId().equals(0l)) {
				tipoempresa.setId(null);
			}			
			
			facade.CadastrarTipoEmpresa(tipoempresa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Empresa Cadastrada Com Sucesso!"));

			// FacesContext.getCurrentInstance().addMessage(null, new
			// FacesMessage(FacesMessage.SEVERITY_INFO,
			// tipoempresa.toString(), "Tipo Empresa Cadastrada Com Sucesso!"));

		Listar();
			return "tipo_empresa.xhtml";

		} else {
			
			facade.AlterarTipoEmpresa(tipoempresa);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Empresa Alterada Com Sucesso!"));

			Listar();
			return "tipo_empresa.xhtml";
		}
	}

	// NOVO
	public String novo() {
		this.tipoempresa = new TipoEmpresa();
		return "salvar_tipo_empresa.xhtml";
	}

	// EDITAR
	public String editar(TipoEmpresa tipoempresa) throws Exception {
		this.tipoempresa = tipoempresa;
		facade.AlterarTipoEmpresa(tipoempresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Empresa Alterada Com Sucesso!"));
		Listar();
		return "salvar_tipo_empresa.xhtml";
	}

	// EXCLUIR
	public void excluir(TipoEmpresa tipoempresa) throws Exception {
		facade.ExcluirTipoEmpresa(tipoempresa);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo Empresa Excluída Com Sucesso!"));
		// FacesContext.getCurrentInstance().addMessage("myform:senha", new
		// FacesMessage("Erro: Senha errada"));
		Listar();
	}

	// LISTAR
	@PostConstruct
	public void Listar() {
		try {
			tiposempresas = facade.ListarTipoEmpresa();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}