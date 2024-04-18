package TugasJava.Tugasakhir.dto;

public class DataGuruDto {
    private Long id;
    private String namaGuru;
    private Integer NIK;
    private String alamatGuru;
    private Integer nomerHp;
    private String mapel; // Nama mata pelajaran

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }

    public Integer getNIK() {
        return NIK;
    }

    public void setNIK(Integer NIK) {
        this.NIK = NIK;
    }

    public String getAlamatGuru() {
        return alamatGuru;
    }

    public void setAlamatGuru(String alamatGuru) {
        this.alamatGuru = alamatGuru;
    }

    public Integer getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(Integer nomerHp) {
        this.nomerHp = nomerHp;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }
}

