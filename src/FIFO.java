import java.util.ArrayList;

public class FIFO extends BaseReplacement {
	
	public FIFO(String x) {
		super(x);
	}
	
	public void start() {
		
		for(tick = 0; tick < ref.size(); tick++) {
			
			int currPage = ref.get(tick);
			Page currFrame = frames.get(0);
			
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
			
			// if not, replace the oldest.
			Page oldest = this.getOldest();
			frames.set(frames.indexOf(oldest), new Page(tick, currPage));
			this.addFramesToTable(true);
		}
		
	}
	
	private Page getOldest() {
		Page oldest = frames.get(0);
		for(int i = 0; i < frames.size(); i++) {
			if(frames.get(i).getAge(tick) > oldest.getAge(tick)) {
				oldest = frames.get(i);
			}
		}
		return oldest;
	}

}
