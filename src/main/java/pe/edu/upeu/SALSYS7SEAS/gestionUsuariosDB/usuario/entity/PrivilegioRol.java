package pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "privilegio_roles")
public class PrivilegioRol {

    @Id
    @Column(name = "id_privilegio_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrivilegioRol;


    //Foraneas
    @ManyToOne
    @JoinColumn(name="idRol", nullable=false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="idPrivilegio", nullable=false)
    private Privilegios privilegios;
}
