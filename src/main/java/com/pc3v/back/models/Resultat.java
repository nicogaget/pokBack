package com.pc3v.back.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="resultats")
@Table(name="resultats")
public class Resultat {
	private Rencontre rencontre;
	private User user;
	private int position;
}
