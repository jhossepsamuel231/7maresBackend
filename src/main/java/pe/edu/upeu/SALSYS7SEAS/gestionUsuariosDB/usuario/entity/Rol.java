package pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    @Column(name = "estado_rol")
    private String estadoRol;

    //Relaciones:
    @OneToMany(mappedBy="rol")
    private Set<Usuario> usuarios;

    @OneToMany(mappedBy="rol")
    private Set<PrivilegioRol> privilegioRoles;
}
