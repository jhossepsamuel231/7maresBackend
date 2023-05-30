package pe.edu.upeu.SALSYS7SEAS.negocioDB.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detalle_pedidos")
public class DetallePedido {

    @Id
    @Column(name = "id_detalle_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetallePedido;

    @Column(name = "cantidad_detalle_pedido")
    private int cantidad;

    //Foraneas:

    @ManyToOne
    @JoinColumn(name="idPedido", nullable=false)
    private Pedido pedidos;

    @ManyToOne
    @JoinColumn(name="idPlatillo", nullable=false)
    private Platillo platillo;
}
