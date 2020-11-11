
import org.junit.Test;
import static org.junit.Assert.*;

public class LCA_DAGTest {

    @Test
    public void testFindLCA(){

        LCA_DAG newGraph = new LCA_DAG();
        newGraph.root = new dagNode(1);
        dagNode n2 = new dagNode(2);
        dagNode n3 = new dagNode(3);
        dagNode n4 = new dagNode(4);
        dagNode n5 = new dagNode(5);
        dagNode n6 = new dagNode(6);

        dagNode[] rootout = {n2, n3, n4, n5};

        dagNode[] n2out = {n4};
        dagNode[] n2in = {newGraph.root};

        dagNode[] n3out = {n4, n5};
        dagNode[] n3in = {newGraph.root};

        dagNode[] n4out = {n5};
        dagNode[] n4in = {newGraph.root, n2, n3};

        dagNode[] n5in = {newGraph.root, n3, n4};

        dagNode[] n6in = {n4};

        newGraph.addEdgeOut(newGraph.root, rootout);
        newGraph.addEdgeOut(n2, n2out);
        newGraph.addEdgeIn(n2, n2in);
        newGraph.addEdgeOut(n3, n3out);
        newGraph.addEdgeIn(n3, n3in);
        newGraph.addEdgeOut(n4, n4out);
        newGraph.addEdgeIn(n4, n4in);
        newGraph.addEdgeIn(n5, n5in);
        newGraph.addEdgeIn(n6, n6in);


        assertEquals("", 3, newGraph.findLCA(n5, n4));
        assertEquals("", 1, newGraph.findLCA(n4, n3));
        assertEquals("", 1, newGraph.findLCA(newGraph.root, n2));
        assertEquals("", 4, newGraph.findLCA(n6, n5));
        assertEquals("", 5, newGraph.findLCA(n5, n5));
    }

}
