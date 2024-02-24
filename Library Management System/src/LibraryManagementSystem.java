// Myrtle G. Gaston
// BSIT - 2

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public void borrowItem() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return "Book: " + title + " by " + author + ", published in " + publicationYear;
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean borrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
    }

    @Override
    public void borrowItem() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }

    @Override
    public String toString() {
        return "DVD: " + title + " directed by " + director + ", running time: " + runningTime + " minutes";
    }
}

abstract class LibraryUser {
    abstract void borrowItem(LibraryItem item);
    abstract void returnItem(LibraryItem item);
    abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    private LibraryItem[] borrowedItems;
    private int numBorrowed;

    public Student(int maxItems) {
        borrowedItems = new LibraryItem[maxItems];
        numBorrowed = 0;
    }

    @Override
    void borrowItem(LibraryItem item) {
        if (numBorrowed < borrowedItems.length && !item.isBorrowed()) {
            item.borrowItem();
            borrowedItems[numBorrowed++] = item;
        } else {
            System.out.println("Unable to borrow item.");
        }
    }

    @Override
    void printItemsBorrowed() {
        System.out.println("Item borrowed by Myrtle: ");
        for (LibraryItem item : borrowedItems) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }
}

class Teacher extends LibraryUser {
    private LibraryItem[] borrowedItems;
    private int numBorrowed;

    public Teacher(int maxItems) {
        borrowedItems = new LibraryItem[maxItems];
        numBorrowed = 0;
    }

    @Override
    void borrowItem(LibraryItem item) {
        if (numBorrowed < borrowedItems.length && !item.isBorrowed()) {
            item.borrowItem();
            borrowedItems[numBorrowed++] = item;
        } else {
            System.out.println("Unable to borrow item.");
        }
    }


    @Override
    void printItemsBorrowed() {
        System.out.println("Item borrowed by Professor Layasan:");
        for (LibraryItem item : borrowedItems) {
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Book book1 = new Book("Romeo & Juliet", "Shakespeare", 1597);
        DVD dvd1 = new DVD("The Notebook", "Nick Cassavetes", 123);

        Student student1 = new Student(4);
        Teacher teacher1 = new Teacher(6);

        System.out.println("-----------------");

        student1.borrowItem(book1);
        student1.printItemsBorrowed();
        
        
        System.out.println("---------");
        System.out.println("-----------------");

        teacher1.borrowItem(dvd1);
        teacher1.printItemsBorrowed();

        System.out.println("---------");
        System.out.println("-----------------");
    }
}