package TugasJava.Tugasakhir.service;

import TugasJava.Tugasakhir.model.DataSiswa;
import TugasJava.Tugasakhir.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    @Autowired
    private SiswaRepository siswaRepository;

    public List<DataSiswa> getAllData() {
        return siswaRepository.findAll();
    }

    public Optional<DataSiswa> getById(Long id) {
        return siswaRepository.findById(id);
    }

    public DataSiswa createDate(DataSiswa dataSiswa) {
        return siswaRepository.save(dataSiswa);
    }

    public DataSiswa updateData(long id, DataSiswa updateData) {
        Optional<DataSiswa> existingDataoptional = siswaRepository.findById(id);
        if (existingDataoptional.isPresent()) {
            DataSiswa existingSiswa = existingDataoptional.get();
            existingSiswa.setNama_siswa(updateData.getNama_siswa());
            existingSiswa.setNISN(updateData.getNISN());
            existingSiswa.setHobi(updateData.getHobi());
            existingSiswa.setJurusan(updateData.getJurusan());
            existingSiswa.setKelas(updateData.getKelas());
            existingSiswa.setUmur(updateData.getUmur());
            existingSiswa.setAlamat(updateData.getAlamat());
            return siswaRepository.save(existingSiswa);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    public void deleteData(Long id) {
        Optional<DataSiswa> hapusSiswa = siswaRepository.findById(id);
        if (hapusSiswa.isPresent()) {
            siswaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id" + id + " tidak ditemukan");
        }
    }
}