
import java.util.Queue;
import java.util.LinkedList;
public class Main
{
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		q.add("movef left");
		q.add("move leftt");
		q.add("move right");
		q.add("insert _");
		q.add("insert D");
		q.add("insert o");
		q.add("insert g");
		q.add("move left");
		q.add("move left");
		q.add("move left");
		q.add("backspace");
		q.add("insert  ");
		q.add("move beginning");
		q.add("move left");
		q.add("insert M");
		q.add("insert y");
		q.add("insert  ");
		q.add("move end");
		q.add("move right");
		q.add("insert  ");
		q.add("insert i");
		q.add("insert s");
		q.add("insert c");
		q.add("insert o");
		q.add("insert o");
		q.add("insert o");
		q.add("move left");
		q.add("delete");
		q.add("move right");
		q.add("insert l");
		q.add("move left");
		q.add("move left");
		q.add("move left");
		q.add("move left");
		q.add("insert  ");
		q.add("move end");
		q.add("insert .");
		q.add("delete");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("backspace");
		q.add("delete");
		q.add("insert e");
		q.add("insert n");
		q.add("insert d");
		q.add("insert  ");
		q.add("insert o");
		q.add("insert f");
		q.add("insert  ");
		q.add("insert t");
		q.add("insert e");
		q.add("insert s");
		q.add("insert t");
		q.add("insert e");
		q.add("insert r");
		q.add("insert .");
		WordProcessor test = new WordProcessor("Big");
		System.out.println("Initial:\t" + test.toStringCursor());
		for(String s : q){
		    test.processCommand(s);
		}
		
	}
}
