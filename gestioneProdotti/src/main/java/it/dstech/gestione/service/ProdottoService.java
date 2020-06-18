package it.dstech.gestione.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.gestione.model.Prodotto;
import it.dstech.gestione.repository.ProdottoRepository;

@Service
@Transactional
public class ProdottoService {
	@Autowired
	ProdottoRepository repo;

	public void save(Prodotto prodotto) {
		repo.save(prodotto);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Prodotto get(Long id) {
		return repo.findById(id).get();
	}
	public List<Prodotto> listAll(){
		return (List<Prodotto>) repo.findAll();
	}
}
