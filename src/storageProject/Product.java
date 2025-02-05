package storageProject;
/*
	 * basit bir depo projesi
	 *
	 * Calisan bir fabrikada uygulanan bir sistem olan depo uygulamasidir.
	 *
	 * 1-) burada oncelikle urunun tanimlamasi  yapilir. id urunIsmi uretici miktar birim ve raf (6 adet fields mevcut)
	 *
	 * 2-) methodlar olusturacagiz.
	 * 		urunTanimlama 	==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak.
	 *
	 * 		urunListele 	==> tanimlanan urunler listelenecek. urunun adeti ve raf numarasi tanimlama yapilmadiysa default deger gorunsun.
	 *
	 * 		urunGirisi 		==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.
	 *
	 * 		urunuRafaKoy 	==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz.
	 *
	 *		urunCikisi 		==> listeden urunu sececegiz ve urunun cikis yapcagiz. burada urun listesinden sadece miktarda degisiklik yapilacak.
	 *							urun adedi 0dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.
	 * 		===> yaptigimiz tum degisiklikler listede de gorunsun.
	 *
	 *
	 * 			id		ismi 	ureticisi	miktari		birimi		raf
	 * 		---------------------------------------------------------------
	 * 		or: 1000	 un 	hekimoglu	0 			cuval 		null
	 *
	 * 		urunGirisi		==> id:1000  urun girisi :5
	 * 		urunListele 	==>
	 *
	 * 			id		ismi 	ureticisi	miktari		birimi		raf
	 * 		---------------------------------------------------------------
	 * 		or: 1000	 un 	hekimoglu	5 			cuval 		null
	 *
	 * 		urunuRafaKoy 	==> id:1000 raf : raf1
	 * 		urunListele 	==>
	 * 			id		ismi 	ureticisi	miktari		birimi		raf
	 * 		---------------------------------------------------------------
	 * 		or: 1000	 un 	hekimoglu	5 			cuval 		raf1
	 *
	 * 		urunCikisi 		==> id 1000: urun cikis : 3 (kalan 2 cuval un)
	 * 		urunListele 	==>
	 * 			id		ismi 	ureticisi	miktari		birimi		raf
	 * 		---------------------------------------------------------------
	 * 		or: 1000	 un 	hekimoglu	2 			cuval 		raf1
	 */


public class Product {

	public int id;
	public String name;  // urun adi
	public String manufacturer;// uretici
	public int quantity = 0;      //adet
	public String unit;       //birim
	public String shelf = null;//raf

	public Product(int id, String name, String manufacturer,String unit) {
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", manufacturer='" + manufacturer + '\'' +
				", unit='" + unit + '\'' +

				'}';
	}
}
