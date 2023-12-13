package controller;

import java.util.ArrayList;
import model.ModelMahasiswa;
import entity.EntityMahasiswa;

public class ControllerMahasiswa {
    ModelMahasiswa modelMahasiswa = new ModelMahasiswa();
    public void tambahMahasiswa(String npm, String nama, String jurusan, String alamat){
        modelMahasiswa.insertMahasiswa(new EntityMahasiswa(npm, nama, jurusan, alamat));
    }
    public void updateMahasiswa(String npm, String nama, String jurusan, String alamat){
        if (modelMahasiswa.updateMahasiswa(npm, nama, jurusan, alamat)) {
            System.out.println("Update Data Berhasil");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public void updateMahasiswaByNama(String nama,String namaBaru){
        if (modelMahasiswa.updateMahasiswaByNama(nama, namaBaru)) {
            System.out.println("Update Data Berhasil");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }

    public void deleteMahasiswa(String npm){
        if(modelMahasiswa.deleteMahasiswa(npm)){
            System.out.println("Data Berhasil dihapus");
        }else{
            System.out.println("Data Tidak Ditemukan");
        }
    }
    public EntityMahasiswa getMahasiswaByNpm(String npm){
        return modelMahasiswa.getMahasiswaByNpm(npm);
    }
    
    public EntityMahasiswa getMahasiswaByNama(String nama){
        return modelMahasiswa.getMahasiswaByNama(nama);
    }

    public ArrayList<EntityMahasiswa> getListMahasiswa(){
        return modelMahasiswa.getListMahasiswa();
    }

    public boolean LoginMahasiswa (String npm, String nama){
        for (EntityMahasiswa data : getListMahasiswa()) {
            if (data.getNpm().equals(npm) && data.getNama().equals(nama)) {
                System.out.println("Login Berhasil");
                return true;
            }
        }
        System.out.println("Login Gagal");
        return false;
    }
}