package ku.cs.aom_product.repository;

import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Hardness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface HardnessRepository extends JpaRepository<Hardness, String> {
    Hardness findByHardness(int hardness);
}
