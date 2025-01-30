package main.singly_linked_list.social_media;

import java.util.Scanner;

public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();
        Scanner scanner = new Scanner(System.in);

        // Example Usage
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 22);
        sm.addUser(4, "Diana", 28);

        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.removeFriendConnection(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.searchUser("Alice");
        sm.searchUser("3");

        sm.countFriends();
    }
}
