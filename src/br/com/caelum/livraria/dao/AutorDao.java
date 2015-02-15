package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {

	@Inject
	private Banco banco;
	
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
		banco.save(autor);
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
