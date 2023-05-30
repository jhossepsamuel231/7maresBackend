package pe.edu.upeu.SALSYS7SEAS.negocioDB.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.SALSYS7SEAS.negocioDB.entity.TipoPlatillo;

@Repository
public interface TipoPlatilloDao extends JpaRepository<TipoPlatillo, Integer> {
}
