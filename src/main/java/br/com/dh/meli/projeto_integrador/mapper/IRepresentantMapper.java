package br.com.dh.meli.projeto_integrador.mapper;

import br.com.dh.meli.projeto_integrador.dto.RepresentantDTO;
import br.com.dh.meli.projeto_integrador.model.Representant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IRepresentantMapper {
    IRepresentantMapper MAPPER = Mappers.getMapper(IRepresentantMapper.class);
    Representant mapDtoToModel(RepresentantDTO representantDTO);
}
