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
@Table(name="tb_cur_curso")
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cur_id")
	private Long id;
	
	@Column(name="cur_nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categoria categoria;
	
}
