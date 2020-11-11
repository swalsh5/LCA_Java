import java.util.*;

class dagNode{

    int data;
    dagNode[] in;
    dagNode[] out;
    public dagNode(int key){
        data = key;
        in = null;
        out = null;
    }

}

public class LCA_DAG{

    dagNode root;

    public void addEdgeIn(dagNode x, dagNode[] inArr){
        x.in = inArr;
    }
    public void addEdgeOut(dagNode x, dagNode[] outArr){
        x.out = outArr;
    }
    
    public int findLCA(dagNode n1, dagNode n2) {
    	return findLCA(root, n1, n2);
    }

    public int findLCA(dagNode root, dagNode n1, dagNode n2){
        if(root == null){
            return -1;
        }
        if((root.data == n1.data) || (root.data == n2.data)){
            return root.data;
        }
        if(n1.data == n2.data){
            return n1.data;
        }
        ArrayList<Integer> lca = new ArrayList<Integer>();
        int i =0;
        while(i<n1.in.length){
            int j=0;
            while(j<n2.in.length){
                if(n1.in[i].data == n2.in[j].data){
                    lca.add(n1.in[i].data);
                    j++;
                }
                else{
                    j++;
                }
            }
            i++;
        }
        if(lca.size()==0){
            if(n1.data > n2.data){
                lca.add(findLCA(root, n1.in[0], n2));
            }
            else{
                lca.add(findLCA(root, n1, n2.in[0]));
            }
        }

        return Collections.max(lca);
    }

/*
    public static void main(String args[]) {
    LCA_DAG newGraph = new LCA_DAG();
    newGraph.root = new dagNode(1);
    dagNode r2 = new dagNode(2);
    dagNode r3 = new dagNode(3);
    dagNode r4 = new dagNode(4);
    dagNode r5 = new dagNode(5);
    dagNode r6 = new dagNode(6);

    dagNode[] rootout = {r2, r3, r4, r5};

    dagNode[] r2out = {r4};
    dagNode[] r2in = {newGraph.root};

    dagNode[] r3out = {r4, r5};
    dagNode[] r3in = {newGraph.root};

    dagNode[] r4out = {r5};
    dagNode[] r4in = {newGraph.root, r2, r3};

    dagNode[] r5in = {newGraph.root, r3, r4};

    dagNode[] r6in = {r4};

    newGraph.addEdgeOut(newGraph.root, rootout);
    newGraph.addEdgeOut(r2, r2out);
    newGraph.addEdgeIn(r2, r2in);
    newGraph.addEdgeOut(r3, r3out);
    newGraph.addEdgeIn(r3, r3in);
    newGraph.addEdgeOut(r4, r4out);
    newGraph.addEdgeIn(r4, r4in);
    newGraph.addEdgeIn(r5, r5in);
    newGraph.addEdgeIn(r6, r6in);
    
    System.out.println("LCA(Node 5, Node 4): " + newGraph.findLCA(r5, r4));
    }
*/
}