package fr.univ.tours.jakartaee.tp7.business.pojo;

public record User (String email, String firstName, String lastName) {
    public boolean isValid() {
        return email != null && !email.isEmpty() && firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty();
    }
}
