package eu.sia.jhipster.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import eu.sia.jhipster.web.rest.TestUtil;

public class BvNationalIdRegTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BvNationalIdReg.class);
        BvNationalIdReg bvNationalIdReg1 = new BvNationalIdReg();
        bvNationalIdReg1.setId(1L);
        BvNationalIdReg bvNationalIdReg2 = new BvNationalIdReg();
        bvNationalIdReg2.setId(bvNationalIdReg1.getId());
        assertThat(bvNationalIdReg1).isEqualTo(bvNationalIdReg2);
        bvNationalIdReg2.setId(2L);
        assertThat(bvNationalIdReg1).isNotEqualTo(bvNationalIdReg2);
        bvNationalIdReg1.setId(null);
        assertThat(bvNationalIdReg1).isNotEqualTo(bvNationalIdReg2);
    }
}
