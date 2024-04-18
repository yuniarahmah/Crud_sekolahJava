package TugasJava.Tugasakhir.service;

import TugasJava.Tugasakhir.model.DataGuru;
import TugasJava.Tugasakhir.repository.GuruRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuruService {
    private GuruRepository guruRepository;

    @Autowired
    public GuruService(GuruRepository guruRepository) {
        this.guruRepository = guruRepository;
    }

    public List<DataGuru> getAllData() {
        return guruRepository.findAll();
    }

    public Optional<DataGuru> getById(Long id) {
        return guruRepository.findById(id);
    }

    //tambah data
    public DataGuru createDate(DataGuru dataGuru) {
        return guruRepository.save(dataGuru);
    }

    //logika ubah data
    public DataGuru updateData(Long id,DataGuru updateData){
        Optional<DataGuru> existingGuruOptional = guruRepository.findById(id); // untuk memanipulasi data atau mengubah data
        if (existingGuruOptional.isPresent()) {  //mengechek data
            DataGuru existingguru = existingGuruOptional.get();
            existingguru.setNama_guru(updateData.getNama_guru());
            existingguru.setAlamat_guru(updateData.getAlamat_guru());
            existingguru.setNIK(updateData.getNIK());
            existingguru.setNomer_hp(updateData.getNomer_hp());
            return guruRepository.save(existingguru);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    //logika hapus data
    public void deleteData(Long id) { //    Long untuk parameter, deleteData untuk method
        Optional<DataGuru> hapusguru = guruRepository.findById(id);
        if (hapusguru.isPresent()) { // Exceptionnya bernama hapusSiswa
            guruRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id " + id + " tdk dtemukan");
        }
    }
}
