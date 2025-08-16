package Tasfia;


import mainpackage.telemedicineapp.User;

public class GuestUser extends User {
        public GuestUser(String name) {
            super(name, 0, "", null); // id=0, password empty, dateOfBirth=null
        }
    }



