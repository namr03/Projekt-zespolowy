package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.PowiadomienieDao;
import ATINS.SystemStudencki.model.Powiadomienie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu PowiadomienieDao.
 * Zapewnia operacje bazodanowe związane z powiadomieniami studentów.
 */
@Transactional
public class PowiadomienieDaoImpl implements PowiadomienieDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Powiadomienie pobierzPoId(Integer id) {
		return entityManager.find(Powiadomienie.class, id);
	}

	@Override
	public List<Powiadomienie> pobierzWszystkie() {
		TypedQuery<Powiadomienie> query = entityManager.createQuery(
			"SELECT p FROM Powiadomienie p ORDER BY p.dataWyslania DESC",
			Powiadomienie.class
		);
		return query.getResultList();
	}

	@Override
	public List<Powiadomienie> pobierzPowiadomieniaStudenta(Integer studentId) {
		TypedQuery<Powiadomienie> query = entityManager.createQuery(
			"SELECT p FROM Powiadomienie p WHERE p.student.idStudent = :studentId ORDER BY p.dataWyslania DESC",
			Powiadomienie.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Powiadomienie> pobierzNajnowszePowiadomienia(
		Integer studentId,
		int limit
	) {
		TypedQuery<Powiadomienie> query = entityManager.createQuery(
			"SELECT p FROM Powiadomienie p WHERE p.student.idStudent = :studentId ORDER BY p.dataWyslania DESC",
			Powiadomienie.class
		);
		query.setParameter("studentId", studentId);
		query.setMaxResults(limit);
		return query.getResultList();
	}

	@Override
	public Long zliczPowiadomieniaStudenta(Integer studentId) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(p) FROM Powiadomienie p WHERE p.student.idStudent = :studentId",
			Long.class
		);
		query.setParameter("studentId", studentId);
		return query.getSingleResult();
	}

	@Override
	public void zapisz(Powiadomienie powiadomienie) {
		entityManager.persist(powiadomienie);
	}

	@Override
	public Powiadomienie aktualizuj(Powiadomienie powiadomienie) {
		return entityManager.merge(powiadomienie);
	}

	@Override
	public void usun(Powiadomienie powiadomienie) {
		Powiadomienie managed = entityManager.contains(powiadomienie)
			? powiadomienie
			: entityManager.merge(powiadomienie);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Powiadomienie powiadomienie = pobierzPoId(id);
		if (powiadomienie != null) {
			entityManager.remove(powiadomienie);
		}
	}

	@Override
	public void usunWszystkiePowiadomieniaStudenta(Integer studentId) {
		entityManager
			.createQuery(
				"DELETE FROM Powiadomienie p WHERE p.student.idStudent = :studentId"
			)
			.setParameter("studentId", studentId)
			.executeUpdate();
	}
}
