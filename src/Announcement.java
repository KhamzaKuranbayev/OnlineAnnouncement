public class Announcement {
    private String title;
    private String body;


    public Announcement(String title, String body, double cost) {
        this.title = title;
        this.body = body;
        this.cost = cost;
    }

    private   double cost;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Announsment{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", cost=" + cost +
                '}';
    }
}
