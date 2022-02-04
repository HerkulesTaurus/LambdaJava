package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
		ciftKareMax(list);
		System.out.println();
		System.out.println("*****");
		
		toplaEl1(list);
		System.out.println();
		System.out.println("*****");
		
		toplaEl2(list);
		System.out.println();
		System.out.println("*****");
		
		carpCiftEl1(list);
		System.out.println();
		System.out.println("*****");
		
		carpCiftEl2(list);
		System.out.println();
		System.out.println("*****");
		
		min1(list);
		System.out.println();
		System.out.println("*****");
		
		min2(list);
		System.out.println();
		System.out.println("*****");
		
		min3(list);
		System.out.println();
		System.out.println("*****");
		
		min4(list);
		System.out.println();
		System.out.println("*****");

		onBestenBykKckSayi(list);
		System.out.println();
		System.out.println("*****");


		ciftElKareByktnKck(list);
		System.out.println();
		System.out.println("*****");
		
		tekKareBykKck(list);
		System.out.println();
		System.out.println("*****");
		
		
		
		
		
	}
	// listteki cift olan elemanların karelerını alınız ve en buyugunu yazdırınız
	
	public static void ciftKareMax(List<Integer> list) {
	
	//Optional<Integer> maxEl =  list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
	// int maxEl = list.stream().filter(Lambda01::ciftBul).map(t->t*t).reduce(Integer::max);
	Optional<Integer> maxEl =  list.stream().filter(Lambda01::ciftBul).map(t-> t * t).reduce(Math::max);
	// Math max da kullanılabılır ama daha genıs calıstıgı ıcın tavsıye edılmez daha dar calısmak daha makul. ınteger daha hızlı calısır
	//reduce() return edılen elamanın null yada ınt den buyuk olur ıhtımalı ıcınm java guvenlık olarak hadle ederek  optıonal class a sart kosuyor
	// maxEl.sout deyınce yazdırır
	
	System.out.println(maxEl);
	
}
	//List deki tum elemanların toplamını yazdırınız
	//Lambda Expression
	
	public static void toplaEl1(List<Integer> list) {
	int	toplam = list.stream().reduce(0,(x,y)->x+y);
	
	/* 
	 *x her zaman ilk degerını atanan degerden (0) alır. 	
	 * y her zaman degerını list.stream() den alır. (akis)
	 * x ilk degerden sonrakı degerlerını islemden alır
	 *  x		 y
	 *  0		 5
	 *  5		-8
	 * -3		13
	 *  10		24 degerlerını sırayla alır 
	 * 
	 */
	
	System.out.println(toplam);
	// System.out.println(list.stream().reduce(0,(x,y)->x+y)); bu sekılde de yazılabılırdı 
	}
	// list dekı tum elemanların toplamını yazınız
	// method reference...
	
	public static void toplaEl2(List<Integer> list) { //spesifik kucuk yapılar hızlı calısır 
											    	//(Math::addExact);
	Optional<Integer> toplam = list.stream().reduce(Integer::sum);// method reference yaptık ustte yaptıgımız ıslemı burda sum la yaptık

	System.out.println(toplam);//Optional[137]

		
	}
	
	// list deki cift  elemanların carpımını yazdırın 
	// method Reference...
	// reduce--> coklu elemanları carpma/bolme gıbı ıslemler ıcın azaltmaya yarar eleman azaltma 
	
	public static void carpCiftEl1(List<Integer> list) {
		
	Optional<Integer> carp = list.stream().filter(Lambda01::ciftBul).reduce(Math::multiplyExact);  //multiplyExact carpma islemi icic
	// ınteger olamayan durumlarda optıonal a alır. verı buyuklugu yada guvenlıgı ıcın 
	
	System.out.println(carp); //Optional[-22619520]

		
	}
	
	// list deki cift  elemanların carpımını yazdırın 
	// Lambda Expression...  //expression tavsıye edılmez method referance tavsıye edılır
	
	public static void carpCiftEl2(List<Integer> list) {

	Integer carp = list.stream().filter(Lambda01::ciftBul).reduce( 1, (x,y)->(x*y));
	// pozitif deger uretiniz
	Integer carpPoz = list.stream().filter(Lambda01::ciftBul).reduce( -1, (x,y)->(x*y));
	
	System.out.println(carp); //-22619520
	
	System.out.println(carpPoz); //22619520
	
	}
	// List'tekı elemanlardan en kucugunu 4 farklı yontem ıle yazdırınız
	
	//1. yontem Method Referance
	
		public static void min1(List<Integer> list) {
		
		Optional<Integer>min=list.stream().reduce(Integer::min); //Optional[-60]
	
		System.out.println(min);
	
	}

	//2. yontem Method Referance-->Math class
	
		public static void min2(List<Integer> list) {
			
		Optional<Integer>min=list.stream().reduce(Math::min);
		
		System.out.println(min); //Optional[-60]
	}
		
	//3. yontem Method Referance-->Haluk class
		
		public static int minBul(int x, int y) {
			return x<y ?  x:y; // ternary  x kucuktur y ise x i ver degılse y yı ver demektır 
					
		}
			
		public static void min3(List<Integer> list) {
					
		Optional<Integer>min=list.stream().reduce(Lambda02::minBul);
				
		System.out.println(min); //Optional[-60]
		}
	
	//4. yontem Lambda Expression 
		
		public static void min4(List<Integer> list) { 
				
		Integer min = list.stream().reduce(Integer.MAX_VALUE,(x,y)->x<y?x:y);
			
		System.out.println(min); ////-60
	
}
		// List ın 15 den buyuk en kucuk tek sayıyı yazdırın

		public static void onBestenBykKckSayi(List<Integer> list) { 

		// list.stream().filter(t->t % 2 == 1).filter(t-> t>15).reduce(Integer::min);			
		
			System.out.println(list.stream().filter(t->t % 2 == 1 & t>15).reduce(Integer::min));//Optional[65]			
		
		}
		
		// list in cıft elemanlarının karelerı nı buyukten kucuge yazdırın 
		
		public static void ciftElKareByktnKck(List<Integer> list) { 

			list.
				stream().
					filter(Lambda01::ciftBul).
							map(t->t*t).sorted(). //akısa gıren elemanlar natural sıralamaya sokar 
								forEach(Lambda01::printEl);//144 484 1156 1764 3600 // yazdırma 
		}
	

		// list ın tek elemanalarının karelerını buyukten kucuge sıralayınız
		
		public static void tekKareBykKck(List<Integer> list) { 

		list.
			stream().
				filter(t->t%2!=0).
						map(t->t*t).
								sorted(Comparator.reverseOrder()).//akısa gıren elemanlar ters sıralanır 
											forEach(Lambda01::printEl); //4225 225 49 9 9 

		}
		
		
		
		
		
		
		
}