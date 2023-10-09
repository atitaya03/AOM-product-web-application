package ku.cs.aom_product.service;

import ku.cs.aom_product.entity.Hardness;
import ku.cs.aom_product.repository.HardnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardnessService {
@Autowired
    private HardnessRepository hardnessRepository;

public List<Hardness> getAllHardness(){
    return  hardnessRepository.findAll();
}

}
