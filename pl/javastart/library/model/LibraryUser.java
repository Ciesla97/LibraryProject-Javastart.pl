package pl.javastart.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User{

    private List<Publication> publicationHistory = new ArrayList<>();
    private List<Publication> borrowedPubliactions = new ArrayList<>();

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
    }

    @Override
    public String toCsv() {
        return getFirstName() + ";" + getLastName() + ";" + getPesel();
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPubliactions() {
        return borrowedPubliactions;
    }

    public void addPubliactionsToHistory(Publication pub){
        publicationHistory.add(pub);
    }
    public void borrowPublication(Publication pub){
        borrowedPubliactions.add(pub);
    }
    public boolean returnPublication(Publication pub){
        boolean result = false;
        if(borrowedPubliactions.contains(pub)) {
            borrowedPubliactions.remove(pub);
            addPubliactionsToHistory(pub);
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(publicationHistory, that.publicationHistory) && Objects.equals(borrowedPubliactions,
                that.borrowedPubliactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationHistory, borrowedPubliactions);
    }
}
