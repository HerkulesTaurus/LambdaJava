package javaLambda;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lambda05 {

	public static void main(String[] args) {
		
		System.out.println(topla(10));
		System.out.println("*****");
		System.out.println(topla1(10));
		System.out.println("*****");
		System.out.println(topla2(10));
		System.out.println("*****");
		System.out.println(toplaCift(10));
		System.out.println("*****");
		System.out.println(toplaCift1(10));
		System.out.println("*****");
		System.out.println(toplaIlkCift(10));
		System.out.println("*****");
		System.out.println(toplaIlkTek(10)); 
		System.out.println("*****");
		ikiIlkXKuvvet(7);
		System.out.println("*****");
		istenenSayiXKuvvet(2, 3);
		istenenSayiXKuvvet(3, 4);
		istenenSayiXKuvvet(5, 6);
		istenenSayiXKuvvet(5, 3);
		istenenSayiXKuvvet(1, 100);
		System.out.println("*****");
		System.out.println(istenenSayininXinciKuvvet(3, 4));
		System.out.println("*****");
		System.out.println(istenenSayininXinciKuvvet(5, 7));
		System.out.println("*****");
		System.err.println(istenenSayininFaktoryeli(12));

		

	}	
		//TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program yaziniz.
		// structured programıng
		public static int topla(int x) {
			
			int toplam =0;
			
			for (int i = 0; i <= x; i++) {
			
				toplam += i;	
			}
			return toplam;
		
		}
		//functional Programming
		public static int topla1(int x) {
			
			return IntStream.range(1, 1+x). //1 2 3 .... x  elemanlarının akısı       //range==> aralık takı  // 1 dahil x+1==> haric
					sum();
		}
		// 3.yontem
		public static int topla2(int x) {
			
			return IntStream.rangeClosed(1, x). // 1 2 3 ...x    x ==>dahil 
					sum();
		}
		
		//TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program yaziniz
			
		
		public static int toplaCift(int x) {
			
			return IntStream.rangeClosed(1, x). // 1 2 3 ...x elemanlarının akısı
					filter(Lambda01::ciftBul).  // 2 4 6 ... eleman akısı  	
					sum();						// 30  ==> 10 a kadar cıft sayıların toplamı
		}
		
		public static int toplaCift1(int x) {

		return IntStream.
					iterate(2, t->t+2).  //iterate: yineleme
							limit(x).	// limit ==> x e kadar gıtsın sonsuza kadar gıtmesın dıye  x/2 yaparsak 30 buluruz
								sum(); //110 ilk on cıft sayının toplamı		
		}
		

		//TASK 03 --> Ilk x pozitif cift sayiyi toplayan program yaziniz
		
		public static int toplaIlkCift(int x) {

			return IntStream.iterate(2, t->t+2).limit(x).sum(); // 2 4 6 8 10 12 14 16 18 20 toplam 110
		}
		

		//TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi yaziniz
		
		public static int toplaIlkTek(int x) {

			return IntStream.iterate(1, t->t+2). 
						limit(x). // akıstakı ılk x elemanı verır
							sum(); //1 3 5 7 9 11 15 17 19 toplam 100
		
		}
		
		
		//TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi yaziniz-->2 4 8 16...ilk 4 kuvvet

		public static void ikiIlkXKuvvet(int x) {

			 IntStream.iterate(2, t->t*2).//2 4 8 16 32 x elemanlarının akısı
								limit(x).       // akıstakı ilk x elemanı verır 
									forEach(Lambda01::printEl);     //akıstakı ılk x elemanı toplar 
			 							//	2 4 8 16 32 64 128 
		}
		
		
		//TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi yaziniz
				
		public static void istenenSayiXKuvvet(int a, int x) { 

			 IntStream.iterate(a, t->t*a).// a a^2 a^3 a^4...x elemanlarının akısı
			 			limit(x).			// akıstakı ilk x elemanı verır 
			 				forEach(Lambda01::printEl);
			 		
		}

		//TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi yaziniz

		
		public static int istenenSayininFaktoryeli(int x) { 

			return IntStream.rangeClosed(1, x).reduce(1, (t,u)->t*u);	

		
		}
			
		//TASK 08 --> Istenilen bir sayinin x kuvvetini ekrana yazdiran programi yaziniz

		public static int istenenSayininXinciKuvvet(int a, int x) { 

		return	 IntStream.iterate(a, t->t*a).// a a^2 a^3 a^4...x elemanlarının akısı
			 			limit(x).			// akıstakı ilk x elemanı verır 
			 				reduce(0, (t,u)->u);		// skip(x-1); de calısır, skip ten sonra cıkan elemanları tolist ile yazdırılmalı
		
		}
		
		
		
		
		
		
		
		
		
		
}


