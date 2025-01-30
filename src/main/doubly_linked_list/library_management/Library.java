package main.doubly_linked_list.library_management;

public class Library {
    private Book head = null;
    private Book tail = null;
    private int bookCount = 0;

    // Add a new book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a new book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a new book at a specific position
    public void addBookAtPosition(int position, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
        } else if (position > bookCount) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            Book newBook = new Book(title, author, genre, bookId, isAvailable);
            Book current = head;
            int count = 1;

            while (count < position - 1) {
                current = current.next;
                count++;
            }

            newBook.next = current.next;
            newBook.prev = current;

            if (current.next != null) {
                current.next.prev = newBook;
            }

            current.next = newBook;
            bookCount++;
        }
    }

    // Remove a book by main.doubly_linked_list.library_management.Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("main.doubly_linked_list.library_management.Library is empty. No book to remove.");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) current.next.prev = current.prev;
                }

                System.out.println("main.doubly_linked_list.library_management.Book with ID " + bookId + " removed.");
                bookCount--;
                return;
            }
            current = current.next;
        }

        System.out.println("main.doubly_linked_list.library_management.Book with ID " + bookId + " not found.");
    }

    // Search for a book by Title or Author
    public void searchBook(String keyword) {
        if (head == null) {
            System.out.println("main.doubly_linked_list.library_management.Library is empty. No book found.");
            return;
        }

        Book current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                System.out.println("main.doubly_linked_list.library_management.Book Found: ID=" + current.bookId + ", Title=" + current.title + ", Author=" +
                        current.author + ", Genre=" + current.genre + ", Available=" + current.isAvailable);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No book found with the keyword: " + keyword);
        }
    }

    // Update a book's Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability of main.doubly_linked_list.library_management.Book ID " + bookId + " updated to " + isAvailable);
                return;
            }
            current = current.next;
        }

        System.out.println("main.doubly_linked_list.library_management.Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("main.doubly_linked_list.library_management.Library is empty. No books to display.");
            return;
        }

        Book current = head;
        while (current != null) {
            System.out.println("main.doubly_linked_list.library_management.Book ID=" + current.bookId + ", Title=" + current.title + ", Author=" + current.author +
                    ", Genre=" + current.genre + ", Available=" + current.isAvailable);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("main.doubly_linked_list.library_management.Library is empty. No books to display.");
            return;
        }

        Book current = tail;
        while (current != null) {
            System.out.println("main.doubly_linked_list.library_management.Book ID=" + current.bookId + ", Title=" + current.title + ", Author=" + current.author +
                    ", Genre=" + current.genre + ", Available=" + current.isAvailable);
            current = current.prev;
        }
    }

    // Count the total number of books
    public void countBooks() {
        System.out.println("Total number of books in the library: " + bookCount);
    }
}
