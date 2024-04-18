package TugasJava.Tugasakhir.model;

import javax.persistence.*;

@Entity
@Table(name = "Guru")
public class DataGuru {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mapel_id")
    private MapelModel mapel;

    @Column(name = "nama_guru")
    private String nama_guru;

    @Column(name = "NIK")
    private String NIK;

    @Column(name = "alamat_guru")
    private String alamat_guru;

    @Column(name = "nomer_hp")
    private String nomer_hp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_guru() {
        return nama_guru;
    }

    public void setNama_guru(String nama_guru) {
        this.nama_guru = nama_guru;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getAlamat_guru() {
        return alamat_guru;
    }

    public void setAlamat_guru(String alamat_guru) {
        this.alamat_guru = alamat_guru;
    }

    public String getNomer_hp() {
        return nomer_hp;
    }

    public void setNomer_hp(String nomer_hp) {
        this.nomer_hp = nomer_hp;
    }

    public MapelModel getMapel() {
        return mapel;
    }

    public void setMapel(MapelModel mapel) {
        this.mapel = mapel;
    }
}
