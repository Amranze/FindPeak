import java.awt.Toolkit;


public class TestECG{
	static float highestMax=0, max=0, prev =0, beforePrev = 0, prevPeak = 0;
	
	public TestECG(){
		highestMax=0;
		max=0; 
		prev =0; 
		beforePrev = 0;
	}

	 public static void detectEcgTest(float current) throws Exception {
			if(current > prev) {
				beforePrev = prev;
				prevPeak = highestMax;
				max = current;
				prev = current;
			} else {
				if(beforePrev < prev && prev > current){
					prevPeak = highestMax;
					highestMax = prev;
					if(prevPeak < highestMax){
						System.out.println("TestECG Highest "+highestMax);
					}
					//SoundUtils.tone(1000,100);
					System.out.println("TestECG Highest "+highestMax + " Max : "+max);
				}
				beforePrev = prev;
				prev = current;
			}
				

	}
}
