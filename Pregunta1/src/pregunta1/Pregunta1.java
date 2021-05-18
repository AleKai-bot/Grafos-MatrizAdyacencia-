/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pregunta1;

import java.util.LinkedList;

/**
 *
 * @author Alejandro-PC
 */
public class Pregunta1 {

    static class Graph {

        int vertices;
        LinkedList<Integer>[] adjList;
        int resp[];
        int cant = 0;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            this.resp = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEgde(int source, int destination) {
            adjList[source].addFirst(destination);
        }

        public void addElement(int source) {
            resp[cant] = source;
            cant++;
        }

        public boolean hayCiclo() {
            boolean visitados[] = new boolean[vertices];
            boolean[] arrayAux = new boolean[vertices];
            for (int i = 0; i < vertices; i++) {
                if (hayCicloAux(i, visitados, arrayAux)) {
                    return true;
                }
            }
            return false;
        }

        public void showCycle() {
            for (int i = 0; i < resp.length; i++) {
                if (resp[i] != 0) {
                    System.out.println(resp[i]);
                }
            }
        }

        public boolean hayCicloAux(int vertex, boolean[] visited, boolean[] array) {
            visited[vertex] = true;
            array[vertex] = true;
            for (int i = 0; i < adjList[vertex].size(); i++) {
                int adjVertex = adjList[vertex].get(i);
                if (!visited[adjVertex] && hayCicloAux(adjVertex, visited, array)) {
                    addElement(adjVertex);
                    return true;
                } else if (array[adjVertex]) {
                    return true;
                }
            }
            array[vertex] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        int vertices = 10;
        Graph graph = new Graph(vertices);
        graph.addEgde(1, 2);
        graph.addEgde(2, 3);
        graph.addEgde(3, 2);

        if (graph.hayCiclo()) {
            System.out.println("Si existe un ciclo y es");
            graph.showCycle();
        } else {
            System.out.println("No existe un ciclo");
        }

    }

}
