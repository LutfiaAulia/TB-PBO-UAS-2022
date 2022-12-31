//mengimpor class yg di perlukan
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

//implemen dr class interface database
public class Mysql implements database{
    private static String DB_URL;
    private static String USER;
    private static String PASS;

    //Constructor untuk menggisi user,pass,dan url sql
    public Mysql(){
        DB_URL = "jdbc:mysql://localhost:3306/takatakoelektronikdb";
        USER = "root";
        PASS = "";
    }

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;

    //metode untuk mengkoneksikan data base
    public void connection(){
        try{
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //metode untuk memperoleh list barang dan keranjang
    @Override
    public String getdatalisba(String query,int menu){
        String listkoba = "";
        connection();
        //Exception
        try{
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            int a = 1;
            //perulangan
            while(resultData.next()){
                //percabangan
                if (menu == 1){
                    System.out.print(a+". "+resultData.getString("NamaBarang")+"\n\tDeskripsi Barang:\n"+resultData.getString("DeskripsiBarang")+"\n\tStok :"+resultData.getString("StokBarang")+"\n\tHarga: "+resultData.getString("HargaBarang")+"\n\n");
                    listkoba += resultData.getString("KodeBarang")+"/2/";
                    a++;
                }
                else{
                    System.out.println(a+"."+resultData.getString("NamaBarang")+"\t"+resultData.getString("JumlahBarang")+"\t"+resultData.getString("HargaBarang"));
                    listkoba += resultData.getString("KodeBarang")+"/2/";
                    a++;
                }
                
            }
            statement.close();
            connect.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return listkoba;
    }

    //metode untuk menambah list barang dan konfirmasi
    @Override
    public void updateData(String query){
        connection();
        //Exception
        try {
            statement = connect.createStatement();
            statement.execute(query);
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    //metode untuk menghapus list keranjang
    @Override
    public void removeList(String kode){
        connection();
        //exception
        try{
            statement = connect.createStatement();
            statement.execute("DELETE FROM keranjang WHERE KodeBarang='"+kode+"';");
            connect.close();
            statement.close();
            int a = 1;
        }catch(Exception e){
            e.getStackTrace();
        }
    }

    //metode untuk memperoleh harga barang di keranjang dan konfirmasi
    @Override
    public int getharga(){
        connection();
        int harto = 0;
        //exception
        try{
            statement = connect.createStatement();
            resultData = statement.executeQuery("SELECT HargaBarang,JumlahBarang FROM keranjang");
            while(resultData.next()){
                harto += resultData.getInt("HargaBarang") * resultData.getInt("JumlahBarang"); 
            }
            connect.close();
            statement.close();
        }catch(Exception e){
            e.getStackTrace();
        }
        return harto;
    }

    //metode untuk memperoleh list keranjang untuk konfirmasi
    @Override
    public String getkera(String query,int menu){
        connection();
        String kobar ="";
        String harbar ="";
        String jumbar ="";
        //exception
        try{
            statement = connect.createStatement();
            resultData = statement.executeQuery(query);
            //perulangan
            while (resultData.next()){
                kobar += resultData.getString("KodeBarang")+"/2/";
                harbar += resultData.getString("HargaBarang")+"/2/";
                jumbar += resultData.getString("JumlahBarang")+"/2/";
            }
            connect.close();
            statement.close();
        }catch(Exception e){
            e.getStackTrace();
        }
        //percabangan
        if (menu == 1){
            return kobar;
        }
        else if(menu == 2){
            return jumbar;
        }
        else{
            return harbar;
        }
    }

    //metode untuk menampilkan barang yg telah di pesan pada cek
    @Override
    public void checkBarang(int noPesan){
        connection();
        //exception
        try {
            statement = connect.createStatement();
            resultData = statement.executeQuery("SELECT tanggalPesanan,Nama,Alamat,Barang,HargaTotal,status FROM datapengguna WHERE IDPemesanan='"+noPesan+"';");
            //Perulangan
            while(resultData.next()){
                System.out.println(resultData.getString("tanggalPesanan")+"\t"+resultData.getString("Nama")+"\t"+resultData.getString("Alamat")+"\t"+resultData.getString("Barang")+"\t"+resultData.getString("HargaTotal")+"\t"+resultData.getString("status"));
            }
            connect.close();
            statement.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}