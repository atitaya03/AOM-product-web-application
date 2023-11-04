package ku.cs.aom_product.repository;

import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByStatus( Status status);
}
