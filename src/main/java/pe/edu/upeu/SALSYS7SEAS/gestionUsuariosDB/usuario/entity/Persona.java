package pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personas")
public class Persona {

    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(name = "nombre_persona")
    private String nombre_persona;

    @Column(name = "apellido_persona")
    private String apellido_persona;

    private String email;

    @Column(name = "estado_persona")
    private String estadoPersona;

    //Foranea
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    private Usuario usuario;
}
