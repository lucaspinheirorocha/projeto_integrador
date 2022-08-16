package br.com.dh.meli.projeto_integrador.util;

import br.com.dh.meli.projeto_integrador.dto.RepresentantDTO;
import br.com.dh.meli.projeto_integrador.model.Representant;
import java.util.ArrayList;
import java.util.List;

/**
 * Represetant Test Util
 *
 * @author Lucas Pinheiro Rocha
 * @author Alexandre Borges Souza
 * @since 15/08/2022
 */
public class RepresentantTestUtil {

    /**
     * Generate empty Representant Model
     * @return Representant
     * @author Lucas Pinheiro Rocha
     * @author Alexandre Borges Souza
     */
    public static Representant generateRepresentantModel() {
        Representant model = Representant.builder().build();
        return model;
    }

    /**
     * Generate Representant Model with content
     * @return Representant
     * @author Lucas Pinheiro Rocha
     * @author Alexandre Borges Souza
     */
    public static Representant representantSampleOne() {
        Representant representant = generateRepresentantModel();
        representant.setId(1L);
        representant.setWarehouse(WarehouseTestUtil.emptyWarehouseGenerator());
        return representant;
    }

    /**
     * Generate list of Representant Model
     * @return List<Representant>
     * @author Lucas Pinheiro Rocha
     * @author Alexandre Borges Souza
     */
    public static List<Representant> listOfRepresentantsSample() {
        List<Representant> representantList = new ArrayList<>();
        representantList.add(representantSampleOne());
        return representantList;
    }

    public static RepresentantDTO generateRepresentantDTO() {
        return RepresentantDTO.builder()
                .name("Joice")
                .warehouseId(1L)
                .build();
    }

    public static Representant createMock(){
        Representant representant = Representant.builder().build();
        representant.setId(1L);
        return representant;
    }

    public static Representant updateMock(){
        return createMock();
    }
}
