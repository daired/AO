package hk.htw.ao.function;

import java.math.BigInteger;

import hk.htw.ao.function.abs.FunctionThread;
import hk.htw.ao.util.OptimizedRandom;

public class RabinMiller extends FunctionThread {

	private final static OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	private boolean res;

	public RabinMiller(String[] values) {
		super(values);
		this.functiontask = new FunctionTask() {

			// Triggered by this.runThread() - defined in abstract FunctionThread
			// Input values, call function(s) and set result
			protected Object call() throws Exception {
				BigInteger n = new BigInteger(parameter[0]);
				return res = rabinMiller(n);
				

		    }
		};
	}

	public boolean getRes() {
		return res;
	}

	
	/**
	 * Ackermann Function (BigInt implementation)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static boolean rabinMiller(BigInteger n){
		
		if(n.compareTo(new BigInteger("3")) >= 0 
				&& n.mod(new BigInteger("2")).equals(BigInteger.ONE)){
		
			BigInteger s = n.subtract(BigInteger.ONE);
			BigInteger t = BigInteger.ZERO;
			
			while(s.mod(new BigInteger("2")).equals(BigInteger.ZERO)){
				s = s.divide(new BigInteger("2"));
				t = t.add(BigInteger.ONE);
			}
			
			for(int k = 0; k < 128; k+=2){
				BigInteger a = RANDOM.generatePositiveRandomByBitLength(1000);
				BigInteger v = ModPow.modPow(a, s, n);
				
				if(!v.equals(BigInteger.ONE)){
					BigInteger i = BigInteger.ZERO;
	
					
					while(!v.equals(n.subtract(BigInteger.ONE))){
						if(i.equals(t.subtract(BigInteger.ONE)))
							return false;
						else{
							v = ModPow.modPow(v, new BigInteger("2"), n);
							i = i.add(BigInteger.ONE);
						}
						
						
					}
				}

			}
			return true;
		}
		else{
			return false;

		}
	}
	


}
