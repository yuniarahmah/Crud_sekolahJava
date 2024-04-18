package TugasJava.Tugasakhir.model;

import javax.persistence.*;

@Entity
@Table(name = "data_siswa")
public class DataSiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NISN")
    private Long NISN;

    @Column(name = "nama_siswa")
    private String nama_siswa;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "umur")
    private String umur;

    @Column(name = "hobi")
    private String hobi;

    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "kelas")
    private String kelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNISN() {
        return NISN;
    }

    public void setNISN(Long NISN) {
        this.NISN = NISN;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
