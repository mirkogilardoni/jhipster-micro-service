package eu.sia.jhipster.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BvNationalIdRegMapperTest {

    private BvNationalIdRegMapper bvNationalIdRegMapper;

    @BeforeEach
    public void setUp() {
        bvNationalIdRegMapper = new BvNationalIdRegMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(bvNationalIdRegMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(bvNationalIdRegMapper.fromId(null)).isNull();
    }
}
