package demo.repo;

import demo.domain.OauthUserDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OauthUserDetailRepository extends CrudRepository<OauthUserDetailsEntity, Integer> {
    OauthUserDetailsEntity findByUsername(String username);
}
