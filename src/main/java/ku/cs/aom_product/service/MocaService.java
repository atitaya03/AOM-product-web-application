package ku.cs.aom_product.service;

import ku.cs.aom_product.entity.Moca;
import ku.cs.aom_product.model.MocaRequest;
import ku.cs.aom_product.repository.MocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MocaService {
    @Autowired
    private MocaRepository repository;

    public double getVolume() {
        Moca data = repository.findAll().get(0);
        return  data.getVolume();

    }

    public void add(MocaRequest request) {
        Moca data = repository.findAll().get(0);
        double volume = data.getVolume();
        volume = volume + request.getVolume();
        data.setVolume(volume);
        repository.save(data);
    }

    public void use(MocaRequest request) {
        Moca data = repository.findAll().get(0);
        double volume = data.getVolume();
        volume = volume - request.getVolume();
        data.setVolume(volume);
        repository.save(data);
    }
}
