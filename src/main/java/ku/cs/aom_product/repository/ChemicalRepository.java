package ku.cs.aom_product.repository;

import ku.cs.aom_product.entity.Chemical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChemicalRepository extends JpaRepository<Chemical, UUID> {
  List<Chemical> findChemicalsByHardness_Hardness(int hardness);
  Chemical findByName(String name);
}
