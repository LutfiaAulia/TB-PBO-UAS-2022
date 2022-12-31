//memasukan class yg di perlukan
import java.util.Scanner;
//import java.io.*;
import java.util.ArrayList;

//class child dari class Mysql
class keranjang extends Mysql{
    //membuat objek dari class
    Scanner masukpil = new Scanner(System.in);
    Scanner masuknobar = new Scanner(System.in);
    //metode untuk hapus/tidak dan tampilkan list keranjang
    public void keran(){
        //mendapatkan kode list barang
        String query = "SELECT * FROM keranjang";
        String kodekera = getdatalisba(query, 2);
        //percabangan
        //cek apakah keranjang kosong atau tidak
        if(kodekera == ""){
            System.out.println("\nKeranjang kosong.");
        }
        else{
            //menampilkan total pembayaran
            System.out.println("Total pembayaran : "+getharga());
            //memasukan pilihan ada barang yg di hapus atau tidak
            System.out.print("\nini adalah list pesanan anda. ada yg akan di hapus ?: (ya/tidak) ");
            String pilih = masukpil.nextLine();
            //menggumpulkan list kode barang
            String [] arrkodekera = kodekera.split("/2/");
            ArrayList<String> arrliskodkera = new ArrayList<String>();
            int a = 0;
            //perulangan
            while(arrkodekera.length > a){
                arrliskodkera.add(arrkodekera[a]);
                a++;
            }
            //percabangan
            //jika jawaban hapus ya atau tidak
            switch(pilih){
                case "ya":
                    System.out.print("\nmasukkan nomor barang yg ingin di hapus: ");
                    int nobar = masuknobar.nextInt();
                    removeList(arrliskodkera.get(nobar-1));
                    System.out.println("Sudah berhasil di hapus !!!");
                    System.out.println("Total pembayaran : "+getharga());
                    break;
                case "tidak":
                    System.out.println("\nkembali ke menu utama.");
                    break;
        }
        }
    }
}
