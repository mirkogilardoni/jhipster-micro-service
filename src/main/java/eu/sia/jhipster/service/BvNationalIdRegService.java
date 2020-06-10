package eu.sia.jhipster.service;

import eu.sia.jhipster.service.dto.BvNationalIdRegDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link eu.sia.jhipster.domain.BvNationalIdReg}.
 */
public interface BvNationalIdRegService {

    /**
     * Save a bvNationalIdReg.
     *
     * @param bvNationalIdRegDTO the entity to save.
     * @return the persisted entity.
     */
    BvNationalIdRegDTO save(BvNationalIdRegDTO bvNationalIdRegDTO);

    /**
     * Get all the bvNationalIdRegs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BvNationalIdRegDTO> findAll(Pageable pageable);


    /**
     * Get the "id" bvNationalIdReg.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BvNationalIdRegDTO> findOne(Long id);

    /**
     * Delete the "id" bvNationalIdReg.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the bvNationalIdReg corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BvNationalIdRegDTO> search(String query, Pageable pageable);
}
