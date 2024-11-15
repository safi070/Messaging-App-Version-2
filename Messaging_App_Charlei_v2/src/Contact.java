import java.util.Scanner;

public class Contact {

    public static int personCount = 0;

    Person[] contacts = new Person[100];

    public Contact() {
        contacts[personCount++] = new Person("192.168.1.10", 2001);
        contacts[personCount++] = new Person("192.168.1.8", 5002);
        contacts[personCount++] = new Person("192.168.1.9", 3001);
        contacts[personCount++] = new Person("192.168.1.11", 6102);
    }

    public void addPerson() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP of the Client to add ");
        String name1 = sc.nextLine();
        System.out.println("Enter the Port Number of the Client to add ");
        int num1 = sc.nextInt();
        contacts[personCount++] = new Person(name1, num1);
        System.out.println("Client Added successfully ...");
    }

    public void deletePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP of the Client to delete ");
        String name1 = sc.nextLine();
//        System.out.println("Enter the Number of the Contact to Delete ");
//        int num1 = sc.nextInt();
        int count = searchPerson(name1);
        if (count!=-1) {
            for (int i=count;i<personCount -1;i++) {
                contacts[i]=contacts[i+1];
            }
            personCount--;
            System.out.println("Contact Deleted successfully ...");
        }
        else
            System.out.println("NO such name exists in the contacts ...");
    }

    public void searchContact(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP of the Client to Search ");
        String name1 = sc.nextLine();
        int count =searchPerson(name1);
        if (count!=-1){
            System.out.println("Client Found ...");
            System.out.println(contacts[count]);
        }
        else
            System.out.println("Client not Found ...");
    }


    public int searchPerson(String name){
        for (int i=0;i<personCount;i++){
            if (contacts[i].getIp().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }


    public Person getClient(int index) {
        return contacts[index];
    }


    public void displayContact() {
        for (int i = 0; i < personCount; i++) {
            System.out.println(contacts[i]);
        }
    }
} //CT