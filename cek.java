/**
 * mengimpor class yg di perlukan
 */
import java.util.Scanner;

//class child dari class Mysql
public class cek extends Mysql{
    Scanner manopes = new Scanner(System.in);
    //metode untuk menampilkan barang yg telah di pesan
    public void cekbarang(){
        //memasukan kode pesanan dan tampilkan
        System.out.print("\nMasukan ID Pesan: ");
        int nopes = manopes.nextInt();
        checkBarang(nopes);
    }
}