package br.com.springdbtest.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import br.com.springdbtest.model.Categoria;
import br.com.springdbtest.model.Curso;
import br.com.springdbtest.model.Materia;
import br.com.springdbtest.repository.MateriaRepository;

@Import(QuickPerfSqlConfig.class)
@DataJpaTest
public class MateriaRepositoryIntegrationTest {
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@ExpectSelect(4)
	@Test
	public void listarMateria() {
		List<Materia> listaMaterias = materiaRepository.findAll();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(1)
	@Test
	public void obterMateria() {
		Optional<Materia> optMateria = materiaRepository.findById(1L);
		Materia materia = optMateria.orElseThrow();
		assertEquals("Classes", materia.getNome());
	}

	@ExpectSelect(4)
	@Test
	public void listarMateriaJPQL() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasJPQL();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(4)
	@Test
	public void listarMateriaJoinCursoJPQL() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasJoinCursoJPQL();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(1)
	@Test
	public void listarMateriasJoinCursoJoinCategoriaJPQL() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasJoinCursoJoinCategoriaJPQL();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(4)
	@Test
	public void listarMateriasCriteria() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasCriteria();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(4)
	@Test
	public void listarMateriasJoinCursoCriteria() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasJoinCursoCriteria();
		assertEquals(3, listaMaterias.size());
	}
	
	@ExpectSelect(1)
	@Test
	public void listarMateriasJoinCursoJoinCategoriaCriteria() {
		List<Materia> listaMaterias = materiaRepository.listarMateriasJoinCursoJoinCategoriaCriteria();
		assertEquals(3, listaMaterias.size());
	}
	

	@ExpectSelect(2)
	@Test
	public void listarEntityGraphMateriaCurso() {
		List<Materia> listaMaterias = materiaRepository.listarEntityGraphMateriaCurso();
		Curso curso = listaMaterias.stream().filter(materia -> "Classes".equals(materia.getNome())).findFirst().get().getCurso();
		Categoria categoria = curso.getCategoria();
		assertEquals("Computacao", categoria.getNome());
	}
	
	@ExpectSelect(1)
	@Test
	public void listarEntityGraphMateriaCursoCategoria() {
		List<Materia> listaMaterias = materiaRepository.listarEntityGraphMateriaCursoCategoria();
		Curso curso = listaMaterias.stream().filter(materia -> "Classes".equals(materia.getNome())).findFirst().get().getCurso();
		Categoria categoria = curso.getCategoria();
		assertEquals("Computacao", categoria.getNome());
	}
	
}
