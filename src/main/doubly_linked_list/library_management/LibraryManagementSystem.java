package main.doubly_linked_list.library_management;

// Main Class to test the main.doubly_linked_list.library_management.Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd("The Alchemist", "Paulo Coelho", "Fiction", 101, true);
        library.addBookAtBeginning("To Kill a Mockingbird", "Harper Lee", "Classic", 102, false);
        library.addBookAtPosition(2, "1984", "George Orwell", "Dystopian", 103, true);

        System.out.println("\nBooks in Forward Order:");
        library.displayBooksForward();

        System.out.println("\nBooks in Reverse Order:");
        library.displayBooksReverse();

        System.out.println("\nSearch for 'Paulo Coelho':");
        library.searchBook("Paulo Coelho");

        System.out.println("\nUpdate Availability for main.doubly_linked_list.library_management.Book ID 101:");
        library.updateAvailability(101, false);

        System.out.println("\nRemove main.doubly_linked_list.library_management.Book with ID 102:");
        library.removeBookById(102);

        System.out.println("\nBooks After Removal:");
        library.displayBooksForward();

        System.out.println("\nTotal Number of Books:");
        library.countBooks();
    }
}
