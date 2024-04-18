package TugasJava.Tugasakhir.controller;

import TugasJava.Tugasakhir.model.DataGuru;
import TugasJava.Tugasakhir.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guru")
public class guruController {
    @Autowired
    private GuruService guruService;

    @GetMapping
    public ResponseEntity<List<DataGuru>> getAllData() {
        List<DataGuru> dataGurus = guruService.getAllData();
        return new ResponseEntity<>(dataGurus, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataGuru> getById(@PathVariable Long id) {
        Optional<DataGuru> dataGuru = guruService.getById(id);
        return dataGuru.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DataGuru> createData(@RequestBody DataGuru dataGuru) {
        DataGuru newData = guruService.createDate(dataGuru);
        return new ResponseEntity<>(newData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataGuru> updateData(@PathVariable Long id, @RequestBody DataGuru updatekelas) {
        DataGuru putkelas = guruService.updateData(id, updatekelas);
        return new ResponseEntity<>(putkelas, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Long id) {
        try {
            guruService.deleteData(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
