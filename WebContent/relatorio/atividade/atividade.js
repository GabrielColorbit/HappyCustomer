function callChartAtividade(){
	
	window.location.href=window.location.href;
	var person;
	var idempresa = $("#idEmpresa").html();
	$.getJSON('http://localhost:8080/CRM/rest/restRelatorio/AtividadePorEmpresa/'+idempresa, callbackRestJson);
	var atividadePorEmpresaList= [];
	function callbackRestJson(data) {


			for(var i in data){
				data

			}

    		var returnape = data;
			person = returnape;
			runChart();

	}
	function runChart(){


		var chart = AmCharts.makeChart( "chartdiv", {
			  "type": "serial",
			  "addClassNames": true,
			  "theme": "light",
			  "autoMargins": false,
			  "marginLeft": 30,
			  "marginRight": 8,
			  "marginTop": 10,
			  "marginBottom": 26,
			  "balloon": {
			    "adjustBorderColor": false,
			    "horizontalPadding": 10,
			    "verticalPadding": 8,
			    "color": "#ffffff"
			  },

			  "dataProvider": person,
			  "valueAxes": [ {
			    "axisAlpha": 0,
			    "position": "left"
			  } ],
			  "startDuration": 1,
			  "graphs": [ {
			    "alphaField": "alpha",
			    "balloonText": "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
			    "fillAlphas": 1,
			    "title": "atividades",
			    "type": "column",
			    "valueField": "numeroatividade",
			    "dashLengthField": "dashLengthColumn"
			  }, {
			    "id": "graph2",
			    "balloonText": "<span style='font-size:12px;'>[[title]] in [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
			    "bullet": "round",
			    "lineThickness": 3,
			    "bulletSize": 7,
			    "bulletBorderAlpha": 1,
			    "bulletColor": "#FFFFFF",
			    "useLineColorForBulletBorder": true,
			    "bulletBorderThickness": 3,
			    "fillAlphas": 0,
			    "lineAlpha": 1,
			    "title": "media",
			    "valueField": "media",
			    "dashLengthField": "dashLengthLine"
			  } ],
			  "categoryField": "mes",
			  "categoryAxis": {
			    "gridPosition": "start",
			    "axisAlpha": 0,
			    "tickLength": 0
			  },
			  "export": {
			    "enabled": true
			  }
		} );
	}


}