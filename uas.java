import java.util.Scanner;

public class uas{
	static Scanner input = new Scanner(System.in);
	static int no[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	static String barang[] = {"1. kinder Joy", "2.Kopikap", "3.Ice Cream Feast", "4.Sikat Gigi", "5.Pepsodent", "6.Charm Body Fit", "7.Coca Cola 3L", "8.Proman", "9.Surya 12", "10.Marlboro"};
	static int harga[] = { 9000, 2000, 5000, 10000, 9000, 16000, 16500, 14000, 21000, 26000 };
	static boolean ulangSemua = true;
	static String notaBarang[] = new String[100];
	static int notaJumlah[] = new int[100];
	static int notaHarga[] = new int[100];
	static int notaTotalHarga[] = new int[100];
	static int semuaTotalHarga;
	static int kembali;
	static int nama;
	static int hargaBenda;
	static String namaBenda = "";
	static int total;
	static String ulang;
	
	static void halamanDepan(){
		System.out.println("----------Selamat Berbelanja----------");
		System.out.println("\t\tUWUMART");
		System.out.println("--------------------------------------");
	}
	public static void menu(){
		for (int i=0; i < barang.length; i++){
			System.out.println(barang[i] + "\t = \t" + harga[i]);
		}
	}
	static void penutup (){
		System.out.println("-------Terima Kasih Telah Berbelanja-------");
	}
	static void pesanan(){
			System.out.println("===========================");
			System.out.println("		Pesanan anda: 	   ");
			System.out.println(" ==========================");
	}
	public static void pilihBarang(){
		for (String h = "Y"; h.equals("Y") || h.equals("y");) {
			System.out.print("Pilih Barang Pesanan Anda : ");
			int jenis = input.nextInt();
			for (int i = 0; i < barang.length; i++){
				if (jenis == no[i]){
					hargaBenda = harga [i];
					namaBenda = barang[i];
					h="t";
				}
			}
			if (jenis <= 0 || jenis > 10) {
				System.out.println("Mohon maaf barang tidak tersedia\nharap masukkan kembali pilihan !!");
				System.out.println();
				h = "y";
			}
			
		}
	}
	public static void main(String[] args){
		int ulangi = 0;
		while(ulangSemua){
				System.out.println(ulangi);
				int a;
				int total;
				String ulang;
				
				halamanDepan();
				menu();
				for (String o = "Y";o.equals("Y") || o.equals("y") ; ) {
					pilihBarang();
				
				System.out.print("Masukkan Jumlah Barang : ");
				int jumlah = input.nextInt();
				total = hargaBenda*jumlah;
				System.out.println("total Harga Satuan : " + hargaBenda);
				System.out.println("Harga Seluruh barang : " + total);
				System.out.println();
				
				System.out.print("Apakah anda ingin membeli sesuatu lagi (Y/N) ? : ");
				ulang = input.next();
				notaBarang[ulangi] = namaBenda;
				notaJumlah[ulangi] = jumlah;
				notaHarga[ulangi] = hargaBenda;
				notaTotalHarga[ulangi] = total;
				
				if(ulang.equalsIgnoreCase("Y")){
					o = "Y";
					ulangi++;
					
				} else if (ulang.equalsIgnoreCase("N")){
					ulangSemua = false;
					pesanan();
					
					for(int x = 0; x < ulangi+1;x++){
						System.out.println("nama Barang = " + notaBarang[x] + "\tJumlah Barang = " + notaJumlah[x] + "\tHarga Per Barang = " +notaHarga[x]);
					}
					int semuaTotalHarga = 0;
					for(a = 0; a < notaTotalHarga.length; a++)
						semuaTotalHarga += notaTotalHarga[a];
						System.out.println("Total Harga Barang = " + semuaTotalHarga);
						System.out.print("Uang Anda: ");
						int bayar = input.nextInt();
						System.out.println("");
					if (bayar < semuaTotalHarga){
						System.out.println("Uang anda kurang silahkan Tambah pembayaran lagi: ");
						bayar = input.nextInt();
					}
					kembali = bayar - semuaTotalHarga;
					System.out.println("Anda Membayarkan = " +bayar);
					if (bayar == total || bayar > total){
						System.out.println("Kembalian Anda = " + kembali);
					} else if(bayar < total){
						System.out.println("Uang Anda Kurang");
					} penutup();
					}
					}
					ulangSemua = false;
				}
				
			}
		}