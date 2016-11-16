package dto;

public class Employer {
    public String companyName;
    public String address;
    public String city;
    public String zip;
    public String phone;
    public String email;
    public String brokerName;
    public String additionalLocations;
    public String sic;

    public Employer(String companyName,
                    String address,
                    String zip,
                    String sic
                    ) {
        this.companyName = companyName;
        this.address = address;
        this.zip = zip;
        this.sic = sic;
    }
}
