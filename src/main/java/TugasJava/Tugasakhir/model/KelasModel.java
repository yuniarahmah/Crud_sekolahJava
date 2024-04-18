package TugasJava.Tugasakhir.model;

import javax.persistence.*;

@Entity
@Table(name = "kelas")
public class KelasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String namaKelas;

    @Column
    private String namaJurusan;

    @Column
    private String waliKelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public String getWaliKelas() {
        return waliKelas;
    }

    public void setWaliKelas(String waliKelas) {
        this.waliKelas = waliKelas;
    }

    @Override
    public String toString() {
        return "KelasModel{" +
                "id=" + id +
                ", namaKelas='" + namaKelas + '\'' +
                ", namaJurusan='" + namaJurusan + '\'' +
                ", waliKelas='" + waliKelas + '\'' +
                '}';
    }
}
