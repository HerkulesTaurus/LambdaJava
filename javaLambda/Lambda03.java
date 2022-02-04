package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>(
				Arrays.asList("mehmet", "emre", "nilgun", "yildiz", "kader", "emine", "islam", "islam", "abuzitttinnn"));

		bykHarfTekrarsizSira(list);	
		System.out.println();
		System.out.println("*****");
		karakterSayisiTekrarsizTersSirali(list);
		System.out.println();
		System.out.println("*****");
		karakterSayisiSiraliEl(list);
		System.out.println();
		System.out.println("*****");
		sonHarTersSiraliEl(list);
		System.out.println();
		System.out.println("*****");
		ciftKareTekrarsizTersSira(list);
		System.out.println();
		System.out.println("*****");
		harfSayisi7Kontrol(list);
		System.out.println();
		System.out.println("*****");
		wIleBaslayanKontrol(list);
		System.out.println();
		System.out.println("*****");	
		xIleBitmesi(list);
		System.out.println();
		System.out.println("*****");
		karakterSayisiEnBuyukEl(list);
		System.out.println();
		System.out.println("*****");
		karakteriEnBuyukEl2(list);		
		System.out.println();
		System.out.println("*****");
		ilkElemanHaricSonHarfSirali(list);
		
		
		
	}

	//Soru: list ın elemanlarını alfabetık buyuk harf ve tekrarsız yazdırınız
	
	public static void bykHarfTekrarsizSira(List<String> list) { // tekrarsız distinct
		
		list.
			stream().
				map(t->t.toUpperCase()). // buyuk harf update edıldı
							sorted(). // alfabetık
								distinct(). // tekrarsız
									forEach(System.out::println);// yazdırıldı
		
	}
	
	//Soru: list ın elemanlarının character sayısını ters sıralı olarak tekrarsız yazdırınız
	
	public static void karakterSayisiTekrarsizTersSirali(List<String> list) { 
		
		list.stream().map(t->t.length()).sorted(Comparator.reverseOrder()).distinct().forEach(Lambda01::printEl);//6 5 4 

	}
	// Soru: List elemanlarının characteer sayısına gore kckten buyuge gore yazdırınız 
	
	public static void karakterSayisiSiraliEl(List<String> list) { 

		list.stream().sorted(Comparator.comparing(t->t.toString().length())).forEach(t->System.out.println(t+" "));
	}
	
	// Soru: list elemanlarının son harfıne gore ters sıralı yazdırınız
	public static void sonHarTersSiraliEl(List<String> list) { 
	
		list.
			stream().
				sorted(Comparator.comparing(t->t.toString().
						charAt(t.toString().length()-1)).reversed()).
								forEach(t->System.out.println(t+ " "));
		
	}
	
	// Soru: Listin elemanların karelerının cift sayılı karelerını hesaplayan ve karelerını tekrarsız buyukten kucuge dogru 
	// yazdıran bir program yazınız.

	public static void ciftKareTekrarsizTersSira(List<String> list) { 

	list.stream().
	//filter(t->t.length()%2==2)
		map(t->t.length()).
			filter(Lambda01::ciftBul).distinct().
					sorted(Comparator.reverseOrder()).
						forEach(Lambda01::printEl); //6 4 
	
	}

	// Soru: List elemanlarının karakter sayısını 7 ve 7 den az olma durumunu kotrol edınız
	
	public static void harfSayisi7Kontrol(List<String> list) { 
	
	/*	
	boolean  kontrol = list.stream().allMatch(t->t.length()<=7);
	
	if (kontrol) {
			System.out.println("List elemanları 7 harften buyuk degıl"); //false

	}else {
		System.out.println("agam list elemanları 7 harften buyuk");
	}
	*/
		
	System.out.println(list.stream().allMatch(t->t.length()<=7)? "7 harften buyuk degıl ": "list elemanları 7 harften buyuk");	
		
	}	
	
	// Soru: list elemanlarının "w" ile baslamasını kontrol edınız 
	
	public static void wIleBaslayanKontrol(List<String> list) { 

	System.out.println(list.stream().noneMatch(t->t.startsWith("w"))? "w ile baslayan isim kimse ayaga kalksın":"agam w ıle baslayan isim oluuur");
		
		
	}
	// Soru: list elemanlarının "x" ile biten en az bır elaman kontrol edınız 
	
		public static void xIleBitmesi(List<String> list) { 
			
			System.out.println(list.stream().anyMatch(t->t.endsWith("x"))? "x ile bıten ayaga kalksın":" agam x ile bıten mı olur");
				
		}
		
	// Soru: karakter sayısı en buyuk elemani yazdırınız 
	
		public static void karakterSayisiEnBuyukEl(List<String> list) {
																										  
		System.out.
			println(list.stream().
				sorted(Comparator.
						comparing(t->t.toString().
								length()).
									reversed()).// ters siraladi   b->k
										findFirst());//ilk eleman
										//limit(1));// limit(a) akıstan cıkan elemanları o parametresibe gore ilk a elemanını alır 
		
		}
		//limit()
		public static void karakteriEnBuyukEl2(List<String> list) {
			  
		 Stream<String> sonIsim = list.
				 stream().
					sorted(Comparator.comparing(t->t.toString().
									length()).
										reversed()).// ters siraladi   b->k
											limit(1);// data-dır limit(a) akıstan cıkan elemanları o parametresibe gore ilk a elemanı alır 
		 									// stream den akıs dan gelen 5 elemanı yazmaz onları atamak gerekıyor List yada Array a 
	System.out.println(Arrays.toString(sonIsim.toArray())); // burası Array yazdırma methodudur. sonIsim kısmı da Array e cevrıldı 
	//[abuzitttinnn]										// to list le list e de cevırebılırdık
														
		}
		
		//Soru: list elemanlarını son harfıne gore sıralayıp ilk eleman harıc kalan elemanları yazdırınız 
		
		public static void ilkElemanHaricSonHarfSirali(List<String> list) {

			list.
			stream().
			sorted(Comparator.comparing(t->t.toString().charAt(t.length()-1))).
			skip(1). // akıstan cıkan elemanların 1. parametreyı almadan atlar 
			forEach(System.out::println);	// forEach(t->t System.out.print(t+" ")); dıger yazdırma methodu
		}
		
		
		
		
		
		
}
