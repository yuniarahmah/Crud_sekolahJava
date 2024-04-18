package TugasJava.Tugasakhir.service;


import TugasJava.Tugasakhir.model.DataSiswa;
import TugasJava.Tugasakhir.model.KelasModel;
import TugasJava.Tugasakhir.repository.KelasRepository;
import TugasJava.Tugasakhir.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {
    @Autowired
    private KelasRepository kelasRepository;

    public List<KelasModel> getAllData() {
        return kelasRepository.findAll();
    }

    public Optional<KelasModel> getById(Long id) {
        return kelasRepository.findById(id);
    }

    public KelasModel createDate(KelasModel kelasModel) {
        return kelasRepository.save(kelasModel);
    }

    public KelasModel updateData(long id, KelasModel updateData) {
        Optional<KelasModel> existingDataoptional = kelasRepository.findById(id);
        if (existingDataoptional.isPresent()) {
            KelasModel existingKelas = existingDataoptional.get();
            existingKelas.setNamaKelas(updateData.getNamaKelas());
            existingKelas.setWaliKelas(updateData.getWaliKelas());
            existingKelas.setNamaJurusan(updateData.getNamaJurusan());
            return kelasRepository.save(existingKelas);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    public void deleteData(Long id) {
        Optional<KelasModel> hapusSiswa = kelasRepository.findById(id);
        if (hapusSiswa.isPresent()) {
            kelasRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id" + id + " tidak ditemukan");
        }
    }
}
