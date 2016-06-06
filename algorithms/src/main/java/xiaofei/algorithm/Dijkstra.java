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
 * Created by Xiaofei on 16/6/6.
 */
public class Dijkstra {

    public static void solve(int[][] graph, int source) {
        int length = graph.length;
        int[] dist = new int[length];
        int[] prev = new int[length];
        Set<Integer> vertexes = new HashSet<>();
        for (int i = 0; i < length; ++i) {
            dist[i] = graph[source][i] == 0 ? Integer.MAX_VALUE : graph[source][i];
            prev[i] = graph[source][i] == 0 ? -1 : source;
            vertexes.add(i);
        }
        dist[source] = 0;
        vertexes.remove(source);
        while (!vertexes.isEmpty()) {
            int minD = Integer.MAX_VALUE;
            int min = -1;
            for (Integer i : vertexes) {
                if (dist[i] < minD) {
                    minD = dist[i];
                    min = i;
                }
            }
            vertexes.remove(min);
            for (int i = 0; i < length; ++i) {
                if (graph[min][i] > 0) {
                    if (dist[i] == Integer.MAX_VALUE || dist[i] < Integer.MAX_VALUE && dist[min] + graph[min][i] < dist[i]) {
                        dist[i] = dist[min] + graph[min][i];
                        prev[i] = min;
                    }
                }
            }
        }
        for (int i = 0; i < length; ++i) {
            System.out.println(" " + i + " " + dist[i] + " " + prev[i]);
        }
    }
}