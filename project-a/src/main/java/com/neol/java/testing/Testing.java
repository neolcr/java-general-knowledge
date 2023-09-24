package com.neol.java.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


interface Authorizer {
    Boolean authorize(String username, String password);
}

class System {
    private final Authorizer authorized;

    public System(Authorizer authorizer) {

        this.authorized = authorizer;
    }

    public int loginCount() {
        return this.authorized == null ? 0 : 1;
    }

    public Authorizer getAuthorizedUsers() {
        return authorized;
    }
}

// Test Double: Dummy: it is used in a test where itself is not the actual important thing
class DummyAuthorizer implements Authorizer {
    public Boolean authorize(String username, String password) {
        return null;
    }
}

// Test Double: Stub (It is a kind of Dummy)
class AcceptingAuthorizerStub implements Authorizer {
    public Boolean authorize(String username, String password) {
        return true;
    }
}
// Test Double: Spy (It is a kind of Stub)
class AcceptingAuthorizerSpy implements Authorizer {
    public boolean authorizeWasCalled = false;

    public Boolean authorize(String username, String password) {
        authorizeWasCalled = true;
        return true;
    }
}

// Test Double: Mock (It is a kind of Spy)
class AcceptingAuthorizerVerificationMock implements Authorizer {
    public boolean authorizeWasCalled = false;

    public Boolean authorize(String username, String password) {
        authorizeWasCalled = true;
        return true;
    }

    public boolean verify() {
        return this.authorizeWasCalled;
    }
}

// Test Double: Fake (Completely different approach)
class AcceptingAuthorizerFake implements Authorizer {
    public Boolean authorize(String username, String password) {
        return username.equals("Bob");
    }
}

public class Testing {

    @Test
    public void testDummy() {
        System system = new System(new DummyAuthorizer());
        assertEquals(system.loginCount(), 1);
    }

    @Test
    public void testStub() {
        System system = new System(new AcceptingAuthorizerStub());
        Assertions.assertTrue(system.getAuthorizedUsers().authorize("Bob", "123"));
    }

    @Test
    public void testSpy(){
        AcceptingAuthorizerSpy acceptingAuthorizerSpy = new AcceptingAuthorizerSpy();
        System system = new System(acceptingAuthorizerSpy);
        system.getAuthorizedUsers().authorize("Bob", "123");
        Assertions.assertTrue(acceptingAuthorizerSpy.authorizeWasCalled);

    }

    @Test
    public void testMock(){
        AcceptingAuthorizerVerificationMock mock = new AcceptingAuthorizerVerificationMock();
        System system = new System(mock);
        system.getAuthorizedUsers().authorize("Bob", "123");
        Assertions.assertTrue(mock.verify());
    }

    @Test
    public void testFake(){
        AcceptingAuthorizerFake fake = new AcceptingAuthorizerFake();
        System system = new System(fake);
        system.getAuthorizedUsers().authorize("Bob", "123");
        // Implement in system the user name and so on
    }
}
