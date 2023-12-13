package view;

import java.util.Scanner;

import controller.ControllerMahasiswa;
import entity.EntityMahasiswa;

public class View {
    static ControllerMahasiswa controller;
    static Scanner input = new Scanner(System.in);

    public static void setController(ControllerMahasiswa controller){
        View.controller = controller;
    }


    public static void login(){
        do {
            System.out.println("LOGIN");
            System.out.println("Masukkan NPM : ");
            String npm = input.next();
            System.out.println("Masukkan Nama : ");
            String nama = input.next();
            if ("admin".equals(npm) && "admin".equals(nama)) {
                System.out.println("Login sebagai Admin");
                menu();
            }else if (controller.LoginMahasiswa(npm, nama)) {
                System.out.println("Login Berhasil");
                menuMhs(npm, nama);
            }
        } while (true);
    }

    public static void menu(){
        int pilihan;
        do {
        System.out.println("MENU");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Hapus Data Mahasiswa");
        System.out.println("3. Tampilkan Data Mahasiswa");
        System.out.println("4. Update Data Mahasiswa");
        System.out.println("5. Cari Data Mahasiswa");
        System.out.println("6. Keluar");
        System.out.println("Pilihan : ");
        pilihan = input.nextInt();
        switch (pilihan){
            case 1:
                tambahData();
                break;
            case 2:
                hapusData();
                break;
            case 3:
                tampilkanData();
                break;
            case 4:
                updateData();
                break;
            case 5:
                cariData();
                break;
                case 6:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
            }
        } while (pilihan != 6);
    }

    public static void menuMhs(String npm, String nama){
        int pilihan;
        do {
        System.out.println("MENU");
        System.out.println("1. Tampilkan Data diri");
        System.out.println("2. Update Data diri");
        System.out.println("3. Keluar");
        System.out.println("Pilihan : ");
        pilihan = input.nextInt();
        switch (pilihan){
            case 1:
                print(controller.getMahasiswaByNpm(npm));
                break;
            case 2:
                updateData();
                break;
            case 3:
                System.out.println("Keluar");
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
            }
        } while (pilihan != 3);
    }


    public static void tambahData(){
        input.nextLine();
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("Masukan Data Mahasiswa");
        System.out.println("NPM : ");
        String npm = input.nextLine();
        System.out.println("NAMA : ");
        String nama = input.nextLine();
        System.out.println("JURUSAN : ");
        String jurusan = input.nextLine();
        System.out.println("ALAMAT : ");
        String alamat = input.nextLine();
        controller.tambahMahasiswa(npm, nama, jurusan, alamat);
        }

    public static void hapusData(){
        System.out.println("2. Hapus Data Mahasiswa");
        System.out.println("Masukkan NPM : ");
        String npm = input.next();
        controller.deleteMahasiswa(npm);
    }

    public static void tampilkanData(){
        System.out.println("3. Tampilkan Data Mahasiswa");
        System.out.println("Data Mahasiswa");
        for (int i = 0; i < controller.getListMahasiswa().size(); i++) {
            System.out.println("NPM : " + controller.getListMahasiswa().get(i).getNpm());
            System.out.println("Nama : " + controller.getListMahasiswa().get(i).getNama());
            System.out.println("Jurusan : " + controller.getListMahasiswa().get(i).getJurusan());
            System.out.println("Alamat : " + controller.getListMahasiswa().get(i).getAlamat());
            System.out.println("================================");
        }
    }

    public static void updateData(){
        System.out.println("UPDATE DATA MAHASISWA");
        System.out.println("1. Update By NPM");
        System.out.println("2. Update Nama Mahasiswa");
        System.out.println("Pilihan : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
            input.nextLine();
            System.out.println("Masukkan NPM : ");
            String npm = input.nextLine();
            System.out.println("Masukkan Nama : ");
            String nama = input.nextLine();
            System.out.println("Masukkan Jurusan : ");
            String jurusan = input.nextLine();
            System.out.println("Masukkan Alamat : ");
            String alamat = input.nextLine();
            controller.updateMahasiswa(npm, nama, jurusan, alamat);
                break;
            case 2:
            input.nextLine();
            System.out.println("Masukkan Nama : ");
            nama = input.nextLine();
            System.out.println("Masukkan Nama Baru : ");
            String namaBaru = input.nextLine();
            controller.updateMahasiswaByNama(nama, namaBaru);
            default:
                break;
        }

    }

    public static void cariData(){
        System.out.println("CARI DATA MAHASISWA");
        System.out.println("1. By NPM");
        System.out.println("2. By Nama");
        System.out.println("Pilihan : ");
        int pilihan = input.nextInt();
        EntityMahasiswa mahasiswa;
        switch (pilihan){
            case 1:
                input.nextLine();
                System.out.println("Masukkan NPM : ");
                String npm = input.nextLine();
                mahasiswa = controller.getMahasiswaByNpm(npm);
                print(mahasiswa);
                break;
            case 2:
                input.nextLine();
                System.out.println("Masukkan Nama : ");
                String nama = input.nextLine();
                print(controller.getMahasiswaByNama(nama));
                break;
            default:
                System.out.println("Pilihan tidak ada");
                break;
        }
    }

    public static void print(EntityMahasiswa mahasiswa){
        if (mahasiswa == null) {
            System.out.println("Data Tidak Ditemukan");
            return;
        }
        System.out.println("NPM : " + mahasiswa.getNpm());
        System.out.println("NAMA : " + mahasiswa.getNama());
        System.out.println("JURUSAN : " + mahasiswa.getJurusan());
        System.out.println("ALAMAT : " + mahasiswa.getAlamat());
    }

}
