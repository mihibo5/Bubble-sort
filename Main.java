import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main{
    public static void main (String args[]) throws FileNotFoundException{        				//args[0] = min, args[1] = max, if (args[].length == 4+) --> args[] numbers to sort
        
        int n = 100;                                                                    		//we will use default quantity of numbers 100
        String result;																			//we will save our results here
		
		if (args.length > 0 && args[0].equals("file")){											//check how many we will be reading numbers from file
			Scanner s = new Scanner(new FileReader("numbers.txt"));								//read numbers from this file
			String cvt[] = s.nextLine().split(" ");												//saving numbers to string array
			int unsorted[] = convertArray(cvt);													//converting string array to int array
			result = Sort.SortArrayToString(unsorted);											//save the results from sorting
			System.out.println(result);															//printing results
		}
        else if (args.length == 1){																//check how many args exists
			int converted[] = convertArray(args);												//convert args to int array
            int min = converted[0];																//get minimum
            int unsorted[] = generate(n, min, Integer.MAX_VALUE);								//generate numbers
			result = Sort.SortArrayToString(unsorted);											//save the results from sorting
			System.out.println(result);															//print results
        }
        else if (args.length == 2){																//check how many args exists
			int converted[] = convertArray(args);												//convert args to int array
            int min = converted[0];																//get minimum
            int max = converted[1];																//get maximum
            int unsorted[] = generate(n, min, max);												//generate numbers
            result = Sort.SortArrayToString(unsorted);											//save the results from sorting
			System.out.println(result);															//print results
        }
        else if (args.length >= 3){																//check how many args exists
			int converted[] = convertArray(args);												//convert args to int array
            result = Sort.SortArrayToString(converted);											//save the results from sorting
			System.out.println(result);															//print results
        }
        else{																					//args do not exist
            int unsorted[] = generate(n, Integer.MIN_VALUE, Integer.MAX_VALUE);					//generate numbers
            result = Sort.SortArrayToString(unsorted);											//save the results from sorting
			System.out.println(result);															//print results
        }
    }
	
	/*METHOD FOR GENERATING NUMBERS*/
    private static int[] generate(int n, int min, int max){
        int generated[] = new int[n];															//we will save generated numbers here
        Random r = new Random();																//creating new object
        for (int i = 0; i < n; i++){															//generating n numbers
			if (min == Integer.MIN_VALUE && max == Integer.MAX_VALUE) generated[i] = r.nextInt();//if condition is true, generate any integer
			else generated[i] = r.nextInt(max - min) + min;										//else generate between two numbers
        }
        return generated;																		//return generated numbers in array
    }
	/*FIELD VARIABLE FOR ARRAY SIZE*/
	private static int csize = 0;
	
	/*METHOD FOR CONVERTING STRING ARRAYS TO INT ARRAY*/
	private static int[] convertArray(String args[]){																			
		csize = args.length;																	//getting the array size
		int converted[] = new int[csize];														//we will save converted numbers here with the size that we got two/three lines up
		if (args.length > 3) converted = convert(true, args);									//calling method to convert array
		else converted = convert(false, args);													//calling method to convert array
		
		return converted;																		//return converted numbers array
	}
	
	/*CORE FOR CONVERTING ARRAY*/
	private static int[] convert(boolean arguments, String args[]){
		int converted[] = new int[csize];
		boolean err = false;
		for (int j = 0; j < args.length; j++) {													//converting numbers on index j+
			try {
				converted[j] = Integer.parseInt(args[j]);										//parse number in array
			}
			catch (NumberFormatException nfe) {													//catch error
				System.out.println("Please input the correct form of number!" + nfe);			//print error
			}
		}
		return converted;
	}
}
