package eu.sia.jhipster.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link BvNationalIdRegSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class BvNationalIdRegSearchRepositoryMockConfiguration {

    @MockBean
    private BvNationalIdRegSearchRepository mockBvNationalIdRegSearchRepository;

}
