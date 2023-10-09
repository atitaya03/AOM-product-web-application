package ku.cs.aom_product.repository;

import ku.cs.aom_product.entity.Chemical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChemicalRepository extends JpaRepository<Chemical, UUID> {
}
