
public class LRU extends BaseReplacement {
		
		public LRU(String x) {
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
						frames.get(i).setLastUsed(tick);
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
					currFrame.setLastUsed(tick);
					this.addFramesToTable(true);
					continue;
				}
				
				// if not, replace the least recently used.
				Page lru = this.getLRU();
				frames.set(frames.indexOf(lru), new Page(tick, currPage));
				this.addFramesToTable(true);
			}
			
		}
		
		private Page getLRU() {
			Page LRU = frames.get(0);
			
			for(int i = 0; i < frames.size(); i++) {
				if(frames.get(i).getLastUsed() < LRU.getLastUsed()) {
					LRU = frames.get(i);
				}
			}
			return LRU;
		}

	}
