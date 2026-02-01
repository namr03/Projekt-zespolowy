package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.PlanZajecDao;
import ATINS.SystemStudencki.model.PlanZajec;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementacja interfejsu PlanZajecDao.
 * Zapewnia operacje bazodanowe związane z planem zajęć.
 */
@Transactional
public class PlanZajecDaoImpl implements PlanZajecDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PlanZajec pobierzPoId(Integer id) {
		return entityManager.find(PlanZajec.class, id);
	}

	@Override
	public List<PlanZajec> pobierzWszystkie() {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p ORDER BY p.dzienTygodnia, p.godzinaStart",
			PlanZajec.class
		);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzPlanDlaPrzedmiotu(Integer przedmiotId) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p WHERE p.przedmiot.idPrzedmiot = :przedmiotId " +
				"ORDER BY p.dzienTygodnia, p.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("przedmiotId", przedmiotId);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzPlanDlaWykladowcy(Integer wykladowcaId) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p WHERE p.wykladowca.idWykladowca = :wykladowcaId " +
				"ORDER BY p.dzienTygodnia, p.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("wykladowcaId", wykladowcaId);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzPlanDlaDnia(String dzienTygodnia) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p WHERE p.dzienTygodnia = :dzienTygodnia ORDER BY p.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("dzienTygodnia", dzienTygodnia);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzPlanStudenta(Integer studentId) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT pz FROM PlanZajec pz WHERE pz.przedmiot IN " +
				"(SELECT z.przedmiot FROM Zapis z WHERE z.student.idStudent = :studentId AND z.status = 'AKTYWNY') " +
				"ORDER BY pz.dzienTygodnia, pz.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("studentId", studentId);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzZajeciaWSali(String sala) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p WHERE p.sala = :sala ORDER BY p.dzienTygodnia, p.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("sala", sala);
		return query.getResultList();
	}

	@Override
	public List<PlanZajec> pobierzZajeciaPoTypie(String typ) {
		TypedQuery<PlanZajec> query = entityManager.createQuery(
			"SELECT p FROM PlanZajec p WHERE p.typ = :typ ORDER BY p.dzienTygodnia, p.godzinaStart",
			PlanZajec.class
		);
		query.setParameter("typ", typ);
		return query.getResultList();
	}

	@Override
	public void zapisz(PlanZajec planZajec) {
		entityManager.persist(planZajec);
	}

	@Override
	public PlanZajec aktualizuj(PlanZajec planZajec) {
		return entityManager.merge(planZajec);
	}

	@Override
	public void usun(PlanZajec planZajec) {
		PlanZajec managed = entityManager.contains(planZajec)
			? planZajec
			: entityManager.merge(planZajec);
		entityManager.remove(managed);
	}

	@Override
	public void usunPoId(Integer id) {
		PlanZajec planZajec = pobierzPoId(id);
		if (planZajec != null) {
			entityManager.remove(planZajec);
		}
	}
}
