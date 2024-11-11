import java.util.*;


public class semaphone {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("hello world ");
		final  PC pc = new PC();
     
     Thread t1 = new Thread(new Runnable() {
    	 
    	public void run() {
    		
    		try {
    			pc.produce();
    		}catch(Exception e) {
    			System.out.println(e);
    		}
    	}
     });
     
     Thread t2 = new Thread(new Runnable() {
    	 public void run() {
    		 try {
    			 pc.consumer();
    		 }catch(Exception e) {
    			 System.out.println(e);
    		 }
    	 }
     });
     
     t1.start();
     t2.start();
     
     
     t1.join();
     t2.join();
    

	}

}

class PC{
	
	
	LinkedList<Integer> l = new LinkedList<>();
	int capacity = 2;
	int value=1;
    int bucket = 20;
	public void produce() throws InterruptedException {
		
		
		while(bucket > 0) {
		synchronized(this){
			  
			while(l.size()==capacity) {
				wait();	
			}
			System.out.println("Producer  the value : "+ value);
			l.add(value);
			notify();
			Thread.sleep(1000);
			
			
			
		  }	
		
		bucket--;
		}
	}
	
	public void consumer() throws InterruptedException{
		
		while(bucket > 0) {
			synchronized(this) {
				
				while(l.size()==0) {
					wait();
				}
				int val = l.removeFirst();
				val--;
				System.out.println("Consumer  the value : "+ val);
				
				notify();
				Thread.sleep(1000);
				
				
			}
			
			bucket--;
		}
		
		
	}
	
	
}
