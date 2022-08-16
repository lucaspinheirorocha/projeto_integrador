package br.com.dh.meli.projeto_integrador.model;

import br.com.dh.meli.projeto_integrador.model.geolocalization.AddressModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
