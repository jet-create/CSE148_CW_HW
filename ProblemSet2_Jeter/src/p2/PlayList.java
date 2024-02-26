package p2;

public class PlayList {
	private PlayableItem[] playableItems;
	private int nElems;
	
	public PlayList(int maxSize) {
		playableItems = new PlayableItem[maxSize];
		nElems = 0;
	}
	
	public void insert(PlayableItem playableItem) {
		playableItems[nElems++] = playableItem;
	}
	
	void play() {
		for(int i = 0; i < nElems; i++) {
			playableItems[i].play();;
		}
	}
}
