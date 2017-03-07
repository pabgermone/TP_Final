package paradigmas.tpFinal.dao.turno;

import paradigmas.tpFinal.dao.PersistenteDAO;
import paradigmas.tpFinal.model.turno.Turno;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Pablo Germone
 */
public class TurnoDAO implements PersistenteDAO<Turno, Integer>{
    @PersistenceContext(unitName = "paradigmas-persistence-unit")
    private EntityManager entityManager;

    /**
     * Guarda en la base los datos de un turno
     * @param turno Entidad con los datos a guardar en la base
     * @return Misma entidad que llega por parametro
     */
    public Turno crear(Turno turno){
        entityManager.persist(turno);
        return turno;
    }

    /**
     * Devuelve los datos de un turno encontrado en la base
     * @param id Primary Key del turno que se desea encontrar en la base
     * @return Datos del turno encontrado
     */
    public Turno obtener(Integer id){
        return entityManager.find(Turno.class, id);
    }

    /**
     * Modifica un turno en la base
     * @param turno Entidad con los datos a modificar en la base
     * @return Entidad resultante de la modificacion en la base
     */
    public Turno modificar(Turno turno){
        return entityManager.merge(turno);
    }

    /**
     * Elimina un turno en la base
     * @param id Primary Key del turno a eliminar
     */
    public void eliminar(Integer id){
        entityManager.remove(obtener(id));
    }
}
