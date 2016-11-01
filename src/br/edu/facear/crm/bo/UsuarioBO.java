package br.edu.facear.crm.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import br.edu.facear.crm.dao.UsuarioDAO;
import br.edu.facear.crm.entity.Cidade;
import br.edu.facear.crm.entity.Genero;
import br.edu.facear.crm.entity.TipoUsuario;
import br.edu.facear.crm.entity.Usuario;

public class UsuarioBO implements InterfaceBO<Usuario> {

	UsuarioDAO udao = new UsuarioDAO();

	// CADASTRAR
	@Override
	public void Cadastrar(Usuario usuario) throws Exception {

		if (usuario.getTipousuario() == null) {
			throw new Exception("Selecione um Tipo Usuario");
		} else if (usuario.getCidade() == null) {
			throw new Exception("Selecione uma Cidade.");
		} else if (usuario.getTelefones_usuario() == null) {
			throw new Exception("Selecione um um Telefone.");
		} else if (usuario.getComunicadores_usuario() == null) {
			throw new Exception("Selecione um Comunicador Usuário.");
		} else if (usuario.getNome() == null) {
			throw new Exception("Nome do Usuário Invalido.");
		} else if (usuario.getCpf() == null) {
			throw new Exception("Fornecido Cpf  Invaliado.");
		} else if (usuario.getDatanascimento() == null) {
			throw new Exception("Data de Nascimento Invalido.");
		} else if (usuario.getEndereco() == null) {
			throw new Exception("Endereço Fornecido Invalido.");
		} else if (usuario.getNumero() == null) {
			throw new Exception("Numero Fornecido Invalido.");
		} else if (usuario.getComplemento() == null) {
			throw new Exception("Complemento Fornecido Invalido.");
		} else if (usuario.getCep() == null) {
			throw new Exception("Cep Fornecido Invalido.");
		} else if (usuario.getBairro() == null) {
			throw new Exception("Bairro Fornecido Invalido.");
		} else if (usuario.getSenha() == null) {
			throw new Exception("Senha Fornecida Invalido.");
		} else if (usuario.getGenero() == null) {
			throw new Exception("Genero Fornecido Invalido.");
		} else if (usuario.getCargo() == null) {
			throw new Exception("Cargo Fornecido Invalido.");
		} else if (usuario.getFoto() == null) {
			throw new Exception("Foto Fornecido Invalido.");
		} else if (usuario.getDatacadastro() == null) {
			throw new Exception("Data Fornecida Invalida.");
		} else if (usuario.getStatus() == null) {
			throw new Exception("Status Fornecido Invalido.");
		}

		udao.Cadastrar(usuario);
	}

	// LISTAR
	@Override
	public ArrayList<Usuario> Listar() throws Exception {
		ArrayList<Usuario> u = udao.Listar();
		if (u == null) {
			throw new Exception("Nenhuma usuário cadastrado");
		}
		return u;
	}

	// ALTERAR
	@Override
	public void Alterar(Usuario usuario) throws Exception {

		if (usuario.getTipousuario() == null) {
			throw new Exception("Selecione um Tipo Usuario");
		} else if (usuario.getCidade() == null) {
			throw new Exception("Selecione uma Cidade.");
		} else if (usuario.getTelefones_usuario() == null) {
			throw new Exception("Selecione um um Telefone.");
		} else if (usuario.getComunicadores_usuario() == null) {
			throw new Exception("Selecione um Comunicador Usuário.");
		} else if (usuario.getNome() == null) {
			throw new Exception("Nome do Usuário Invalido.");
		} else if (usuario.getCpf() == null) {
			throw new Exception("Fornecido Cpf  Invaliado.");
		} else if (usuario.getDatanascimento() == null) {
			throw new Exception("Data de Nascimento Invalido.");
		} else if (usuario.getEndereco() == null) {
			throw new Exception("Endereço Fornecido Invalido.");
		} else if (usuario.getNumero() == null) {
			throw new Exception("Numero Fornecido Invalido.");
		} else if (usuario.getComplemento() == null) {
			throw new Exception("Complemento Fornecido Invalido.");
		} else if (usuario.getCep() == null) {
			throw new Exception("Cep Fornecido Invalido.");
		} else if (usuario.getBairro() == null) {
			throw new Exception("Bairro Fornecido Invalido.");
		} else if (usuario.getSenha() == null) {
			throw new Exception("Senha Fornecida Invalido.");
		} else if (usuario.getGenero() == null) {
			throw new Exception("Genero Fornecido Invalido.");
		} else if (usuario.getCargo() == null) {
			throw new Exception("Cargo Fornecido Invalido.");
		} else if (usuario.getFoto() == null) {
			throw new Exception("Foto Fornecido Invalido.");
		} else if (usuario.getDatacadastro() == null) {
			throw new Exception("Data Fornecida Invalida.");
		} else if (usuario.getStatus() == null) {
			throw new Exception("Status Fornecido Invalido.");
		}

		udao.Alterar(usuario);
	}

	// BUSCAR ID
	@Override
	public Usuario BuscarID(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Usuário pesquisado é Inválido");
		} else if (id <= 0) {
			throw new Exception("Usuário Pesquisado é Inválido");
		}

		return udao.BuscarID(id);
	}

	// EXCLUIR
	@Override
	public void Excluir(Usuario o) throws Exception {
		if (o.getNome() == null) {
			throw new Exception("Usuario Selecionada é inválido.");
		}
		udao.Excluir(o);
	}
}