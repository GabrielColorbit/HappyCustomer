package br.edu.facear.test;

public class MainTest {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 2; i++) {

			// TIPO USUARIO
			TipoUsuarioTest tipousuariotest = new TipoUsuarioTest();
			tipousuariotest.testCadastrarTipoUsuario();

			// TIPO ATIVIDADE
			TipoAtividadeTest tipoatividadetest = new TipoAtividadeTest();
			tipoatividadetest.testCadastrarTipoAtividade();

			// TIPO EMPRESA
			TipoEmpresaTest tipoempresatest = new TipoEmpresaTest();
			tipoempresatest.testCadastrarTipoEmpresa();

			// TIPO CONTATO
			TipoContatoTest tipocontatotest = new TipoContatoTest();
			tipocontatotest.testCadastrarTipoContato();

			// ORIGEM CONTATO
			OrigemContatoTest origemcontatotest = new OrigemContatoTest();
			origemcontatotest.testCadastrarOrigemContato();

			// PRODUTO
			ProdutoTest produtotest = new ProdutoTest();
			produtotest.testCadastrarProduto();

			// TIPO TELEFONE
			TipoTelefoneTest tipotelefonetest = new TipoTelefoneTest();
			tipotelefonetest.testCadastrarTipoTelefone();

			// TIPO COMUNICADOR
			TipoComunicadorTest tipocomunicadortest = new TipoComunicadorTest();
			tipocomunicadortest.testCadastrarTipoComunicador();

			if (i == 1) {

				// TIPO USUÁRIO
				tipousuariotest.testAterarTipoUsuario();

				// TIPO ATIVIDADE
				tipoatividadetest.testAterarTipoAtividade();

				// TIPO EMPRESA
				tipoempresatest.testAterarTipoEmpresa();

				// TIPO CONTATO
				tipocontatotest.testAterarTipoContato();

				// ORIGEM CONTATO
				origemcontatotest.testAterarOrigemContato();

				// PRODUTO
				produtotest.testAterarProduto();

				// TIPO TELEFONE
				tipotelefonetest.testAterarTipoTelefone();

				// TIPO COMUNICADOR
				tipocomunicadortest.testAterarTipoComunicador();

			}
		}

		// ESTADO
		EstadoTest estadotest = new EstadoTest();
		estadotest.testCadastrarEstado();

		// CIDADE
		CidadeTest cidadetest = new CidadeTest();
		cidadetest.testCadastrarCidade();

		// // ESTADO
		// estadotest.testAterarEstado();
		//
		// // CIDADE
		// cidadetest.testAterarCidade();

		for (int y = 0; y < 2; y++) {

			// USUARIO
			UsuarioTest usuariotest = new UsuarioTest();
			usuariotest.testCadastrarUsuario();

			// EMPRESA
			EmpresaTest empresatest = new EmpresaTest();
			empresatest.testCadastrarEmpresa();

			// CONTATO
			ContatoTest contatotest = new ContatoTest();
			contatotest.testCadastrarContato();

			// ATIVIDADE
			AtividadeTest atividadetest = new AtividadeTest();
			atividadetest.testCadastrarAtividade();

			// NEGOCIO
			NegocioTest negociotest = new NegocioTest();
			negociotest.testCadastrarNegocio();

			// LIGACAO
			LigacaoTest ligacaotest = new LigacaoTest();
			ligacaotest.testCadastrarLigacao();

			if (y == 1) {

//				// USUARIO
//				usuariotest.testAterarUsuario();
//
//				// EMPRESA
////				empresatest.testAterarEmpresa();
//
//				// CONTATO
//				contatotest.testAterarContato();
//
//				// ATIVIDADE
//				atividadetest.testAterarAtividade();
//
//				// NEGOCIO
//				negociotest.testAterarNegocio();
//
//				// LIGACAO
//				ligacaotest.testAterarLigacao();

			}
		}
	}
}