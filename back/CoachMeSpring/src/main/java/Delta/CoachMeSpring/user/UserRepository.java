package Delta.CoachMeSpring.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    public List<User> findAll();

    public List<User> findByLastName(String searchStr);

    public Optional<User> findByEmail(String email);
}
