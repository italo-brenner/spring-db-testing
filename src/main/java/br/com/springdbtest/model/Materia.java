package br.com.springdbtest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_mat_materia")
public class Materia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id")
	private Long id;
	
	@Column(name="mat_nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="cur_id")
	private Curso curso;
	
}
