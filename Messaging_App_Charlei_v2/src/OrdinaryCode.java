import java.io.IOException;

//import org.jline.terminal.Terminal;
//import org.jline.terminal.TerminalBuilder;

public class OrdinaryCode {


    public static void intro(){
        System.out.println("""
                \n\n\n\n\t\t\t\t\t _________________________________________________
                         \t\t\t|              WELCOME TO TALKZY                  |
                         \t\t\t|              Your Own Chatting App              |
                         \t\t\t|_________________________________________________|
                      \n\n\t\t\t What do you want to perform??
                      \n\t\t\t 1. Add IP
                      \n\t\t\t 2. Display all IPs
                      \n\t\t\t 3. Delete a IP
                      \n\t\t\t 4. Search a IP
                      \n\t\t\t 5. Become Server Host 
                      \n\t\t\t 6. Become a client
                      \n\t\t\t 7. See Chats
                      \n\t\t\t 8. Search Messages
                      \n\t\t\t 9. See unseen Messages
                      \n\t\t\t 10. Exit
                      """);
    }

    public static void outo(){
        System.out.println("""
                \n\n\n\n\t\t\t\t\t _________________________________________________
                         \t\t\t|           THANK-YOU For Using TALKZY            |
                         \t\t\t|              Your Own Chatting App              |
                         \t\t\t|_________________________________________________|
                         \t\t\t| PRODUCED BY :
                         \t\t\t| *** NAME ***                        *** REG-NO ***  
                         \t\t\t| Muhammad Safi-Ur-Rehman           / SP24-BSE-083 /
                         \t\t\t| Muhammad Saffi                  / FA23-BCS-208 / 
                """);
    }




    public void loading() throws InterruptedException{
        for(int i=0;i<5;i++){
//            System.out.println("Loading |");
//            Thread.sleep(100);
//            System.out.println("\033c");
//            clrscr();
            if(i==0){
                System.out.println("Loading /");
                Thread.sleep(100);
                //   System.out.println("\033c");
                //clrscr();
                clear();
            }
            if(i==2){
                System.out.println("Loading -");
                Thread.sleep(100);
                //   System.out.println("\033c");
                //clrscr();
                clear();
            }
            if(i==3){
                System.out.println("Loading \\");
                Thread.sleep(100);
                // System.out.println("\033c");
                // clrscr();
                clear();
            }
            if(i==4){
                System.out.println("Loading |");
                Thread.sleep(500);
                // System.out.println("\033c ");
                //clrscr();
                clear();
            }
        }
    }


    public static void clrscr(){
//Clears Screen in java.
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());

        }
    }


    public static void clear() {
        // This is the ANSI escape code for clearing the terminal screen
        System.out.print("\033[H\033[2J");
        System.out.flush();  // Flush the output to apply the change
    }


    public static void clear1() {
        try {
            // Windows
            if (System.getProperty("os.name").contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                // Unix/Linux/MacOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clear2() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


//    public class ClearScreen {
//        public static void clear() {
//            try {
//                // Create a terminal instance using JLine
//                Terminal terminal = TerminalBuilder.builder().system(true).build();
//                terminal.puts(org.jline.utils.InfoCmp.Capability.clear);
//                terminal.flush();  // Apply the clear command
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

} // CT
