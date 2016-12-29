package br.edu.facear.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.facear.crm.entity.AtividadePorEmpresa;
import br.edu.facear.crm.entity.AtividadesPorStatus;
import br.edu.facear.crm.entity.NegocioPorContato;
import br.edu.facear.crm.entity.NegocioPorEmpresa;

public class RelatorioDAO {



	public ArrayList<AtividadePorEmpresa> SelectAtividade(Long idempresa){

		ConnectionJDBC c = new ConnectionJDBC();
		Connection conn = c.connectToDatabaseOrDie();
		ArrayList<AtividadePorEmpresa> apelist = new ArrayList<>();
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("with totalempresa as( Select count(ef.empresa) as empresa ,ef.mes as mes from( select a.empresa_id as empresa ,case EXTRACT(month from(to_date(a.datacadastro, 'DD/MM/YYYY'))) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Marco' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes From \"TB_ATIVIDADE\" a Group By a.datacadastro ,a.empresa_id)as ef Group by ef.mes Order by ef.mes ),totalatividade as ( Select count(ef.atividade) as atividade ,ef.mes as mes From(select a.id as atividade ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY'))) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Marco' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes from \"TB_ATIVIDADE\" a group By a.datacadastro ,a.id )as ef Group by ef.mes Order by ef.mes ), media as ( Select round( ta.atividade::numeric, 4)/round( te.empresa::numeric, 4) as media ,te.mes from totalempresa te inner join totalatividade ta on (ta.mes = te.mes) ), atividades as ( Select count(ef.atividade) as numeroatividade ,ef.mes as mes From(select a.id as atividade ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY'))) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Marco' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes from \"TB_ATIVIDADE\" a where a.empresa_id = "+idempresa+" group By a.datacadastro ,a.id )as ef Group by ef.mes Order by ef.mes ), kpi as ( Select a.numeroatividade ,m.media ,a.mes From atividades a inner join media m on (m.mes = a.mes) Order by a.mes ) Select * from kpi ");

//	      while ( rs.next() )
//	      {
//
//	    	  ResultSetMetaData rsmd = rs.getMetaData();
//    		  System.out.println(rsmd.getColumnName(1));
//    		  System.out.println(rsmd.getColumnName(2));
//    		  System.out.println(rsmd.getColumnName(3));
//
//
//	      }

      	  apelist = new ArrayList<AtividadePorEmpresa>();
	      while ( rs.next() )
	      {

	    	  Long numeroatividades = rs.getLong("numeroatividade");
	          String mes = rs.getString("mes");
          	  Double media = rs.getDouble("media");
          	  AtividadePorEmpresa ape= new AtividadePorEmpresa();
              ape.setNumeroatividade(numeroatividades);
          	  ape.setMes(mes);
          	  ape.setMedia(media);
          	  apelist.add(ape);
          	  
          	 System.out.println(numeroatividades);
          	 System.out.println(media);
          	 System.out.println(mes);
	      }

	      rs.close();
	      st.close();
	    }
	    catch (SQLException se) {
	      System.err.println(se.getMessage());
	    }
	    return apelist;
	  }



	public ArrayList<NegocioPorEmpresa> ListNegocios(){

		ConnectionJDBC c = new ConnectionJDBC();
		Connection conn = c.connectToDatabaseOrDie();
		ArrayList<NegocioPorEmpresa> npelist = new ArrayList<>();
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("select e.id||'-'||e.razaosocial as empresa ,e.idfoto as idfoto ,count(e.id) as negocios from \"TB_NEGOCIO\" n inner join \"TB_EMPRESA\" e on(e.id = n.empresa_id) Group by e.id ,e.razaosocial ,e.idfoto ");

	      while ( rs.next() )
	      {

	    	  String empresa = rs.getString("empresa");
	          Long idfoto = rs.getLong("idfoto");
          	  Long negocios = rs.getLong("negocios");
          	  NegocioPorEmpresa npe= new NegocioPorEmpresa();
	      	  npe.setEmpresa(empresa);
	      	  npe.setFoto("http://localhost:8080/CRM/rest/restFoto/RetornaImagem/"+idfoto);
	      	  npe.setNegocios(negocios);
	      	  npelist.add(npe);
          	  
          	 System.out.println(empresa);
          	 System.out.println(idfoto);
          	 System.out.println(negocios);
	      }

	      rs.close();
	      st.close();
	    }
	    catch (SQLException se) {
	      System.err.println(se.getMessage());
	    }
	    return npelist;
	  }

	


	public ArrayList<NegocioPorContato> ListNegociosPorContato(){

		ConnectionJDBC c = new ConnectionJDBC();
		Connection conn = c.connectToDatabaseOrDie();
		ArrayList<NegocioPorContato> npclist = new ArrayList<>();
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("select c.id||'-'||c.nome as contato ,c.idfoto as idfoto ,count(c.id) as negocios from \"TB_NEGOCIO\" n inner join \"TB_CONTATO\" c on(c.id = n.contato_id) Group by c.id ,c.nome ,c.idfoto ");

	      while ( rs.next() )
	      {

	    	  String contato = rs.getString("contato");
	          Long idfoto = rs.getLong("idfoto");
          	  Long negocios = rs.getLong("negocios");
          	  NegocioPorContato npc= new NegocioPorContato();
	      	  npc.setContato(contato);
	      	  npc.setFoto("http://localhost:8080/CRM/rest/restFoto/RetornaImagem/"+idfoto);
	      	  npc.setNegocios(negocios);
	      	  npclist.add(npc);
          	  
          	 System.out.println(contato);
          	 System.out.println(idfoto);
          	 System.out.println(negocios);
	      }

	      rs.close();
	      st.close();
	    }
	    catch (SQLException se) {
	      System.err.println(se.getMessage());
	    }
	    return npclist;
	  }

	
	public ArrayList<AtividadesPorStatus> AtividadesPorStatus(){

		ConnectionJDBC c = new ConnectionJDBC();
		Connection conn = c.connectToDatabaseOrDie();
		ArrayList<AtividadesPorStatus> apslist = new ArrayList<>();
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("select count(a.id) as atividade ,case a.situacao when 0 then 'Aberto' when 1 then 'Cancelado' when 2 then 'Paralisado' when 3 then 'Finalizado' end AS situacao ,case a.situacao when 0 then '#67B7DC' when 1 then '#dc5050' when 2 then '#FDD400' when 3 then '#84B761' end AS cor From \"TB_ATIVIDADE\" a Group By a.situacao");

	      while ( rs.next() )
	      {

	    	  Long atividade = rs.getLong("atividade");
	          String situacao = rs.getString("situacao");
          	  String cor= rs.getString("cor");
          	  AtividadesPorStatus aps= new AtividadesPorStatus();
	      	  aps.setAtividade(atividade);
	      	  aps.setSituacao(situacao);
	      	  aps.setCor(cor);
	      	  apslist.add(aps);
          	  
          	 System.out.println(atividade);
          	 System.out.println(situacao);
          	 System.out.println(cor);
	      }

	      rs.close();
	      st.close();
	    }
	    catch (SQLException se) {
	      System.err.println(se.getMessage());
	    }
	    return apslist;
	  }

	
	
	
}