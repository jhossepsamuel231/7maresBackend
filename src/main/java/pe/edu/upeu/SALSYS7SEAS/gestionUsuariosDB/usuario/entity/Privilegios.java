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
@Table(name = "privilegios")
public class Privilegios {

    @Id
    @Column(name = "id_privilegio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrivilegio;

    @Column(name = "nombre_privilegio")
    private String nombrePrivilegio;

    @Column(name = "estado_privilegio")
    private String estadoPrivilegio;

    //Relaciones:
    @OneToMany(mappedBy="privilegios")
    private Set<PrivilegioRol> privilegioRoles;
}
