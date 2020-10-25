public class District {

    int id;
    String name;
    Region region;

    public District(int id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public void printInfo() {
        System.out.println(getId() + ". " + getName() + ", " + getRegion().getName());
    }

    @Override
    public String toString() {
        return getName() + ", " + getRegion().getName();
    }

}
