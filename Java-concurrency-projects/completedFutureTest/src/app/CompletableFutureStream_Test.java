package app;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class CompletableFutureStream_Test {

	 
	public static void main(String[] args) {
		try {
			List<Integer> list = Arrays.asList(5, 9, 14,19,23);

			 

			 list.stream().map(num->CompletableFuture.supplyAsync(()->getNumber(num))).map(CompletableFuture->CompletableFuture.thenApply(n->n*n)).map(t->t.join()).forEach(s->System.out.println(s));

			/*Stream data = list.stream().map(num -> CompletableFuture.supplyAsync(() -> getNumber(num)));

			data.map(CompletableFuture -> ((CompletableFuture) CompletableFuture).thenApply(n -> n * n)).map(t -> t.join())
					.forEach(s -> System.out.println(s));
					
            */
			 
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int getNumber(int a) {
		return a * a;
	}

}
