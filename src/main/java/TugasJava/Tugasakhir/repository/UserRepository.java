package TugasJava.Tugasakhir.repository;


import TugasJava.Tugasakhir.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findById(long userId);

    UserModel findByEmail(String email);
}
