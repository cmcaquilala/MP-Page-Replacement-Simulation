import java.util.ArrayList;

public class LFU extends BaseReplacement {
	ArrayList<ArrayList<Integer>> freq = new ArrayList<ArrayList<Integer>>();
	
	public LFU(String x) {
		super(x);
	}
	
	public void start() {
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		// freq matrix setup
		for(int i = 0; i < ref.size(); i++) {
			if(!temp.contains(ref.get(i))) {
				temp.add(ref.get(i));
			}
		}
		for(int i = 0; i < temp.size(); i++) {
			freq.add(new ArrayList<Integer>());
			freq.get(i).add(temp.get(i));
			freq.get(i).add(0);			
		}
		
		for(tick = 0; tick < ref.size(); tick++) {
			
			int currPage = ref.get(tick);
			Page currFrame = frames.get(0);
			
			addFreq(currPage);
			
			// check if frame already exists
			boolean exists = false;
			for(int i = 0; i < frames.size(); i++) {
				if(frames.get(i).getValue() == currPage) {
					exists = true;
				}
			}
			
			// if it already exists, go to the next ref
			if(exists) {
				this.addFramesToTable(false);
				continue;
			}
			
			// since it doesn't exist yet, add one page fault
			pageFault++;
			
			// check first for empty frames
			for(int i = 0; i < frames.size(); i++) {
				if(frames.get(i).isEmpty()) {
					currFrame = frames.get(i);
					break;
				}
			}
			
			// if you found an empty frame, set it there
			if(currFrame.isEmpty()) {
				currFrame.setValue(currPage);
				currFrame.setFirst(tick);
				this.addFramesToTable(true);
				continue;
			}
			
			// if not, replace the least used.
			Page least = this.getLeastUsed();
			frames.set(frames.indexOf(least), new Page(tick, currPage));
			this.addFramesToTable(true);
		}
		
	}
	
	private Page getLeastUsed() {
		ArrayList<Page> arr = new ArrayList<Page>();
		
		// get the least frequency page(s)
		Page least = frames.get(0);
		arr.add(least);
		for(int i = 0; i < frames.size(); i++) {
			if(this.getFreq(frames.get(i)) < this.getFreq(least)) {
				arr.clear();
				least = frames.get(i);
				arr.add(least);
			} else if (this.getFreq(frames.get(i)) == this.getFreq(least)) {
				arr.add(frames.get(i));				
			}
		}
		
		// if there are multiple, get oldest page.
		Page oldest = arr.get(0);
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i).getAge(tick) > oldest.getAge(tick)) {
				oldest = arr.get(i);
			}
		}
		return oldest;
	}
	
	private void addFreq(int value) {
		for(int i = 0; i < freq.size(); i++) {
			if(freq.get(i).get(0) == value) {
				freq.get(i).set(1, freq.get(i).get(1)+1);
			}
		}
	}
	
	private int getFreq(Page page) {
		int value = page.getValue();
		for(int i = 0; i < freq.size(); i++) {
			if(freq.get(i).get(0) == value) {
				return freq.get(i).get(1);
			}
		}
		return 0;
	}

}
