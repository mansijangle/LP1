import java.util.*;

public class pageReplacement {

	
	public static int FIFO(int pages[],int n,int capacity) {
		// this is the frame size 
		HashSet<Integer> hs = new HashSet<>(capacity);
		// this is for fifo
		Queue<Integer> q = new LinkedList<>();
		
		int pagefalut = 0;
		
		for(int i=0; i<n; i++) {
			
			if(hs.size() < capacity) {
				
				if(!q.contains(pages[i])) {
					
					hs.add(pages[i]);
					
					pagefalut++;
					
					q.add(pages[i]);
				}
				
			}
// if the set the full then we have to  remove the  element using FIFO 
// delete the element for the both set and queue then insert in both
			else {
				
				if(!q.contains(pages[i])) {
					int val = q.peek();
					
					
					hs.remove(val);
					q.remove();// removing the element in the queue
					
					
					hs.remove(val); // removing the element in hashset and hashset only count the uqniue value
					
					hs.add(pages[i]);
					q.add(pages[i]);
					
					
					
					pagefalut++;
					
					
				}
				//implementing the FIFO 
			}
		}
		
		return pagefalut;
		
	}
	
	

	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 
                2, 3, 0, 3, 2,1}; 

int capacity = 3; 
System.out.println( FIFO(pages, pages.length, capacity)); 
	}

}
