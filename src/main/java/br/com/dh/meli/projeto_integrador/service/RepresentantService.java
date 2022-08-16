package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.RepresentantDTO;
import br.com.dh.meli.projeto_integrador.exception.NotFoundException;
import br.com.dh.meli.projeto_integrador.exception.PreconditionFailedException;
import br.com.dh.meli.projeto_integrador.mapper.IRepresentantMapper;
import br.com.dh.meli.projeto_integrador.model.Representant;
import br.com.dh.meli.projeto_integrador.model.Warehouse;
import br.com.dh.meli.projeto_integrador.repository.IRepresentantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepresentantService implements IRepresentantService{

    @Autowired
    IRepresentantRepository repo;

    @Autowired
    IWarehouseService warehouseService;

    @Override
    public RepresentantDTO create(RepresentantDTO representantDTO) {
        idMustBeNull(representantDTO.getId());
        Representant representant = convertToModel(representantDTO);

        Representant representantSaved = repo.saveAndFlush(representant);

        representantDTO.setId(representantSaved.getId());
        return representantDTO;
    }

    @Override
    public RepresentantDTO update(Long id, RepresentantDTO representantDTO) {
        Representant representantFound = findById(id);

        Representant representantModel = convertToModel(representantDTO);
        representantFound.setWarehouse(representantModel.getWarehouse());
        representantFound.setName(representantModel.getName());
        repo.saveAndFlush(representantModel);
        representantDTO.setId(representantFound.getId());
        System.out.println(representantDTO.toString());
        return representantDTO;
    }

    private Representant findById(Long id) {
        Optional<Representant> representantFound = repo
                .findById(id);

        if (representantFound.isEmpty()) {
            throw new NotFoundException("Representant not found");
        }

        return representantFound.get();
    }

    private Representant convertToModel(RepresentantDTO representantDTO) {
        Warehouse warehouse = warehouseService
                .findWarehouseById(representantDTO.getWarehouseId());

        Representant convertedRepresentant = new Representant();

        convertedRepresentant.setName(representantDTO.getName());
        convertedRepresentant.setWarehouse(warehouse);
        return convertedRepresentant;
    }

    private void idMustBeNull(Long id) {
        if (id != null) {
            throw new PreconditionFailedException("Id must not be provided");
        }
    }
}
