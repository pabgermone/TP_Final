package paradigmas.tpFinal.dao;

/**
 * @author Pablo Germone
 *
 * Esta interfaz se usa en todos los DAOs. El tipo de ENTIDAD y ID se definen en cada clase en que se implemente
 */
public interface PersistenteDAO<ENTIDAD, ID> {
    public ENTIDAD crear(ENTIDAD entidad);

    public ENTIDAD obtener(ID id);

    public ENTIDAD modificar(ENTIDAD entidad);

    public void eliminar(ID id);
}
