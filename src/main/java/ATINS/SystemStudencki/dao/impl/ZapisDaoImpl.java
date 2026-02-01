package ATINS.SystemStudencki.dao.impl;

import ATINS.SystemStudencki.dao.ZapisDao;
import ATINS.SystemStudencki.model.Zapis;
import ATINS.SystemStudencki.model.Student;
import ATINS.SystemStudencki.model.Przedmiot;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Implementacja interfejsu ZapisDao.
 * Obsługuje operacje bazodanowe związane z zapisami studentów na przedmioty.
 */
@Repository
@Transactional
public class ZapisDaoImpl implements ZapisDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Zapis pobierzPoId(Integer id) {
        return entityManager.find(Zapis.class, id);
    }

    @Override
    public List<Zapis> pobierzWszystkie() {
        TypedQuery<Zapis> query = entityManager.createQuery(
                "SELECT z FROM Zapis z", Zapis.class);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzZapisyStudenta(Integer studentId) {
        TypedQuery<Zapis> query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.idStudent = :studentId", Zapis.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzZapisyNaPrzedmiot(Integer przedmiotId) {
        TypedQuery<Zapis> query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.przedmiot.idPrzedmiot = :przedmiotId", Zapis.class);
        query.setParameter("przedmiotId", przedmiotId);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzAktywneZapisyStudenta(Integer studentId) {
        TypedQuery<Zapis> query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.idStudent = :studentId AND z.status = 'AKTYWNY'", Zapis.class);
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }

    @Override
    public List<Zapis> pobierzZapisyStudentaWRoku(Integer studentId, String rokAkademicki) {
        TypedQuery<Zapis> query = entityManager.createQuery(
                "SELECT z FROM Zapis z WHERE z.student.idStudent = :studentId AND z.rokAkademicki = :rokAkademicki", Zapis.class);
        query.setParameter("studentId", studentId);
        query.setParameter("rokAkademicki", rokAkademicki);
        return query.getResultList();
    }

    @Override
    public boolean czyStudentZapisany(Integer studentId, Integer przedmiotId) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(z) FROM Zapis z WHERE z.student.idStudent = :studentId AND z.przedmiot.idPrzedmiot = :przedmiotId", Long.class);
        query.setParameter("studentId", studentId);
        query.setParameter("przedmiotId", przedmiotId);
        return query.getSingleResult() > 0;
    }

    @Override
    public Long policzZapisyNaPrzedmiot(Integer przedmiotId) {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT COUNT(z) FROM Zapis z WHERE z.przedmiot.idPrzedmiot = :przedmiotId", Long.class);
        query.setParameter("przedmiotId", przedmiotId);
        return query.getSingleResult();
    }

    @Override
    public void zapisz(Zapis zapis) {
        entityManager.persist(zapis);
    }

    @Override
    public Zapis aktualizuj(Zapis zapis) {
        return entityManager.merge(zapis);
    }

    @Override
    public void usun(Zapis zapis) {
        entityManager.remove(entityManager.contains(zapis) ? zapis : entityManager.merge(zapis));
    }

    @Override
    public void usunPoId(Integer id) {
        Zapis zapis = pobierzPoId(id);
        if (zapis != null) {
            entityManager.remove(zapis);
        }
    }

    @Override
    public void zmienStatus(Integer zapisId, String nowyStatus) {
        Zapis zapis = pobierzPoId(zapisId);
        if (zapis != null) {
            zapis.setStatus(nowyStatus);
            entityManager.merge(zapis);
        }
    }
}
