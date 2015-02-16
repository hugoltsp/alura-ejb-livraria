package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {

	@Inject
	private AutorDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salva(Autor autor) {
		this.dao.salva(autor);
		throw new RuntimeException();
	}

	public List<Autor> todosAutores() {
		return this.dao.todosAutores();
	}

	public Autor buscaPelaId(final Integer autorId) {
		return this.dao.buscaPelaId(autorId);
	}
}