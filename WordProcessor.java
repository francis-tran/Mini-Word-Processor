
import java.util.Stack;
public class WordProcessor implements MiniWPI{
  /**
	*Default constructor
	* Stacks are already initalized so no need to initalize an empty string
  */
  public WordProcessor(){
      
  }
  /**
   *Argument constructor
   *@param add a string to the left stack
  */
  public WordProcessor(String s){
      char[] arr = s.toCharArray();
      for(int i = 0; i < arr.length; i++){
          left.push(arr[i]);
      }
  }
    
  /** Is cursor at the start of the text? */
  public boolean isAtStart(){
      return left.empty();
  }


  /** Is cursor at the end of the text? */
  public boolean isAtEnd(){
      return right.empty();
  }


  /** Insert c into the string at the cursor. */
  public void insertChar(char c){
      left.push(c);
  }

  /** Move cursor left 1 character.  If we're already at the
   * start of the string, do nothing.
   */
  public void moveLeft(){
      if(!isAtStart()){
        right.push(left.pop());
      }
  }


  /** Move cursor right 1 character.  If we're already at the
   * end of the string, do nothing.
   */
  public void moveRight(){
      if(!isAtEnd()){
        left.push(right.pop());
      }
  }


  /** Delete character before the cursor.  If there is none,
   * do nothing. */
  public void backspace(){
      if(!isAtStart()){
          left.pop();
      }
  }


  /** Delete character after the cursor.  If there is none,
   * do nothing. */
  public void delete(){
      if(!isAtEnd()){
          right.pop();
      }      
  }


  /** Move cursor to start of the text. */
  public void moveToStart(){
      while(!left.empty()){
          right.push(left.pop());
      }
  }


  /** Move cursor to end of the text. */
  public void moveToEnd(){
      while(!right.empty()){
          left.push(right.pop());
      }      
  }


  /** Convert to string.  The cursor position is ignored.
   * @see toStringCursor
   */
  public String toString(){
        Stack<Character> tempStack = new Stack<Character>();
        String s = "";
        Character temp;
        while(!left.empty()){
            temp = left.pop();
            tempStack.push(temp);
        }
        while(!tempStack.empty()){
            temp = tempStack.pop();
            s += temp;
            left.push(temp);
        }
        while(!right.empty()){
            temp = right.pop();
            s += temp;
            tempStack.push(temp);
        }
        while(!tempStack.empty()){
            temp = tempStack.pop();
            right.push(temp);
        }
        return s;
        
  }



  /** Like toString, but the special character | is included
   * to mark the cursor position.
   */
  public String toStringCursor(){
        Stack<Character> tempStack = new Stack<Character>();
        String s = "";
        Character temp;
        while(!left.empty()){
            temp = left.pop();
            tempStack.push(temp);
        }
        while(!tempStack.empty()){
            temp = tempStack.pop();
            s += temp;
            left.push(temp);
        }
        s += "|";
        while(!right.empty()){
            temp = right.pop();
            s += temp;
            tempStack.push(temp);
        }
        while(!tempStack.empty()){
            temp = tempStack.pop();
            right.push(temp);
        }
        return s;
  }


  /** Search forward for the next occurrence of c that starts at the
   * cursor or later.  If found, leave the cursor immediately after
   * that occurrence and return true.  Else, leave the cursor at the
   * end of the text and return false. */

  public boolean search(char c){
      Character temp = 'a';
      while(!right.empty()){
          temp = right.pop();
          left.push(temp);
          if(temp == c){
              return true;
          }
      }
      return false;
  }

/** Method that reads in the string that was retrieved from the top of the Queue and
 *  executes the appropriate command. It also calls a method to print out the command
 *  just executed and the resulting stacks
 */

  public void processCommand(String s){
      if(s.contains("insert")){
          Character c = s.charAt(s.length() - 1);
          this.insertChar(c);
          this.printtest(s);
      }
      else if (s.equals("move left")){
          this.moveLeft();
          this.printtest(s);
      }
      else if (s.equals("move right")){
          this.moveRight();
          this.printtest(s);
      }
      else if(s.contains("search")){
          Character c = s.charAt(s.length() - 1);
          this.insertChar(c);
          this.printtest(s);
      }
      else if(s.equals("backspace")){
          this.backspace();
          this.printtest(s);
      }
      else if(s.equals("delete")){
          this.delete();
          this.printtest(s);
      }
      else if (s.equals("move beginning")){
          this.moveToStart();
          this.printtest(s);
      }
      else if (s.equals("move end")){
          this.moveToEnd();
          this.printtest(s);
      }
      else{
          System.out.println(s + "\tUnrecognized command was inputted. Please try again.");
      }
  }
  
  /* Method to print out a command and the results */

  public void printtest(String s){
      // To make printing the insertion of "space" more user friendly
      if(s.equals("insert  ")){
        System.out.println("insert space:\t" + this.toStringCursor());  
      }
      // Weird printing issue if I don't add an extra character before or after the colon.
      else if(s.equals("delete")){
        System.out.println("delete: \t" + this.toStringCursor());  
      }
      else{
        System.out.println(s + ":\t" + this.toStringCursor());
      }
  }

}