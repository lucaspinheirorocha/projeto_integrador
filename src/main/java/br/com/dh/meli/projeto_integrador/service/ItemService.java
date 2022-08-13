package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.ItemDTO;
import br.com.dh.meli.projeto_integrador.exception.NotFoundException;
import br.com.dh.meli.projeto_integrador.mapper.IItemMapper;
import br.com.dh.meli.projeto_integrador.model.Advertisement;
import br.com.dh.meli.projeto_integrador.model.Item;
import br.com.dh.meli.projeto_integrador.repository.IItemRepository;
import br.com.dh.meli.projeto_integrador.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService implements IItemService {

    @Autowired
    private IItemRepository repo;

    @Autowired
    private IAdvertisementService advertisementService;
    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = repo.findById(id);
        if(item.isEmpty()){
            throw new NotFoundException("Item not found");
        }
        return item.get();
    }

    @Override
    public Item createItem(ItemDTO dto) {
        Item item = IItemMapper.MAPPER.mappingItemDTOItem(dto);
        Advertisement advertisement = advertisementService.getAdvertisementById(dto.getAdvertisementId());
        item.setAdvertisement(advertisement);
        //return repo.save(item);
        return item;
    }

    @Override
    public ItemDTO convertToDTO(Item item) {
        ItemDTO dto = IItemMapper.MAPPER.mappingItemToItemDTO(item);
        dto.setAdvertisementId(item.getAdvertisement().getId());
        dto.setBatchNumber(item.getBatchStock().getBatchNumber());
        return dto;
    }
}
