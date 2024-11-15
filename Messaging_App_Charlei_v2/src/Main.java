// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int flag=0;
        MessagingApp messagingApp = new MessagingApp();

        Scanner scanner = new Scanner(System.in);
        while (true) {

            OrdinaryCode.intro();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    messagingApp.contacts.addPerson();
                    break;
                case 2:
                    messagingApp.contacts.displayContact();
                    break;
                case 3:
                    messagingApp.contacts.deletePerson();
                    break;
                case 4:
                    messagingApp.contacts.searchContact();
                    break;
                case 5:
                    messagingApp.serverHost();
                    break;
                case 6:
                    messagingApp.clientHost();
                    break;
                case 7:
                    messagingApp.displayMessages();
                    break;
                case 8:
                    messagingApp.searchMessages();
                    break;
                case 9:
                    messagingApp.seeUnseenMessages();
                    break;
                case 10:
                    OrdinaryCode.outo();
                    flag=1;
                    //System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if(flag==1)
                break;
        }

    }// MT
}// CT

