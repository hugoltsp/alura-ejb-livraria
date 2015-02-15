package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {
 	
	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	void postConstruct(){
		System.out.println("--AutorDao criado");
	}
	
	public void salva(Autor autor) {
		System.out.println("Salvando autor..." + autor.getNome());
		
//		try {
//			Thread.sleep(20000);
//		} catch (InterruptedException e) {
// 			e.printStackTrace();
//		}
		
		System.out.println("..Autor " +autor.getNome()+ " salvo");
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
