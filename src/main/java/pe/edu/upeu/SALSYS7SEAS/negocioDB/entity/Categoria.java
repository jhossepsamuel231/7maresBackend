package pe.edu.upeu.SALSYS7SEAS.negocioDB.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categorias")
public class Categoria {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "estado_categoria")
    private String estadoCategoria;

    //Foraneas:
    @ManyToOne
    @JoinColumn(name="idPlatilo", nullable=false)
    private Platillo platillos;
}
