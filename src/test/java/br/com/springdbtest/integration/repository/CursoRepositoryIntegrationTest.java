package br.com.springdbtest.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import br.com.springdbtest.model.Curso;
import br.com.springdbtest.repository.CursoRepository;

@Import(QuickPerfSqlConfig.class)
@DataJpaTest
public class CursoRepositoryIntegrationTest {
	
	@Autowired
	private CursoRepository cursoRepositoryTest;
	
	@ExpectSelect(4)
	@Test
	public void listarCursos() {
		List<Curso> listaCursos = cursoRepositoryTest.findAll();
		assertEquals(3, listaCursos.size());
	}
	
}
