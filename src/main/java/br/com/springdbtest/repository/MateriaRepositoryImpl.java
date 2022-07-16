package br.com.springdbtest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.springdbtest.model.Materia;

public class MateriaRepositoryImpl implements MateriaRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Materia> listarMateriasJPQL() {
		TypedQuery<Materia> query = entityManager.createQuery("select m from Materia m", Materia.class);
		return query.getResultList();
	}
	
	@Override
	public List<Materia> listarMateriasJoinCursoJPQL() {
		TypedQuery<Materia> query = entityManager.createQuery("select m from Materia m join fetch m.curso c", Materia.class);
		return query.getResultList();
	}

	@Override
	public List<Materia> listarMateriasJoinCursoJoinCategoriaJPQL() {
		TypedQuery<Materia> query = entityManager.createQuery("select m from Materia m join fetch m.curso c join fetch c.categoria", Materia.class);
		return query.getResultList();
	}

	@Override
	public List<Materia> listarMateriasCriteria() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Materia> criteriaQuery = builder.createQuery(Materia.class);
		Root<Materia> root = criteriaQuery.from(Materia.class);
		
		criteriaQuery.select(root);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	@Override
	public List<Materia> listarMateriasJoinCursoCriteria() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Materia> criteriaQuery = builder.createQuery(Materia.class);
		Root<Materia> root = criteriaQuery.from(Materia.class);
		root.fetch("curso");
		
		criteriaQuery.select(root);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	@Override
	public List<Materia> listarMateriasJoinCursoJoinCategoriaCriteria() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Materia> criteriaQuery = builder.createQuery(Materia.class);
		Root<Materia> root = criteriaQuery.from(Materia.class);
		root.fetch("curso").fetch("categoria");
		
		criteriaQuery.select(root);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
