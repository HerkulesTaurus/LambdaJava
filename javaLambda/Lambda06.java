package javaLambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lambda06 {

	public static void main(String[] args) throws IOException {
	
		//TASK 01 --> haluk.txt dosyasini okuyunuz.(Console'a yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini okuyunuz -->  ");
        										 //"src/lambda/haluk.txt"
        Files.
        	lines(Paths.get("src/haluk.txt")). // file erisip file satırları akıs alındı
        		forEach(System.out::println);
        
	 
        //TASK 02 --> haluk.txt dosyasini buyuk harflerle okuyunuz.(Console'a buyuk harflerle yazdiriniz)
        System.out.println("\n*** haluk.txt dosyasini buyuk harflerle okuyunuz -->  ");
        
        Files.
        	lines(Paths.get("src/haluk.txt")). // file erisip file satırları akıs alındı
    			map(String::toUpperCase).
    				forEach(System.out::println); // akıstadı satırların buyuk harf ile update edıldı
        
      
        
        //TASK 03 --> haluk.txt dosyasindaki ilk satiri kucuk harflerle yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki ilk satiri kucuk harflerle okuyunuz 01 -->  ");
        
        Files.
    		lines(Paths.get("src/haluk.txt")). // file erisip file satırları akıs alındı
    			limit(1).						// ilksatır alında
    				map(String::toLowerCase). 	// kucuk harfe cevrıldı
    					forEach(System.out::println); // akıstadı satırların buyuk harf ile update edıldı
        
        
        
        
        //TASK 04 --> haluk.txt dosyasinda "basari" kelimesinin kac satirda gectiginiz yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        
        System.out.println( Files.
			lines(Paths.get("src/haluk.txt")). // file erisip file satırları akıs alındı
				filter(t->t.contains("basari")).						// basari ları filtreledi
					count()); // sayıyor   ==> 1 defa gecıyor 
						
        
        //TASK 05 --> haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki farkli kelimeleri  yazdiriniz. -->  ");
        
      System.out.println(Files.
			lines(Paths.get("src/haluk.txt")).       // file erisip file satırları akıs alındı
					map(t->t.split(" ")).		     // " " gore satırlardakı elemanları parcalayıp array a atadı
							flatMap(Arrays::stream). // Arrays classından stream() ile array elemanlarından yenı bır akıs olusturdu
										distinct().  // yenı akıstakı array elemaları tekrarsız hale getırıldı
										 	collect(Collectors.toList()));	// yenı akıstakı array tekrarsız elemanları liste atandı		
						
        //TASK 06 --> haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz.
        System.out.println("\n*** haluk.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        
        
        
        
        
        
        //TASK 07 --> haluk.txt dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız yaziniz.
        System.out.println("\n*** haluk.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        
        
        
        
        
        
        //TASK 08 --> haluk.txt dosyasinda "a" harfi gecen kelimelerin sayisini ekrana yazdiran programi yaziniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        
        
        
        
        
        
        //TASK 09 --> haluk.txt dosyasinda icinde "a" harfi gecen kelimeleri yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        
        
        
        
        
        
        //TASK 10 --> haluk.txt dosyasinda kac /farklı harf kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        
        
        
        
        
        
        
        
        //TASK 11 --> haluk.txt dosyasinda kac farkli kelime kullanildigini yazdiriniz
        System.out.println("\n*** haluk.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
	}

}
