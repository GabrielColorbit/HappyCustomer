with totalempresa as(
  Select count(ef.empresa) as empresa
  ,ef.mes as mes from(
      select
        a.empresa_id as empresa
        ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY')))
          when 1 then '01-Janeiro'
          when 2 then '02-Fevereiro'
          when 3 then '03-Marco'
          when 4 then '04-Abril'
          when 5 then '05-Maio'
          when 6 then '06-Junho'
          when 7 then '07-Julho'
          when 8 then '08-Agosto'
          when 9 then '09-Setembro'
          when 10 then '10-Outubro'
          when 11 then '11-Novembro'
          when 12 then '12-Dezembro'
          else 'Indefinido'
          end AS mes
      From \"TB_ATIVIDADE\" a
      Group By a.datacadastro
      ,a.empresa_id
  )as ef
  Group by ef.mes
  Order by ef.mes

),totalatividade as (
  Select count(ef.atividade) as atividade
    ,ef.mes as mes
  From(select
        a.id as atividade
        ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY')))
          when 1 then '01-Janeiro'
          when 2 then '02-Fevereiro'
          when 3 then '03-Marco'
          when 4 then '04-Abril'
          when 5 then '05-Maio'
          when 6 then '06-Junho'
          when 7 then '07-Julho'
          when 8 then '08-Agosto'
          when 9 then '09-Setembro'
          when 10 then '10-Outubro'
          when 11 then '11-Novembro'
          when 12 then '12-Dezembro'
          else 'Indefinido'
          end AS mes
      from \"TB_ATIVIDADE\" a
      group By
      a.datacadastro
      ,a.id
  )as ef
  Group by ef.mes
  Order by ef.mes
), media as (
  Select
    round( ta.atividade::numeric, 4)/round( te.empresa::numeric, 4) as media
    ,te.mes from totalempresa te inner join totalatividade ta on (ta.mes = te.mes)
), atividades as (
  Select
     count(ef.atividade) as numeroatividade
     ,ef.mes as mes
  From(select
       a.id as atividade
       ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY')))
         when 1 then '01-Janeiro'
         when 2 then '02-Fevereiro'
         when 3 then '03-Marco'
         when 4 then '04-Abril'
         when 5 then '05-Maio'
         when 6 then '06-Junho'
         when 7 then '07-Julho'
         when 8 then '08-Agosto'
         when 9 then '09-Setembro'
         when 10 then '10-Outubro'
         when 11 then '11-Novembro'
         when 12 then '12-Dezembro'
         else 'Indefinido'
        end AS mes
     from \"TB_ATIVIDADE\" a
     where a.empresa_id = "+idempresa+"
     group By
     a.datacadastro
     ,a.id
   )as ef
   Group by ef.mes
   Order by ef.mes
), kpi as (
    Select
      a.numeroatividade
      ,m.media
      ,a.mes
    From atividades a
    inner join media m on (m.mes = a.mes)
    Order by a.mes
)
Select * from kpi
