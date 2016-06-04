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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import xiaofei.library.comparatorgenerator.ComparatorGenerator;
import xiaofei.library.comparatorgenerator.Criterion;

/**
 * Created by Xiaofei on 16/6/4.
 */
public class Kruskal {

    public static void solve(int[][] graph) {
        List<Edge> edges = new ArrayList<>();
        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        List<Edge> result = new ArrayList<>();
        int length = graph.length;
        for (int i = 0; i < length; ++i) {
            disjointSet.makeSet(i);
            for (int j = i + 1; j < length; ++j) {
                if (graph[i][j] > 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(edges, new ComparatorGenerator<>(Edge.class).generate());
        int last = -1;
        while (result.size() < length - 1) {
            while (++last < edges.size()) {
                if (disjointSet.find(edges.get(last).start) != disjointSet.find(edges.get(last).end)) {
                    break;
                }
            }
            disjointSet.union(edges.get(last).start, edges.get(last).end);
            result.add(edges.get(last));
        }
        for (Edge edge : result) {
            System.out.println(edge.start + " " + edge.end + " " + edge.weight);
        }
        System.out.println();
    }

    private static class Edge {
        int start;
        int end;
        @Criterion
        int weight;
        Edge(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }

    }
}
