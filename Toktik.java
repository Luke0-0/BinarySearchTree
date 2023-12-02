/* TokTik Application
Luke Reinbach
5/4/2023
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Toktik {

    public static void main (String [] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(System.in);
        int choice = 0;
        BinarySearchTree bst = new BinarySearchTree();
        boolean check = false;

        while (choice != 8) {
            System.out.println();
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");
            System.out.print("Enter your choice: ");

            // Error statements
            try {
                choice = input.nextInt();
                if (choice <= 0 || choice >= 9 && check == false) {
                    System.out.println("That is not one of the options! Please try again.");
                }
            }
            
            // Check is used to determine if the catch statement was activated, and if so then the error message won't trigger twice in line 44
            catch(InputMismatchException i) {
                System.out.println("That is not one of the options! Please try again.");
                check = true;
            }
            
            input.nextLine();

            // If statements for choices

            // Retreive profile description from account name
            if (choice == 1) {
                System.out.print("Enter the account name: ");
                String accountName = input.nextLine();
                BinaryTreeNode profDesc = bst.find(accountName);
                if (profDesc == null) {
                    System.out.println("That account name does not exist.");
                }
                else {
                    System.out.println("The profile description is: " + profDesc.a.desc);    
                }  
            }

            // List all account names
            if (choice == 2) {
                bst.preOrder();
            }

            // Create an account to be inserted into BST
            if (choice == 3) {
                System.out.print("Enter account name: ");
                String accountName = input.nextLine();
                System.out.print("Enter account description: ");
                String desc = input.nextLine();
                bst.insert(new Account(accountName, desc));
            }

            // Remove given account from BST
            if (choice == 4) {
                System.out.print("Enter the account name: ");
                String accountName = input.nextLine();
                BinaryTreeNode test = bst.find(accountName);
                if (test == null) {
                    System.out.println("Account not found.");
                }
                else {
                    bst.delete(accountName);
                    System.out.println("Account deleted successfully.");
                }
            }

            // List all posts from given account name
            if (choice == 5) {
                System.out.print("Enter the account name: ");
                String accountName = input.nextLine();
                BinaryTreeNode title = bst.find(accountName);
                if (title == null) {
                    System.out.println("That account name does not exist.");
                }
                else if (title.a.posts.size() == 0) {
                    System.out.println("This user has no posts.");
                }
                else {
                    Account a = title.a;
                    for (int i = 0; i < a.posts.size(); i++) {
                        System.out.println();
                        System.out.println("Title: " + a.posts.get(i).title);
                        System.out.println("Video: " + a.posts.get(i).video);
                        System.out.println("Number of Likes: " + a.posts.get(i).numLikes);
                    }
                }  
            }

            // Create a post for an account
            if (choice == 6) {
                System.out.print("Enter account name: ");
                String accountName = input.nextLine();
                BinaryTreeNode postInfo = bst.find(accountName);
                if (postInfo == null) {
                    System.out.println("That account name does not exist.");
                }
                else {
                    System.out.print("Enter the title: ");
                    String title = input.nextLine();
                    System.out.print("Enter the file name: ");
                    String fileName = input.nextLine();

                    Random random = new Random();
                    int numLikes = random.nextInt(10000);

                    Post p = new Post(title, fileName, numLikes);
                    postInfo.a.posts.add(p);
                } 
            }

            // Load file into program
            if (choice == 7) {
                System.out.print("Enter file name: ");
                String fileName = input.next();
                File file = new File(fileName);
                if (file.exists()) {
                    try (Scanner fileScanner = new Scanner(file)) {
                        while(fileScanner.hasNextLine()){
                            String command = fileScanner.nextLine();
                            if (command.substring(0, 6).equals("Create")) {
                                int secondSpace = command.indexOf(" ", 8);
                                String name = command.substring(7, secondSpace);
                                String description = command.substring(secondSpace + 1);
                                Account account = new Account(name, description);
                                bst.insert(account);
                            }
                        }
                    }
                    System.out.println("File loaded successfully.");
                }
                else {
                    System.out.println("File does not exist.");
                }
                
            }

            // End the program
            if (choice == 8) {
                System.out.println();
                System.out.println("Bye!");
                input.close();
            }

        }
       

        

      







    }    
}