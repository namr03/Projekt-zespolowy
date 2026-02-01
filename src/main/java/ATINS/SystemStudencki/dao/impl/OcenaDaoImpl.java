package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.OcenaDao;
import ATINS.SystemStudencki.model.Ocena;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu OcenaDao.
 * Zapewnia operacje bazodanowe związane z ocenami studentów.
 */
@Transactional
public class OcenaDaoImpl implements OcenaDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Ocena pobierzPoId(Integer id) {
		return entityManager.find(Ocena.class, id);
	}

	@Override
	public List<Ocena> pobierzWszystkie() {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		return query.getResultList();
	}

	@Override
	public List<Ocena> pobierzOcenyDlaZapisu(Integer zapisId) {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o WHERE o.zapis.idZapis = :zapisId ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		query.setParameter("zapisId", zapisId);
		return query.getResultList();
	}

	@Override
	public List<Ocena> pobierzOcenyStudenta(Integer studentId) {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o WHERE o.zapis.student.idStudent = :studentId ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Ocena> pobierzOcenyStudentaZPrzedmiotu(
		Integer studentId,
		Integer przedmiotId
	) {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o WHERE o.zapis.student.idStudent = :studentId " +
				"AND o.zapis.przedmiot.idPrzedmiot = :przedmiotId ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		query.setParameter("studentId", studentId);
		query.setParameter("przedmiotId", przedmiotId);
		return query.getResultList();
	}

	@Override
	public List<Ocena> pobierzOcenyWedlugKategorii(
		Integer zapisId,
		String kategoria
	) {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o WHERE o.zapis.idZapis = :zapisId AND o.kategoria = :kategoria " +
				"ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		query.setParameter("zapisId", zapisId);
		query.setParameter("kategoria", kategoria);
		return query.getResultList();
	}

	@Override
	public Ocena pobierzOstatniaOcene(Integer zapisId) {
		TypedQuery<Ocena> query = entityManager.createQuery(
			"SELECT o FROM Ocena o WHERE o.zapis.idZapis = :zapisId ORDER BY o.dataWystawienia DESC",
			Ocena.class
		);
		query.setParameter("zapisId", zapisId);
		query.setMaxResults(1);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void zapisz(Ocena ocena) {
		entityManager.persist(ocena);
	}

	@Override
	public Ocena aktualizuj(Ocena ocena) {
		return entityManager.merge(ocena);
	}

	@Override
	public void usun(Ocena ocena) {
		Ocena managed = entityManager.contains(ocena)
			? ocena
			: entityManager.merge(ocena);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Ocena ocena = pobierzPoId(id);
		if (ocena != null) {
			entityManager.remove(ocena);
		}
	}

	@Override
	public Double obliczSredniaOcenZapisu(Integer zapisId) {
		TypedQuery<Double> query = entityManager.createQuery(
			"SELECT AVG(o.wartosc) FROM Ocena o WHERE o.zapis.idZapis = :zapisId AND o.wartosc IS NOT NULL",
			Double.class
		);
		query.setParameter("zapisId", zapisId);
		return query.getSingleResult();
	}

	@Override
	public Double obliczSredniaOcenStudenta(Integer studentId) {
		TypedQuery<Double> query = entityManager.createQuery(
			"SELECT AVG(o.wartosc) FROM Ocena o WHERE o.zapis.student.idStudent = :studentId AND o.wartosc IS NOT NULL",
			Double.class
		);
		query.setParameter("studentId", studentId);
		return query.getSingleResult();
	}
}
