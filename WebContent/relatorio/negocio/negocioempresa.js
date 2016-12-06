function callChartNegocioEmpresa(){

	window.location.href=window.location.href;

	var proprieties;
	$.getJSON('http://localhost:8080/CRM/rest/restRelatorio/NegocioPorEmpresa/', callbackRestJson);
	function callbackRestJson(data) {
    		var returnape = data;
    		proprieties = returnape;
				runChartNegocioPorEmresa();
	}


	function runChartNegocioPorEmresa(){

		var chart = AmCharts.makeChart("chartNegocioPorEmpresa",
		{
		    "type": "serial",
		    "theme": "light",
		     "marginTop": 70,
		    "dataProvider":proprieties ,
		    "valueAxes": [{
		      
		        "axisAlpha": 0,
		        "dashLength": 4,
		        "position": "left"
		    }],
		    "startDuration": 1,
		    "graphs": [{
		        "balloonText": "<span style='font-size:13px;'>[[category]]: <b>[[value]]</b></span>",
		        "bulletOffset": 10,
		        "bulletSize": 52,
		        "cornerRadiusTop": 8,
		        "customBulletField": "foto",
		        "fillAlphas": 0.8,
		        "lineAlpha": 0,
		        "type": "column",
		        "valueField": "negocios"
		    }],
		    "categoryField": "empresa",
		    "categoryAxis": {
		        "axisAlpha": 0,
		        "gridAlpha": 0,
		        "inside": true,
		        "tickLength": 0
		    },
		    "valueScrollbar": {
		        "autoGridCount":true
		    },
		    "chartCursor": {
		        "cursorColor":"#85C5E3",
		        "valueBalloonsEnabled": false,
		        "cursorAlpha": 0,
		        "valueLineAlpha":0.5,
		        "valueLineBalloonEnabled": true,
		        "valueLineEnabled": true,
		        "zoomable":true,
		        "valueZoomable":true
		    },
		    "export": {
		    	"enabled": true
		     }
		});

	}


}
