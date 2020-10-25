import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static User onlineUser = null;
    public static void main(String[] args) {

        int choice;
        // 1. Regions massivini ochish - 20 ta joy bo'lsin - boshlanishiga 3ta qiymat berilsin

        // 2.Distric massivini ochish - 20 ta joy bo'lsin - boshlanishiga 5ta qiymat berilsin

        // 3. User massivini ochish - 20 ta joy bo'lsin - boshlanishiga 3ta qiymat berilsin

        // 4. Category massivini ochish - 20 ta joy bo'lsin - boshlanishiga 3ta qiymat berilsin

        // 5. SubCategory massivini ochish - 20 ta joy bo'lsin - boshlanishiga 6ta qiymat berilsin

        // 6. Message massivini ochish - 20 ta joy bo'lsin
        // 7. Announcement massivini ochish - 20 ta joy bo'lsin


        // printMainMenu - method
        // login
        // signUp
        // Exit

        Region[] regions = new Region[20];
        regions[0] = new Region(1,"Toshkent");
        regions[1] =new Region(2, "Samarqand");
        regions[2] =new Region(3,"Xorazm");

        District[] districts = new District[20];
        districts[0] =new District(1,"Yunusobod",regions[0]);
        districts[1] =new District(2, "Urganch",regions[2]);
        districts[2] =new District(3,"Urgut",regions[1]);
        districts[3] =new District(4, "Chilonzor",regions[0]);
        districts[4] =new District(5, "Xiva",regions[2]);

        User[]users=new User[20];
        users[0]=new User("Anvar","anvarganiev@.uz",districts[0],"123","994567834");
        users[1]=new User("Zarina","usmonovazarina@.ru",districts[1],"1234","974563245");
        users[2]=new User("Tolibjon","tolibkarimov@gmail.com",districts[2],"12345","904562345");


        Category[] categories=new Category[20];
        categories[0]=new Category(1,"Transport","qwerty");
        categories[1]=new Category(2,"Bolalar dunyosi","rtyu");
        categories[2]=new Category(3,"Elektronika","fhgty");



        SubCategory[] subcategories=new SubCategory[20];
        subcategories[0]=new SubCategory(1,"Televizor",categories[2]);
        subcategories[1]=new SubCategory(2,"Avto",categories[0]);
        subcategories[2]=new SubCategory(3,"Bolalar kiyimlari",categories[1]);
        subcategories[3]=new SubCategory(4,"Telefon",categories[2]);



        Message[] messages = new Message[20];
        Announcement[] announcements = new Announcement[20];

        while (true) {
            printMainMenu();
            choice = scanner.nextInt();
            // 1. Log In
            // 2. Sign Up
            // 3. Exit

            switch (choice) {
                case 1 -> login(users);
                case 2 -> signUp(users, districts);
                case 3 -> System.exit(0);
            }

            boolean b = true;
            while (b) {
                printOperations();
                choice = scanner.nextInt();
                // 1. Add announcement
                // 2. View announcements
                // 3. My announcements
                // 4. Write message
                // 5. Inbox
                // 6. Logout;

                switch (choice) {
                    case 1 -> addAnnouncement(categories, subCategories, announcements);
                    case 2 -> viewAnnouncements(announcements);
                    case 3 -> viewMyAnnouncement(announcements);
                    case 4 -> writeMessage(announcements, messages);
                    case 5 -> viewInbox(messages);
                    case 6 -> b = false;
                }
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("1. Log In");
        System.out.println("2. Sign Up");
        System.out.println("3. Exit");
    }

    private static void login(User[] users) {
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        for (User user : users) {
            if (user != null) {
                if (user.login(email, password)) {
                    onlineUser = user;
                    System.out.println("\n" + user.getName() + ", Welcome to Online Announcement System");
                }
            }
        }
    }

    private static void signUp(User[] users, District[] districts) {
        boolean b = true;
        while (b) {

            scanner = new Scanner(System.in);
            System.out.print("\nFull Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            printRegions(districts);
            int districtId = scanner.nextInt();
            District district = getDistrictById(districtId, districts);
            if (district != null) {
                System.out.println(district.toString());
            }
            scanner = new Scanner(System.in);
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            boolean notFound = checkUser(email, users);
            if (notFound) {
                int index = 0;
                for (User user : users) {
                    if (user == null) {
                        users[index] = new User(name, email, district, password, phone);
                        onlineUser = users[index];
                        System.out.println("\n" + users[index].getName() + ", Welcome to Online Announcement System");
                        b = false;
                        break;
                    }
                    index++;
                }
            } else {
                System.out.println("This user is already registered to system!\n");
                b = false;
            }
        }
    }

    private static void printRegions(District[] districts) {
        System.out.println("Choose address:");
        System.out.println("----------------------");
        for (District district : districts) {
            if (district != null) {
                district.printInfo();
            }
        }
        System.out.println("----------------------");
    }

    private static District getDistrictById(int districtId, District[] districts) {

        for (District district : districts) {
            if (district != null) {
                if (district.getId() == districtId)
                    return district;
            }
        }
        return null;
    }

    private static boolean checkUser(String email, User[] users) {
        for (User user : users) {
            if (user != null) {
                if (user.getEmail().equals(email))
                    return false;
            }
        }
        return true;
    }
}
