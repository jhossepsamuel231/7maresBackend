package pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.SALSYS7SEAS.gestionUsuariosDB.usuario.entity.Rol;

@Repository
public interface RolDao extends JpaRepository<Rol, Integer> {
}
