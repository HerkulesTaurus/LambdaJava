package LambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Q03 {

	// String isimlerden olusan bir list olusturun
	// Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
	// Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
	// Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
	// Konsoldaki farklı öğeleri ters sırada yazdırın.
	// Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle
	// yazdırın.

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Lutfullah");
		list.add("Emine");
		list.add("Emine");
		list.add("Yusuf");
		list.add("Seyfullah");
		list.add("Hakan");

		//kosoldakı farklı ogelerı uzunluklarıyla beraber yazıdırın
		list.stream().distinct().sorted().forEach(t -> System.out.println(t + "=" + t.length()));
		System.out.println("******************");
		
		// Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
		list.stream().distinct().sorted(Comparator.comparing(t -> t.lenght())).forEach(t -> System.out.println(t));
		System.out.println("******************");
		
		// Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
		list.stream().distinct().sorted(Comparator.comparing(t -> t.charAt(t.lenght() - 1)))
				.forEach(t -> System.out.println(t));
		System.out.println("******************");
		
		// Konsoldaki farklı öğeleri ters sırada yazdırın.
		list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(t->System.out.println(t));
		System.out.println("******************");
		
		// Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle

		list.
			stream().
				filter(t->t.length()<7).
					distinct().map(t>t.toUpperCase()).
						sorted(Comparator.reverseOrder()).
							forEach(t->System.out.println(t));
		
		
	}

}