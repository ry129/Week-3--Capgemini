package main.circular_linked_list.ticket;

class TicketReservationSystem {
    // Node representing each ticket reservation
    class TicketNode {
        int ticketID;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        TicketNode(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketID = ticketID;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head; // Points to the first node in the circular list
    private int size;        // Number of tickets in the system

    // Constructor to initialize the system
    public TicketReservationSystem() {
        head = null;
        size = 0;
    }

    // Add a new ticket reservation at the end of the circular list
    public void addReservation(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            // If the list is empty, make this the only node (circular)
            head = newTicket;
            newTicket.next = head;
        } else {
            // Traverse to the last node and insert the new ticket
            TicketNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTicket;
            newTicket.next = head;
        }
        size++;
    }

    // Remove a ticket by Ticket ID
    public boolean removeTicketByID(int ticketID) {
        if (head == null) return false;

        TicketNode current = head;
        TicketNode prev = null;

        do {
            if (current.ticketID == ticketID) {
                if (prev == null) {
                    // If the ticket to be removed is the head (first ticket)
                    if (head.next == head) {
                        head = null; // Only one node in the list
                    } else {
                        // Find the last node to update its next pointer
                        TicketNode temp = head;
                        while (temp.next != head) {
                            temp = temp.next;
                        }
                        head = head.next; // Move head to the next node
                        temp.next = head;
                    }
                } else {
                    prev.next = current.next; // Skip the current node
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        return false; // Ticket ID not found
    }

    // Display all current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchQuery) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchQuery) || current.movieName.equalsIgnoreCase(searchQuery)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found for the given search query.");
        }
    }

    // Calculate the total number of booked tickets
    public int totalBookedTickets() {
        return size;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addReservation(101, "John Doe", "Inception", "A1", "2025-01-28 14:00");
        system.addReservation(102, "Jane Smith", "Avatar", "B3", "2025-01-28 16:00");
        system.addReservation(103, "Alice Johnson", "Titanic", "C4", "2025-01-28 18:00");

        // Display all tickets
        System.out.println("Current Tickets:");
        system.displayTickets();

        // Search for a ticket by customer name
        System.out.println("\nSearch by customer name:");
        system.searchTicket("Jane Smith");

        // Remove a ticket by Ticket ID
        System.out.println("\nRemoving ticket with ID 102:");
        if (system.removeTicketByID(102)) {
            System.out.println("Ticket removed successfully.");
        } else {
            System.out.println("Ticket not found.");
        }

        // Display all tickets after removal
        System.out.println("\nUpdated Tickets:");
        system.displayTickets();

        // Calculate total number of tickets
        System.out.println("\nTotal booked tickets: " + system.totalBookedTickets());
    }
}
