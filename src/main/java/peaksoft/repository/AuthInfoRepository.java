package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.AuthInfo;

import java.util.Optional;

@Repository
public interface AuthInfoRepository extends JpaRepository<AuthInfo,Long> {
    Optional<AuthInfo> findByEmail(String email);

    boolean existsByEmail(String email);
}
