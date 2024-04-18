package TugasJava.Tugasakhir.controller;

import TugasJava.Tugasakhir.model.KelasModel;
import TugasJava.Tugasakhir.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kelas")
public class KelasController {
    @Autowired
    private KelasService kelasService;

    @GetMapping
    public ResponseEntity<List<KelasModel>> getAllData() {
        List<KelasModel> kelasModels = kelasService.getAllData();
        return new ResponseEntity<>(kelasModels, HttpStatus.OK);
    }

    //    get 1 id
    @GetMapping("/{id}")

    public ResponseEntity<KelasModel> getById(@PathVariable Long id) {
        Optional<KelasModel> kelasModel = kelasService.getById(id);
        return kelasModel.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //    Tambah Data
    @PostMapping //    method postmen
    public ResponseEntity<KelasModel> createData(@RequestBody KelasModel kelasModel) {
        KelasModel newData = kelasService.createDate(kelasModel);
        return new ResponseEntity<>(newData,HttpStatus.OK);
    }

    //    ubah Data
    @PutMapping("/{id}")
    public ResponseEntity<KelasModel> updateData(@PathVariable Long id, @RequestBody KelasModel updatekelas) {
        KelasModel putkelas = kelasService.updateData(id, updatekelas);
        return new ResponseEntity<>(putkelas, HttpStatus.OK);
    }

    //    Hapus Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        kelasService.deleteData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
