package com.pc3v.back.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="rencontres")
@Table(name="rencontres")
public class Rencontre {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	 private Long id;
	 private Competition competition;
	 private Date date;
	 private Set<User> joueursInscrits=new HashSet<>();
	 private Resultat resultat;
	 
}
