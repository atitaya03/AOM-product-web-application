package ku.cs.aom_product.service;


import ku.cs.aom_product.entity.Mold;
import ku.cs.aom_product.model.MoldRequest;
import ku.cs.aom_product.repository.MoldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class MoldService {
    @Autowired
    private MoldRepository moldRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Mold> getAllMolds(){
        return moldRepository.findAll();
    }


    public void addMold(MoldRequest request){
        Mold record = modelMapper.map(request,Mold.class);
        moldRepository.save(record);
    }
}
