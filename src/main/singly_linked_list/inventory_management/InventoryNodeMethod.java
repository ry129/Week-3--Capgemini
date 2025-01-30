package main.singly_linked_list.inventory_management;

public class InventoryNodeMethod {
        InventoryNode root;

        // Add a item to the list
        public void add(String itemName, int itemID, int quantity, double price, int pos) {
            InventoryNode templ = new InventoryNode(itemName, itemID, quantity, price);

            // If adding at the head of the list
            if (pos == 0) {
                templ.next = root;
                root = templ;
                return;
            }

            InventoryNode current = templ;
            int currentIndex = 0;

            // Traverse the list to find the correct position
            while (current != null && currentIndex < pos - 1) {
                current = current.next;
                currentIndex++;
            }

            // If `pos` is out of range
            if (current == null) {
                System.out.println("Invalid position: " + pos);
                return;
            }

            // Insert the new node at the specified position
            templ.next = current.next;
            current.next = templ;
        }


        // Display all item
        public void display() {
            if (root == null) {
                System.out.println("Bag is empty.");
                return;
            }

            InventoryNode t = root;
            while (t != null) {
                System.out.println("Item Name: " + t.itemName);
                System.out.println("Item ID: " + t.itemID);
                System.out.println("Quantity: " + t.quantity);
                System.out.println("Price: " + t.price);
                System.out.println();
                t = t.next;
            }
        }

        // Delete a iem by itemID number
        public void delete(int itemID) {
            if (root == null) {
                System.out.println("Bag  is empty. Nothing to delete.");
                return;
            }

            // If the head node is to be deleted
            if (root.itemID == itemID) {
                root = root.next;
                System.out.println("Item with itemID  " + itemID + " deleted.");
                return;
            }

            InventoryNode current = root;
            InventoryNode previous = null;

            while (current != null && current.itemID!= itemID) {
                previous = current;
                current = current.next;
            }

            if (current == null) {
                System.out.println("Item with ItemID " +itemID + " not found.");
                return;
            }

            previous.next = current.next;
            System.out.println("Student with roll number " + itemID + " deleted.");
        }

        // Display an item by itemID
        public void displayByItemID(int itemID) {
            if (root == null) {
                System.out.println("Item list is empty.");
                return;
            }

            InventoryNode t = root;
            while (t != null) {
                if (t.itemID == itemID) {
                    System.out.println("Details of item with itemID " + itemID + ":");
                    System.out.println("Name: " + t.itemName);
                    System.out.println("ID: " + t.itemID);
                    System.out.println("Quantity: " + t.quantity);
                    System.out.println("Price: " + t.price);
                    return;
                }
                t = t.next;
            }

            System.out.println("item with itemID " + itemID + " not found.");
        }


        public void upgradeGrade(int itemID, int finalQuantit) {
            if (root == null) {
                System.out.println("Bag is empty.");
                return;
            }

            InventoryNode t = root;
            while (t != null) {
                if (t.itemID == itemID) {
                    t.quantity = finalQuantit;
                    System.out.println("Quantity of item with itemID : " + itemID + " updated to " + finalQuantit + ".");
                    return;
                }
                t = t.next;
            }

            System.out.println("Item not found.");
        }


        //calculate total value of inventory
        public double total(InventoryNode root) {
            if (root == null) {
                System.out.println("Bag is empty.");
            }
            double total = 0.0;
            InventoryNode current = root;
            while (current != null) {
                total += current.price*current.quantity;
                current = current.next;
            }
            return total;
        }




        //sort the inventory based of price or name
        public void sort() {
            if (root == null) {
                System.out.println("Bag is empty.");
                return;
            }

            InventoryNode current = root;
            InventoryNode index = null;

            // Bubble sort based on price
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if (current.price > index.price) {
                        // Swap the values of the nodes
                        String tempName = current.itemName;
                        int tempID = current.itemID;
                        int tempQuantity = current.quantity;
                        double tempPrice = current.price;

                        current.itemName = index.itemName;
                        current.itemID = index.itemID;
                        current.quantity = index.quantity;
                        current.price = index.price;

                        index.itemName = tempName;
                        index.itemID = tempID;
                        index.quantity = tempQuantity;
                        index.price = tempPrice;
                    }
                    index = index.next;
                }
                current = current.next;
            }

            System.out.println("Inventory sorted by price.");
        }



    }
