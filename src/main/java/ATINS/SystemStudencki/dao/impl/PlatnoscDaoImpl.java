package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.PlatnoscDao;
import ATINS.SystemStudencki.model.Platnosc;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu PlatnoscDao.
 * Zapewnia operacje bazodanowe związane z płatnościami studentów.
 */
@Transactional
public class PlatnoscDaoImpl implements PlatnoscDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Platnosc pobierzPoId(Integer id) {
		return entityManager.find(Platnosc.class, id);
	}

	@Override
	public List<Platnosc> pobierzWszystkie() {
		TypedQuery<Platnosc> query = entityManager.createQuery(
			"SELECT p FROM Platnosc p ORDER BY p.dataWplaty DESC",
			Platnosc.class
		);
		return query.getResultList();
	}

	@Override
	public List<Platnosc> pobierzWszystkiePlatnosciStudenta(Integer studentId) {
		TypedQuery<Platnosc> query = entityManager.createQuery(
			"SELECT p FROM Platnosc p WHERE p.student.idStudent = :studentId ORDER BY p.dataWplaty DESC",
			Platnosc.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Platnosc> pobierzZaleglePlatnosci(Integer studentId) {
		TypedQuery<Platnosc> query = entityManager.createQuery(
			"SELECT p FROM Platnosc p WHERE p.student.idStudent = :studentId AND p.status = 'NIEOPLACONA' ORDER BY p.dataWplaty",
			Platnosc.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Platnosc> pobierzOplaconePlatnosci(Integer studentId) {
		TypedQuery<Platnosc> query = entityManager.createQuery(
			"SELECT p FROM Platnosc p WHERE p.student.idStudent = :studentId AND p.status = 'OPLACONA' ORDER BY p.dataWplaty DESC",
			Platnosc.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Platnosc> pobierzPlatnosciPoStatusie(String status) {
		TypedQuery<Platnosc> query = entityManager.createQuery(
			"SELECT p FROM Platnosc p WHERE p.status = :status ORDER BY p.dataWplaty DESC",
			Platnosc.class
		);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public Double obliczSumeZaleglosci(Integer studentId) {
		TypedQuery<Double> query = entityManager.createQuery(
			"SELECT COALESCE(SUM(p.kwota), 0.0) FROM Platnosc p WHERE p.student.idStudent = :studentId AND p.status = 'NIEOPLACONA'",
			Double.class
		);
		query.setParameter("studentId", studentId);
		Double result = query.getSingleResult();
		return result != null ? result : 0.0;
	}

	@Override
	public void zapisz(Platnosc platnosc) {
		entityManager.persist(platnosc);
	}

	@Override
	public Platnosc aktualizuj(Platnosc platnosc) {
		return entityManager.merge(platnosc);
	}

	@Override
	public void usun(Platnosc platnosc) {
		Platnosc managed = entityManager.contains(platnosc)
			? platnosc
			: entityManager.merge(platnosc);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Platnosc platnosc = pobierzPoId(id);
		if (platnosc != null) {
			entityManager.remove(platnosc);
		}
	}
}
