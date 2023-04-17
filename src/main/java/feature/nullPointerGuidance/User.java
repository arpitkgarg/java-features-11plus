package feature.nullPointerGuidance;

public class User {
    public UserDetail userDetail;
    String id;
    String email;

    public static void main(String[] args) {
        User john = new User();
        john.userDetail.address.firstLine = "ABC Apartment";
    }

    public static class UserDetail {
        public Address address;
        String name;
        String mobileNumber;
    }

    public static class Address {
        public String firstLine;
        String secondLine;
        String city;
        String pincode;
    }
}


