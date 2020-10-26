import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static User onlineUser = null;
    static int indexAnnounce = 0;
    static int indexMessage = 0;
    static boolean hasAnnouncement = false;

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
        regions[0] = new Region(1, "Toshkent");
        regions[1] = new Region(2, "Samarqand");
        regions[2] = new Region(3, "Xorazm");

        District[] districts = new District[20];
        districts[0] = new District(1, "Yunusobod", regions[0]);
        districts[1] = new District(2, "Urganch", regions[2]);
        districts[2] = new District(3, "Urgut", regions[1]);
        districts[3] = new District(4, "Chilonzor", regions[0]);
        districts[4] = new District(5, "Xiva", regions[2]);

        User[] users = new User[20];
        users[0] = new User("Anvar", "anvarganiev@.uz", districts[0], "123", "994567834");
        users[1] = new User("Zarina", "usmonovazarina@.ru", districts[1], "1234", "974563245");
        users[2] = new User("Tolibjon", "tolibkarimov@gmail.com", districts[2], "12345", "904562345");


        Category[] categories = new Category[20];
        categories[0] = new Category(1, "Transport", "qwerty");
        categories[1] = new Category(2, "Bolalar dunyosi", "rtyu");
        categories[2] = new Category(3, "Elektronika", "fhgty");


        SubCategory[] subCategories = new SubCategory[20];
        subCategories[0] = new SubCategory(1, "Televizor", categories[2]);
        subCategories[1] = new SubCategory(2, "Avto", categories[0]);
        subCategories[2] = new SubCategory(3, "Bolalar kiyimlari", categories[1]);
        subCategories[3] = new SubCategory(4, "Telefon", categories[2]);


        Message[] messages = new Message[20];
        Announcement[] announcements = new Announcement[20];

        while (true) {
            printMainMenu();
            choice = scanner.nextInt();
            // 1. Log In
            // 2. Sign Up
            // 3. Exit

            switch (choice) {
                case 1:
                    login(users);
                    break;
                case 2:
                    signUp(users, districts);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

            if (onlineUser != null) {
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
                        case 1:
                            addAnnouncement(categories, subCategories, announcements);
                            break;
                        case 2:
                            viewAnnouncements(announcements);
                            break;
                        case 3:
                            viewMyAnnouncement(announcements);
                            break;
                        case 4:
                            writeMessage(announcements, messages);
                            break;
                        case 5:
                            viewInbox(messages);
                            break;
                        case 6:
                            b = false;
                            break;
                    }
                }
            }
        }
    }

    private static void printOperations() {
        System.out.println("\nChose the operation:");
        System.out.println("1. Add announcement");
        System.out.println("2. View announcements");
        System.out.println("3. My announcements");
        System.out.println("4. Write message");
        System.out.println("5. Inbox");
        System.out.println("6. Log out");
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

    private static void addAnnouncement(Category[] categories, SubCategory[] subCategories, Announcement[] announcements) {
        scanner = new Scanner(System.in);

        System.out.print("Title: ");
        String title = scanner.nextLine();
        categories(categories);

        int choice = scanner.nextInt();
        Category category = categories[choice - 1];

        printSubCategories(subCategories, category);

        choice = scanner.nextInt();
        SubCategory subCategory = getSubCategoryByIndex(subCategories, category, choice);
        if (subCategory != null) {
            System.out.println(category.getName() + " > " + subCategory.getName());
        }

        System.out.println("Body: ");
        scanner = new Scanner(System.in);
        String body = scanner.nextLine();
        System.out.println("Cost: ");
        double cost = scanner.nextDouble();

        announcements[indexAnnounce++] = new Announcement(title, body, onlineUser, subCategory, onlineUser.getDistrict(), cost);
        hasAnnouncement = true;
        System.out.println("Announcement saved!");
    }

    private static SubCategory getSubCategoryByIndex(SubCategory[] subCategories, Category category, int choice) {
        int index = 1;
        for (SubCategory subCategory : subCategories) {
            if (subCategory != null) {
                if (subCategory.getCategory().equals(category)) {
                    if (index == choice)
                        return subCategory;
                    index++;
                }
            }
        }
        return null;
    }

    private static void viewAnnouncements(Announcement[] announcements) {
        int index = 1;
        System.out.println("All announcement");
        System.out.println("-----------------------------------------");
        for (Announcement announcement : announcements) {
            if (announcement != null) {
                System.out.print(index + ". " + announcement.toString() + "\n");
                index++;
            }
        }
        if (index == 1)
            System.out.println("No data!");

        System.out.println("-----------------------------------------");
    }

    private static void writeMessage(Announcement[] announcements, Message[] messages) {

        if (hasAnnouncement) {
            viewAnnouncements(announcements);

            System.out.println("Choose the announcement:");
            int choice = scanner.nextInt();
            Announcement announcement = announcements[choice - 1];

            System.out.println();
            System.out.println(announcement.getTitle() + " | " + announcement.getUser().getName()
                    + " | " + announcement.getDistrict().getName() + ", " + announcement.getDistrict().getRegion().getName());

            System.out.println("New Message");
            System.out.print("Title: ");

            scanner = new Scanner(System.in);
            String title = scanner.nextLine();
            System.out.print("Body: ");
            String body = scanner.nextLine();

            messages[indexMessage++] = new Message(title, body, onlineUser, announcement);
            System.out.println("Message sent!");
        } else {
            System.out.println("There is no announcement!");
        }
    }

    private static void viewInbox(Message[] messages) {
        int index = 1;
        System.out.println("All Messages");
        System.out.println("-----------------------------------------");
        for (Message message : messages) {
            if (message != null) {
                if (message.getAnnouncement().getUser().equals(onlineUser)) {
                    System.out.println(index + ". " + message.toString());
                    index++;
                }
            }
        }
        if (index == 1)
            System.out.println("No data!");
        System.out.println("-----------------------------------------");
    }

    private static void printSubCategories(SubCategory[] subCategories, Category category) {
        System.out.println(category.getName() + "'s subcategories:");
        System.out.println("------------------------");
        int index = 1;
        for (SubCategory subCategory : subCategories) {
            if (subCategory != null) {
                if (subCategory.getCategory().equals(category)) {
                    System.out.println(index + ". " + subCategory.getName());
                    index++;
                }
            }
        }
        System.out.println("------------------------");
    }

    private static void categories(Category[] categories) {
        System.out.println("\nChoose the Category:");
        System.out.println("------------------------");
        int index = 1;
        for (Category category : categories) {
            if (category == null) {
                break;
            } else {
                System.out.println(index + ". " + category.getName());
                index++;
            }
        }
        System.out.println("------------------------");
    }

    private static void viewMyAnnouncement(Announcement[] announcements) {
        int index = 1;
        System.out.println("All announcement");
        System.out.println("-----------------------------------------");
        for (Announcement announcement : announcements) {
            if (announcement != null) {
                if (announcement.getUser().equals(onlineUser)) {
                    System.out.print(index + ". " + announcement.toString() + "\n");
                    index++;
                }
            }
        }
        if (index == 1)
            System.out.println("No data!");
        System.out.println("-----------------------------------------");
    }


}








