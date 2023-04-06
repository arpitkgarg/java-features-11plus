package learn.features.java17;

public class NullPointerGuidance {
    public static void main(String[] args) {
        User john = new User();

        john.userDetail.address.firstLine = "ABC Apartment";
    }

}


class User {
    String id;
    String email;
    UserDetail userDetail;
}

class UserDetail {
    String name;
    String mobileNumber;
    Address address;
}

class Address {
    String firstLine;
    String secondLine;
    String city;
    String pincode;
}