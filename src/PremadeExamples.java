import java.util.ArrayList;

public class PremadeExamples {
	static ArrayList<Integer> pages = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		String ref = "1,3,1,0,2,3,0,4,4,1";
//		String ref = "7,0,1,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1";
		ref = ref.replace(",","");
		
		
		FIFO a = new FIFO(ref);
		a.start();
		System.out.println("=============");
		System.out.println("FIFO");
		System.out.println("=============");
		a.printTable();
		System.out.println();
		System.out.println();
		
		LRU b = new LRU(ref);
		b.start();
		System.out.println("=============");
		System.out.println("LRU");
		System.out.println("=============");
		b.printTable();
		System.out.println();
		System.out.println();
		
		LFU c = new LFU(ref);
		c.start();
		System.out.println("=============");
		System.out.println("LFU");
		System.out.println("=============");
		c.printTable();
		System.out.println();
		System.out.println();
		
		MFU d = new MFU(ref);
		d.start();
		System.out.println("=============");
		System.out.println("MFU");
		System.out.println("=============");
		d.printTable();
		System.out.println();
		System.out.println();
	}
}
