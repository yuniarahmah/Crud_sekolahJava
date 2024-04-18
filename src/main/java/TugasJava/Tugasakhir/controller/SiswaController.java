package TugasJava.Tugasakhir.controller;

import TugasJava.Tugasakhir.model.DataSiswa;
import TugasJava.Tugasakhir.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/data_siswa")
public class SiswaController {
    @Autowired
    private SiswaService siswaService;

    //    get semua id
    @GetMapping
    public ResponseEntity<List<DataSiswa>> getAllData() {
        List<DataSiswa> dataSiswas = siswaService.getAllData();
        return new ResponseEntity<>(dataSiswas, HttpStatus.OK);
    }

    //    get 1 id
    @GetMapping("/{id}")

    public ResponseEntity<DataSiswa> getById(@PathVariable Long id) {
        Optional<DataSiswa> siswaModels = siswaService.getById(id);
        return siswaModels.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //    Tambah Data
    @PostMapping //    method postmen
    public ResponseEntity<DataSiswa> createData(@RequestBody DataSiswa dataSiswa) {
        DataSiswa newData = siswaService.createDate(dataSiswa);
        return new ResponseEntity<>(newData,HttpStatus.OK);
    }

    //    ubah Data
    @PutMapping("/{id}")
    public ResponseEntity<DataSiswa> updateData(@PathVariable Long id, @RequestBody DataSiswa ubahSiswa) {
        DataSiswa putSiswa = siswaService.updateData(id, ubahSiswa);
        return new ResponseEntity<>(putSiswa, HttpStatus.OK);
    }

    //    Hapus Data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        siswaService.deleteData(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
