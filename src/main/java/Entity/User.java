package Entity;

import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String e_mail;
    private String password;

    public User() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && e_mail.equals(user.e_mail) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, e_mail, password);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", e_mail='" + e_mail + '\'' + ", password='" + password + '\'' + '}';
    }
}

