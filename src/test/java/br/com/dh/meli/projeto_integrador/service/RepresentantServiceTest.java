package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.dto.InboundOrderDTO;
import br.com.dh.meli.projeto_integrador.dto.RepresentantDTO;
import br.com.dh.meli.projeto_integrador.exception.PreconditionFailedException;
import br.com.dh.meli.projeto_integrador.repository.IRepresentantRepository;
import br.com.dh.meli.projeto_integrador.util.RepresentantTestUtil;
import br.com.dh.meli.projeto_integrador.util.WarehouseTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class RepresentantServiceTest {
    @InjectMocks
    private RepresentantService service;

    @Mock
    private IRepresentantRepository repo;

    @Mock
    private IWarehouseService warehouseService;

    @BeforeEach
    public void setup() {
        BDDMockito.when(warehouseService.findWarehouseById(ArgumentMatchers.anyLong()))
                .thenReturn(WarehouseTestUtil.warehouseModelSampleOne());
        BDDMockito.when(repo.saveAndFlush(ArgumentMatchers.any()))
                .thenReturn(RepresentantTestUtil.createMock());
    }

    @Test
    @DisplayName("Create a new representant when id is null and payload comes correctly")
    void create() {
        RepresentantDTO payload = RepresentantTestUtil.generateRepresentantDTO();

        RepresentantDTO representantDTOReturned = service.create(payload);

        assertThat(representantDTOReturned.getId()).isPositive();
    }

    @Test
    @DisplayName("Throw an exception when id is not null on payload")
    void create_PreconditionException() {
        RepresentantDTO payload = RepresentantTestUtil.generateRepresentantDTO();
        payload.setId(1L);

        PreconditionFailedException exception = assertThrows(PreconditionFailedException.class, () -> {
            service.create(payload);
        });


        assertThat(exception.getStatus()).isEqualTo(HttpStatus.PRECONDITION_FAILED);
    }

    @Test
    void findByName() {
    }
}
