package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.PrzedmiotDao;
import ATINS.SystemStudencki.model.Przedmiot;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu PrzedmiotDao.
 * Zapewnia dostęp do danych przedmiotów poprzez EntityManager.
 */
@Transactional
public class PrzedmiotDaoImpl implements PrzedmiotDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Przedmiot pobierzPoId(Integer id) {
		return entityManager.find(Przedmiot.class, id);
	}

	@Override
	public List<Przedmiot> pobierzWszystkie() {
		TypedQuery<Przedmiot> query = entityManager.createQuery(
			"SELECT p FROM Przedmiot p ORDER BY p.nazwa",
			Przedmiot.class
		);
		return query.getResultList();
	}

	@Override
	public List<Przedmiot> pobierzPrzedmiotyWSemestrze(String semestr) {
		TypedQuery<Przedmiot> query = entityManager.createQuery(
			"SELECT p FROM Przedmiot p WHERE p.semestr = :semestr ORDER BY p.nazwa",
			Przedmiot.class
		);
		query.setParameter("semestr", semestr);
		return query.getResultList();
	}

	@Override
	public List<Przedmiot> pobierzDostepnePrzedmioty() {
		TypedQuery<Przedmiot> query = entityManager.createQuery(
			"SELECT p FROM Przedmiot p WHERE p.limitMiejsc IS NULL OR " +
				"(SELECT COUNT(z) FROM Zapis z WHERE z.przedmiot = p AND z.status = 'AKTYWNY') < p.limitMiejsc " +
				"ORDER BY p.nazwa",
			Przedmiot.class
		);
		return query.getResultList();
	}

	@Override
	public Przedmiot pobierzPoNazwie(String nazwa) {
		try {
			TypedQuery<Przedmiot> query = entityManager.createQuery(
				"SELECT p FROM Przedmiot p WHERE p.nazwa = :nazwa",
				Przedmiot.class
			);
			query.setParameter("nazwa", nazwa);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Przedmiot> wyszukajPoNazwie(String fragmentNazwy) {
		TypedQuery<Przedmiot> query = entityManager.createQuery(
			"SELECT p FROM Przedmiot p WHERE LOWER(p.nazwa) LIKE LOWER(:fragment) ORDER BY p.nazwa",
			Przedmiot.class
		);
		query.setParameter("fragment", "%" + fragmentNazwy + "%");
		return query.getResultList();
	}

	@Override
	public Long pobierzLiczbeZapisanychStudentow(Integer idPrzedmiot) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(z) FROM Zapis z WHERE z.przedmiot.idPrzedmiot = :idPrzedmiot AND z.status = 'AKTYWNY'",
			Long.class
		);
		query.setParameter("idPrzedmiot", idPrzedmiot);
		return query.getSingleResult();
	}

	@Override
	public void zapisz(Przedmiot przedmiot) {
		entityManager.persist(przedmiot);
	}

	@Override
	public Przedmiot aktualizuj(Przedmiot przedmiot) {
		return entityManager.merge(przedmiot);
	}

	@Override
	public void usun(Przedmiot przedmiot) {
		Przedmiot managed = entityManager.contains(przedmiot)
			? przedmiot
			: entityManager.merge(przedmiot);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Przedmiot przedmiot = pobierzPoId(id);
		if (przedmiot != null) {
			entityManager.remove(przedmiot);
		}
	}
}
