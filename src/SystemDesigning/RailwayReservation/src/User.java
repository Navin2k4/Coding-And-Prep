

public class User {
    private String name;
    private int age;
    private String gender;
    private BerthPreference preference;

    public User(int age, String gender, BerthPreference preference, String name) {
        this.age = age;
        this.gender = gender;
        this.preference = preference;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BerthPreference getPreference() {
        return preference;
    }

    public void setPreference(BerthPreference preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return String.format(
                "%-15s : %s\n%-15s : %d\n%-15s : %s\n%-15s : %s",
                "Name", name,
                "Age", age,
                "Gender", gender,
                "Preference", preference
        );
    }
}
