public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;

    //Constructor
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS]; //20x20 matrix
        nVerts = 0;//no vertices yet

        //Fill adjMatrix with 0s
        for(int i = 0; i < MAX_VERTS; i++){
            for(int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }//end constructor

    public void addVertex(char label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(int vertex1, int vertex2) {
        adjMat[vertex1][vertex2] = 1;
        adjMat[vertex2][vertex1] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    //Depth-first search:
    // Rule 1: If possible, visit an adjacent vertex, mark it, and push it on the stack
    // Rule 2: If you can't follow rule 1, then, if possible, pop a vertex off the stack
    // Rule 3: If you can't follow rule 1 or 2, you're done
    public int getAdjUnvisitedVertex(int v) {
        for(int i = 0; i < nVerts; i++){
            if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i; //return first such vertices
            }
        }
        return -1; //no such vertices
    }

    public void dfs() {
        vertexList[0].wasVisited = true; //mark it
        displayVertex(0); //display it
        theStack.push(0); //push it

        while( !theStack.isEmpty() ) { //until the stack is empty
            int v = getAdjUnvisitedVertex( theStack.peek() );
        }
    }
}
