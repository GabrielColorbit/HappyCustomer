package br.edu.facear.crm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Situacao {
	Aberto, Cancelado, Paralisado, Finalizado
}