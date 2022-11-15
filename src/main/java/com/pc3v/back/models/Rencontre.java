package com.pc3v.back.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name="rencontres")
@Table(name="rencontres")
public class Rencontre {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private Long id;
	 private Competition competition;
	 private Date date;
	 private int nbrInscription;
	 
}
