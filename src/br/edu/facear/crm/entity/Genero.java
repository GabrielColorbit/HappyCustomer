package br.edu.facear.crm.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Genero implements Serializable{
	masculino, feminino;	 
}