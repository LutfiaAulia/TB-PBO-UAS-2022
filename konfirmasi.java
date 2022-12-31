/**
 * mengimpor class yg di perlukan
 */
import java.util.Scanner;
import java.time.LocalDate;

//class child dari class Mysql
public class konfirmasi extends Mysql {
    //membuat objek baru dari class yg di import;
    Scanner mana = new Scanner(System.in);
    Scanner maal = new Scanner(System.in);
    //metode untuk konfirmasi dan memasukkan data pemesan
    public void dataPenerima(){
        //memperoleh list kode,jumlah,harga pada barang
        String liskod = getkera("SELECT * FROM keranjang",1);
        String lisjum = getkera("SELECT * FROM keranjang", 2);
        String lishar = getkera("SELECT * FROM keranjang", 3);
        //percabangan
        //pengecekan apakah keranjang kosong
        if (liskod == ""){
            System.out.println("keranjang kosong.");
        }
        else{
            //memasukkan data pemesan
            System.out.println("untuk konfirmasi :");
            System.out.print("\nmasukan nama : ");
            String nama = mana.nextLine();
            System.out.print("\nmasukan alamat : ");
            String alamat = maal.nextLine();
            //memperoleh id pesanan
            double id = Math.random()*100000;
            int idPesan = (int) id;
            //memasukan list kode,jumlah,harga ke dalam array
            String [] arrliskod = liskod.split("/2/");
            String [] arrlisjum = lisjum.split("/2/");
            String [] arrlishar = lishar.split("/2/");
            //memperoleh harga total
            int harto = getharga();
            //Date
            //memperoleh tanggal pemesanan
            LocalDate tangpe = LocalDate.now();
            String barang ="";
            int a = 0;
            //perulangan
            while(arrliskod.length > a){
                barang += arrliskod[a]+"\t"+arrlisjum[a]+"\t"+arrlishar[a]+"\n";
                a++;
            }
            String quedata = "INSERT INTO datapengguna(IDPemesanan,tanggalPesanan,Nama,Alamat,Barang,HargaTotal,Status) VALUES('"+idPesan+"','"+tangpe+"','"+nama+"','"+alamat+"','"+barang+"','"+harto+"','Dalam pengiriman');";
            updateData(quedata);
            updateData("DELETE FROM keranjang");
            System.out.println("\n nomor id pemesanan anda : "+idPesan);
        }
    }        
}