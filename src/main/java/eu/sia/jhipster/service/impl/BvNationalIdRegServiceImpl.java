package eu.sia.jhipster.service.impl;

import eu.sia.jhipster.service.BvNationalIdRegService;
import eu.sia.jhipster.domain.BvNationalIdReg;
import eu.sia.jhipster.repository.BvNationalIdRegRepository;
import eu.sia.jhipster.repository.search.BvNationalIdRegSearchRepository;
import eu.sia.jhipster.service.dto.BvNationalIdRegDTO;
import eu.sia.jhipster.service.mapper.BvNationalIdRegMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link BvNationalIdReg}.
 */
@Service
@Transactional
public class BvNationalIdRegServiceImpl implements BvNationalIdRegService {

    private final Logger log = LoggerFactory.getLogger(BvNationalIdRegServiceImpl.class);

    private final BvNationalIdRegRepository bvNationalIdRegRepository;

    private final BvNationalIdRegMapper bvNationalIdRegMapper;

    private final BvNationalIdRegSearchRepository bvNationalIdRegSearchRepository;

    public BvNationalIdRegServiceImpl(BvNationalIdRegRepository bvNationalIdRegRepository, BvNationalIdRegMapper bvNationalIdRegMapper, BvNationalIdRegSearchRepository bvNationalIdRegSearchRepository) {
        this.bvNationalIdRegRepository = bvNationalIdRegRepository;
        this.bvNationalIdRegMapper = bvNationalIdRegMapper;
        this.bvNationalIdRegSearchRepository = bvNationalIdRegSearchRepository;
    }

    /**
     * Save a bvNationalIdReg.
     *
     * @param bvNationalIdRegDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BvNationalIdRegDTO save(BvNationalIdRegDTO bvNationalIdRegDTO) {
        log.debug("Request to save BvNationalIdReg : {}", bvNationalIdRegDTO);
        BvNationalIdReg bvNationalIdReg = bvNationalIdRegMapper.toEntity(bvNationalIdRegDTO);
        bvNationalIdReg = bvNationalIdRegRepository.save(bvNationalIdReg);
        BvNationalIdRegDTO result = bvNationalIdRegMapper.toDto(bvNationalIdReg);
        bvNationalIdRegSearchRepository.save(bvNationalIdReg);
        return result;
    }

    /**
     * Get all the bvNationalIdRegs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BvNationalIdRegDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BvNationalIdRegs");
        return bvNationalIdRegRepository.findAll(pageable)
            .map(bvNationalIdRegMapper::toDto);
    }


    /**
     * Get one bvNationalIdReg by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BvNationalIdRegDTO> findOne(Long id) {
        log.debug("Request to get BvNationalIdReg : {}", id);
        return bvNationalIdRegRepository.findById(id)
            .map(bvNationalIdRegMapper::toDto);
    }

    /**
     * Delete the bvNationalIdReg by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BvNationalIdReg : {}", id);
        bvNationalIdRegRepository.deleteById(id);
        bvNationalIdRegSearchRepository.deleteById(id);
    }

    /**
     * Search for the bvNationalIdReg corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BvNationalIdRegDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of BvNationalIdRegs for query {}", query);
        return bvNationalIdRegSearchRepository.search(queryStringQuery(query), pageable)
            .map(bvNationalIdRegMapper::toDto);
    }
}
