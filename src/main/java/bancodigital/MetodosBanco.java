package bancodigital;

import java.util.concurrent.ThreadLocalRandom;

public class MetodosBanco {

	public static long numeroConta() {
		
		return metodoNumeroConta();
	
	}
	
	private static long metodoNumeroConta() {
			
		long numero;
		
		return numero = ThreadLocalRandom.current().nextLong(100000000L, 999999999L);
	}
	
}
