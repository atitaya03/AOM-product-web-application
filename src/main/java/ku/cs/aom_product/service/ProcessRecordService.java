package ku.cs.aom_product.service;


import ku.cs.aom_product.entity.ProcessRecord;
import ku.cs.aom_product.model.ProcessRecordRequest;
import ku.cs.aom_product.repository.ProcessRecordRepository;
import ku.cs.aom_product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProcessRecordService {

    @Autowired
    private ProcessRecordRepository processRecordRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<ProcessRecord> getProcessRecordByProductId(UUID id){
        return processRecordRepository.findAllByProductId(id);
    }


    public int getProducedProcessRecordByProductId(UUID id){
        List<ProcessRecord> processRecords = processRecordRepository.findAllByProductId(id);
        int sum = 0;

        for (ProcessRecord processRecord : processRecords) {
            sum += processRecord.getQuantityRecord();
        }

        return sum;
    }



    public void createProcessRecord (ProcessRecordRequest request){
        ProcessRecord record = modelMapper.map(request, ProcessRecord.class);
        record.setProduct(productRepository.findById(request.getId()).get());
        processRecordRepository.save(record);

    }
}
