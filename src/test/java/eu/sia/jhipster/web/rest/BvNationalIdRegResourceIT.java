package eu.sia.jhipster.web.rest;

import eu.sia.jhipster.JhipsterMicroServiceApp;
import eu.sia.jhipster.config.TestSecurityConfiguration;
import eu.sia.jhipster.domain.BvNationalIdReg;
import eu.sia.jhipster.repository.BvNationalIdRegRepository;
import eu.sia.jhipster.repository.search.BvNationalIdRegSearchRepository;
import eu.sia.jhipster.service.BvNationalIdRegService;
import eu.sia.jhipster.service.dto.BvNationalIdRegDTO;
import eu.sia.jhipster.service.mapper.BvNationalIdRegMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import eu.sia.jhipster.domain.enumeration.EVENTEnum;
import eu.sia.jhipster.domain.enumeration.STATUSEnum;
/**
 * Integration tests for the {@link BvNationalIdRegResource} REST controller.
 */
@SpringBootTest(classes = { JhipsterMicroServiceApp.class, TestSecurityConfiguration.class })
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class BvNationalIdRegResourceIT {

    private static final Long DEFAULT_SUBMITTER_MEMBER_ID = 1L;
    private static final Long UPDATED_SUBMITTER_MEMBER_ID = 2L;

    private static final Long DEFAULT_SUBMITTER_TRADER_ID = 1L;
    private static final Long UPDATED_SUBMITTER_TRADER_ID = 2L;

    private static final String DEFAULT_SUBMITTER_TRADER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SUBMITTER_TRADER_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_MEMBER_ID = 1L;
    private static final Long UPDATED_MEMBER_ID = 2L;

    private static final Integer DEFAULT_NATIONAL_ID_TYPE = 1;
    private static final Integer UPDATED_NATIONAL_ID_TYPE = 2;

    private static final String DEFAULT_NATIONAL_ID_CODE = "AAAAAAAAAA";
    private static final String UPDATED_NATIONAL_ID_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SHORT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SHORT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ID_NAME_DISPLAY = "AAAAAAAAAA";
    private static final String UPDATED_ID_NAME_DISPLAY = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_CODE_INVESTMENT_DECISION = "BBBBBBBBBB";

    private static final String DEFAULT_COUNTRY_CODE_ORDER_EXECUTION = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_CODE_ORDER_EXECUTION = "BBBBBBBBBB";

    private static final EVENTEnum DEFAULT_EVENT = EVENTEnum.Enable;
    private static final EVENTEnum UPDATED_EVENT = EVENTEnum.Delete;

    private static final STATUSEnum DEFAULT_STATUS = STATUSEnum.Enabled;
    private static final STATUSEnum UPDATED_STATUS = STATUSEnum.Deleted;

    private static final String DEFAULT_USER_DATA = "AAAAAAAAAA";
    private static final String UPDATED_USER_DATA = "BBBBBBBBBB";

    private static final Long DEFAULT_CREATION_DATE = 1L;
    private static final Long UPDATED_CREATION_DATE = 2L;

    private static final Long DEFAULT_CREATION_TIME = 1L;
    private static final Long UPDATED_CREATION_TIME = 2L;

    private static final Long DEFAULT_UPDATE_DATE = 1L;
    private static final Long UPDATED_UPDATE_DATE = 2L;

    private static final Long DEFAULT_UPDATE_TIME = 1L;
    private static final Long UPDATED_UPDATE_TIME = 2L;

    @Autowired
    private BvNationalIdRegRepository bvNationalIdRegRepository;

    @Autowired
    private BvNationalIdRegMapper bvNationalIdRegMapper;

    @Autowired
    private BvNationalIdRegService bvNationalIdRegService;

    /**
     * This repository is mocked in the eu.sia.jhipster.repository.search test package.
     *
     * @see eu.sia.jhipster.repository.search.BvNationalIdRegSearchRepositoryMockConfiguration
     */
    @Autowired
    private BvNationalIdRegSearchRepository mockBvNationalIdRegSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restBvNationalIdRegMockMvc;

    private BvNationalIdReg bvNationalIdReg;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BvNationalIdReg createEntity(EntityManager em) {
        BvNationalIdReg bvNationalIdReg = new BvNationalIdReg()
            .submitterMemberId(DEFAULT_SUBMITTER_MEMBER_ID)
            .submitterTraderId(DEFAULT_SUBMITTER_TRADER_ID)
            .submitterTraderName(DEFAULT_SUBMITTER_TRADER_NAME)
            .memberId(DEFAULT_MEMBER_ID)
            .nationalIdType(DEFAULT_NATIONAL_ID_TYPE)
            .nationalIdCode(DEFAULT_NATIONAL_ID_CODE)
            .shortCode(DEFAULT_SHORT_CODE)
            .idNameDisplay(DEFAULT_ID_NAME_DISPLAY)
            .countryCodeInvestmentDecision(DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION)
            .countryCodeOrderExecution(DEFAULT_COUNTRY_CODE_ORDER_EXECUTION)
            .event(DEFAULT_EVENT)
            .status(DEFAULT_STATUS)
            .userData(DEFAULT_USER_DATA)
            .creationDate(DEFAULT_CREATION_DATE)
            .creationTime(DEFAULT_CREATION_TIME)
            .updateDate(DEFAULT_UPDATE_DATE)
            .updateTime(DEFAULT_UPDATE_TIME);
        return bvNationalIdReg;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BvNationalIdReg createUpdatedEntity(EntityManager em) {
        BvNationalIdReg bvNationalIdReg = new BvNationalIdReg()
            .submitterMemberId(UPDATED_SUBMITTER_MEMBER_ID)
            .submitterTraderId(UPDATED_SUBMITTER_TRADER_ID)
            .submitterTraderName(UPDATED_SUBMITTER_TRADER_NAME)
            .memberId(UPDATED_MEMBER_ID)
            .nationalIdType(UPDATED_NATIONAL_ID_TYPE)
            .nationalIdCode(UPDATED_NATIONAL_ID_CODE)
            .shortCode(UPDATED_SHORT_CODE)
            .idNameDisplay(UPDATED_ID_NAME_DISPLAY)
            .countryCodeInvestmentDecision(UPDATED_COUNTRY_CODE_INVESTMENT_DECISION)
            .countryCodeOrderExecution(UPDATED_COUNTRY_CODE_ORDER_EXECUTION)
            .event(UPDATED_EVENT)
            .status(UPDATED_STATUS)
            .userData(UPDATED_USER_DATA)
            .creationDate(UPDATED_CREATION_DATE)
            .creationTime(UPDATED_CREATION_TIME)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateTime(UPDATED_UPDATE_TIME);
        return bvNationalIdReg;
    }

    @BeforeEach
    public void initTest() {
        bvNationalIdReg = createEntity(em);
    }

    @Test
    @Transactional
    public void createBvNationalIdReg() throws Exception {
        int databaseSizeBeforeCreate = bvNationalIdRegRepository.findAll().size();
        // Create the BvNationalIdReg
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);
        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isCreated());

        // Validate the BvNationalIdReg in the database
        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeCreate + 1);
        BvNationalIdReg testBvNationalIdReg = bvNationalIdRegList.get(bvNationalIdRegList.size() - 1);
        assertThat(testBvNationalIdReg.getSubmitterMemberId()).isEqualTo(DEFAULT_SUBMITTER_MEMBER_ID);
        assertThat(testBvNationalIdReg.getSubmitterTraderId()).isEqualTo(DEFAULT_SUBMITTER_TRADER_ID);
        assertThat(testBvNationalIdReg.getSubmitterTraderName()).isEqualTo(DEFAULT_SUBMITTER_TRADER_NAME);
        assertThat(testBvNationalIdReg.getMemberId()).isEqualTo(DEFAULT_MEMBER_ID);
        assertThat(testBvNationalIdReg.getNationalIdType()).isEqualTo(DEFAULT_NATIONAL_ID_TYPE);
        assertThat(testBvNationalIdReg.getNationalIdCode()).isEqualTo(DEFAULT_NATIONAL_ID_CODE);
        assertThat(testBvNationalIdReg.getShortCode()).isEqualTo(DEFAULT_SHORT_CODE);
        assertThat(testBvNationalIdReg.getIdNameDisplay()).isEqualTo(DEFAULT_ID_NAME_DISPLAY);
        assertThat(testBvNationalIdReg.getCountryCodeInvestmentDecision()).isEqualTo(DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION);
        assertThat(testBvNationalIdReg.getCountryCodeOrderExecution()).isEqualTo(DEFAULT_COUNTRY_CODE_ORDER_EXECUTION);
        assertThat(testBvNationalIdReg.getEvent()).isEqualTo(DEFAULT_EVENT);
        assertThat(testBvNationalIdReg.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testBvNationalIdReg.getUserData()).isEqualTo(DEFAULT_USER_DATA);
        assertThat(testBvNationalIdReg.getCreationDate()).isEqualTo(DEFAULT_CREATION_DATE);
        assertThat(testBvNationalIdReg.getCreationTime()).isEqualTo(DEFAULT_CREATION_TIME);
        assertThat(testBvNationalIdReg.getUpdateDate()).isEqualTo(DEFAULT_UPDATE_DATE);
        assertThat(testBvNationalIdReg.getUpdateTime()).isEqualTo(DEFAULT_UPDATE_TIME);

        // Validate the BvNationalIdReg in Elasticsearch
        verify(mockBvNationalIdRegSearchRepository, times(1)).save(testBvNationalIdReg);
    }

    @Test
    @Transactional
    public void createBvNationalIdRegWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = bvNationalIdRegRepository.findAll().size();

        // Create the BvNationalIdReg with an existing ID
        bvNationalIdReg.setId(1L);
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BvNationalIdReg in the database
        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeCreate);

        // Validate the BvNationalIdReg in Elasticsearch
        verify(mockBvNationalIdRegSearchRepository, times(0)).save(bvNationalIdReg);
    }


    @Test
    @Transactional
    public void checkMemberIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = bvNationalIdRegRepository.findAll().size();
        // set the field null
        bvNationalIdReg.setMemberId(null);

        // Create the BvNationalIdReg, which fails.
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);


        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkShortCodeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bvNationalIdRegRepository.findAll().size();
        // set the field null
        bvNationalIdReg.setShortCode(null);

        // Create the BvNationalIdReg, which fails.
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);


        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUpdateDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = bvNationalIdRegRepository.findAll().size();
        // set the field null
        bvNationalIdReg.setUpdateDate(null);

        // Create the BvNationalIdReg, which fails.
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);


        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUpdateTimeIsRequired() throws Exception {
        int databaseSizeBeforeTest = bvNationalIdRegRepository.findAll().size();
        // set the field null
        bvNationalIdReg.setUpdateTime(null);

        // Create the BvNationalIdReg, which fails.
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);


        restBvNationalIdRegMockMvc.perform(post("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllBvNationalIdRegs() throws Exception {
        // Initialize the database
        bvNationalIdRegRepository.saveAndFlush(bvNationalIdReg);

        // Get all the bvNationalIdRegList
        restBvNationalIdRegMockMvc.perform(get("/api/bv-national-id-regs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bvNationalIdReg.getId().intValue())))
            .andExpect(jsonPath("$.[*].submitterMemberId").value(hasItem(DEFAULT_SUBMITTER_MEMBER_ID.intValue())))
            .andExpect(jsonPath("$.[*].submitterTraderId").value(hasItem(DEFAULT_SUBMITTER_TRADER_ID.intValue())))
            .andExpect(jsonPath("$.[*].submitterTraderName").value(hasItem(DEFAULT_SUBMITTER_TRADER_NAME)))
            .andExpect(jsonPath("$.[*].memberId").value(hasItem(DEFAULT_MEMBER_ID.intValue())))
            .andExpect(jsonPath("$.[*].nationalIdType").value(hasItem(DEFAULT_NATIONAL_ID_TYPE)))
            .andExpect(jsonPath("$.[*].nationalIdCode").value(hasItem(DEFAULT_NATIONAL_ID_CODE)))
            .andExpect(jsonPath("$.[*].shortCode").value(hasItem(DEFAULT_SHORT_CODE)))
            .andExpect(jsonPath("$.[*].idNameDisplay").value(hasItem(DEFAULT_ID_NAME_DISPLAY)))
            .andExpect(jsonPath("$.[*].countryCodeInvestmentDecision").value(hasItem(DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION)))
            .andExpect(jsonPath("$.[*].countryCodeOrderExecution").value(hasItem(DEFAULT_COUNTRY_CODE_ORDER_EXECUTION)))
            .andExpect(jsonPath("$.[*].event").value(hasItem(DEFAULT_EVENT.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].userData").value(hasItem(DEFAULT_USER_DATA)))
            .andExpect(jsonPath("$.[*].creationDate").value(hasItem(DEFAULT_CREATION_DATE.intValue())))
            .andExpect(jsonPath("$.[*].creationTime").value(hasItem(DEFAULT_CREATION_TIME.intValue())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.intValue())));
    }
    
    @Test
    @Transactional
    public void getBvNationalIdReg() throws Exception {
        // Initialize the database
        bvNationalIdRegRepository.saveAndFlush(bvNationalIdReg);

        // Get the bvNationalIdReg
        restBvNationalIdRegMockMvc.perform(get("/api/bv-national-id-regs/{id}", bvNationalIdReg.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(bvNationalIdReg.getId().intValue()))
            .andExpect(jsonPath("$.submitterMemberId").value(DEFAULT_SUBMITTER_MEMBER_ID.intValue()))
            .andExpect(jsonPath("$.submitterTraderId").value(DEFAULT_SUBMITTER_TRADER_ID.intValue()))
            .andExpect(jsonPath("$.submitterTraderName").value(DEFAULT_SUBMITTER_TRADER_NAME))
            .andExpect(jsonPath("$.memberId").value(DEFAULT_MEMBER_ID.intValue()))
            .andExpect(jsonPath("$.nationalIdType").value(DEFAULT_NATIONAL_ID_TYPE))
            .andExpect(jsonPath("$.nationalIdCode").value(DEFAULT_NATIONAL_ID_CODE))
            .andExpect(jsonPath("$.shortCode").value(DEFAULT_SHORT_CODE))
            .andExpect(jsonPath("$.idNameDisplay").value(DEFAULT_ID_NAME_DISPLAY))
            .andExpect(jsonPath("$.countryCodeInvestmentDecision").value(DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION))
            .andExpect(jsonPath("$.countryCodeOrderExecution").value(DEFAULT_COUNTRY_CODE_ORDER_EXECUTION))
            .andExpect(jsonPath("$.event").value(DEFAULT_EVENT.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.userData").value(DEFAULT_USER_DATA))
            .andExpect(jsonPath("$.creationDate").value(DEFAULT_CREATION_DATE.intValue()))
            .andExpect(jsonPath("$.creationTime").value(DEFAULT_CREATION_TIME.intValue()))
            .andExpect(jsonPath("$.updateDate").value(DEFAULT_UPDATE_DATE.intValue()))
            .andExpect(jsonPath("$.updateTime").value(DEFAULT_UPDATE_TIME.intValue()));
    }
    @Test
    @Transactional
    public void getNonExistingBvNationalIdReg() throws Exception {
        // Get the bvNationalIdReg
        restBvNationalIdRegMockMvc.perform(get("/api/bv-national-id-regs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBvNationalIdReg() throws Exception {
        // Initialize the database
        bvNationalIdRegRepository.saveAndFlush(bvNationalIdReg);

        int databaseSizeBeforeUpdate = bvNationalIdRegRepository.findAll().size();

        // Update the bvNationalIdReg
        BvNationalIdReg updatedBvNationalIdReg = bvNationalIdRegRepository.findById(bvNationalIdReg.getId()).get();
        // Disconnect from session so that the updates on updatedBvNationalIdReg are not directly saved in db
        em.detach(updatedBvNationalIdReg);
        updatedBvNationalIdReg
            .submitterMemberId(UPDATED_SUBMITTER_MEMBER_ID)
            .submitterTraderId(UPDATED_SUBMITTER_TRADER_ID)
            .submitterTraderName(UPDATED_SUBMITTER_TRADER_NAME)
            .memberId(UPDATED_MEMBER_ID)
            .nationalIdType(UPDATED_NATIONAL_ID_TYPE)
            .nationalIdCode(UPDATED_NATIONAL_ID_CODE)
            .shortCode(UPDATED_SHORT_CODE)
            .idNameDisplay(UPDATED_ID_NAME_DISPLAY)
            .countryCodeInvestmentDecision(UPDATED_COUNTRY_CODE_INVESTMENT_DECISION)
            .countryCodeOrderExecution(UPDATED_COUNTRY_CODE_ORDER_EXECUTION)
            .event(UPDATED_EVENT)
            .status(UPDATED_STATUS)
            .userData(UPDATED_USER_DATA)
            .creationDate(UPDATED_CREATION_DATE)
            .creationTime(UPDATED_CREATION_TIME)
            .updateDate(UPDATED_UPDATE_DATE)
            .updateTime(UPDATED_UPDATE_TIME);
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(updatedBvNationalIdReg);

        restBvNationalIdRegMockMvc.perform(put("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isOk());

        // Validate the BvNationalIdReg in the database
        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeUpdate);
        BvNationalIdReg testBvNationalIdReg = bvNationalIdRegList.get(bvNationalIdRegList.size() - 1);
        assertThat(testBvNationalIdReg.getSubmitterMemberId()).isEqualTo(UPDATED_SUBMITTER_MEMBER_ID);
        assertThat(testBvNationalIdReg.getSubmitterTraderId()).isEqualTo(UPDATED_SUBMITTER_TRADER_ID);
        assertThat(testBvNationalIdReg.getSubmitterTraderName()).isEqualTo(UPDATED_SUBMITTER_TRADER_NAME);
        assertThat(testBvNationalIdReg.getMemberId()).isEqualTo(UPDATED_MEMBER_ID);
        assertThat(testBvNationalIdReg.getNationalIdType()).isEqualTo(UPDATED_NATIONAL_ID_TYPE);
        assertThat(testBvNationalIdReg.getNationalIdCode()).isEqualTo(UPDATED_NATIONAL_ID_CODE);
        assertThat(testBvNationalIdReg.getShortCode()).isEqualTo(UPDATED_SHORT_CODE);
        assertThat(testBvNationalIdReg.getIdNameDisplay()).isEqualTo(UPDATED_ID_NAME_DISPLAY);
        assertThat(testBvNationalIdReg.getCountryCodeInvestmentDecision()).isEqualTo(UPDATED_COUNTRY_CODE_INVESTMENT_DECISION);
        assertThat(testBvNationalIdReg.getCountryCodeOrderExecution()).isEqualTo(UPDATED_COUNTRY_CODE_ORDER_EXECUTION);
        assertThat(testBvNationalIdReg.getEvent()).isEqualTo(UPDATED_EVENT);
        assertThat(testBvNationalIdReg.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testBvNationalIdReg.getUserData()).isEqualTo(UPDATED_USER_DATA);
        assertThat(testBvNationalIdReg.getCreationDate()).isEqualTo(UPDATED_CREATION_DATE);
        assertThat(testBvNationalIdReg.getCreationTime()).isEqualTo(UPDATED_CREATION_TIME);
        assertThat(testBvNationalIdReg.getUpdateDate()).isEqualTo(UPDATED_UPDATE_DATE);
        assertThat(testBvNationalIdReg.getUpdateTime()).isEqualTo(UPDATED_UPDATE_TIME);

        // Validate the BvNationalIdReg in Elasticsearch
        verify(mockBvNationalIdRegSearchRepository, times(1)).save(testBvNationalIdReg);
    }

    @Test
    @Transactional
    public void updateNonExistingBvNationalIdReg() throws Exception {
        int databaseSizeBeforeUpdate = bvNationalIdRegRepository.findAll().size();

        // Create the BvNationalIdReg
        BvNationalIdRegDTO bvNationalIdRegDTO = bvNationalIdRegMapper.toDto(bvNationalIdReg);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBvNationalIdRegMockMvc.perform(put("/api/bv-national-id-regs").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(bvNationalIdRegDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BvNationalIdReg in the database
        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeUpdate);

        // Validate the BvNationalIdReg in Elasticsearch
        verify(mockBvNationalIdRegSearchRepository, times(0)).save(bvNationalIdReg);
    }

    @Test
    @Transactional
    public void deleteBvNationalIdReg() throws Exception {
        // Initialize the database
        bvNationalIdRegRepository.saveAndFlush(bvNationalIdReg);

        int databaseSizeBeforeDelete = bvNationalIdRegRepository.findAll().size();

        // Delete the bvNationalIdReg
        restBvNationalIdRegMockMvc.perform(delete("/api/bv-national-id-regs/{id}", bvNationalIdReg.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<BvNationalIdReg> bvNationalIdRegList = bvNationalIdRegRepository.findAll();
        assertThat(bvNationalIdRegList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the BvNationalIdReg in Elasticsearch
        verify(mockBvNationalIdRegSearchRepository, times(1)).deleteById(bvNationalIdReg.getId());
    }

    @Test
    @Transactional
    public void searchBvNationalIdReg() throws Exception {
        // Configure the mock search repository
        // Initialize the database
        bvNationalIdRegRepository.saveAndFlush(bvNationalIdReg);
        when(mockBvNationalIdRegSearchRepository.search(queryStringQuery("id:" + bvNationalIdReg.getId()), PageRequest.of(0, 20)))
            .thenReturn(new PageImpl<>(Collections.singletonList(bvNationalIdReg), PageRequest.of(0, 1), 1));

        // Search the bvNationalIdReg
        restBvNationalIdRegMockMvc.perform(get("/api/_search/bv-national-id-regs?query=id:" + bvNationalIdReg.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(bvNationalIdReg.getId().intValue())))
            .andExpect(jsonPath("$.[*].submitterMemberId").value(hasItem(DEFAULT_SUBMITTER_MEMBER_ID.intValue())))
            .andExpect(jsonPath("$.[*].submitterTraderId").value(hasItem(DEFAULT_SUBMITTER_TRADER_ID.intValue())))
            .andExpect(jsonPath("$.[*].submitterTraderName").value(hasItem(DEFAULT_SUBMITTER_TRADER_NAME)))
            .andExpect(jsonPath("$.[*].memberId").value(hasItem(DEFAULT_MEMBER_ID.intValue())))
            .andExpect(jsonPath("$.[*].nationalIdType").value(hasItem(DEFAULT_NATIONAL_ID_TYPE)))
            .andExpect(jsonPath("$.[*].nationalIdCode").value(hasItem(DEFAULT_NATIONAL_ID_CODE)))
            .andExpect(jsonPath("$.[*].shortCode").value(hasItem(DEFAULT_SHORT_CODE)))
            .andExpect(jsonPath("$.[*].idNameDisplay").value(hasItem(DEFAULT_ID_NAME_DISPLAY)))
            .andExpect(jsonPath("$.[*].countryCodeInvestmentDecision").value(hasItem(DEFAULT_COUNTRY_CODE_INVESTMENT_DECISION)))
            .andExpect(jsonPath("$.[*].countryCodeOrderExecution").value(hasItem(DEFAULT_COUNTRY_CODE_ORDER_EXECUTION)))
            .andExpect(jsonPath("$.[*].event").value(hasItem(DEFAULT_EVENT.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].userData").value(hasItem(DEFAULT_USER_DATA)))
            .andExpect(jsonPath("$.[*].creationDate").value(hasItem(DEFAULT_CREATION_DATE.intValue())))
            .andExpect(jsonPath("$.[*].creationTime").value(hasItem(DEFAULT_CREATION_TIME.intValue())))
            .andExpect(jsonPath("$.[*].updateDate").value(hasItem(DEFAULT_UPDATE_DATE.intValue())))
            .andExpect(jsonPath("$.[*].updateTime").value(hasItem(DEFAULT_UPDATE_TIME.intValue())));
    }
}
