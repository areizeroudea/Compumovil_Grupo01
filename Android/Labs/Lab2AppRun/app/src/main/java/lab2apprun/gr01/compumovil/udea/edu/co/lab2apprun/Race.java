package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

/**
 * Created by areizero on 19/03/2016.
 */
public class Race
{
    private long id;
    private String name;
    private String descripion;
    private String distance;
    private String place;
    private String contactPhone;
    private String contactEmail;
    private String date;

    public Race()
    {
    }

    public Race(long id, String name, String descripion, String distance, String place, String contactPhone, String contactEmail, String date)
    {
        this.id = id;
        this.name = name;
        this.descripion = descripion;
        this.distance = distance;
        this.place = place;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
