//impor class yg di perlukan
import java.util.Scanner;

class Main{
    public static void main(String[] args){
        //membuat objek baru dari class yg di import
        Mysql sql = new Mysql();
        Barang data = new Barang();
        keranjang kera = new keranjang();
        konfirmasi konfir = new konfirmasi();
        cek cek = new cek();
        Scanner mano = new Scanner(System.in);
        //berfungsi membuat pilihan menu
        boolean menu = true;
        //perulangan
        while(menu){
            System.out.println("Selamat Datang di Taka Tako Elektronik :) ");
            String judul = "List Produk";
            //String method
            System.out.println("======================================");
            System.out.println("              "+judul.toUpperCase());
            System.out.println("======================================");
            System.out.print("1.List barang\n2.Keranjang\n3.konfirmasi\n4.cek\n5.exit\n\nSelect : ");
            int nome = mano.nextInt();
            //percabangan
            switch(nome){
                case 1 :
                    //menggunakan method class barang untuk memilih barang
                    data.ListBarang();
                    break;
                case 2 :
                    //menggunakan method class keranjang untuk menampilkan dan menghapus
                    kera.keran();
                    break;
                case 3 :
                    //menggunakan method class konfirmasi untuk memasukan data pemesan
                    konfir.dataPenerima();
                    break;
                case 4:
                    //menggunakan method class cek untuk melihat barang yg telah di pesan
                    cek.cekbarang();
                    break;
                case 5 :
                    //keluar dari program
                    menu = false;
                    break;
                default:
                    System.out.println("menu tidak di temukan");
                    break;
            }
        }
    }
} 