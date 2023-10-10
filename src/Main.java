import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int userMenu = -1;
	static ArrayList<Integer> pages = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner mm = new Scanner(System.in);
		while(userMenu != 0) {
			
			try {
				String ref;
				
				System.out.println("Welcome! This is Caquilala's Page Replacement Simulator.");
				System.out.println("What type of task are you thinking of?");
				System.out.println("1 - First in First Out (FIFO)");
				System.out.println("2 - Least Recently Used (LRU)");
				System.out.println("3 - Least Frequently Used (LFU)");
				System.out.println("4 - Most Frequently Used (MFU)");
				System.out.println();
				System.out.println("0 - Exit");
				System.out.println();
				
				System.out.print("> ");
				
				userMenu = Integer.parseInt(mm.nextLine());
				
				System.out.println();
				System.out.println();
				if(userMenu == 1) {
					
					System.out.println("You chose 1 - First in First Out (FIFO).");
					System.out.println();
					System.out.println();
					System.out.println("Start by inputing the reference string separated by a comma.");
					System.out.println("For example: 1,6,4,2,0,7,4,7,3,2");
					System.out.println("Leave blank to end.");
					System.out.println();
					
					System.out.print("> ");
					ref = mm.nextLine();
					ref = ref.replace(",","");
					
					FIFO table = new FIFO(ref);
					table.start();
					
					System.out.println();
					System.out.println("Here are the figures!");
					System.out.println();
					System.out.println("=============");
					System.out.println("FIFO");
					System.out.println("=============");
					table.printTable();
					System.out.println();
					System.out.println();
					
				} else if(userMenu == 2) {
					System.out.println("You chose 2 - Least Recently Used (LRU).");
					System.out.println();
					System.out.println();
					System.out.println("Start by inputing the reference string separated by a comma.");
					System.out.println("For example: 1,6,4,2,0,7,4,7,3,2");
					System.out.println("Leave blank to end.");
					System.out.println();
					
					System.out.print("> ");
					ref = mm.nextLine();
					ref = ref.replace(",","");
					
					LRU table = new LRU(ref);
					table.start();
					
					System.out.println();
					System.out.println("Here are the figures!");
					System.out.println();
					System.out.println("=============");
					System.out.println("LRU");
					System.out.println("=============");
					table.printTable();
					System.out.println();
					System.out.println();
				} else if(userMenu == 3) {
					System.out.println("You chose 3 - Least Frequently Used (LFU).");
					System.out.println();
					System.out.println();
					System.out.println("Start by inputing the reference string separated by a comma.");
					System.out.println("For example: 1,6,4,2,0,7,4,7,3,2");
					System.out.println("Leave blank to end.");
					System.out.println();
					
					System.out.print("> ");
					ref = mm.nextLine();
					ref = ref.replace(",","");
					
					LFU table = new LFU(ref);
					table.start();
					
					System.out.println();
					System.out.println("Here are the figures!");
					System.out.println();
					System.out.println("=============");
					System.out.println("LFU");
					System.out.println("=============");
					table.printTable();
					System.out.println();
					System.out.println();
				} else if(userMenu == 4) {
					System.out.println("You chose 4 - Most Frequently Used (MFU).");
					System.out.println();
					System.out.println();
					System.out.println("Start by inputing the reference string separated by a comma.");
					System.out.println("For example: 1,6,4,2,0,7,4,7,3,2");
					System.out.println("Leave blank to end.");
					System.out.println();
					
					System.out.print("> ");
					ref = mm.nextLine();
					ref = ref.replace(",","");
					
					MFU table = new MFU(ref);
					table.start();
					
					System.out.println();
					System.out.println("Here are the figures!");
					System.out.println();
					System.out.println("=============");
					System.out.println("MFU");
					System.out.println("=============");
					table.printTable();
					System.out.println();
					System.out.println();
				} else if(userMenu == 0) {
					break;
				} else {
					System.out.println("I'm afraid I didn't get that.");
					System.out.println();
					System.out.println();
				}
				
				System.out.println();
				System.out.println("Continue? (1/0)");
				System.out.print("> ");
				
				userMenu = Integer.parseInt(mm.nextLine());
				
				System.out.println();
				System.out.println();
				System.out.println();
			} catch (Exception e) {
				System.out.println();
				System.out.println("Please check your inputs.");
				System.out.println();
				System.out.println();
				System.out.println();
			}
			
		}
		mm.close();
		System.out.println("Thank you!");
	}
	
}
