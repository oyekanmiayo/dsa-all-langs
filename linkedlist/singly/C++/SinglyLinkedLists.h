//
// Created by Simon Akpoveso on 14/12/2020.
//

#ifndef LINKEDLISTS_SINGLYLINKEDLISTS_H
#define LINKEDLISTS_SINGLYLINKEDLISTS_H

struct Node{
    int data;
    Node *next;
};

class SinglyLinkedList{
private:
    Node *head_node;
    int size = 0;
    void delete_nodes();
    void update_list_size(bool increase); //A true flag adds to size and vice versa
public:
    void add_first(int data);
    void add_last(int data);
    Node* get_head_pointer();
    int get_list_size();
    void add_at_position(int position, int data); //0 indexed
    void remove_first();
    void remove_last();
    void remove_at_position(int position); //0 indexed
public:
    SinglyLinkedList();

    virtual ~SinglyLinkedList();
};


#endif //LINKEDLISTS_SINGLYLINKEDLISTS_H
