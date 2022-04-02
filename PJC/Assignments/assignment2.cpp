#include <iostream>
#include <string>

using namespace std;

template <typename T>
struct Node {
	T data;
	Node* next;

	Node(T data) {
		this->data = data;
		this->next = nullptr;
	}
};

template <typename T>
void pushBack(Node<T>*& head_ref, T data) {
	if ((head_ref) == nullptr) {
		(head_ref) = new Node(data);
		return;
	}
	Node<T>* it = (head_ref);
	while (it->next != nullptr) {
		it = it->next;
	}
	it->next = new Node(data);
}

template <typename T>
void showList(const Node<T>* head) {
	Node<T>* temp = head;
	while (temp) {
		cout << temp->data << " ";
		temp = temp->next;
	}
	cout << "\n";
}

template <typename T>
Node<T>* arrayToList(const T a[], size_t size) {
	Node<T>* head = nullptr;
	for (int i = 0; i < size; i++) {
		pushBack(head, a[i]);
	}

	return head;
}

template <typename T, typename Pred>
Node<T>* extract(Node<T>*& head, Pred pred) {
	Node<T>* curr = head;
	while (curr) {
		if (pred(curr->data)) {
			cout << curr->data << " ";
		}
		curr = curr->next;
	}
	cout << endl;
}

template <typename T>
void deleteList(Node<T>*& head) {
	while (head) {
		Node<T>* temp = head;
		head = head->next;
		free(temp);
		showList(head);
	}
}

bool isLong(const std::string& s) { return s.size() >= 5; }

int main() {
	int tabi[] = { 2, 1, 4, 3, 6, 5, 7, 8 };
	size_t sizei = sizeof(tabi) / sizeof(tabi[0]);
	Node<int>* listAi = arrayToList(tabi, sizei);
	showList(listAi);
	Node<int>* listBi = extract(listAi,
		[](int n) {
			return n % 2 == 0;
		});
	showList(listBi);
	showList(listAi);
	deleteList(listBi);
	deleteList(listAi);

	std::string tabs[]{ "Kasia", "Ola", "Ala",
						"Zosia", "Ela", "Basia" };
	size_t sizes = sizeof(tabs) / sizeof(tabs[0]);
	Node<std::string>* listAs = arrayToList(tabs, sizes);
	showList(listAs);
	Node<std::string>* listBs = extract(listAs, isLong);
	showList(listBs);
	showList(listAs);
	deleteList(listBs);
	deleteList(listAs);
}
