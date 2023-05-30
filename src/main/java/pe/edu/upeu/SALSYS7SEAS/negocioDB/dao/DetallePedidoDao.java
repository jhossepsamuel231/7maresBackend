package pe.edu.upeu.SALSYS7SEAS.negocioDB.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.SALSYS7SEAS.negocioDB.entity.DetallePedido;

@Repository
public interface DetallePedidoDao extends JpaRepository<DetallePedido, Integer> {
}
