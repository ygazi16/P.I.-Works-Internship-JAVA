package pi_works;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Random rn = new Random();
	      int row = 0;
	      int col = 0;
	  	int [][] myList = new int[15][15];
	  	int allowableHigh = 0;
	  	int allowableLow = 0;
	  	int nextStep = 0;
	  	int count = 0;
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File ("/Users/yarkingazi/Desktop/132-workspace/pi_works/src/pi_works/input_file")));
				String nextLine ;
			    try {
					while ((nextLine = br.readLine()) != null) {
					
						StringTokenizer st = new StringTokenizer(nextLine," ");  
					     while (st.hasMoreTokens()) {  
					    	myList[row][col] = Integer.parseInt(st.nextToken());
					        col++;
					     }  
						row++;
						col=0;
						
						
						
					}
					
					//Just to show that all input read is put into a 2D Array.
					System.out.println(Arrays.deepToString(myList).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
					int i;
					int j;
					boolean skipRow = false;
					//count += myList[0][0];
					for(i = 0; i < myList.length; i++) {
                    	for(j = 0; j < myList[0].length; j++) {
                    		if(j != nextStep) {
                    			continue;
                    		}
                    		if(myList[i][j] != 0) {
                    			if(!isPrime(myList[i][j])) {
                    			count += myList[i][nextStep];
                    			skipRow = true;
                    			allowableHigh = modifyHigh(nextStep, myList);
                    			allowableLow = modifyLow(nextStep);
                    			
                    			
                    			nextStep = rn.nextInt(allowableHigh - allowableLow +1) + allowableLow;
                    			if(i+1 < myList.length) {
                    			while(isPrime(myList[i+1][nextStep])){
                    				nextStep = rn.nextInt(allowableHigh - allowableLow +1) + allowableLow;
                    			}
                    			}
                    			
                    			System.out.println("Allowable lowest column in the next row:" + allowableLow);
                    			System.out.println("Allowable highest column in the next row:" + allowableHigh);
                    			System.out.println("Current count:" + count);
                    			System.out.println("Where iteration at now:" + myList[i][j]);
                    			System.out.println("In which columns are allowed in the next row:" +nextStep);
                    			System.out.println("*");
                    			break;
                    			}
                    		
                    			}
                    			if(skipRow) continue;	
                    		}
                    
                   	}
                    
					
					
					System.out.println(count);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
	

}
	public static int modifyLow(int nextStep) {
		int low = nextStep;
		low -= 1;
		if(low < 0) {
			return 0;
		}else {
			return low;
		}
		
	}
	public static int modifyHigh(int nextStep, int [][] list) {
		int high = nextStep;
		high += 1;
		if(high == list.length) {
			return list.length-1;
		}else {
			return high;
		}
	}
	
	static boolean isPrime(int n)
    {
       
        if (n <= 1)
            return false;
  
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
	

}
