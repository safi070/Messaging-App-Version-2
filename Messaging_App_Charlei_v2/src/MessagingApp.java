import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessagingApp {
    Message[][] messages = new Message[100][100];
    Contact contacts;
    private final String senderName="Safi";
    //[No of contacts][No of messages]


    public MessagingApp() {
        contacts = new Contact();// Initialize the contacts object
        initializeMessages();
    }

    public void initializeMessages() {
        Message msg1 = new Message(senderName, "Ali", "Hi, How are you ?");
        Message msg2 = new Message(senderName, "Hamza", "The great gatsby ");
        Message msg3 = new Message(senderName, "Ahmed", "A pine of woods");
        Message msg4 = new Message(senderName, "mustafa", "Hi, What are you doing ?");


        // messages[Contacts NUM ] [Messages Number]
        // Contacts numbers [0]=Ali   [1]=Hamza   [2]=Ahmed   [3]=mustafa
        // messages numbers []

        messages[0][0] = msg1;
        messages[1][0] = msg2;
        messages[2][0] = msg3;
        messages[3][0] = msg4;
    }

//    public void sendMessage(String senderName,String receiver,String content) {
//
//        Message msg = new Message(senderName, receiver, content);
//        for (int i = 0; i < contacts.personCount; i++) {
//            if (contacts.getClient(i).getIp().equals(receiver)) {
//                for (int j = 0; j < messages[i].length; j++) {
//                    if (messages[i][j] == null) {
//                        messages[i][j] = msg;
//                        break;
//                    }
//                }
//            }
//        }
//    }


    public void sendMessage(String senderName, String receiver, String content) {
        Message msg = new Message(senderName, receiver, content);
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getClient(i).getIp().equals(receiver) |contacts.getClient(i).getIp().equals(senderName)) {
                // Store the message in the messages array for the correct contact
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] == null) { // Find the first empty slot
                        messages[i][j] = msg; // Store the message
                        System.out.println("Message stored: " + msg.getMessageContent());
                        break; // Exit after storing the message
                    }
                }
                break; // Exit after finding the correct client
            }
        }
    }



//    public void sendMessageToServer(String senderName, String receiver, String content) {
//        Message msg = new Message(senderName, receiver, content);
//        for (int i = 0; i < contacts.personCount; i++) {
//            if (contacts.getClient(i).getIp().equals(senderName)) {
//                // Store the message in the messages array for the correct contact
//                for (int j = 0; j < messages[i].length; j++) {
//                    if (messages[i][j] == null) { // Find the first empty slot
//                        messages[i][j] = msg; // Store the message
//                        System.out.println("Message stored: " + msg.getMessageContent());
//                        break; // Exit after storing the message
//                    }
//                }
//                break; // Exit after finding the correct client
//            }
//        }
//    }





    public void displayMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP of the client to display its messages "); // receiver name
        String name = sc.nextLine();
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getClient(i).getIp().equals(name)|contacts.getClient(i).getIp().equals(senderName)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null) {
                        System.out.println("From : " + messages[i][j].getSenderName() + "  At Time : " + messages[i][j].getTimeStamp());
                        System.out.println(messages[i][j].getMessageContent() + "\n");
                    }
                }
            }
        }
    }

    public void searchMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name of the name of contact for search "); // receiver name
        String name = sc.nextLine();
        System.out.println("Enter the keyword you want to search  ");
        String keyword = sc.nextLine();
        boolean flag=false;
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getClient(i).getIp().equals(name)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null && messages[i][j].getMessageContent().contains(keyword)) {
                        System.out.println("Message Found   From Chats " + messages[i][j].getReceiverName());
                        System.out.println(messages[i][j].getMessageId());
                        System.out.println(messages[i][j].getMessageContent());
                        flag=true;
                    }
                }
                if(!flag)
                    System.out.println("No message is found ...");
            }
        }
    }


    public void seeUnseenMessages() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person to see unseen messages ");
        String name = sc.nextLine();
        boolean unseenMessageFound = false;
        for (int i = 0; i < contacts.personCount; i++) {
            if (contacts.getClient(i).getIp().equals(name)) {
                for (int j = 0; j < messages[i].length; j++) {
                    if (messages[i][j] != null && !messages[i][j].isSeen()) {
                        System.out.println("From : " + messages[i][j].getSenderName()+ " To : "+messages[i][j].getReceiverName() + "  At Time : " + messages[i][j].getTimeStamp());
                        System.out.println(messages[i][j].getMessageContent() + "\n");
                        messages[i][j].setSeen(true);
                        unseenMessageFound = true;
                    }
                }
            }
        }
        if (!unseenMessageFound) {
            System.out.println("No unseen messages found ... ");
        }
    }

    public void serverHost(){
        Scanner sc =new Scanner(System.in);

        System.out.println("You have chose server ");
        System.out.println("Enter Port Num  ");
        int port=sc.nextInt();

       server(port);
    }

    public void clientHost() {
        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter Port Num  ");
//        int port1 = sc.nextInt();
        System.out.println("Enter IP address ");
        String ip = sc.nextLine();

     //   sc.nextLine();


        int exist = contacts.searchPerson(ip);
        if (exist != -1) {
           int port1= contacts.getClient(exist).getPortNum();
           client(ip,port1);
        }
        else
            System.out.println("Client doesn't Exist Add it first ");



    } //FT



    public void client(String ip,int port) {

        try {
            Socket client = new Socket(ip,port);


            while (true) {
                OutputStreamWriter os = new OutputStreamWriter(client.getOutputStream());
                PrintWriter out = new PrintWriter(os, true); // to send the data on the network
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Message to send over the network ");
                String msg = sc.nextLine();
                sendMessage(senderName,ip,msg);   // send and store message
                out.println(msg);

                if (msg.equalsIgnoreCase("0")){
                    break;
                }

                InputStreamReader isr = new InputStreamReader(client.getInputStream()); // Gives a reader a object
                BufferedReader in = new BufferedReader(isr);
                String str = in.readLine();
                sendMessage(ip,senderName,str);   // send and store message
                if (str.equalsIgnoreCase("0")){
                    break;
                }
                System.out.println("Server :  " + str);
            }


        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.out.println(e.getMessage());

        }
    }




    public void server(int port) {
        if (getIpOfClient(port).equalsIgnoreCase("0")) {
            System.out.println("Wrong Port Address of the desired Ip");
            return;
        }
        try {
            System.out.println("Waiting for client to join .....");
            ServerSocket server = new ServerSocket(port);
            Socket ss = server.accept();
            System.out.println("Client Connected ");

            // Server loop for receiving and sending messages
            while (true) {
                InputStreamReader isr = new InputStreamReader(ss.getInputStream());
                BufferedReader in = new BufferedReader(isr);
                String str = in.readLine();
                sendMessage(getIpOfClient(port),"Safi", str); // send and store message
                if (str.equalsIgnoreCase("0")) {
                    break;
                }
                System.out.println("Client :  " + str);

                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Message to send to the client ");
                String msg = sc.nextLine();
                if (msg.equalsIgnoreCase("0")) {
                    break;
                }
                sendMessage("Safi", getIpOfClient(port), msg); // send and store message
                OutputStreamWriter os = new OutputStreamWriter(ss.getOutputStream());
                PrintWriter out = new PrintWriter(os, true);
                out.println(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getIpOfClient(int portNum) {
        for (int i = 0; i < 20; i++) {
            if (contacts.getClient(i).getPortNum() == portNum) {
                return contacts.getClient(i).getIp();
            }
        }
        return "0";
    }





}//CT

