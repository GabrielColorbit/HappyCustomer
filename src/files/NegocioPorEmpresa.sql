select
	e.id||'-'||e.razaosocial as empresa
    ,e.idfoto as idfoto
    ,count(e.id) as negocios

from "TB_NEGOCIO" n
inner join "TB_EMPRESA" e on (e.id = n.empresa_id)
Group by
	e.id
    ,e.razaosocial
    ,e.idfoto
