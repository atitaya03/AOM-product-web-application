package ku.cs.aom_product.service;


import ku.cs.aom_product.entity.Mold;
import ku.cs.aom_product.repository.MoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoldService {
    @Autowired
    private MoldRepository moldRepository;

    public List<Mold> getAllMolds(){
        return moldRepository.findAll();
    }
}
