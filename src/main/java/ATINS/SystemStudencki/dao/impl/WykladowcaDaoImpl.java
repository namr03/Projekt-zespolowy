package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.WykladowcaDao;
import ATINS.SystemStudencki.model.Wykladowca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu WykladowcaDao.
 * Zapewnia operacje dostępu do danych wykładowców.
 */
@Transactional
public class WykladowcaDaoImpl implements WykladowcaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Wykladowca pobierzPoId(Integer id) {
		return entityManager.find(Wykladowca.class, id);
	}

	@Override
	public Wykladowca pobierzPoLoginie(String login) {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w WHERE w.login = :login",
			Wykladowca.class
		);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Wykladowca pobierzPoEmail(String email) {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w WHERE w.email = :email",
			Wykladowca.class
		);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Wykladowca> pobierzWszystkich() {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w ORDER BY w.nazwisko, w.imie",
			Wykladowca.class
		);
		return query.getResultList();
	}

	@Override
	public List<Wykladowca> wyszukajPoNazwisku(String nazwisko) {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w WHERE LOWER(w.nazwisko) LIKE LOWER(:nazwisko) ORDER BY w.nazwisko, w.imie",
			Wykladowca.class
		);
		query.setParameter("nazwisko", "%" + nazwisko + "%");
		return query.getResultList();
	}

	@Override
	public List<Wykladowca> pobierzPoTytuleNaukowym(String tytulNaukowy) {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w WHERE w.tytulNaukowy = :tytulNaukowy ORDER BY w.nazwisko, w.imie",
			Wykladowca.class
		);
		query.setParameter("tytulNaukowy", tytulNaukowy);
		return query.getResultList();
	}

	@Override
	public Wykladowca uwierzytelnij(String login, String haslo) {
		TypedQuery<Wykladowca> query = entityManager.createQuery(
			"SELECT w FROM Wykladowca w WHERE w.login = :login AND w.haslo = :haslo",
			Wykladowca.class
		);
		query.setParameter("login", login);
		query.setParameter("haslo", haslo);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void zapisz(Wykladowca wykladowca) {
		entityManager.persist(wykladowca);
	}

	@Override
	public Wykladowca aktualizuj(Wykladowca wykladowca) {
		return entityManager.merge(wykladowca);
	}

	@Override
	public void usun(Wykladowca wykladowca) {
		Wykladowca managed = entityManager.contains(wykladowca)
			? wykladowca
			: entityManager.merge(wykladowca);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Wykladowca wykladowca = pobierzPoId(id);
		if (wykladowca != null) {
			entityManager.remove(wykladowca);
		}
	}

	@Override
	public boolean czyIstniejeLogin(String login) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(w) FROM Wykladowca w WHERE w.login = :login",
			Long.class
		);
		query.setParameter("login", login);
		return query.getSingleResult() > 0;
	}

	@Override
	public boolean czyIstniejeEmail(String email) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(w) FROM Wykladowca w WHERE w.email = :email",
			Long.class
		);
		query.setParameter("email", email);
		return query.getSingleResult() > 0;
	}

	@Override
	public long zliczWszystkich() {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(w) FROM Wykladowca w",
			Long.class
		);
		return query.getSingleResult();
	}
}
