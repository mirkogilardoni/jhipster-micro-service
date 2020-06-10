package eu.sia.jhipster.web.rest;

import eu.sia.jhipster.service.BvNationalIdRegService;
import eu.sia.jhipster.web.rest.errors.BadRequestAlertException;
import eu.sia.jhipster.service.dto.BvNationalIdRegDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link eu.sia.jhipster.domain.BvNationalIdReg}.
 */
@RestController
@RequestMapping("/api")
public class BvNationalIdRegResource {

    private final Logger log = LoggerFactory.getLogger(BvNationalIdRegResource.class);

    private static final String ENTITY_NAME = "jhipsterMicroServiceBvNationalIdReg";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BvNationalIdRegService bvNationalIdRegService;

    public BvNationalIdRegResource(BvNationalIdRegService bvNationalIdRegService) {
        this.bvNationalIdRegService = bvNationalIdRegService;
    }

    /**
     * {@code POST  /bv-national-id-regs} : Create a new bvNationalIdReg.
     *
     * @param bvNationalIdRegDTO the bvNationalIdRegDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new bvNationalIdRegDTO, or with status {@code 400 (Bad Request)} if the bvNationalIdReg has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bv-national-id-regs")
    public ResponseEntity<BvNationalIdRegDTO> createBvNationalIdReg(@Valid @RequestBody BvNationalIdRegDTO bvNationalIdRegDTO) throws URISyntaxException {
        log.debug("REST request to save BvNationalIdReg : {}", bvNationalIdRegDTO);
        if (bvNationalIdRegDTO.getId() != null) {
            throw new BadRequestAlertException("A new bvNationalIdReg cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BvNationalIdRegDTO result = bvNationalIdRegService.save(bvNationalIdRegDTO);
        return ResponseEntity.created(new URI("/api/bv-national-id-regs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /bv-national-id-regs} : Updates an existing bvNationalIdReg.
     *
     * @param bvNationalIdRegDTO the bvNationalIdRegDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated bvNationalIdRegDTO,
     * or with status {@code 400 (Bad Request)} if the bvNationalIdRegDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the bvNationalIdRegDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bv-national-id-regs")
    public ResponseEntity<BvNationalIdRegDTO> updateBvNationalIdReg(@Valid @RequestBody BvNationalIdRegDTO bvNationalIdRegDTO) throws URISyntaxException {
        log.debug("REST request to update BvNationalIdReg : {}", bvNationalIdRegDTO);
        if (bvNationalIdRegDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BvNationalIdRegDTO result = bvNationalIdRegService.save(bvNationalIdRegDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, bvNationalIdRegDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /bv-national-id-regs} : get all the bvNationalIdRegs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bvNationalIdRegs in body.
     */
    @GetMapping("/bv-national-id-regs")
    public ResponseEntity<List<BvNationalIdRegDTO>> getAllBvNationalIdRegs(Pageable pageable) {
        log.debug("REST request to get a page of BvNationalIdRegs");
        Page<BvNationalIdRegDTO> page = bvNationalIdRegService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /bv-national-id-regs/:id} : get the "id" bvNationalIdReg.
     *
     * @param id the id of the bvNationalIdRegDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the bvNationalIdRegDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bv-national-id-regs/{id}")
    public ResponseEntity<BvNationalIdRegDTO> getBvNationalIdReg(@PathVariable Long id) {
        log.debug("REST request to get BvNationalIdReg : {}", id);
        Optional<BvNationalIdRegDTO> bvNationalIdRegDTO = bvNationalIdRegService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bvNationalIdRegDTO);
    }

    /**
     * {@code DELETE  /bv-national-id-regs/:id} : delete the "id" bvNationalIdReg.
     *
     * @param id the id of the bvNationalIdRegDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bv-national-id-regs/{id}")
    public ResponseEntity<Void> deleteBvNationalIdReg(@PathVariable Long id) {
        log.debug("REST request to delete BvNationalIdReg : {}", id);
        bvNationalIdRegService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/bv-national-id-regs?query=:query} : search for the bvNationalIdReg corresponding
     * to the query.
     *
     * @param query the query of the bvNationalIdReg search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/bv-national-id-regs")
    public ResponseEntity<List<BvNationalIdRegDTO>> searchBvNationalIdRegs(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of BvNationalIdRegs for query {}", query);
        Page<BvNationalIdRegDTO> page = bvNationalIdRegService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
        }
}
