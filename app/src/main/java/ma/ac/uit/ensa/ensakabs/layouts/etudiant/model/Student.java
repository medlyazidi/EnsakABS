package ma.ac.uit.ensa.ensakabs.layouts.etudiant.model;


public class Student {
    String items;
    private boolean selected;


    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Student(String items  ) {

        this.items = items;
    }
    public boolean getSelected() {
        return selected;
    }

    public boolean setSelected(Boolean selected) {
        return this.selected = selected;
    }
}
