package model;

public class UserModel {
    public int id;
    public String userName;
    public String password;
    public String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"userName\":\"" + userName + "\"" +
                ", \"password\":\"" + password + "\"" +
                ", \"displayName\":\"" + displayName + "\"" +
                "}";
    }
}
