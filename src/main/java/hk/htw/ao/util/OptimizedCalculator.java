package hk.htw.ao.util;

import java.math.BigInteger;

public class OptimizedCalculator {

	private final OptimizedRandom RANDOM = OptimizedRandom.getInstance();
	
	/**
	 * Singleton Pattern
	 */
	private static OptimizedCalculator instance;

	private OptimizedCalculator() {
	}

	public static OptimizedCalculator getInstance() {
		if (OptimizedCalculator.instance == null) {
			OptimizedCalculator.instance = new OptimizedCalculator();
		}
		return OptimizedCalculator.instance;
	}

	/**
	 * GCD Mod Methode - rekursive Implementation
	 */
	public BigInteger fibonacci(BigInteger n) {
		return (n.compareTo(new BigInteger("1")) <= 0) ? n
				: fibonacci(n.subtract(BigInteger.ONE)).add(fibonacci(n.subtract(new BigInteger("2"))));
	}

	/**
	 * GCD Mod Methode - optimierte Implementation
	 */
	public BigInteger fibonacci2(BigInteger n) {

		if (n.equals(BigInteger.ZERO))
			return BigInteger.ZERO;
		BigInteger a, b, h;
		a = BigInteger.ZERO;
		b = BigInteger.ONE;

		for (BigInteger i = new BigInteger("2"); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
			h = a;
			a = b;
			b = h.add(b);
		}

		return b;
	}

	/**
	 * GCD Mod Methode - rekursive Implementation
	 */
	public BigInteger gcdMod(BigInteger a, BigInteger b) {
		return b.equals(BigInteger.ZERO) ? a : gcdMod(b, a.mod(b));
	}

