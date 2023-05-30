package pe.edu.upeu.SALSYS7SEAS.negocioDB.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "fecha_pedido")
    private Date fechaPedido;

    @Column(name = "estado_pedido")
    private String estadoPedido;

    //Relaciones:

    @OneToMany(mappedBy="pedidos")
    private Set<DetallePedido> detallePedidos;
}
