/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta3;

/**
 *
 * @author Alejandro-PC
 */
public class Pregunta3 {

    /**
     * @param args the command line arguments
     */
    int vertex;
    int matrix[][];
    int inax[];
    int cant = 1;
    int grado;

    public Pregunta3(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
        this.inax = new int[vertex];
        this.grado = 0;
    }

    public void grado(int source) {
        inax[cant] = source;
        cant++;
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination] = 1;
    }

    public void buscaAis() {
        for (int i = 1; i < vertex; i++) {
            boolean solo = true;
            for (int j = 1; j < vertex; j++) {
                if (matrix[i][j] == 1) {
                    solo = false;
                }
            }
            if (solo) {
                grado(i);
            }
        }
    }

    public void printGraph() {
        System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 1; i < vertex; i++) {
            for (int j = 1; j < vertex; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 1; i < vertex; i++) {
            if (inax[i] != 0) {
                System.out.print("vertice inalcanzable ->" + inax[i]);
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        Pregunta3 graph = new Pregunta3(7);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);

        graph.buscaAis();
        graph.printGraph();

    }

}
