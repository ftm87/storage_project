package storageProject;

import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    public static ArrayList<Product> urunlistesi = new ArrayList<>();
    public static int idSayac = 1000;

    public void start() {


        Scanner scanner = new Scanner(System.in);

        boolean dongu = true;
        // Ana menuyu yazdiran metot
        while (dongu) {
            System.out.println("\n====== Depo Yönetim Sistemi ======");
            System.out.println("1. Ürün Tanımlama");
            System.out.println("2. Ürün Listeleme");
            System.out.println("3. Ürün Girişi");
            System.out.println("4. Ürünü Rafa Koyma");
            System.out.println("5. Ürün Çıkışı");
            System.out.println("6. Çıkış");
            System.out.print("Lütfen bir işlem seçiniz: ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    urunTanimlama();
                    break;
                case 2:
                    urunListele();
                    break;
                case 3:
                    urunGirisi();
                    break;
                case 4:
                    urunuRafaKoy();
                    break;
                case 5:
                    urunCikisi();
                    break;
                case 6:
                    System.out.println("Sistemden çıkılıyor...");
                    dongu = false;
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.");
                    break;
            }
        }

    }


    public static void urunTanimlama() {
        System.out.println("Ürün Tanımlama işlemi seçildi.");
        Scanner input = new Scanner(System.in);
        System.out.println("Ürün Ismi : ");
        String productName = input.nextLine();
        System.out.println("Üretici : ");
        String manufacturer = input.nextLine();
        System.out.println("Birim : ");
        String unit = input.nextLine();

        Product yeniUrun = new Product(idSayac++,productName, manufacturer, unit); //idsayac ekle
        urunlistesi.add(yeniUrun); //Arraylistte urunu listeye ekledik.


        System.out.println("Tanımlanan Ürün: " + productName);

    }

    public static void urunListele() {
        System.out.println("Ürün Listeleme işlemi seçildi.");
        System.out.println("\n----------Urun Listesi -------");

        for (Product product : urunlistesi) {
             System.out.println(" id:  " + product.id + "  isim:  " + product.name + " uretici:  " + product.manufacturer
                    + " miktar : " + product.quantity
                    + " birim : " + product.unit + "  raf :  " + product.shelf);

        }

          System.out.println("id \n productName \n manifacturer \n quantity\n unit\n shelf");


    }

    public static void urunGirisi() {
        System.out.println("Ürün Girişi işlemi seçildi.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ürün id: ");
        int id = scanner.nextInt();
        System.out.print("Ürün girişi miktarı: ");
        int miktar = scanner.nextInt();

        for (Product product : urunlistesi) {
            if (product.id == id) {
                product.quantity += miktar; // burasi miktari artirir
                System.out.println("Urun girisi yapildi");
                return;
            }
        }
        System.out.println("urun bulunamadi");

    }

    public static void urunuRafaKoy() {
        System.out.println("Ürünü Rafa Koyma işlemi seçildi.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Urun ID sini giriniz: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Raf numarasi giriniz: ");
        String raf = scanner.nextLine();

        for (Product product : urunlistesi) {
            if (product.id == id) {
                product.shelf = raf;
                System.out.println("Ürün başarıyla rafa yerleştirildi.");
                return;
            }
        }
        System.out.println("Bu ID ile eşleşen ürün bulunamadı.");

    }

    public static void urunCikisi() {
        System.out.println("Ürün Çıkışı işlemi seçildi.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Urun id numarasi giriniz");
        int id = scanner.nextInt();
        System.out.println("urun cikis miktari giriniz");
        int quantity = scanner.nextInt();

        for (Product product : urunlistesi) {
            if (product.id == id) {
                if (product.quantity < quantity) {
                    System.out.println("Yetersiz stok");
                } else {
                    product.quantity -= quantity;
                    System.out.println("Urun cikisi yapildi");
                }
                return;
            }
            System.out.println("Urun bulunamadi");
        }
    }


}