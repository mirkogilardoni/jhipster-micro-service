package eu.sia.jhipster.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import eu.sia.jhipster.web.rest.TestUtil;

public class BvNationalIdRegDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BvNationalIdRegDTO.class);
        BvNationalIdRegDTO bvNationalIdRegDTO1 = new BvNationalIdRegDTO();
        bvNationalIdRegDTO1.setId(1L);
        BvNationalIdRegDTO bvNationalIdRegDTO2 = new BvNationalIdRegDTO();
        assertThat(bvNationalIdRegDTO1).isNotEqualTo(bvNationalIdRegDTO2);
        bvNationalIdRegDTO2.setId(bvNationalIdRegDTO1.getId());
        assertThat(bvNationalIdRegDTO1).isEqualTo(bvNationalIdRegDTO2);
        bvNationalIdRegDTO2.setId(2L);
        assertThat(bvNationalIdRegDTO1).isNotEqualTo(bvNationalIdRegDTO2);
        bvNationalIdRegDTO1.setId(null);
        assertThat(bvNationalIdRegDTO1).isNotEqualTo(bvNationalIdRegDTO2);
    }
}
