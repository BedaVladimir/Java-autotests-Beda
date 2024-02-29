package model;

public record ContactData(String fname, String lname, String address, String number, String email) {
    public ContactData() {
        this("", "", "", "", "");
    }
    public ContactData withFirstName(String fname) {
        return new ContactData(fname, this.lname, this.address, this.number, this.email);
    }
    public ContactData withLastName(String lname) {
        return new ContactData(this.fname, lname, this.address, this.number, this.email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.fname, this.lname, address, this.number, this.email);
    }
    public ContactData withNumber(String number) {
        return new ContactData(this.fname, this.lname, this.address, number, this.email);
    }
    public ContactData withEmail(String email) {
        return new ContactData(this.fname, this.lname, this.address, this.number, email);
    }
}