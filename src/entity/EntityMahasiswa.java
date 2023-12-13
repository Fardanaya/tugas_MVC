package entity;

public class EntityMahasiswa {
    private String npm;
    private String nama;
    private String jurusan;
    private String alamat;

    public EntityMahasiswa(String npm, String nama, String jurusan, String alamat) {
        this.npm = npm;
        this.nama = nama;
        this.jurusan = jurusan;
        this.alamat = alamat;
    }

    public String getNpm() {
        return npm;
    }

    public String getNama() {
        return nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
