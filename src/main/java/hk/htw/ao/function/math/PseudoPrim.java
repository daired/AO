package hk.htw.ao.function.math;
import java.math.BigInteger;
import hk.htw.ao.util.OptimizedRandom;


public class PseudoPrim {

	protected final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	protected final BigInteger TWO = new BigInteger("2");
	protected final BigInteger ONE = new BigInteger("1");
	protected final BigInteger ZERO = new BigInteger("0");
	
	public PseudoPrim() {
	}

	public static void main(String[] args) {
		PseudoPrim primer = new PseudoPrim();
		primer.run(1);
	}

	private void run(int runlength) {
		BigInteger n = RANDOM.generatePositiveRandomByBitLength(8);
		boolean testedPseudoPrime = isPseudoPrime(n);
		if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
		else{      			  System.out.println(n + " is not pseudoprime");}
	    int i = 1;
		while(!testedPseudoPrime /*i<length*/){
			n = RANDOM.generatePositiveRandomByBitLength(8);
			testedPseudoPrime = isPseudoPrime(n);
			if(testedPseudoPrime) System.out.println(n + " is pseudoprime");
			else{      			  System.out.println(n + " is not pseudoprime");}
			i++;
		}
		
		
	}


	private boolean isPseudoPrime(BigInteger n) {;
		
		if( !(n.compareTo( TWO ) > 0) || !(n.mod( TWO ).compareTo( ONE ) == 0) ){
			return false;
		}
		BigInteger s =  n.subtract( ONE );
		BigInteger t =  new BigInteger("0");
		 
		while(s.mod( TWO ).compareTo( ZERO ) == 0){
			s = s.divide(TWO);
			t = t.add( ONE );
		}
		
		int k = 0;
		while(k<128){
			
			BigInteger a = RANDOM.generatePositiveRandomByBitLength(8);
			
			while (  !(a.compareTo( ONE ) > 0) || !(a.compareTo(n) < 0) ){
				a = RANDOM.generatePositiveRandomByBitLength(8);
			}
			BigInteger v = a.modPow(s, n);
			
			if( !(v.compareTo(ONE) == 0) ){
				BigInteger i = ZERO;
				while( !(v.compareTo(n.subtract(ONE)) == 0) ){
					if(i.compareTo(n.subtract(ONE)) == 0) return false;
					else{
						v = v.modPow(TWO, n);
						i = i.add(ONE);
					}
				}
			}
			
			k += 2;
			System.out.println("k up to : " + k);
		}
		
		return true;
		
	}

}
