package ku.cs.aom_product.service;


import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Hardness;
import ku.cs.aom_product.model.ChemicalRequest;
import ku.cs.aom_product.model.UpdateChemicalRequest;
import ku.cs.aom_product.repository.ChemicalRepository;
import ku.cs.aom_product.repository.HardnessRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ChemicalService {
    @Autowired
    private ChemicalRepository chemicalRepository;

    @Autowired
    private HardnessRepository hardnessRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Chemical> getAllChemicals(){
        return chemicalRepository.findAll();
    }

    public Chemical getChemicalByName(String name){
        return chemicalRepository.findByName(name);
    }

    public List<Chemical> getChemicalsByHardness(int hardness){
        return chemicalRepository.findChemicalsByHardness_Hardness(hardness);
    }


    public void createChemical(ChemicalRequest chemical){
        Chemical record = modelMapper.map(chemical,Chemical.class);
        Hardness hardness = hardnessRepository.findByHardness(chemical.getHardness());
        record.setHardness(hardness);
        chemicalRepository.save(record);
    }

    public void addChemical(String name, Double addChem){
        Chemical record = chemicalRepository.findByName(name);
        double newVolume = record.getVolume() + addChem;
        record.setVolume(newVolume);
        chemicalRepository.save(record);}



    public void useChemical(String name, Double useChem){
        Chemical record = chemicalRepository.findByName(name);
        double newVolume = record.getVolume() - useChem;
        record.setVolume(newVolume);
        chemicalRepository.save(record);

    }
}
