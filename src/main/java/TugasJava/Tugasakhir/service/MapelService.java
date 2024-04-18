package TugasJava.Tugasakhir.service;

import TugasJava.Tugasakhir.model.MapelModel;
import TugasJava.Tugasakhir.repository.MapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapelService {
    @Autowired
    private MapelRepository mapelRepository;

    public List<MapelModel> getAllData() {
        return mapelRepository.findAll();
    }

    public Optional<MapelModel> getById(Long id) {
        return mapelRepository.findById(id);
    }

    public MapelModel createDate(MapelModel mapelModel) {
        return mapelRepository.save(mapelModel);
    }

    public MapelModel updateData(long id, MapelModel updateData) {
        Optional<MapelModel> existingDataoptional = mapelRepository.findById(id);
        if (existingDataoptional.isPresent()) {
            MapelModel existingmapel = existingDataoptional.get();
            existingmapel.setNama_mapel(updateData.getNama_mapel());
            return mapelRepository.save(existingmapel);
        } else {
            throw new IllegalArgumentException("id siswa " + id + " tidk ditemukan");
        }
    }

    public void deleteData(Long id) {
        Optional<MapelModel> hapusSiswa = mapelRepository.findById(id);
        if (hapusSiswa.isPresent()) {
            mapelRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("siswa dengan id" + id + " tidak ditemukan");
        }
    }
}
