package pe.edu.upeu.SALSYS7SEAS.negocioDB.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_platillos")
public class TipoPlatillo {

    @Id
    @Column(name = "id_tipo_platillo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPlatillo;

    @Column(name = "nombre_tipo_platillo")
    private String nombreTipoPlatillo;

    @Column(name = "estado_tipo_platillo")
    private String estadoTipoPlatillo;

    //Relaciones
    @OneToMany(mappedBy="tipoPlatillo")
    private Set<Platillo> platillos;
}
