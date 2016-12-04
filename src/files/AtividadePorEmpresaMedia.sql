with
totalempresa as (
    select
    	count(ef.empresa) as empresa
    	,ef.mes as mes
    from(
        select
            sum(a.empresa_id) as total
            ,a.empresa_id as empresa
            ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY') ))
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
                else 'Indefinido'
            end AS mes

            From "TB_ATIVIDADE" a
            Group By
            a.datacadastro
            ,a.empresa_id
    )as ef
    Group By
      ef.mes
),
totalatividade as (
 	select
        count(a.id) as atividade
		,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY') ))
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
            else 'Indefinido'
         end   AS mes

    From "TB_ATIVIDADE" a
    Group by
       a.datacadastro

),
media as (
	select
    	round( ta.atividade::numeric, 4)/round( te.empresa::numeric, 4) as media
    	,te.mes
	from totalempresa te
    inner join totalatividade ta on (ta.mes = te.mes)

)
,atividades as (
    select

        count(a.id) as numeratividade
       ,case EXTRACT(month from (to_date(a.datacadastro, 'DD/MM/YYYY') ))
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
            else 'Indefinido'
         end   AS mes

    From "TB_ATIVIDADE"  a
    Where
        a.empresa_id = 1
    Group by
       a.datacadastro
),
kpi as (
    select
        count(a.numeratividade) as numeroatividade
    	,m.media
        ,a.mes
    From atividades  a
    inner join media m on (m.mes = a.mes)
	Group By
        m.media
        ,a.mes

)select * from kpi