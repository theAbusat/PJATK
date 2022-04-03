#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<map>


using namespace std;

struct Connection {
	string from;
	string to;
	int duration;
	Connection(string from, string to, int duration)
		: from(from), to(to), duration(duration)
	{ }
};

ostream& operator<<(ostream& s, const Connection& c) {
	return cout << c.from << " -> " << c.to << ": " << c.duration << "s\n";
}


int main(){
    ifstream infile("STL-telephones.dat");
    string caller;
    string calee;
    int dur;
    map<string, vector<Connection>> m;
    while(infile >> caller >> calee >> dur){
        m[caller].push_back(Connection(caller, calee, dur));
        
    }

	
    infile.close();

	string chatterbox; // name of greatest chatterbox
	int longestTime = 0; // longest time 'talked' by
	// one person as the caller
	// ...
	// loop calculating and printing total time
	// talked by each person and finding the person
	// with this time the longest

	for(auto it = m.begin(); it!= m.end(); ++it){
		cout << it->first << ": ";
		int sum = 0;
		for(auto it2 = it->second.begin(); it2 != it->second.end(); ++it2){
			sum = sum + it2->duration;
			if (sum > longestTime)
			{
				longestTime = sum;
				chatterbox = it2->from;
			}
			
		}
		cout << sum << " seconds\n";
	}

	// ...
	// printing the name and the list of
	// connections of the greatest chatterbox

	cout << chatterbox << " chattered for " << longestTime << " seconds" <<  endl;
	for(auto it = m.begin(); it != m.end(); it++){
		int count = 0;
		if (it->first == chatterbox)
		{
			for (auto it2 = it->second.begin(); it2 != it->second.end(); ++it2)
				cout << *it2;
		}
		
	}
    

}
