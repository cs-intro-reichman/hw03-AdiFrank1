/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	// #feedback: you should always declare initalized value even if the expected default provide the same value
	static int iterationCounter1 = 0;
	static int iterationCounter2 = 0;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter1);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter2);

	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
    	double g = loan/n ;
	// #feedback: what the porpuse of this variable?
    	while (endBalance(loan, rate, n, g) >= epsilon ) 
	{
		// #feedback: payy attention for indentations
		g += epsilon;
    		iterationCounter1++;
    	}

    	return g;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	// Replace the following statement with your code
    	double h =loan; 
    	double l = 1.0;
    	double g = (l+h)/2;
    	int counter2 = 0 ;
	// #feedback: bad indentations
    	while (h-l > epsilon)
    	{
		// #feedback: always use {} to scope the content of the condition - even when there is only one line of code within
		if ((endBalance(loan,rate,n,g)*endBalance(loan,rate,n,l))>0) {
    			l=g;
		}
    		else {
    			h=g;
		}
    		
		g=(l+h)/2;
    		iterationCounter2++;
    	}
    		
    	return g;
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
		double retPay = loan;
		rate= rate/100;
		for (int i=1;i<=n;i++)
		{
			retPay= ((retPay-payment)* (rate+1)) ;
		}
    	return retPay;
	}
}
