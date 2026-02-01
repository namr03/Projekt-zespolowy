package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.SylabusDao;
import ATINS.SystemStudencki.model.Sylabus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu SylabusDao.
 * Zapewnia operacje dostępu do danych sylabusów przedmiotów.
 */
@Transactional
public class SylabusDaoImpl implements SylabusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Sylabus pobierzPoId(Integer id) {
		return entityManager.find(Sylabus.class, id);
	}

	@Override
	public List<Sylabus> pobierzWszystkie() {
		TypedQuery<Sylabus> query = entityManager.createQuery(
			"SELECT s FROM Sylabus s ORDER BY s.nazwa",
			Sylabus.class
		);
		return query.getResultList();
	}

	@Override
	public List<Sylabus> pobierzSylabusPrzedmiotu(Integer przedmiotId) {
		TypedQuery<Sylabus> query = entityManager.createQuery(
			"SELECT s FROM Sylabus s WHERE s.przedmiot.idPrzedmiot = :przedmiotId ORDER BY s.nazwa",
			Sylabus.class
		);
		query.setParameter("przedmiotId", przedmiotId);
		return query.getResultList();
	}

	@Override
	public Sylabus pobierzPoNazwie(String nazwa) {
		TypedQuery<Sylabus> query = entityManager.createQuery(
			"SELECT s FROM Sylabus s WHERE s.nazwa = :nazwa",
			Sylabus.class
		);
		query.setParameter("nazwa", nazwa);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Sylabus> wyszukajPoTresci(String fragmentTresci) {
		TypedQuery<Sylabus> query = entityManager.createQuery(
			"SELECT s FROM Sylabus s WHERE LOWER(s.tresc) LIKE LOWER(:fragment) ORDER BY s.nazwa",
			Sylabus.class
		);
		query.setParameter("fragment", "%" + fragmentTresci + "%");
		return query.getResultList();
	}

	@Override
	public void zapisz(Sylabus sylabus) {
		entityManager.persist(sylabus);
	}

	@Override
	public Sylabus aktualizuj(Sylabus sylabus) {
		return entityManager.merge(sylabus);
	}

	@Override
	public void usun(Sylabus sylabus) {
		Sylabus managed = entityManager.contains(sylabus)
			? sylabus
			: entityManager.merge(sylabus);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Sylabus sylabus = pobierzPoId(id);
		if (sylabus != null) {
			entityManager.remove(sylabus);
		}
	}
}
