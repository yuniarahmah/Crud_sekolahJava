package TugasJava.Tugasakhir.repository;

import TugasJava.Tugasakhir.model.DataSiswa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiswaRepository extends JpaRepository<DataSiswa, Long> {
}
