import java.util.*;


public class optimalPR {

	public static boolean search(int key,int frame[]) {
		for(int i=0; i<frame.length; i++) {
			if(key==frame[i]) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int predict(int pg[],int frame[],int pn,int index) {
		
	  int res = -1; int farthest = index; // index is start from the current position of your page 
	  // res is used for finding the farthest in whole page 
	  
	  for(int i=0; i<frame.length; i++) {
		  int j;
		  for(j=index; j<pn ; j++) {
			  if(pg[j]==frame[i]) {
				  
				  if(j > farthest) {
					  farthest = j;
					  res = i;
				  }
				  break;
			  }
			  
		  }
		  
		  if(j==pn) { 
				
				return i; // traversal the whole pages doesn't find anypages so directly return the ith frame which previously is pointing 
			}
	  }
		
	 return (res==-1) ?  0 : res;    // 
	 
	 
	}
	public static void  optimalPageReplacement(int pg[],int pn,int fn ) {
		
		int[] fr = new int[fn];
		
		int hit = 0;
		int index = 0;
		for(int i=0; i<pn; i++) {
			if(search(pg[i],fr)){
				hit++;
				continue;
			}
			
			if(index < fn) {
				fr[index++] = pg[i];
			}else {
				int j = predict(pg,fr,pn,i+1);
						
					fr[j] = pg[i];
				
			}
		}
		
		
		 System.out.println("No. of hits = " + hit);
	     System.out.println("No. of pageFalut = " + (pn - hit));
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 int pg[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 ,1,2,0,1,7,0,1};
		        int pn = pg.length;
		        int fn = 3;
		        optimalPageReplacement(pg, pn, fn);

	}

}
