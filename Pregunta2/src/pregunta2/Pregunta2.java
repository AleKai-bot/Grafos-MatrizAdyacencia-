/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta2;

/**
 *
 * @author Alejandro-PC
 */
public class Pregunta2 {

    /**
     * @param args the command line arguments
     */
    int vertex;
    int matrix[][];
    int camino[];
    int cant = 1;

    public Pregunta2(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
        this.camino = new int[vertex];
    }

    public void addCamino(int source) {
        for (int j = 0; j < cant; j++) {
            if (camino[j] == source) {
                return;
            }
        }
        camino[cant] = source;
        cant++;
    }

    public void addEdge(int source, int destination) {
        //add edge
        matrix[source][destination] = 1;
        //add bak edge for undirected graph
        matrix[destination][source] = 1;
    }

    public void buscaCamino() {
        addCamino(1);
        for (int i = 1; i < vertex; i++) {
            for (int j = 1; j < vertex; j++) {
                if (matrix[i][j] == 1) {
                    addCamino(j);
                }
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
        System.out.print("El camino encontrado es:\n");
        for (int j = 1; j < cant; j++) {
            if (camino[j] != 0) {
                System.out.print(camino[j] + "->");
            }
        }
    }

    public static void main(String[] args) {
        Pregunta2 graph = new Pregunta2(7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 5);
        graph.addEdge(5, 1);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
      //  graph.buscaCamino();
        graph.printGraph();
        
    }

}
