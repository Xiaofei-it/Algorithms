/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiaofei on 16/6/4.
 */
public class Prim {

    public static void solve(int[][] graph) {
        Set<Edge> edges1 = new HashSet<>();
        Set<Edge> edges2 = new HashSet<>();
        Set<Integer> vertexes1 = new HashSet<>();
        Set<Integer> vertexes2 = new HashSet<>();
        for (int i = 0; i < graph.length; ++i) {
            vertexes1.add(i);
            for (int j = i + 1; j < graph[i].length; ++j) {
                if (graph[i][j] > 0) {
                    edges1.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        vertexes1.remove(0);
        vertexes2.add(0);
        while (!vertexes1.isEmpty()) {
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;
            for (Edge edge : edges1) {
                if (vertexes1.contains(edge.start) && vertexes2.contains(edge.end)
                    || vertexes1.contains(edge.end) && vertexes2.contains(edge.start)) {
                    if (edge.weight < minWeight) {
                        minWeight = edge.weight;
                        minEdge = edge;
                    }
                }
            }
            edges2.add(minEdge);
            vertexes1.remove(minEdge.start);
            vertexes1.remove(minEdge.end);
            vertexes2.add(minEdge.start);
            vertexes2.add(minEdge.end);
        }
        for (Edge edge : edges2) {
            System.out.println(edge.start + " " + edge.end + " " + edge.weight);
        }
        System.out.println();
    }

    private static class Edge {
        int start;
        int end;
        int weight;
        Edge(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }

    }
}
