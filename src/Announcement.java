public class Announcement {

    String title;
    String body;
    User user;
    SubCategory subCategory;
    District district;
    double cost;

    public Announcement(String title, String body, User user, SubCategory subCategory, District district, double cost) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.subCategory = subCategory;
        this.district = district;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public District getDistrict() {
        return district;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return getUser().getName() + "   |   " + getUser().getDistrict().getName() + ", "
                + getUser().getDistrict().getRegion().getName() + "   |   " + getTitle() + "   |   "
                + getBody() + "   |   " + getCost();
    }
}
