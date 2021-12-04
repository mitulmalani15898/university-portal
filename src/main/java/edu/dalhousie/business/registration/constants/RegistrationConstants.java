package edu.dalhousie.business.registration.constants;

import java.util.HashMap;
import java.util.Map;

public class RegistrationConstants {
    public static final Map<Integer, String> genders = new HashMap<Integer, String>() {
        {
            put(1, "swimming");
            put(2, "badminton");
            put(3, "table tennis");
            put(4, "gym");
        }
    };
}
