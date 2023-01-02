package pageObjectClasses;

import org.testng.annotations.Test;

public class Open {
    @Test(priority = 3)
    void open(){
        System.out.println("am bindu");
    }
    @Test()
    void talk(){
        System.out.println("am from india");
        //Assert.fail();
    }
    @Test(priority = 1)
    void finish(){
        System.out.println("am leaving");
    }
}



