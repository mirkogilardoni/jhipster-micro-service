package eu.sia.jhipster.service.mapper;


import eu.sia.jhipster.domain.*;
import eu.sia.jhipster.service.dto.BvNationalIdRegDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link BvNationalIdReg} and its DTO {@link BvNationalIdRegDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BvNationalIdRegMapper extends EntityMapper<BvNationalIdRegDTO, BvNationalIdReg> {



    default BvNationalIdReg fromId(Long id) {
        if (id == null) {
            return null;
        }
        BvNationalIdReg bvNationalIdReg = new BvNationalIdReg();
        bvNationalIdReg.setId(id);
        return bvNationalIdReg;
    }
}
