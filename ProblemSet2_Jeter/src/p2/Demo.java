package p2;

public class Demo {

	public static void main(String[] args) {
		Song s1 = new Song("My Kind of Woman", "Mac DeMarco", 191);
		Song s2 = new Song("we fell in love in october", "girl in red", 184);
		
		Opera o1 = new Opera("O mio babbino caro", "Puccini", 150);
		Opera o2 = new Opera("Largo al factotum", "Rossini", 241);
		
		PlayList music = new PlayList(100);
		music.insert(s1);
		music.insert(s2);
		music.insert(o1);
		music.insert(o2);
		
		music.play();


	}

}
