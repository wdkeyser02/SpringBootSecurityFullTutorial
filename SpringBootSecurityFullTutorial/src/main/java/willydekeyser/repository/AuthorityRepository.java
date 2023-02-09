package willydekeyser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import willydekeyser.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}
