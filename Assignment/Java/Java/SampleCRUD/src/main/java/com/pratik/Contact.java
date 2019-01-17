package com.pratik;

/**
 * Contact
 */
public class Contact {

    private int home;
    private int office;
    private int personal;

    public void AddContacts() {
        System.out.println("Enter your home number");
        this.home = App.input.nextInt();

        System.out.println("Enter your office number");
        this.office = App.input.nextInt();

        System.out.println("Enter your personal number");
        this.personal = App.input.nextInt();
    }

    /**
     * @return the home
     */
    public int getHome() {
        return home;
    }

    /**
     * @return the personal
     */
    public int getPersonal() {
        return personal;
    }

    /**
     * @param personal the personal to set
     */
    public void setPersonal(int personal) {
        this.personal = personal;
    }

    /**
     * @return the office
     */
    public int getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(int office) {
        this.office = office;
    }

    /**
     * @param home the home to set
     */
    public void setHome(int home) {
        this.home = home;
    }
}