public class Main {
    public static void main(String[] args) {
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


    }
}
