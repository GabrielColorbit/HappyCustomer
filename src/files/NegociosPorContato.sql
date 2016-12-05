select
	c.id||'-'||c.nome as contato
    ,c.idfoto as idfoto
    ,count(c.id) as negocios

from "TB_NEGOCIO" n
inner join "TB_CONTATO" c on (c.id = n.contato_id)
Group by
	c.id
    ,c.nome
    ,c.idfoto
