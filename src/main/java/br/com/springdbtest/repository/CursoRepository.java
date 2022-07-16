package br.com.springdbtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springdbtest.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
