/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    public Library() {
      super("<Name Unknown>", "<Address Unknown>", 1);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
      this.hasElevator = true;
    }
//adding a book to the library
    public void addTitle(String title) {
      collection.put(title, true);
    }
//overloaded addTitle method that allows input on author of the book
    public void addTitle(String title, String author) {
      collection.put(title, true);
      System.out.println("Added: " + title + " by " + author);
  }
///overloaded addTitle method that allows input on author, as well as the publication date of the book
    public void addTitle(String title, String author, int pubDate) {
      collection.put(title, true);
      System.out.println("Added: " + title + " by " + author + " published " + pubDate);
  }



    //removing book from the library
        public String removeTitle(String title){
          if (collection.containsKey(title)) {
            collection.remove(title);
            return title;
          }
          return null;
        }
    //checking out a book (meaning it is removed from the library)
        public void checkOut(String title) {
          if (collection.containsKey(title)) {
            collection.put(title, false);

        }
    }
    public void returnBook(String title) {
      if (collection.containsKey(title)) {
        collection.put(title, true);
    
    }
}
//returns whether a book with the given title is in the collection.
public boolean containsTitle(String title) {
  return collection.containsKey(title);
}
//returns whether or not a book with the given title is available for rent 
public boolean isAvailable(String title) {
  return collection.getOrDefault(title, false);
}
//print all the books that are currently in the library
public void printCollection() {
  System.out.println("Library Collection:");
  for (String title : collection.keySet()) {
    System.out.println(title + " - " + (collection.get(title) ? "Available" : "Check Out"));
  }
}

public void showOptions() {
    super.showOptions(); // Call the superclass method
    System.out.println(" + addTitle(String title)");
    System.out.println(" + removeTitle(String title)");
    System.out.println(" + checkOut(String title)");
    System.out.println(" + returnBook(String title)");
    System.out.println(" + containsTitle(String title)");
    System.out.println(" + isAvailable(String title)");
    System.out.println(" + printCollection()");
}

public void goToFloor(int floorNum) {
    if (hasElevator) {
        System.out.println("Taking the elevator to floor #" + floorNum);
        this.activeFloor = floorNum;
    } else {
        super.goToFloor(floorNum);
    }
}
public static void main(String[] args) {
  Library myLibrary = new Library();
    myLibrary.addTitle("The Great Gatsby");
    myLibrary.addTitle("1984");
    myLibrary.addTitle("Pride and Prejudice");
    myLibrary.printCollection();
    System.out.println("Is '1984' available? " + myLibrary.isAvailable("1984"));
    myLibrary.checkOut("1984");
    System.out.println("Is '1984' available after checkout? " + myLibrary.isAvailable("1984"));
    myLibrary.returnBook("1984");
    System.out.println("Is '1984' available after return? " + myLibrary.isAvailable("1984"));
    myLibrary.removeTitle("Pride and Prejudice");
    myLibrary.printCollection();
    myLibrary.addTitle("The Catcher in the Rye", "J.D. Salinger", 1951);
}
}