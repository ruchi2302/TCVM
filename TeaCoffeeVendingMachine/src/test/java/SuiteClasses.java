import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ContainerStatusTest.class, MakeBlackCoffeeTest.class, MakeCoffeeTest.class,
		MakeBlackTeaTest.class, MakeTeaTest.class, RefillContainerTest.class, ResetContainerTest.class })

public class SuiteClasses {

}
