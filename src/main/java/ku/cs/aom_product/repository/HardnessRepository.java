package ku.cs.aom_product.repository;

import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Hardness;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HardnessRepository extends JpaRepository<Hardness, String> {
    Hardness findByHardness(int hardness);
}
