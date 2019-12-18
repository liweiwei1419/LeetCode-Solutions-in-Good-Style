#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Solution {

private:
    double dfs(const string &A, const string &B,
               unordered_map<string, unordered_map<string, double >> graph,
               unordered_set<string> &visited) {
        if (A == B) {
            return 1.0;
        }

        visited.insert(A);

        for (const auto &pair: graph[A]) {
            const string &C = pair.first;

            if (visited.count(C)) {
                continue;
            }

            double d = dfs(C, B, graph, visited);
            if (d > 0) {
                return d * graph[A][C];
            }
        }
        return -1.0;
    }

public:
    vector<double> calcEquation(vector<vector<string>> &equations,
                                vector<double> &values,
                                vector<vector<string>> &queries) {

        unordered_map<string, unordered_map<string, double >> graph;

        int size = equations.size();
        // graph[a][b] = 2 表示 a / b = 2.0
        for (int i = 0; i < size; ++i) {
            const string &A = equations[i][0];
            const string &B = equations[i][1];

            const double k = values[i];

            graph[A][B] = k;
            graph[B][A] = 1.0 / k;
        }

        vector<double> res;

        for (vector<string> query:queries) {
            const string &X = query[0];
            const string &Y = query[1];

            if (!graph.count(X) || !graph.count(Y)) {
                res.push_back(-1.0);
                continue;
            }

            unordered_set<string> visited;
            res.push_back(dfs(X, Y, graph, visited));
        }
        return res;
    }
};
