package racetrack

import grails.test.mixin.*

/**
 * Created by rommelrico on 9/11/14.
 */
@TestFor(User)
class UserTests {
    void testSimpleConstraints() {
        mockForConstraintsTests(User)
        def user = new User(login:"someone",password:"blah",role:"SuperUser")
        assertFalse user.validate()
        assertEquals "inList", user.errors["role"]
    }

    void testUniqueConstraint(){
        def jdoe = new User(login:"jdoe",password:"blah",role:"user")
        def admin = new User(login:"admin",password:"blah",role:"admin")
        mockDomain(User, [jdoe, admin])

        def badUser = new User(login:"jdoe")
        badUser.save()
        assertEquals 2, User.count()
        assertNull badUser.errors["login"]

        def goodUser = new User(login:"good", password:"password", role:"user")
        goodUser.save()
        assertEquals 3, User.count()
        assertNotNull User.findByLoginAndPassword("good", "password")
    }
}
