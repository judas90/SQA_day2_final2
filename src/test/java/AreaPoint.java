import org.testng.Assert;
import org.testng.annotations.Test;


@Test
public class AreaPoint {

    public void testDistance() {

        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(5.0,5.0);

        Assert.assertEquals(5.656854249492381, p2.countDistance(p1));

    }

    public void testDistanceNegative(){
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(5.0,5.0);

        Assert.assertNotNull(p2.countDistance(p1),"Error!");

    }

    public void testDistanceFunction(){
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(5.0,5.0);

        Assert.assertEquals(5.656854249492381, MyFirstProgram.distance(p1,p2));

    }

}
