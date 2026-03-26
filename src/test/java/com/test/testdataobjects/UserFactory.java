package com.test.testdataobjects;

import com.test.pages.ProductsPage;
import com.test.utilities.ConfigReader;

public class UserFactory {

    public static User standardUser() {
        return new User(
                ConfigReader.get("user.standard.username"),
                ConfigReader.get("all.users.password")
        );
    }
    public static User performaceGlitshingUser() {
        return new User(
                ConfigReader.get("user.performance.glitch"),
                ConfigReader.get("all.users.password")

        );

    }
}
