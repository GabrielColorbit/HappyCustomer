package br.edu.facear.crm.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Situacao {
	aberto, cancelado, paralisado, finalizado
}