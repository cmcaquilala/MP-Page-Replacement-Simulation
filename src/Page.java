
public class Page {
	int first = 0;
	int value = 0;
	int lastUsed = 0;
//	int useCount = 0;
	
	public Page(int first, int value) {
		this.first = first;
		this.value = value;
		this.lastUsed = first;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getAge(int tick) {
		return tick - first;
	}
	
	public boolean isEmpty() {
		if(value == -1) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		if(this.isEmpty()) {
			return " ";
		}
		return value + "";
	}

	public int getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(int lastUsed) {
		this.lastUsed = lastUsed;
	}
	
}
