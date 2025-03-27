package bai10;

import java.util.Optional;

public class User {
    private int id;
    private String name;
    private Optional<String> email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public String toDisplayString() {
        return String.format("Tên: %-7s | Email: %s", name, email.orElse("Không có email"));
    }
}
