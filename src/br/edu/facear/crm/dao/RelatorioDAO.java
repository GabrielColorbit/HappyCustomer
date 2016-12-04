package br.edu.facear.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.facear.crm.entity.AtividadePorEmpresa;

public class RelatorioDAO {



	public ArrayList<AtividadePorEmpresa> SelectAtividade(Long idempresa){

		ConnectionJDBC c = new ConnectionJDBC();
		Connection conn = c.connectToDatabaseOrDie();
		ArrayList<AtividadePorEmpresa> apelist = new ArrayList<>();
	    try
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("with totalempresa as( select count(ef.empresa) as empresa ,ef.mes as mes from( select sum(a.empresa_id) as total ,a.empresa_id as empresa ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY'))) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Março' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes From \"TB_ATIVIDADE\" a Group By a.datacadastro ,a.empresa_id )as ef Group By ef.mes ), totalatividade as ( select count(a.id) as atividade ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY') )) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Março' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes From \"TB_ATIVIDADE\" a Group by a.datacadastro ), media as ( select round( ta.atividade::numeric, 4)/round( te.empresa::numeric, 4) as media ,te.mes from totalempresa te inner join totalatividade ta on (ta.mes = te.mes) ) ,atividades as ( select count(a.id) as numeroatividade ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY') )) when 1 then '01-Janeiro' when 2 then '02-Fevereiro' when 3 then '03-Março' when 4 then '04-Abril' when 5 then '05-Maio' when 6 then '06-Junho' when 7 then '07-Julho' when 8 then '08-Agosto' when 9 then '09-Setembro' when 10 then '10-Outubro' when 11 then '11-Novembro' when 12 then '12-Dezembro' else 'Indefinido' end AS mes From \"TB_ATIVIDADE\" a Where a.empresa_id = "+idempresa+" Group by a.datacadastro ), kpi as ( select a.numeroatividade ,m.media ,a.mes From atividades a inner join media m on (m.mes = a.mes) Order by a.mes )select * from kpi ");

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


}