package feature.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordDemoTest {
    @Test
    public void testToCreatePersonDetailsInJava11(){

        PersonInJava11 person = new PersonInJava11("John", 36);

        Assertions.assertEquals(person.getAge(), 36);
        Assertions.assertEquals(person.getName(),"John");
    }

    @Test
    public void testToCreatePersonDetails(){

        Person person = new Person("John", 36);

        Assertions.assertEquals(person.age(), 36);
        Assertions.assertEquals(person.name(),"John");
    }
}
