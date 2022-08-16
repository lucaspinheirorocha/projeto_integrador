package br.com.dh.meli.projeto_integrador.dto;

import br.com.dh.meli.projeto_integrador.model.geolocalization.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * DTO for payload for add new Representant
 *
 * @author Evelyn Cristini Oliveira
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepresentantDTO {
    private Long id;
    @NotEmpty(message = "O campo representantName não pode estar vazio.")
    private String name;

    @NotEmpty(message = "O campo warehouseId não pode estar vazio")
    private Long warehouseId;
}
