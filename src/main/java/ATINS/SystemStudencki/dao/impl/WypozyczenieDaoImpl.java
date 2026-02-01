package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.WypozyczenieDao;
import ATINS.SystemStudencki.model.Wypozyczenie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu WypozyczenieDao.
 * Zapewnia operacje bazodanowe związane z wypożyczeniami książek w bibliotece.
 */
@Transactional
public class WypozyczenieDaoImpl implements WypozyczenieDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Wypozyczenie pobierzPoId(Integer id) {
		return entityManager.find(Wypozyczenie.class, id);
	}

	@Override
	public List<Wypozyczenie> pobierzWszystkie() {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w ORDER BY w.dataWypozyczenia DESC",
			Wypozyczenie.class
		);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzWypozyczeniaStudenta(Integer studentId) {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.student.idStudent = :studentId ORDER BY w.dataWypozyczenia DESC",
			Wypozyczenie.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzAktywneWypozyczeniaStudenta(
		Integer studentId
	) {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.student.idStudent = :studentId AND w.dataOddania IS NULL " +
				"ORDER BY w.dataWypozyczenia DESC",
			Wypozyczenie.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzWypozyczeniaKsiazki(Integer ksiazkaId) {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.ksiazka.idKsiazka = :ksiazkaId ORDER BY w.dataWypozyczenia DESC",
			Wypozyczenie.class
		);
		query.setParameter("ksiazkaId", ksiazkaId);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzPrzeterminowaneWypozyczenia() {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.dataOddania IS NULL AND w.terminZwrotu < CURRENT_DATE " +
				"ORDER BY w.terminZwrotu",
			Wypozyczenie.class
		);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzPrzeterminowaneWypozyczeniaStudenta(
		Integer studentId
	) {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.student.idStudent = :studentId " +
				"AND w.dataOddania IS NULL AND w.terminZwrotu < CURRENT_DATE ORDER BY w.terminZwrotu",
			Wypozyczenie.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<Wypozyczenie> pobierzWypozyczeniaPoStatusie(String status) {
		TypedQuery<Wypozyczenie> query = entityManager.createQuery(
			"SELECT w FROM Wypozyczenie w WHERE w.status = :status ORDER BY w.dataWypozyczenia DESC",
			Wypozyczenie.class
		);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public boolean czyStudentMaWypozyczonaKsiazke(
		Integer studentId,
		Integer ksiazkaId
	) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(w) FROM Wypozyczenie w WHERE w.student.idStudent = :studentId " +
				"AND w.ksiazka.idKsiazka = :ksiazkaId AND w.dataOddania IS NULL",
			Long.class
		);
		query.setParameter("studentId", studentId);
		query.setParameter("ksiazkaId", ksiazkaId);
		return query.getSingleResult() > 0;
	}

	@Override
	public Long policzAktywneWypozyczeniaStudenta(Integer studentId) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(w) FROM Wypozyczenie w WHERE w.student.idStudent = :studentId AND w.dataOddania IS NULL",
			Long.class
		);
		query.setParameter("studentId", studentId);
		return query.getSingleResult();
	}

	@Override
	public void zapisz(Wypozyczenie wypozyczenie) {
		entityManager.persist(wypozyczenie);
	}

	@Override
	public Wypozyczenie aktualizuj(Wypozyczenie wypozyczenie) {
		return entityManager.merge(wypozyczenie);
	}

	@Override
	public void usun(Wypozyczenie wypozyczenie) {
		Wypozyczenie managed = entityManager.contains(wypozyczenie)
			? wypozyczenie
			: entityManager.merge(wypozyczenie);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		Wypozyczenie wypozyczenie = pobierzPoId(id);
		if (wypozyczenie != null) {
			entityManager.remove(wypozyczenie);
		}
	}
}
