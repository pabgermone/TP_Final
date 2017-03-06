package paradigmas.tpFinal.model.turno;

import paradigmas.tpFinal.model.cliente.Cliente;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Pablo Germone
 */

@Entity
@Table(name = "Turno")
public class Turno {

    @Id
    @Column(name = "TurnoId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TurnoFecha", nullable = false)
    private Date fecha;

    @Column(name = "TurnoHorario", nullable = false)
    private String hora;

    @Column(name = "TurnoCancelacion")
    private Date cancelacion;

    /**
     * @ManyToOne se usa para las relaciones muchos a uno
     * targetEntity indica el nombre con la que se esta relacionando
     *
     * @JoinColumn indica que esta propiedad representa la columna de la tabla que se usa como Foreign de la
     * otra tabla.
     */
    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "TurnoClienteId")
    private Cliente cliente;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    public Date getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(Date cancelacion) {
        this.cancelacion = cancelacion;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    @Override
    public String toString(){
        String mensaje = "Fecha: " + getFecha() + " Horario: " + getHora() + " Paciente: " + getCliente().getNombre() + " " + getCliente().getApellido();

        if(getCancelacion() != null){
            mensaje += " Fecha de cancelacion: " + getCancelacion();
        }

        return mensaje;
    }
}
