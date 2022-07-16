package br.com.springdbtest.repository;

import java.util.List;

import br.com.springdbtest.model.Materia;

public interface MateriaRepositoryCustom {
	
	public List<Materia> listarMateriasJPQL();
	public List<Materia> listarMateriasJoinCursoJPQL();
	public List<Materia> listarMateriasJoinCursoJoinCategoriaJPQL();
	
	public List<Materia> listarMateriasCriteria();
	public List<Materia> listarMateriasJoinCursoCriteria();
	public List<Materia> listarMateriasJoinCursoJoinCategoriaCriteria();

}
