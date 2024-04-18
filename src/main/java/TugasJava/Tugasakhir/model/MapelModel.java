package TugasJava.Tugasakhir.model;

import javax.persistence.*;

@Entity
@Table(name = "Mapel")
public class MapelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_mapel")
    private String nama_mapel;
    @ManyToOne
    @JoinColumn(name = "guru_mapel")
    private DataGuru guru;

    public Long getId() {
        return id;
    }

    public DataGuru getGuru() {
        return guru;
    }

    public void setGuru(DataGuru guru) {
        this.guru = guru;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }
}
