package ku.cs.aom_product.service;


import ku.cs.aom_product.entity.Mold;
import ku.cs.aom_product.entity.Product;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.repository.MoldRepository;
import ku.cs.aom_product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasheetService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private MoldRepository moldRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public void createDataSheet(DatasheetRequest request){
        Product record = modelMapper.map(request,Product.class);
        Mold mold = moldRepository.findById(request.getMoldId()).get();
        record.setMold(mold);
        record.setShape(request.getShape());
        repository.save(record);

    }
}
