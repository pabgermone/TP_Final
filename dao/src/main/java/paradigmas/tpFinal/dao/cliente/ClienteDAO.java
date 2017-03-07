package paradigmas.tpFinal.dao.cliente;

import paradigmas.tpFinal.dao.PersistenteDAO;
import paradigmas.tpFinal.model.cliente.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Pablo Germone
 */
public class ClienteDAO implements PersistenteDAO<Cliente, Integer>{

    /**
     * PersistenceContext y EntityManager:
     * . https://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html_single/#d0e46
     */
    @PersistenceContext(unitName = "paradigamas-persistence-unit")
    private EntityManager entityManager;


    /**
     * Persiste en la base los datos de la entidad Cliente
     * @param cliente Entidad con datos del cliente a ser persistido
     * @return Misma entidad Cliente que llego por parametro
     */
    public Cliente crear(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }


    /**
     * Trae datos de un cliente en la base
     * @param id Primary Key del cliente del que se quieren recuperar los datos
     * @return Devuelve una entidad con los datos encontrados en la base
     */
    public Cliente obtener(Integer id){
        return entityManager.find(Cliente.class, id);
    }


    /**
     * Modifica los datos de un cliente en la base
     * @param cliente Entidad con los datos del cliente a modificar
     * @return Devuelve la entidad modificada
     */
    public Cliente modificar(Cliente cliente){
        return entityManager.merge(cliente);
    }


    /**
     * Elimina los datos de un cliente de la base
     * @param id Primary Key del cliente que se quiere eliminar
     */
    public void eliminar(Integer id){
        entityManager.remove(obtener(id));
    }
}
