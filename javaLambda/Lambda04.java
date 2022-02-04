package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Lambda04 {

	public static void main(String[] args) {
		//burasdakiler  obje*****//
TechPro trGunduz=new TechPro("yaz","TR gunduz", 97, 124); // constructor techpro class dan aldık 
TechPro engGunduz=new TechPro("kis","ENG gunduz", 95, 131); // burda  obje   yaptık
TechPro trGece=new TechPro("bahar","TR gece", 98, 143);      // list e atacaz
TechPro engGece=new TechPro("sonbahar","ENG gece", 93, 151);

		
// techPro clasından baglantı kurduk
		
List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz,engGunduz,trGece,engGece));

// bu class da retunr type calısacagız

System.out.println(	batchOrt92Byk(list));  //true
System.out.println();
System.out.println("********");
System.out.println(ogrSayisi110az(list));
System.out.println(	batchOrt92Byk(list));  //true
System.out.println();
System.out.println("********");
System.out.println(herhangiBirBaharKontrol(list));//true
System.out.println();
System.out.println("********");
System.out.println(ogrSayisiTersSiraliBatch(list));
System.out.println();
System.out.println("********");
System.out.println(batchOrtSiraliBatch(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcSayisiEnAz2Batch(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcOrt95BykOgrcSayisi(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcOrt95BykOgrcSayisi1(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcSayisi130BykBatchOrt(list));
System.out.println();
System.out.println("********");
System.out.println(gunduzBatchSayisi(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcSayisi130FazlaEnBykBatch(list));
System.out.println();
System.out.println("********");
System.out.println(ogrcSayisi150AzEnKckBatch(list));




	}
	
	//Task 01-->batch ort larının 92 den buyuk oldugu kontrol eden pr create edınız
	
	public static boolean batchOrt92Byk(List<TechPro> list) {
		
	return	list.
			stream().
				allMatch(t->t.getBatchOrt()>92); // akıstakı her eleman batchOrt field ına gore eslesmesı kontrol edıldı
	}
	
	//Task 02-->ogrc sayilarının hic birinin 110 dan az olmadıgıni kontrol eden pr create edınız
	
		public static boolean ogrSayisi110az(List<TechPro> list) {
	
		return	list.
					stream().
						noneMatch(t->t.getOgrcSayisi()<110); // noneMatch   //true
						//allMatch(t->t.getOgrcSayisi()>110); usttekının aynısı 
	}	
		
	//Task 03-->batch lerde herhangı bırınde bahar olup olamdıgını kontrol edınz 
		
	public static boolean herhangiBirBaharKontrol(List<TechPro> list) { // return type calıstıgımız ıcın boolean yaptık
	
		return	list.
					stream().
						anyMatch(t->t.getBatch().equals("bahar"));
				
	}
	
	//Task 04-->batch leri ogr sayilarina gore bykten->kcuge siralayiniz
				//List<TechPro> bunu buraya yazdık 
	public static List<TechPro> ogrSayisiTersSiraliBatch(List<TechPro> list) { 
	
	return list.
				stream().
					sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()) // ogrencısayısı parametresıne gore ters sıraladı
					.collect(Collectors.toList());// collect methodu akısdaki elemanları istenen sarta gore toplar
						//toArray yazarsak Array a cevırır													//Collectors.toList() -> collect de toplanan elemanları list e cevirir.
	
	//[TechPro [batch=sonbahar, batchName=ENG gece, batchOrt=93, ogrcSayisi=151], TechPro [batch=bahar, batchName=TR gece, batchOrt=93, ogrcSayisi=143], 
	// TechPro [batch=kis, batchName=ENG gunduz, batchOrt=93, ogrcSayisi=131], TechPro [batch=yaz, batchName=TR gunduz, batchOrt=93, ogrcSayisi=124]]

	}
	
	//Task 05-->batch leri batch ortlamasina gore b->k e siralayip ilk 3 unu yazdırınız
	
	public static List<TechPro> batchOrtSiraliBatch(List<TechPro> list){
	
		return list.
				stream().
					sorted(Comparator.comparing(TechPro::getBatchOrt).// ogrcsayisi parametresıne gore
							reversed()).		
								limit(3). // akıstakı elemanalrın ılk 3 elamanını alır 
									collect(Collectors.toList()); // collect akıstakı elemanları ıstenen sarta gore 
									// collector.tolist() -> collect e toplanan elemanlari list e cevirir
	}
		
	//Task 06-->batchleri ogrc sayisi en az olan 2. batch i yazdırınız 
		
	public static List<TechPro> ogrcSayisiEnAz2Batch(List<TechPro> list){
		
	return list.
			stream().
				sorted(Comparator.comparing(TechPro::getOgrcSayisi)).		
						limit(2). // ilk iki eleman alindi
							skip(1). // ilk eleman atlandı 2. sı alındı
								collect(Collectors.toList()); //[TechPro [batch=kis, batchName=ENG gunduz, batchOrt=95, ogrcSayisi=131]]
								//collect list e gore toplama yapar
	}
			
	//Task 07-->batch ort 95 den buyuk olan batch lerin ogrc sayilarinin toplamini yazdiriniz
			
	public static int ogrcOrt95BykOgrcSayisi(List<TechPro> list){
		
	return	list.stream().filter(t->t.getBatchOrt()>95).map(t->t.getOgrcSayisi()).reduce(0,Integer::sum);//toplamı verır 267
	 																			//reduce(0,/t,u)->t+u) aynı sonucu verır 
	}
	
	public static int ogrcOrt95BykOgrcSayisi1(List<TechPro> list){
		
		return	list.
				stream().
				filter(t->t.getBatchOrt()>95). // 95 den buyuk sartı saglandı
				mapToInt(t->t.getOgrcSayisi()).sum(); //sum lambda methodu =>max =>min var  
																		// mapToInt()--> type gore ınt  return ederkı sum() calısır
														  		        // reduce e gerek kalmaz daha kısa ve hızlı code imkanı saglar
	}
	//Task 08-->ogrc sayilari 130 dan buyuk olan batch lerin batch ortalamalarının ortalamasını bulunuz
	
	public static OptionalDouble ogrcSayisi130BykBatchOrt(List<TechPro> list){
		
	return	list.
			stream().
				filter(t->t.getOgrcSayisi()>130).
					mapToDouble(t->t.getBatchOrt()).
							average();  //OptionalDouble[95.33333333333333]

				
	}
		
	//task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
	
	public static int gunduzBatchSayisi(List<TechPro> list){
		
	return(int)	list.stream().filter(t->t.getBatchName().contains("gunduz")).count();
	
	}
	
	
	
	
	//task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
	
	public static OptionalInt ogrcSayisi130FazlaEnBykBatch(List<TechPro> list){
		
		return  list.stream().filter(t->t.getOgrcSayisi()>130).mapToInt(TechPro::getBatchOrt).max(); //OptionalInt[98]

	
	}
	
	
	 
	//task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz.
		
	public static OptionalInt ogrcSayisi150AzEnKckBatch(List<TechPro> list){
		
		return  list.stream().filter(t->t.getOgrcSayisi()<150).mapToInt(TechPro::getBatchOrt).min(); //OptionalInt[95]
																						//getAsInt();--> cıktıyı ınt type olarak return eder	
	
	}
	
	
	
	
	
}
