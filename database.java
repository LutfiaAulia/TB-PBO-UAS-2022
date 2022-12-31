//class interface
//metode yg di butuhkan dalam mysql
public interface database {
    //metode untuk memperoleh list barang dan keranjang
    public String getdatalisba(String query,int menu);
    //metode untuk menambah list barang dan konfirmasi
    public void updateData(String query);
    //metode untuk menghapus list keranjang
    public void removeList(String kode);
    //metode untuk memperoleh harga barang di keranjang dan konfirmasi
    public int getharga();
    //metode untuk memperoleh list keranjang untuk konfirmasi
    public String getkera(String query,int menu);
    //metode untuk menampilkan barang yg telah di pesan pada cek
    public void checkBarang(int noPesan);
}
