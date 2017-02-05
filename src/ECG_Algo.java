import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ECG_Algo {
	static float highestMax=0, peak, max=0, prev =0, beforePrev = 0;

	public static void main(String[] args) {
		
		ArrayList<String> data_list = readCSVToArrayList("C:\\Users\\Amrane Ait Zeouay\\Documents\\workspace-sts-3.6.4.RELEASE\\Algo\\src\\test.csv");

		int nsamp = data_list.size()-2;
		float[] ecg = new float[nsamp];
		for(int i=2;i<nsamp;i++){
			ecg[i-2] = Float.parseFloat(data_list.get(i));
		}
		//for(int k=0;k<30; k++){
			//System.out.println(" k "+k);
			for(int i=0; i<ecg.length;i++){
				//long startTime = System.nanoTime();
				TestECG.detectEcgTest(ecg[i]);
				//long endTime = System.nanoTime();
				//System.out.println("Took "+(endTime - startTime) + " ns");
			}	
		//}
	}

	 private static void detectEcgTestA(float current) {
			if(current > prev ) {
				beforePrev = prev;
				max = current;
				prev = current;
			}
			else {
				if(beforePrev < prev && prev > current){
					highestMax = prev;
					System.out.println("Highest "+highestMax + " Max : "+max);
				}
				beforePrev = prev;
				prev = current;
			}
	}

	
	public static ArrayList<String> readCSVToArrayList(String csvpath) {

        ArrayList<String> dataAL = new ArrayList<String>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(csvpath));
            //reader.readLine();//
            String line = null;//

            int line_num = 0;
            while ((line = reader.readLine()) != null) {

                String item[] = line.split(",");
                dataAL.add(item[0]);

                //System.out.println(dataAL.get(line_num));
                line_num++;
            }
            //System.out.println(dataAL.size());
            //System.out.print(ticketStr.toString());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return dataAL;
    }

}
