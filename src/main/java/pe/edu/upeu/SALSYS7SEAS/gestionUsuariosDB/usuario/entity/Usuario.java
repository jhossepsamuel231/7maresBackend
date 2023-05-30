package pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String username;

    private String password;

    @Column(name = "estado_usuario")
    private String estadoUsuario;

    //Foraneas
    @ManyToOne
    @JoinColumn(name="idRol", nullable=false)
    private Rol rol;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;
}
