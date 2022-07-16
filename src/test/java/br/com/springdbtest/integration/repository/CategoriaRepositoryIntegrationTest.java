package br.com.springdbtest.integration.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.quickperf.spring.sql.QuickPerfSqlConfig;
import org.quickperf.sql.annotation.ExpectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import br.com.springdbtest.model.Categoria;
import br.com.springdbtest.repository.CategoriaRepository;

@Import(QuickPerfSqlConfig.class)
@DataJpaTest
public class CategoriaRepositoryIntegrationTest {
	
	@Autowired
	private CategoriaRepository categoriaRepositoryTest;
	
	@ExpectSelect(1)
	@Test
	public void listarCategoria() {
		List<Categoria> listaCategoria = categoriaRepositoryTest.findAll();
		assertEquals(3, listaCategoria.size());
	}

}
