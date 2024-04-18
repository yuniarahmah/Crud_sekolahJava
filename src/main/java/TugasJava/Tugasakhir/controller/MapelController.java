package TugasJava.Tugasakhir.controller;

import TugasJava.Tugasakhir.model.MapelModel;
import TugasJava.Tugasakhir.service.MapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mapel")
public class MapelController {
    @Autowired
    private MapelService mapelService;

    @GetMapping
    public ResponseEntity<List<MapelModel>> getAllData() {
        List<MapelModel> mapelModels = mapelService.getAllData();
        return new ResponseEntity<>(mapelModels, HttpStatus.OK);
    }

    //    get 1 id
    @GetMapping("/{id}")

    public ResponseEntity<MapelModel> getById(@PathVariable Long id) {
        Optional<MapelModel> mapelModel = mapelService.getById(id);
        return mapelModel.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //    Tambah Data
    @PostMapping //    method postmen
    public ResponseEntity<MapelModel> createData(@RequestBody MapelModel mapelModel) {
        MapelModel newData = mapelService.createDate(mapelModel);
        return new ResponseEntity<>(newData,HttpStatus.OK);
    }

    //    ubah Data
    @PutMapping("/{id}")
    public ResponseEntity<MapelModel> updateData(@PathVariable Long id, @RequestBody MapelModel updatekelas) {
        MapelModel putkelas = mapelService.updateData(id, updatekelas);
        return new ResponseEntity<>(putkelas, HttpStatus.OK);
    }

    //    Hapus Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        mapelService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

