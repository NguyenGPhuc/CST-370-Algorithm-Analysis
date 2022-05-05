/*
 * INSTRUCTION:
 *     This is a C++ staring code for hw7_2.
 *     When you finish the development, download this file.
 *     Note that the current filename is "main.cpp".
 *     But rename it to "main_hw7_2.cpp".
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, ID, Name, and Date.
/*
 * Title: main_hw7_2.cpp
 * Abstract: Using BFS, mark each neighbor to the current node as one more than the current marked number. Print out that list at the end.
 * ID: 1337
 * Name: Paul Nguyen
 * Date: 03/24/2022
 */

#include <iostream>
#include <queue>
#include <vector>
#include <map>
using namespace std;

// auto read_graph(vector<vector<int>> & g)
// {
//     map<string, int> intToString;
//     int num_of_vertices;
//     string city;
    
  
//     cin >> num_of_vertices;

//     for (int i = 0; i < num_of_vertices; i++){
//       cin >> city;
//       intToString.insert(pair<string, int>(city, i));
//     }
  
  
//     // for (auto& t : intToString){
//     // std::cout << t.first << " " 
//     //           << t.second << "\n";
//     // }
  
//     // Adjust the size of graph vector to hold all vertices.
//     g.resize(num_of_vertices);
    
//     int num_of_edges;
//     cin >> num_of_edges;


//     string from;
//     string to;
    
//     for (int i = 0; i < num_of_edges-1; i++) 
//     {
        
//         // cin >> from;
//         // cin >> to;
//         cin >> from >> to;
//         auto f = intToString.find(from);
//         auto t = intToString.find(to);
      
//         g[f->second].push_back(t->second);
//     }
  
//     return intToString;
// }


void printGraph(vector<vector<int>> & g) 
{
    for (int i = 0; i < g.size(); i++) 
    {
        cout << i;
        for (int j = 0; j < g[i].size(); j++) 
        {
            cout << " -> " << g[i][j];
        }
        cout << endl;
    }
}


vector<int> bfs(vector<vector<int>> & g, int src, map<string, int> cMap) 
{
  queue<int> q;
	int count = 1;
	vector<int> mark(g.size(), -1);
  
	mark[src] += count;
    q.push(src);
    while (!q.empty()) 
    {
        int curr = q.front();
        q.pop();

        
        // cout << "visiting: " << curr << endl;

        for (int i = 0; i < g[curr].size(); i++) 
        {
            int neighbor = g[curr][i];
            if(mark[neighbor] == -1) 
            {
				        mark[neighbor] = mark[curr]+1;
                q.push(neighbor);
            }
        }
    }

  // cout << "\n==== Mark Array ==== " << endl;
	// for (int i = 0; i < g.size(); i++)
	// {
	// 	cout << "Mark[" << i << "]: " << mark[i] << endl;
	// }
  // int i = 0;
  // for (auto& t : cMap){
  //   std::cout << t.second << ":" << mark[i] << "\n" ;
  //   i++;
  // }

    return mark;
}



int main()
{
    vector<vector<int>> graph;
    

    map<string, int> intToString;
    int num_of_vertices;
    string city;
    string startCity = "MO";
    int hop = 0;

    
  
    cin >> num_of_vertices;

    for (int i = 0; i < num_of_vertices; i++){
      cin >> city;
      intToString.insert(pair<string, int>(city, i));
    }
  
  
    // Adjust the size of graph vector to hold all vertices.
    graph.resize(num_of_vertices);
    
    int num_of_edges;
    cin >> num_of_edges;


    string from;
    string to;
    
    for (int i = 0; i < num_of_edges; i++) 
    {

        cin >> from >> to;
        

        auto f = intToString.find(from);
        auto t = intToString.find(to);
      
        graph[f->second].push_back(t->second);
        
    }
    
    cin >> startCity;
    cin >> hop;
  
    // cout << "==== Printing Input Graph - Vertext By Vertex =====" << endl;
    // printGraph(graph);

    auto it = intToString.find(startCity);
    int src = it->second;
  
    // cout << "\n==== BFS - Source Vertext: " << src << " =====" << endl;
    auto modBsf = bfs(graph, src, intToString);
    auto t =  intToString.cbegin();
    for (int i = 0; i < num_of_vertices; i++){
      
      if (modBsf[t->second] <= hop && modBsf[t->second] != -1){
        cout << t->first << ":" << modBsf[t->second] << endl;
      }
      ++t;
    }

    return 0;
}

