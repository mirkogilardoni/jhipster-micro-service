package eu.sia.jhipster.repository.search;

import eu.sia.jhipster.domain.BvNationalIdReg;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Spring Data Elasticsearch repository for the {@link BvNationalIdReg} entity.
 */
public interface BvNationalIdRegSearchRepository extends ElasticsearchRepository<BvNationalIdReg, Long> {
}
