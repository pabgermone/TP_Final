package paradigmas.tpFinal.model.cliente;

import javax.persistence.*;
import java.util.List;

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
    @Column(name="ClienteID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ClienteDNI", nullable = false)
    private int dni;

    @Column(name="ClienteNombre", nullable = false)
    private String nombre;

    @Column(name="ClienteApellido", nullable = false)
    private String apellido;

    /**
     * @OneToMany se usa para las tablas que tienen una relacion de muchos a uno con otra tabla.
     * El FetchType indica la forma en que se realizan las consultas al hacer uso de la entidad:
     *      EAGER indica que al hacer una consulta tambien se consultara por todas las colecciones de la entidad
     *      LAZY indica que los elementos de las colecciones de la entidad se iran consultando a medida que se
     *      necesiten.
     * El mappedBy indica el nombre de la variable que referencia a la ForeignKey en la tabla que esta del lado
     * "muchos" de la relacion.
     * El targetEntity indica con que entidad del programa se relaciona
     *
     * Generalmente esta etiqueta se usa con una lista en la parte "uno" de la relacion
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente", targetEntity = Turno.class)
    private List<Turno> turnos;


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


    public List<Turno> getTurnos() {
        return turnos;
    }


    @Override
    public String toString(){
        return "NroCliente: " + getId() + ", Nombre: " + getNombre() + ", Apellido: " + getApellido() + ", DNI: " + getDni();
    }
}
