package com.pc3v.back.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="resultats")
@Table(name="resultats")
public class Resultat {
	private Rencontre rencontre;
	private User user;
	private int position;
}
