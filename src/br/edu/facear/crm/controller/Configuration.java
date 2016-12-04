package br.edu.facear.crm.controller;

public class Configuration {
	public String returnMonth(int m){
		String mes = "mes não identificado";
		if(m == 1){
			mes = "Janeiro";
		}else if(m == 2){
			mes = "Fevereiro";
		}else if(m == 3){
			mes = "Março";
		}else if(m == 4){
			mes = "Abril";
		}else if(m == 5){
			mes = "Maio";
		}else if(m == 6){
			mes = "Junho";
		}else if(m == 7){
			mes = "Julho";
		}else if(m == 8){
			mes = "Agosto";
		}else if(m == 9){
			mes = "Setembro";
		}else if(m == 10){
			mes = "Outubro";
		}else if(m == 11){
			mes = "Novembro";
		}
		else if(m == 12){
			mes = "Dezembro";
		}
		return mes;
	}
}
