package model;

public record ContactData(String id, String fname, String lname, String address, String number, String email) {
    public ContactData() {
        this("", "", "", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.fname, this.lname, this.address, this.number, this.email);
    }
    public ContactData withFirstName(String fname) {
        return new ContactData(this.id, fname, this.lname, this.address, this.number, this.email);
    }
    public ContactData withLastName(String lname) {
        return new ContactData(this.id, this.fname, lname, this.address, this.number, this.email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.fname, this.lname, address, this.number, this.email);
    }
    public ContactData withNumber(String number) {
        return new ContactData(this.id, this.fname, this.lname, this.address, number, this.email);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.fname, this.lname, this.address, this.number, email);
    }
}