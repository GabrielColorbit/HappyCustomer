function callChartAtividade(){

	window.location.href=window.location.href;
	var proprieties;
	var idempresa = $("#idEmpresa").html();
	$.getJSON('http://localhost:8080/CRM/rest/restRelatorio/AtividadePorEmpresa/'+idempresa, callbackAtividadeEmpresa);
	function callbackAtividadeEmpresa(data) {
			var returnape = data;
			proprieties = returnape;
			runChartAtividade();

	}
	function runChartAtividade(){


		var chart = AmCharts.makeChart( "chartAtividadePorEmpresa", {
			  "type": "serial",
			  "addClassNames": true,
			  "theme": "patterns",
			  "language": "fr",
			  "autoMargins": false,
			  "marginLeft": 30,
			  "marginRight": 8,
			  "marginTop": 70,
			  "marginBottom": 26,
			  "balloon": {
			    "adjustBorderColor": false,
			    "horizontalPadding": 10,
			    "verticalPadding": 8,
			    "color": "#ffffff"
			  },

			  "dataProvider": proprieties,
			  "valueAxes": [ {
			    "axisAlpha": 0,
			    "position": "left"
			  } ],
			  "startDuration": 1,
			  "graphs": [ {
			    "alphaField": "alpha",
			    "balloonText": "<span style='font-size:12px;'>[[title]] em [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
			    "fillAlphas": 1,
			    "title": "Atividades",
			    "type": "column",
			    "valueField": "numeroatividade",
			    "dashLengthField": "dashLengthColumn"
			  }, {
			    "id": "graph2",
			    "balloonText": "<span style='font-size:12px;'>[[title]] em [[category]]:<br><span style='font-size:20px;'>[[value]]</span> [[additional]]</span>",
			    "bullet": "round",
			    "lineThickness": 3,
			    "bulletSize": 7,
			    "bulletBorderAlpha": 1,
			    "bulletColor": "#FFFFFF",
			    "useLineColorForBulletBorder": true,
			    "bulletBorderThickness": 3,
			    "fillAlphas": 0,
			    "lineAlpha": 1,
			    "title": "Média",
			    "valueField": "media",
			    "dashLengthField": "dashLengthLine"
			  } ],
			  "categoryField": "mes",
			  "categoryAxis": {
			    "gridPosition": "start",
			    "axisAlpha": 0,
			    "tickLength": 0
			  },
			  "valueScrollbar": {
			        "autoGridCount":true
			    },
			    "valueLineBalloonEnabled": true,
		        "valueLineEnabled": true,
			    "zoomControl": {
					"zoomControlEnabled": true
				},
			  "export": {
			    "enabled": true
			  }
		} );
	}


}

function callChartAtividadePorStatus(){
	window.location.href=window.location.href;

	var proprieties;
	$.getJSON('http://localhost:8080/CRM/rest/restRelatorio/AtividadesPorStatus/', callbackRestJson);
	function callbackRestJson(data) {
    		var returnape = data;
    		proprieties = returnape;
    		runChartAtivdadePorStatus();
	}


	function runChartAtivdadePorStatus(){


		var chart = AmCharts.makeChart("chartAtividadePorStatus", {
		    "theme": "light",
		    "type": "serial",
		    "dataProvider": proprieties,
		    "valueAxes": [{
		        "stackType": "3d",
		        "position": "left",
		        "title": "Número de Atividades",
		    }],
		    "startDuration": 1,
		    "graphs": [{
		        "balloonText": "[[category]] : <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "fillColorsField": "cor",
		        "title": "Atividade",
		        "type": "column",
		        "valueField": "atividade"
		    }, {
		        "balloonText": "[[category]] : <b>[[value]]</b>",
		        "fillAlphas": 0.9,
		        "lineAlpha": 0.2,
		        "title": "2005",
		        "type": "column",
		        "valueField": "year2005"
		    }],
		    "plotAreaFillAlphas": 0.1,
		    "depth3D": 60,
		    "angle": 30,
		    "title": "situacao",
		    "categoryField": "situacao",
		    "categoryAxis": {
		        "gridPosition": "start"
		    },
		    "export": {
		    	"enabled": true
		     }
		});
		jQuery('.chart-input').off().on('input change',function() {
			var property	= jQuery(this).data('property');
			var target		= chart;
			chart.startDuration = 0;

			if ( property == 'topRadius') {
				target = chart.graphs[0];
		      	if ( this.value == 0 ) {
		          this.value = undefined;
		      	}
			}

			target[property] = this.value;
			chart.validateNow();
		});




	}
}
