

import org.testng.Assert;
import org.testng.annotations.Test;


public class AreaTest {


    @Test
    public void testSquareAreaPositive() {
        Square s = new Square(5);
        Assert.assertEquals(25.0, s.sayArea());

    }


    private void testSquareAreaNegative() {
        Square s = new Square(5);
        Assert.assertEquals(25, s.sayArea());

    }

}
