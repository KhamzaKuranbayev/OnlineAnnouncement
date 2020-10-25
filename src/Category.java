public class Category {
    int id;
    String name;
    String descreption;

    public Category(int id, String name, String descreption) {
        this.id = id;
        this.name = name;
        this.descreption = descreption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descreption='" + descreption + '\'' +
                '}';
    }
}
