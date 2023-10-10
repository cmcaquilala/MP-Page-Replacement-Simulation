import java.util.ArrayList;

abstract class BaseReplacement {
	int tick = 0;
	int noFrames = 3;
	int pageFault = 0;
	String[] table = {"","","",""};
	ArrayList<Integer> ref = new ArrayList<Integer>();
	ArrayList<Page> frames = new ArrayList<Page>();
	
	public BaseReplacement(String x) {
		for(int i = 0; i < x.length(); i++) {
			int page = Integer.parseInt(Character.toString(x.charAt(i)));
			ref.add(page);
		}
		for(int i = 0; i < noFrames; i++) {
			frames.add(new Page(-1,-1));
		}
	}
	
	public abstract void start();
	
	protected void addFramesToTable(boolean pageFault) {
		if(pageFault) {
			table[0] += "   " + frames.get(0);
			table[1] += "   " + frames.get(1);
			table[2] += "   " + frames.get(2);	
			table[3] += "   1";
		} else {
			table[0] += "    ";
			table[1] += "    ";
			table[2] += "    ";	
			table[3] += "    ";
		}
	}
	
	public void printTable() {
		System.out.print("REF         ");
		for(int i = 0; i < ref.size(); i++) {
			System.out.print("   " + ref.get(i));
		}		
		
		System.out.println();
		System.out.println();
		System.out.print("            ");
		System.out.println(table[0]);
		System.out.print("Frames      ");
		System.out.println(table[1]);
		System.out.print("            ");
		System.out.println(table[2]);
		System.out.println();
		System.out.print("Page Fault  ");
		System.out.println(table[3]);
		System.out.println("Total: " + pageFault);
	}
	
	public int getPageFault() {
		return this.pageFault;
	}
	
}
