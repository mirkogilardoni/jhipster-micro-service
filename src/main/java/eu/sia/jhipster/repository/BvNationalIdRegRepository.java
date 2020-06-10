package eu.sia.jhipster.repository;

import eu.sia.jhipster.domain.BvNationalIdReg;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the BvNationalIdReg entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BvNationalIdRegRepository extends JpaRepository<BvNationalIdReg, Long> {
}
