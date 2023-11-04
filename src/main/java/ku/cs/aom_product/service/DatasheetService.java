package ku.cs.aom_product.service;


import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Mold;
import ku.cs.aom_product.entity.Product;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.repository.ChemicalRepository;
import ku.cs.aom_product.repository.MoldRepository;
import ku.cs.aom_product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DatasheetService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ChemicalRepository chemicalRepository;
    @Autowired
    private MoldRepository moldRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Product> getAllProduct(){
        return repository.findAll();
    }

    public List<Product> getAllWaitingProduct(){
        return repository.findAllByStatus(Status.WAITING);
    }

    public void updateStatus(UUID id){
        Product record  = repository.findById(id).get();
        record.setStatus(Status.COMPLETE);
        repository.save(record);

    }
    public void createDataSheet(DatasheetRequest request){
        Product record = modelMapper.map(request,Product.class);
        Chemical chemical = chemicalRepository.findByName(request.getChemicalName());
        record.setChemical(chemical);
        repository.save(record);
    }

    public Product getOneById(UUID id){
        return repository.findById(id).get();
    }

}
