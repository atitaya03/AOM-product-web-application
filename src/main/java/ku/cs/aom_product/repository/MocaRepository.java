package ku.cs.aom_product.repository;

import ku.cs.aom_product.entity.Moca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MocaRepository extends JpaRepository <Moca, UUID>{

}
