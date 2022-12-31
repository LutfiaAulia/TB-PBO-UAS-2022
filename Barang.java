//import class yg di perlukan
import java.util.Scanner;
import java.util.ArrayList;

// class child dari class Mysql
class Barang extends Mysql {
    //membuat objek dari class
    Scanner masukkan = new Scanner(System.in);
    Scanner majumba = new Scanner(System.in);
    //metode untuk pilih barang dan jumlah
    public void ListBarang(){
        //memperoleh kode barang melalui getdatalisba dan menyimpan di arraylist
        String quelisba = "SELECT * FROM listperangkatelektronik";
        String ListKode = getdatalisba(quelisba,1);
        String [] arrLisKod = ListKode.split("/2/");
        // menggunakan collection framework (Arraylist)
        ArrayList<String> arrlisliskod = new ArrayList<String>();
        int a = 0;
        //perulangan
        while(arrLisKod.length>a){
            arrlisliskod.add(arrLisKod[a]);
            a++;
        }
        //menerima input pilihan barang
        System.out.print("\npilih barang: ");
        int nobar = masukkan.nextInt();
        //percabangan
        //pengecekkan apa barang ada di list
        if(nobar <= arrlisliskod.size() && nobar != 0){
            System.out.print("\njumlah barang : ");
            int jumba = majumba.nextInt();
            //percabangan
            //pengecekan jumlah barang tidak boleh 0
            if(jumba == 0){
                System.out.println("tidak Boleh kosong");
            }
            else{
                //menambah data ke data base
                String queupdate = "INSERT INTO keranjang(KodeBarang,NamaBarang,HargaBarang) SELECT KodeBarang,NamaBarang,HargaBarang FROM listperangkatelektronik WHERE KodeBarang='"+arrlisliskod.get(nobar-1)+"';";
                updateData(queupdate);
                updateData("UPDATE keranjang SET JumlahBarang='"+jumba+"' WHERE KodeBarang='"+arrlisliskod.get(nobar-1)+"';");
            }
        }
        else{
            System.out.println("tidak di temukan,kembali ke menu awal");
        }  
    }
}
