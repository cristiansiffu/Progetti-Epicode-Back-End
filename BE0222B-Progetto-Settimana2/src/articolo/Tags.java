package articolo;

public class Tags {
	private String[] tags;
	
	public Tags(String[] tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		String stringa = "";
		for(int i = 0; i < this.tags.length; i++) {
			stringa += (" " + tags[i]);
		}
		return stringa;
	}
}
