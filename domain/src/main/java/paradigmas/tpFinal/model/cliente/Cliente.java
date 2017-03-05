package paradigmas.tpFinal.model.cliente;

import javax.persistence.*;

/**
 * @author Pablo Germone
 */

@Entity //Indica que esta clase sirve como entidad Hibernate
@Table(name="Cliente") //Indica el nombre de la tabla en donde trabaja esta entidad
public class Cliente {

    /**
     * Representa el ID de un cliente
     * @Id: Anotacion que indica que se trata de una Primary Key
     * @Column: Anotacion que indica el nombre de la columna de la tabla donde esta la Primary Key
     * @GeneratedValue: Generador numerico para la columna indicada.
     *                  El tipo de generacion es indicado por la variable strategy que puede tomar
     *                  cualquier valor del tipo GenerationType.
     *                  Pueden ser:
     *                      AUTO: Indica que el tipo de proveedor BD debe elegir el tipo de estrategia mas
     *                      conveniente.
     *
     *                      IDENTITY: Indica que el proveedor debe aignar un valor de Primary Key usando
     *                      la columna de identidad.
     *
     *                      SEQUENCE: Indica que el proveedor debe asignar un valor usando una secuencia
     *                      de la BD.
     *
     *                      TABLE: ??
     */
    @Id
    @Column(name="ClienteID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ClienteDNI")
    private int dni;

    @Column(name="ClienteNombre")
    private String nombre;

    @Column(name="ClienteApellido")
    private String apellido;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    @Override
    public String toString(){
        return "NroCliente: " + getId() + ", Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", DNI: " + getDni();
    }
}
