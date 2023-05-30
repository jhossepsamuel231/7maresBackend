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
@Table(name = "platillos")
public class Platillo {

    @Id
    @Column(name = "id_platillo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlatillo;

    @Column(name = "nombre_platillo")
    private String nombrePlatillo;

    @Column(name = "costo_platillo")
    private int costoPlatillo;

    @Column(name = "estado_platillo")
    private String estadoPlatillo;

    //Foraneas:
    @ManyToOne
    @JoinColumn(name="idTipoPlatillo", nullable=false)
    private TipoPlatillo tipoPlatillo;

    //Relaciones:
    @OneToMany(mappedBy="platillo")
    private Set<DetallePedido> detallePedidos;

    @OneToMany(mappedBy="platillos")
    private Set<Categoria> categorias;
}
