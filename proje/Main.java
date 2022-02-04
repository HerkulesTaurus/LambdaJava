package proje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Main {
	
	public static List<Ogrenci> ogListesi=new ArrayList<>();

	public static void main(String[] args) {
		
		ogrenciListesi();
		notaGoreSirala(30, 90);
		yasaGoreSirala();
		yasaVeCinsiyeteGore(30, "kadin");
		ismeGoreSirala("Ahmet");
		soyİsmeGoreSirala("Can");
		ortHesaplama();
		
	}
	// reduce methoduyla ort hesaplama 
    private static double ortHesaplama() {
	double toplam= ogListesi.stream().mapToDouble(Ogrenci::getDiplomaNotu).reduce(0.0,Double::sum);
	return toplam/ogListesi.size();
	
    	
	}

	// Öğrencileri soyisimlerine göre yazdırin
    private static void soyİsmeGoreSirala(String soyAd) {
    	
    	ogListesi.
    		stream().
    			filter(t->t.getSoyAd().equalsIgnoreCase(soyAd)).
						collect(Collectors.toList());

    	
    	
    	System.out.println("************************************************************************");
	}


	// Öğrencileri isimlerine göre yazdırın
    private static void ismeGoreSirala(String isim) {

    	ogListesi.
    			stream().
    					filter(t->t.getAd().equalsIgnoreCase(isim)).
    							collect(Collectors.toList());
    	
    	System.out.println("************************************************************************");    	
	}



	// Öğrencileri belirli bir yaşa ve cinsiyete göre sıralayarak listeleyin
    private static void yasaVeCinsiyeteGore(int yas, String cinsiyet) {
    	
    	ogListesi.
    		stream().
    			filter(t->t.getYas()< yas ).
    				filter(t->t.getCinsiyet().
    							equalsIgnoreCase(cinsiyet)).
    									sorted(Comparator.comparing(Ogrenci::getYas)).
    										forEach(System.out::println);
    	
System.out.println("************************************************************************");
    	
	}


	// Öğrencileri yaşlarına göre  ters sıralayarak yazdirin
    private static void yasaGoreSirala() {
    	
    	ogListesi.
    		stream().
    			sorted(Comparator.comparing(Ogrenci::getYas).reversed()).
    				forEach(System.out::println);
    	
    	System.out.println("************************************************************************");

	}
    
    
    
	// Öğrenci notlarını alt ve üst limitlere göre sıralayarak  yazdirin

	private static void notaGoreSirala(double i, double j) {
		 		
		ogListesi.
			stream().
				filter(t->t.getDiplomaNotu()>i && t.getDiplomaNotu()<j).
							forEach(t->System.out.println(t.toString()));
		System.out.println("************************************************************************");

	}

	private static void ogrenciListesi() {

		ogListesi.add(new Ogrenci("Ahmet", "Can",   30, 95.5, "erkek"));
		ogListesi.add(new Ogrenci("Ahmet", "Yarba", 25, 90.5, "erkek"));
		ogListesi.add(new Ogrenci("Ayse", "Can",    21, 82.5, "kadin"));
		ogListesi.add(new Ogrenci("Merve", "Aslan", 30, 98.8, "kadin"));
		ogListesi.add(new Ogrenci("Veli", "Han",    80, 35.5, "erkek"));
		ogListesi.add(new Ogrenci("Funda", "Funda", 24, 99.2, "kadin"));
		
	}

	
	
	
	
}
