
public class solution {

	public static double findGeometricSum(int k){

		if (k == 0 ) return (double)1;
        
        return 1 + ((double)1/2)*findGeometricSum(--k);
	}
}
