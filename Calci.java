//this code is written to solve string calculator program which is a technical assessment given by Incubyte Datatech Pvt. Ltd.
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException{
	    	//A BufferedReader object is created to take input from buffer
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//the input is stored into string s
		String s=br.readLine();
		
		//integer sum stores sum of integers in string
		int sum=Add(s);//ADD() method is where addition of integers in string occurs
		
		System.out.println(sum);
	}
    	public static int Add(String numbers){
        
        	//if method checks if string is empty or not. if string is empty 0 is returned
        	if(numbers.equals("")){return 0;}
        
        	//string is broken into individual characters and sored in a array of size of string
        	char[] c=numbers.toCharArray();
        
        	//sum stores sum of integers and cc is used a flag to check -ve numbers
        	int sum=0,cc=0;
        	//StringBuffer is created to store -ve numbers occuring in string
        	StringBuffer sb=new StringBuffer();
        
        	//try method is used to throw exception if -ve numbers are given in input
        	try{
            
            		for(int i=0;i<numbers.length();i++){
                
                		//character in char array is checked if it is digit or not
                		if(Character.isDigit(c[i])){
                    
                    			//if the char is digit then it is checked if it is -ve no or not by using the following logic
                    			if(numbers.charAt(i-1)=='-'){
                        
                        			//if no is -ve, count flag is incremented
                        			cc++;
                        
		                        	//number with -ve sign is added to string buffer
        		                	sb.append("-"+numbers.charAt(i));
                        
                		        	//logic to check if number has more than single digits
                        			//if it has n=more than one digit then susequent numbers are added to stringbuffer
                        			while(Character.isDigit(c[i+1])){
                        				i=i+1;
                            				sb.append(numbers.charAt(i));
                        			}
                        			sb.append(" ");
                    			}
                    			//if count is equal to 0 then it means no -ve numbers occured till now and addition is done
                    			else if(cc==0){
                        
                        			//StringBufferto append car digit for addition
                        			StringBuffer ss=new StringBuffer();
                        			ss.append(numbers.charAt(i));
                        
	                        		//logic to check if number has more than single digits
        	                		//if it has n=more than one digit then susequent numbers are added to stringbuffer
                	        		while(Character.isDigit(c[i+1])){
                        	    			i=i+1;
                            				ss.append(numbers.charAt(i));
                        			}
                        
                        			//stringbufferis conver to string and parsed to Integer for addition
                        			int a=Integer.parseInt(ss.toString());
                        			if(a<1000){sum=sum+a;}
                    			}
                		}
            		}
            		//if counter flag is greater than 0 then exception is thrown to tell -ve numbers are there in string
            		if(cc>0){throw new Exception();}
            
            		//if exception is not thrown then sum of numbers is returned
            		return sum;
        	}
        	//catch block catches -ve numbers exception
        	catch(Exception e){
            
            	System.out.print("negatives not allowed ");
            	System.out.println(sb);
            	//zero is returned is -ve numbers ate there in string
            	return 0;
        	}
    	}
}