	/**
	 * GCD Mod Methode - iterative Implementation
	 */
	public BigInteger gcdMod2(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger tmp = b;
			b = a.mod(b);
			a = tmp;
		}
		return a;
	}

	/**
	 * Ackermann Funktion int
	 */
	public int ackermannFuncInt(int m, int n) {
		// Definiert für m,n >= 0, sonst 0
		if (m >= 0 && n >= 0)
			return m == 0 ? n + 1
					: n == 0 ? ackermannFuncInt(m - 1, 1) : ackermannFuncInt(m - 1, ackermannFuncInt(m, n - 1));
		else
			return 0;
	}

	/**
	 * Ackermann Funktion BigInteger
	 */
	public BigInteger ackermannFunc(BigInteger m, BigInteger n) {
		if (m.compareTo(BigInteger.ZERO) >= 0 && n.compareTo(BigInteger.ZERO) >= 0)
			return m.equals(BigInteger.ZERO) ? n.add(BigInteger.ONE)
					: n.equals(BigInteger.ZERO) ? ackermannFunc(m.subtract(BigInteger.ONE), BigInteger.ONE)
							: ackermannFunc(m.subtract(BigInteger.ONE), ackermannFunc(m, n.subtract(BigInteger.ONE)));
		else
			return BigInteger.ZERO;
	}


	/**
	 * Optional Hausaufgabe 3
	 * @param a
	 * @param n
	 * @return
	 */
	public BigInteger powBig(BigInteger a, BigInteger n){
		// Definiert für a, m,n > 0, sonst -1
				if (a.compareTo(BigInteger.ZERO) > 0 && n.compareTo(BigInteger.ZERO) >= 0) {
					BigInteger res = BigInteger.ONE;
					for (int i = 1; i <= n.bitLength(); i++) {
						BigInteger tmp = a;
						// bitshift from right to left
						if ((n.and(BigInteger.ONE.shiftLeft(i))).equals(BigInteger.ZERO))
							continue;

						for (int j = 0; j < i; j++)
							tmp = tmp.multiply(tmp);
						
						res = res.multiply(tmp); 
					}

					if (!n.and(BigInteger.ONE).equals(BigInteger.ZERO))
						res = res.multiply(a); 

					return res;
				} 
				else
					return new BigInteger("-1");
		
		
	}
	
	
	/**
	 * modulares Potenzieren (a^n mod m)
	 *	a: Basis
	 *	n: Exponent
	 *	m: Modulo
	 *
	 *	int implementation
	 */
	public int potenzModuloInt(int a, int n, int m) {
		// Definiert für a, m,n > 0, sonst -1
		if (a > 0 && m > 0 && n >= 0) {
			// log base 2 für HighestOneBit zur Berechnung der genutzten Bits
			int bitlength = (int) (Math.log((double) Integer.highestOneBit(n)) / Math.log(2.0));
			int res = 1;
			for (int i = 1; i <= bitlength; i++) {
				// bitshift from right to left
				if ((n & (1 << i)) == 0)
					continue;
				int tmp = a;
				for (int j = 0; j < i; j++)
					// Es Gilt: a^(n1 * n2) mod m = (a^n1 mod m)^n2 mod m
					tmp = ((tmp * tmp) % m);

				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res * tmp) % m);
			}

			if ((n & 1) != 0)
				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod
				// m
				res = ((res * a) % m);

			return res;
		} else
			return -1;
	}

	/**
	 * modulares Potenzieren (a^n mod m)
	 *	a: Basis
	 *	n: Exponent
	 *	m: Modulo
	 *
	 *	BigInteger implementation
	 */
	public BigInteger potenzModuloBig(BigInteger a, BigInteger n, BigInteger m) {
		// Definiert für a, m,n > 0, sonst -1
		if (a.compareTo(BigInteger.ZERO) > 0 && m.compareTo(BigInteger.ZERO) > 0 && n.compareTo(BigInteger.ZERO) >= 0) {
			BigInteger res = BigInteger.ONE;
			for (int i = 1; i <= n.bitLength(); i++) {
				// bitshift from right to left
				if ((n.and(BigInteger.ONE.shiftLeft(i))).equals(BigInteger.ZERO))
					continue;
				BigInteger tmp = a;
				for (int j = 0; j < i; j++)
					// Es Gilt: a^(n1 * n2) mod m = (a^n1 mod m)^n2 mod m
					tmp = ((tmp.multiply(tmp)).mod(m));
				
				// Es gilt: a^(n1 + n2) mod m = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res.multiply(tmp)).mod(m)); 
			}

			if (!n.and(BigInteger.ONE).equals(BigInteger.ZERO))
				// Es gilt: a^(n1 + n2) mod m  = ((a^n1 mod m) * (a^n2 mod m) mod m
				res = ((res.multiply(a)).mod(m)); 

			return res;
		} 
		else
			return new BigInteger("-1");
	}

	/**
	 * extended GCD
	 */
	public BigInteger[] extendedGCD(BigInteger a, BigInteger b) {
		BigInteger uc, vc, ud, vd, c, d, q;

		if (a.compareTo(BigInteger.ZERO) >= 0 && b.compareTo(BigInteger.ZERO) >= 0
				&& (!a.equals(BigInteger.ZERO) || b.equals(BigInteger.ZERO))) {

			d = b;
			c = a;

			uc = BigInteger.ONE;
			vc = BigInteger.ZERO;
			ud = BigInteger.ZERO;
			vd = BigInteger.ONE;

			while (!c.equals(BigInteger.ZERO)) {
				// Invariant: uca+vcb=c and uda+vdb=d
				q = d.divide(c);

				BigInteger tempC = c;
				c = d.subtract(q.multiply(c));
				d = tempC;

				BigInteger tempUc = uc;
				BigInteger tempVc = vc;
				uc = ud.subtract((q.multiply(uc)));
				vc = vd.subtract((q.multiply(vc)));

				ud = tempUc;
				vd = tempVc;
			}

			BigInteger[] res = { d, ud, vd };
			return res;

		} else {
			return null;
		}

	}

	public boolean rabinMiller(BigInteger n){
		
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
				BigInteger v = potenzModuloBig(a, s, n);
				
				if(!v.equals(BigInteger.ONE)){
					BigInteger i = BigInteger.ZERO;
	
					
					while(!v.equals(n.subtract(BigInteger.ONE))){
						if(i.equals(t.subtract(BigInteger.ONE)))
							return false;
						else{
							v = potenzModuloBig(v, new BigInteger("2"), n);
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