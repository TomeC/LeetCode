// https://leetcode.cn/problems/clone-graph/submissions/
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
using namespace std;

class Node
{
public:
    int val;
    vector<Node *> neighbors;
    Node()
    {
        val = 0;
        neighbors = vector<Node *>();
    }
    Node(int _val)
    {
        val = _val;
        neighbors = vector<Node *>();
    }
    Node(int _val, vector<Node *> _neighbors)
    {
        val = _val;
        neighbors = _neighbors;
    }
};

class Solution
{
public:
    Node *cloneGraph(Node *node)
    {
        if (node == nullptr)
        {
            return nullptr;
        }
        unordered_map<int, Node *> cacheMap;
        unordered_set<int> vMap;
        return dfsCloneGraph(node, cacheMap, vMap);
    }
    Node *dfsCloneGraph(Node *node, unordered_map<int, Node *> &cacheMap, unordered_set<int> &vMap)
    {
        Node *cNode = cacheMap[node->val];
        if (cNode == nullptr)
        {
            cNode = new Node(node->val);
            cacheMap[cNode->val] = cNode;
        }
        vMap.emplace(cNode->val);
        for (size_t i = 0; i < node->neighbors.size(); i++)
        {
            int nv = node->neighbors[i]->val;
            Node *tNode = cacheMap[nv];
            if (tNode == nullptr)
            {
                tNode = new Node(nv);
                cacheMap[nv] = tNode;
            }
            cNode->neighbors.push_back(tNode);
            if (vMap.find(nv) == vMap.end())
            {
                dfsCloneGraph(node->neighbors[i], cacheMap, vMap);
            }
        }
        return cNode;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    Node *n1 = new Node(1);
    Node *n2 = new Node(2);
    Node *n3 = new Node(3);
    Node *n4 = new Node(4);

    n1->neighbors.push_back(n2);
    n1->neighbors.push_back(n4);

    n2->neighbors.push_back(n1);
    n2->neighbors.push_back(n3);

    n3->neighbors.push_back(n2);
    n3->neighbors.push_back(n4);

    n4->neighbors.push_back(n1);
    n4->neighbors.push_back(n3);
    Node *node = s.cloneGraph(n1);
    return 0;
}
