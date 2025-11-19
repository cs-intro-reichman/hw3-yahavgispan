// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	
	public static int plus(int x1, int x2) {
		int result = x1;
		if(x2>0)
			for (int i = 0; i<x2; i++){
			 result++;
			} 
		else
			for (int i = 0; i<Math.abs(x2); i++){
		 	result--;
			}
		return result;
	}


	public static int minus(int x1, int x2) {
		int result = x1;
		if(x2>0)
			for (int i = 0; i<x2; i++){
			 result--;
			} 
		else
			for (int i = 0; i<Math.abs(x2); i++){
		 	result++;
			}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiply = 0;
		for (int i = 0; i<Math.abs(x2); i++){
		 multiply = plus(Math.abs(x1), multiply);
		}
		if (x1 >0 && x2 >0 || x1 < 0 && x2 < 0 )
		return multiply;
		else
		return minus(0, multiply);
	}

	public static int pow(int x, int n) {
		int pow = 1;
		for (int i = 0; i<n; i++){
		 pow = times(x, pow);
		}
		return pow;
	}


	public static int div(int x1, int x2) {
		int counter = 0;
		int sum = 0;
		while (sum < Math.abs(x1)) {
			sum = plus(Math.abs(x2), sum);
			if (sum <= x1){
			counter++;
			}
		}
		if (x1 >0 && x2 >0 || x1 < 0 && x2 < 0 )
		return counter;
		else
		return minus(0, counter);
	}

	public static int mod(int x1, int x2) {
	    int counter = 0;
		int sum = 0;
		while (sum < x1) {
			sum = plus(x2, sum);
			counter++;
		}
		return minus(counter, div(x1, x2));
	}	


	public static int sqrt(int x) {
		int i = 0;
		while (times (i , i) < x){
			i++;
		}
		if (mod( x , times(i, i)) != 0){
	     return i-1;
		}
		else{
		 return (i);

		}
	}	  	  
}