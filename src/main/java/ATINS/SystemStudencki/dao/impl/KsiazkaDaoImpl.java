package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.KsiazkaDao;
import ATINS.SystemStudencki.model.Ksiazka;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu KsiazkaDao.
 * Zapewnia operacje dostępu do danych książek w systemie bibliotecznym.
 */
@Transactional
public class KsiazkaDaoImpl implements KsiazkaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ksiazka pobierzPoId(Integer id) {
		return entityManager.find(Ksiazka.class, id);
	}

	@Override
	public List<Ksiazka> pobierzWszystkie() {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k ORDER BY k.tytul",
			Ksiazka.class
		);
		return query.getResultList();
	}

	@Override
	public List<Ksiazka> pobierzDostepneKsiazki() {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k WHERE k.dostepna = true AND k.ilosc > 0 ORDER BY k.tytul",
			Ksiazka.class
		);
		return query.getResultList();
	}

	@Override
	public Ksiazka pobierzPoIsbn(String isbn) {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k WHERE k.isbn = :isbn",
			Ksiazka.class
		);
		query.setParameter("isbn", isbn);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Ksiazka> wyszukajPoTytule(String tytul) {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k WHERE LOWER(k.tytul) LIKE LOWER(:tytul) ORDER BY k.tytul",
			Ksiazka.class
		);
		query.setParameter("tytul", "%" + tytul + "%");
		return query.getResultList();
	}

	@Override
	public List<Ksiazka> wyszukajPoAutorze(String autor) {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k WHERE LOWER(k.autor) LIKE LOWER(:autor) ORDER BY k.autor, k.tytul",
			Ksiazka.class
		);
		query.setParameter("autor", "%" + autor + "%");
		return query.getResultList();
	}

	@Override
	public List<Ksiazka> pobierzNiedostepneKsiazki() {
		TypedQuery<Ksiazka> query = entityManager.createQuery(
			"SELECT k FROM Ksiazka k WHERE k.dostepna = false OR k.ilosc = 0 ORDER BY k.tytul",
			Ksiazka.class
		);
		return query.getResultList();
	}

	@Override
	public void zapisz(Ksiazka ksiazka) {
		entityManager.persist(ksiazka);
	}

	@Override
	public Ksiazka aktualizuj(Ksiazka ksiazka) {
		return entityManager.merge(ksiazka);
	}

	@Override
	public void usun(Ksiazka ksiazka) {
		Ksiazka managed = entityManager.contains(ksiazka)
			? ksiazka
			: entityManager.merge(ksiazka);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Ksiazka ksiazka = pobierzPoId(id);
		if (ksiazka != null) {
			entityManager.remove(ksiazka);
		}
	}

	@Override
	public void zmniejszIlosc(Integer id) {
		Ksiazka ksiazka = pobierzPoId(id);
		if (
			ksiazka != null &&
			ksiazka.getIlosc() != null &&
			ksiazka.getIlosc() > 0
		) {
			ksiazka.setIlosc(ksiazka.getIlosc() - 1);
			if (ksiazka.getIlosc() == 0) {
				ksiazka.setDostepna(false);
			}
			entityManager.merge(ksiazka);
		}
	}

	@Override
	public void zwiekszIlosc(Integer id) {
		Ksiazka ksiazka = pobierzPoId(id);
		if (ksiazka != null) {
			Integer nowaIlosc =
				(ksiazka.getIlosc() != null ? ksiazka.getIlosc() : 0) + 1;
			ksiazka.setIlosc(nowaIlosc);
			ksiazka.setDostepna(true);
			entityManager.merge(ksiazka);
		}
	}

	@Override
	public long zliczWszystkie() {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(k) FROM Ksiazka k",
			Long.class
		);
		return query.getSingleResult();
	}
}
