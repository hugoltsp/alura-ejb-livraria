package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AutorDao {
 	
	@PersistenceContext
	private EntityManager entityManager;
	 	
	@PostConstruct
	void postConstruct(){
		System.out.println("--AutorDao criado");
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		this.entityManager.persist(autor);

	}
	
	public List<Autor> todosAutores() {
		return this.entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
 	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.entityManager.find(Autor.class, autorId);
		return autor;
	}
	
}