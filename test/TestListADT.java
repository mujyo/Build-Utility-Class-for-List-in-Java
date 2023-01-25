import listadt.ListADT;
import listadt.ListADTImpl;
import listadt.ListADTUtilities;
import org.junit.Before;
import org.junit.Test;

public class TestListADT {
    String[] listNorm;
    String[] listExcep;
    ListADT<String> lAdt;
    ListADT<String> lAdtJoint;
    ListADT<String> lAdtDisJoint;
    ListADT<String> lAdtDisExcep;
    ListADT<String> lAdtEqual;
    @Before
    public void setUp(){
        listNorm = new String[]{"a", "b", "c", "d"};
        listExcep = new String[]{"a", "b", null, "c"};
        this.lAdt = new ListADTImpl<String>();
        this.lAdt.addBack("1");
        this.lAdt.addBack("1");
        this.lAdt.addBack("2");
        this.lAdt.addBack("3");

        this.lAdtJoint = new ListADTImpl<String>();
        this.lAdtJoint.addBack("5");
        this.lAdtJoint.addBack("6");
        this.lAdtJoint.addBack("7");
        this.lAdtJoint.addBack("8");

        this.lAdtDisJoint = new ListADTImpl<String>();
        this.lAdtDisJoint.addBack("1");
        this.lAdtDisJoint.addBack("2");
        this.lAdtDisJoint.addBack("1");
        this.lAdtDisJoint.addBack("3");

        this.lAdtDisExcep = new ListADTImpl<String>();
        this.lAdtDisExcep.addBack("1");
        this.lAdtDisExcep.addBack(null);

        this.lAdtEqual = new ListADTImpl<String>();
        this.lAdtEqual.addBack("1");
        this.lAdtEqual.addBack("1");
        this.lAdtEqual.addBack("2");
        this.lAdtEqual.addBack("3");
    }

    @Test
    public void testToList(){
        ListADT strListADTNorm = ListADTUtilities.toList(this.listNorm);
        assert (strListADTNorm.toString().equals("(a b c d)"));

        try{
            ListADT strListADTExcep = ListADTUtilities.toList(listExcep);
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }
    }

    @Test
    public void testAddAll(){
        ListADTUtilities.addAll(this.lAdt, this.listNorm);
        assert (this.lAdt.toString().equals("(1 2 3 a b c d)"));

        try{
            ListADTUtilities.addAll(this.lAdt, null);
        } catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }
    }

    @Test
    public void testFreq(){
        assert (ListADTUtilities.frequency(this.lAdt, "1")==2);
    }

    @Test
    public void testDisjoint(){
        assert (ListADTUtilities.disjoint(this.lAdt, this.lAdtJoint) == true);
        assert (ListADTUtilities.disjoint(this.lAdt, this.lAdtDisJoint) == false);

        try {
            ListADTUtilities.disjoint(this.lAdt, this.lAdtDisExcep);
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }
    }

    @Test
    public void testEqual(){
        assert (ListADTUtilities.equals(this.lAdt, this.lAdtEqual) == true);
        assert (ListADTUtilities.equals(this.lAdt, this.lAdtDisJoint) == false);

        try {
            ListADTUtilities.equals(this.lAdt, this.lAdtDisExcep);
        }catch(IllegalArgumentException err){
            System.out.println(err.toString());
        }
    }

    @Test
    public void testReverse(){
        ListADTUtilities.reverse(this.lAdt);
        assert (this.lAdt.toString().equals("(3 2 1 1)"));
    }

    @Test
    public void testSwap(){
        ListADTUtilities.swap(this.lAdtEqual, 1, 2);
        assert (this.lAdtEqual.toString().equals("(1 2 1 3)"));
    }
}
