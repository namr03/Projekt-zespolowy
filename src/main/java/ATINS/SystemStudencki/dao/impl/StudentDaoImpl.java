package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.StudentDao;
import ATINS.SystemStudencki.model.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu StudentDao.
 * Zapewnia operacje CRUD oraz metody wyszukiwania dla encji Student.
 */
@Transactional
public class StudentDaoImpl implements StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student pobierzPoId(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public Student pobierzPoNumerzeIndeksu(String nrIndeksu) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE s.nrIndeksu = :nrIndeksu",
			Student.class
		);
		query.setParameter("nrIndeksu", nrIndeksu);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Student pobierzPoLoginie(String login) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE s.login = :login",
			Student.class
		);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Student pobierzPoEmail(String email) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE s.email = :email",
			Student.class
		);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Student> pobierzWszystkich() {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s ORDER BY s.nazwisko, s.imie",
			Student.class
		);
		return query.getResultList();
	}

	@Override
	public List<Student> pobierzPoRokuStudiow(Integer rokStudiow) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE s.rokStudiow = :rokStudiow ORDER BY s.nazwisko, s.imie",
			Student.class
		);
		query.setParameter("rokStudiow", rokStudiow);
		return query.getResultList();
	}

	@Override
	public List<Student> wyszukajPoNazwisku(String nazwisko) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE LOWER(s.nazwisko) LIKE LOWER(:nazwisko) ORDER BY s.nazwisko, s.imie",
			Student.class
		);
		query.setParameter("nazwisko", "%" + nazwisko + "%");
		return query.getResultList();
	}

	@Override
	public Student uwierzytelnij(String login, String haslo) {
		TypedQuery<Student> query = entityManager.createQuery(
			"SELECT s FROM Student s WHERE s.login = :login AND s.haslo = :haslo",
			Student.class
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
	public void zapisz(Student student) {
		entityManager.persist(student);
	}

	@Override
	public Student aktualizuj(Student student) {
		return entityManager.merge(student);
	}

	@Override
	public void usun(Student student) {
		if (entityManager.contains(student)) {
			entityManager.remove(student);
		} else {
			Student attached = entityManager.find(
				Student.class,
				student.getIdStudent()
			);
			if (attached != null) {
				entityManager.remove(attached);
			}
		}
	}

	@Override
	public void usunPoId(Integer id) {
		Student student = pobierzPoId(id);
		if (student != null) {
			entityManager.remove(student);
		}
	}

	@Override
	public boolean czyIstniejeNrIndeksu(String nrIndeksu) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(s) FROM Student s WHERE s.nrIndeksu = :nrIndeksu",
			Long.class
		);
		query.setParameter("nrIndeksu", nrIndeksu);
		return query.getSingleResult() > 0;
	}

	@Override
	public boolean czyIstniejeLogin(String login) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(s) FROM Student s WHERE s.login = :login",
			Long.class
		);
		query.setParameter("login", login);
		return query.getSingleResult() > 0;
	}

	@Override
	public boolean czyIstniejeEmail(String email) {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(s) FROM Student s WHERE s.email = :email",
			Long.class
		);
		query.setParameter("email", email);
		return query.getSingleResult() > 0;
	}

	@Override
	public long zliczWszystkich() {
		TypedQuery<Long> query = entityManager.createQuery(
			"SELECT COUNT(s) FROM Student s",
			Long.class
		);
		return query.getSingleResult();
	}
}
