#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
private:

    pair<string, double> &find(const string &C,
                               unordered_map<string, pair<string, double >> &parent) {

        if (C != parent[C].first) {
            const auto &p = find(parent[C].first, parent);

            parent[C].first = p.first;
            parent[C].second *= p.second;
        }
        return parent[C];
    }

public:
    vector<double> calcEquation(vector<vector<string>> &equations,
                                vector<double> &values,
                                vector<vector<string>> &queries) {

        unordered_map<string, pair<string, double >> parent;
        int size = equations.size();

        for (int i = 0; i < size; ++i) {
            const string &A = equations[i][0];
            const string &B = equations[i][1];
            const double k = values[i];

            if (!parent.count(A) && !parent.count(B)) {
                // 如果 A 和 B 目前不在一个集合中
                parent[A] = {B, k};
                parent[B] = {B, 1.0};
            } else if (!parent.count(A)) {
                // 如果只有 A 不在集合中
                parent[A] = {B, k};
            } else if (!parent.count(B)) {
                parent[B] = {A, 1.0 / k};
            } else {
                auto &rootA = find(A, parent);
                auto &rootB = find(B, parent);

                if (rootA != rootB) {
                    rootA.first = rootB.first;
                    rootA.second *= (k * rootB.second);
                }
            }
        }

        vector<double> res;

        for (const auto &query:queries) {
            const string &X = query[0];
            const string &Y = query[1];

            if (!parent.count(X) || !parent.count(Y)) {
                res.push_back(-1.0);
                continue;
            }

            auto &rootX = find(X, parent);
            auto &rootY = find(Y, parent);

            if (rootX.first != rootY.first) {
                res.push_back(-1.0);
            } else {
                res.push_back(rootX.second / rootY.second);
            }
        }
        return res;
    }
};

