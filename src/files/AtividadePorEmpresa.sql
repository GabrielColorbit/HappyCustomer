select
    a.empresa_id as empresa
    ,count(a.id) as numeratividade
    ,case EXTRACT(month from (to_date(a.datacadastro, 'YYYY-DD-MM') ))
    	when 1 then 'Janeiro'
        when 2 then 'Fevereiro'
    	when 3 then 'Março'
        when 4 then 'Abril'
    	when 5 then 'Maio'
        when 6 then 'Junho'
    	when 7 then 'Julho'
        when 8 then 'Agosto'
    	when 9 then 'Setembro'
        when 10 then 'Outubro'
        when 11 then 'Novembro'
        when 12 then 'Dezembro'
     end   AS OrderMonth

From "TB_ATIVIDADE"  a
Where
	a.empresa_id = 1

Group by
	a.empresa_id
  ,a.datacadastro
