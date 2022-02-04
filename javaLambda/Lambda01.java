package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Lambda01 {

	public static void main(String[] args) {
		/*
		 * 1) Lambda "Functional Programming" "Functional Programming" de
		 * "Nasil yaparim?" degil "Ne yaparim?" dusunulur. 2) "Structured Programming"
		 * de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur 3)
		 * "Functional Programming" hiz, code kisaligi, code okunabilirligi ve hatasiz
		 * code yazma acilarindan cok faydalidir. 4) Lambda sadece
		 * collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak
		 * map'lerde kullanılmaz. Lambda kullanmak hatasız code kullanmaktır.
		 */

		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 34, 22, 60, 42, 55));
		prinElSStructured(list); // method call yaptık                       ********************** 1.yontem
		System.out.println();
		System.out.println(" **** ");
		
		printElfunctional(list); // asagıda yazdıgımız method u call yaptık************************2.yontem
		System.out.println();
		System.out.println(" **** ");
		
		printElfunctional1(list); // method reference-->alttaki method u refere ettık yazdırdık****3.yontem
		System.out.println();
		System.out.println(" **** ");
		
		printCiftElStructured(list);//12 34 22 60 42 
		System.out.println();
		System.out.println(" **** ");
		
		printCiftElFunctional1(list);//12 34 22 60 42 
		System.out.println();
		System.out.println(" **** ");
		
		printCiftElFunctional2(list);//12 34 22 60 42
		System.out.println();
		System.out.println(" **** ");
		
		printCiftAltmisKucuk(list);//12 34 22 42 
		System.out.println();
		System.out.println(" **** ");
		
		printTekYirmiAlti(list);//13 65 3 34 22 60 42 55 
		System.out.println();
		System.out.println("  **** ");
		
		ciftKarePrint(list);//144 1156 484 3600 1764 
		System.out.println();
		System.out.println("  **** ");
		
		KupBirFazlaTekFunction(list);//2198 274626 28 166376 
		System.out.println();
		System.out.println("  **** ");
		
		KareKokCiftFunction(list);
		System.out.println();
		System.out.println("  **** ");
		
		maxElFunction(list);
		

	}

	// structured Programming ile list elemanlarının tamamını aralarında bosluk
	// bırakarak yazdırın
	public static void prinElSStructured(List<Integer> list) {// 12 13 65 3 34 22 60 42 method olusturduk
		for (Integer w : list) {
			System.out.print(w + " ");
		}
//*******foreach de list yatay (12, 13, 65, 3, 34, 22, 60, 42, 55)
		// functional programming ile list elemaanlarının tamamını aralarına bosluk
		// bırakarak yazdırın.

	}

	public static void printElfunctional(List<Integer> list) { // yukardakı for yerıne sadece bu satır yeterlı oluyor
		list.stream().forEach(t -> System.out.print(t + " ")); // Lambda Expression
		// stream()   : datalari yukarıdan sagıya akis seklıne getırır
		// for each() : data nın parametresıne gore her bır elemanı isler.
		// t-> : Lambda operatoru
		// Lambda Expression yapisi cok tavisye edilmez daha cok METHOD REFERENCE kullanılır
		
	}
	
	// METHOD REFERENCE --> Kendı create ettıgımız veya java dan aldıgımız method ile
	// ClassName::MethodName -->EZBERLE--> yukardaki classname ve altta olusturdugumuz methodname yazılır
	
	public static void printEl(int t) {// refere edilecek method create edildi
		System.out.print(t+" ");
		
	}
	public static void printElfunctional1(List<Integer>list) {
		list.stream().forEach(Lambda01::printEl); //foreach herbır eleamana method u uygular-->Lambda Methodu 
	//	list stream    for   classname 	methodname   sıralamasıyla yazılır			
//*******stream ise list i diket hale getırıyor [12]
											//  [13]
											//  [65]
											//  [3]
	}
	//Structured Programming ile list elemanlarının cift olanlarını aynı satıra aralarında bosluk bırakarak yazdırın
	
	public static void printCiftElStructured(List<Integer>list) {
		for(Integer w:list) {
			if (w%2==0) {
				System.out.print(w+" "); //12 34 22 60 42 
			}
		}
		
	}
	//Structured Programming ile list elemanlarının cift olanlarını aynı satırda arlarında bosluk bırakarak yazınız
	public static void printCiftElFunctional1(List<Integer>list) {
		list.stream().filter(t-> t % 2 ==0).forEach(Lambda01::printEl);//modulus yaptık (t->t%2==0)
												// method reference yaptık
	
	// filter()--> akis icerisindeki elemaları istenen sarta gore filtreleme yapar
	
	}
	public static boolean ciftBul(int i) { // refere edılecek tohum method create edıldı, heryerden hazır cagıracagız
		
		return i%2==0; 
		
	}
	public static void printCiftElFunctional2(List<Integer>list) {
		list.stream().filter(Lambda01::ciftBul).forEach(Lambda01::printEl); // iki tane methıd refere ettik 
	// filter()--> akis icerisindeki elemaları istenen sarta gore filtreleme yapar
	
	
	}
	// Functıonal programmıng ile list elemanlarının cıft/60 dan kucuk olanlarını aynı satırda arlarında bosluk olarak yazdır
	public static void printCiftAltmisKucuk(List<Integer>list) {
		list.stream().filter(t->t%2==0 & t<60).forEach(Lambda01::printEl);
		
	}
	//  Functıonal programmıng ile list elemanlarının tek veya 20 den buyuk olanlarını aynı satırda aralarında bosluk olarak yazdı
	public static void printTekYirmiAlti(List<Integer>list) {
		list.stream().filter(t->t%2==1 || t>20).forEach(Lambda01::printEl);
		
	}
	//  Functıonal Programmıng ile list elemanlarının cift olanlarının karelerini aynı satırda aralarında bosluk birakarak yazdı

	public static void ciftKarePrint(List<Integer>list) { //map update /isleme tabi tutulması ıcın kullanılır
		list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);;
		//              ustte cıft bul cagırdık  kare al     foreach yazdırma 
		//map()--> genellikle matematık ıslemlerınde kullanılır bolme carpma cıkarma kare yazdırma

	}
	// Functional Programming ile list elemanlarinin  cift olanlarinin
	// karelerini ayni satirda aralarina bosluk birakarak yazdiriniz
	// public static void ciftKarePrint(List<Integer> list){
	// list.stream().filter(Lambda01::ciftBul).map(t->t*t).forEach(Lambda01::printEl);
	// map()--> bir ara islemde kullanilir.elemanları istenen isleme gore degistirmek update etmek icin kullanilir.

	
	//  Functıonal Programming ile list elemanlarının tek olanlarının kuplerinin bir fazlasını aynı satırda aralarında bosluk birakarak yazdı

	public static void KupBirFazlaTekFunction(List<Integer>list) {
		
		list.   //bu sekılde yazmak conventıon a uygun
			stream().
			filter(t->t%2==1).
			map(t->(t*t*t)+1).
			forEach(Lambda01::printEl);
	
	}
	//  Functıonal Programming ile list elemanlarının cift olanlarının karekoklerini aynı satırda aralarında bosluk birakarak yazdı
	
	public static void KareKokCiftFunction(List<Integer>list) { //(Math::sqrt) karekok unu alır
		list.stream().filter(Lambda01::ciftBul).map(Math::sqrt).forEach(t->System.out.println(t+" "));//3.4641016151377544, 5.830951894845301

	}
	
	//List ın en buyuk elemanını yazdırınız
	
	public static void maxElFunction(List<Integer>list) {
	
	Optional<Integer> maxEl = list.stream().reduce(Math::max); //max kutuphanedekı hazır en buyugu bulma 
	//list i  maxEl e esitledik optional<ınteger> --> optıonal generık bır class dır
	System.out.println(maxEl);// Optional[65]
//reduce()-->azaltmak... bır cok data yı tek bır data ya(max/min/carp/topla) dusurmek ıcın kullanılır 
	
	}

	
}

