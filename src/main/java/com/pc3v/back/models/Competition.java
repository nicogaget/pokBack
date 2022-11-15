package com.pc3v.back.models;

 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="competitons")
@Table(name="competitions")
public class Competition {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private Long id;
	 
	 private String titre;
	 private ETypeCompetition competition;
	 private Date dateDebut;
	 private Date dateFin;
	 private int nbreDeManche;
	 
	 
}
