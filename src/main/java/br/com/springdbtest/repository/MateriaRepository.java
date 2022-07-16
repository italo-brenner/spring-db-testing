package br.com.springdbtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springdbtest.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>, MateriaRepositoryCustom {
	
	@EntityGraph(attributePaths = {"curso"})
	@Query("select m from Materia m")
	public List<Materia> listarEntityGraphMateriaCurso();
	
	@EntityGraph(attributePaths = {"curso.categoria"})
	@Query("select m from Materia m")
	public List<Materia> listarEntityGraphMateriaCursoCategoria();

}
