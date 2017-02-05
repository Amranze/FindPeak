
public class TestECG {
	static float highestMax=0, peak, max=0, prev =0, beforePrev = 0;

	 public static void detectEcgTest(float current) {
			if(current > prev ) {
				beforePrev = prev;
				max = current;
				prev = current;
			}
			else {
				if(beforePrev < prev && prev > current){
					highestMax = prev;
					System.out.println("TestECG Highest "+highestMax + " Max : "+max);
				}
				beforePrev = prev;
				prev = current;
			}
	}
}
