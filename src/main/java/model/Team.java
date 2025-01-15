package model;

public record Team(String name) {

    @Override
    public String toString() {
        return name;
    }
}
