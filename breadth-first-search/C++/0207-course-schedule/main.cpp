#include <iostream>
#include <vector>
#include <queue>

using namespace std;


class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>> &prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int plen = prerequisites.size();
        if (plen == 0) {
            return true;
        }
        vector<int> inDegree(numCourses);
        for (auto p:prerequisites) {
            inDegree[p[0]]++;
        }
        queue<int> q;
        for (int i = 0; i < numCourses; ++i) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        // 拓扑排序的结果
        vector<int> res;
        while (!q.empty()) {
            int num = q.front();
            q.pop();
            res.push_back(num);
            // 【我在看代码的时候，就觉得这个地方可能是超时的原因】
            for (auto p:prerequisites) {
                if (p[1] == num) {
                    inDegree[p[0]]--;
                    if (inDegree[p[0]] == 0) {
                        q.push(p[0]);
                    }
                }
            }
        }
        return res.size() == numCourses;
    }
};
