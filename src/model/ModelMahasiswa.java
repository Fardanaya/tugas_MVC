package model;

import java.util.ArrayList;
import entity.EntityMahasiswa;

public class ModelMahasiswa {
    public ArrayList<EntityMahasiswa> listMahasiswa;

    public ModelMahasiswa(){
        listMahasiswa = new ArrayList<EntityMahasiswa>();
    }

    public void insertMahasiswa(EntityMahasiswa mahasiswa){
        listMahasiswa.add(mahasiswa);
    }

    public boolean updateMahasiswa(String npm, String nama, String jurusan, String alamat){
        for (EntityMahasiswa listMahasiswa : listMahasiswa) {
            if (listMahasiswa.getNpm().equals(npm)) {
                listMahasiswa.setNama(nama);
                listMahasiswa.setJurusan(jurusan);
                listMahasiswa.setAlamat(alamat);
                return true;
            }
        }
        return false;
    }
    
    public boolean updateMahasiswaByNama(String nama, String namaBaru){
        for (EntityMahasiswa listMahasiswa : listMahasiswa) {
            if (listMahasiswa.getNama().equals(nama)) {
                listMahasiswa.setNama(namaBaru);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMahasiswa(String npm){
        for (EntityMahasiswa data : listMahasiswa) {
            if (data.getNpm().equals(npm)) {
                listMahasiswa.remove(data);
                return true;
            }
        }
        return false;
    }

    public EntityMahasiswa getMahasiswaByNpm(String npm){
        for (EntityMahasiswa entityMahasiswa : listMahasiswa) {
            if (entityMahasiswa.getNpm().equals(npm)) {
                return entityMahasiswa;
            }
        }
        return null;
    }

    public EntityMahasiswa getMahasiswaByNama(String nama){
        for (EntityMahasiswa entityMahasiswa : listMahasiswa) {
            if (entityMahasiswa.getNama().equals(nama)) {
                return entityMahasiswa;
            }
        }
        return null;
    }

    public ArrayList<EntityMahasiswa> getListMahasiswa() {
        return listMahasiswa;
    }
    
}
