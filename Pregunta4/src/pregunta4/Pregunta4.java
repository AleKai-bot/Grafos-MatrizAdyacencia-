/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta4;

/**
 *
 * @author Alejandro-PC
 */
public class Pregunta4 {

    /**
     * @param args the command line arguments
     */
    int vertex;
    int matrix[][];
    int grados[][];
    int cant = 1;
    int grado;

    public Pregunta4(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
        this.grados = new int[vertex][vertex];
        this.grado = 0;
    }

    public void grado(int source, int g) {
        grados[source][1] = g;
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination] = 1;

        //add bak edge for undirected graph
        matrix[destination][source] = 1;
    }

    public void sumaGrados() {
        for (int i = 1; i < vertex; i++) {
            for (int j = 1; j < vertex; j++) {
                if (matrix[i][j] == 1) {
                    grado++;
                }
            }
            grado(i, grado);
            grado = 0;
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
            System.out.print(grados[i][1] + " conexiones a ->" + i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Pregunta4 graph = new Pregunta4(8);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 7);
        graph.addEdge(4, 7);
        graph.addEdge(6, 7);
        graph.addEdge(7, 5);
        graph.sumaGrados();
        graph.printGraph();

    }


    
    
    
}
