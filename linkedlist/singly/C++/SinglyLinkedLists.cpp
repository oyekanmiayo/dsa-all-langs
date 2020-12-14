
//
// Created by Simon Akpoveso on 13/12/2020.
//

#include "SinglyLinkedLists.h"
#include <iostream>

using namespace std;

SinglyLinkedList::SinglyLinkedList() {
    head_node = nullptr;
}

void SinglyLinkedList::update_list_size(bool increase) {
    if (increase){
        size+=1;
    }else {
        size-=1;
    }
}

void SinglyLinkedList::add_first(int data) {
    if (head_node == nullptr) {
        head_node = new Node;
        head_node->data = data;
        head_node->next = nullptr;
        update_list_size(true);
        return;
    }
    Node *current = head_node;
    Node *temp;
    while (current != nullptr){
        temp = current;
        current = current->next;
    }
    current = new Node;
    temp->next = current;
    current->data = data;
    current->next = nullptr;
    update_list_size(true);
}

void SinglyLinkedList::add_last(int data) {
    if (head_node == nullptr) {
        head_node = new Node;
        head_node->data = data;
        head_node->next = nullptr;
        update_list_size(true);
        return;
    }
    Node *temp = head_node;
    head_node = new Node;
    head_node->data = data;
    head_node->next = temp;
    update_list_size(true);
}

void SinglyLinkedList::add_at_position(int position, int data) {
    if (size+1 < position) {
        std::cout << "List not large enough" << std::endl;
    }else if (position == size+1) {
        add_first(data);
    }else if (position == 0){
        add_last(data);
    }else {
        Node *temp = head_node;
        for (int i = 0; i < position - 1; ++i) {
            //Subtract position from 1 so we don't point to the data we want to substitute
            temp = temp->next;
        }
        auto new_node = new Node;
        new_node->data = data;
        new_node->next = temp->next;
        temp->next = new_node;
        update_list_size(true);
    }
}

void SinglyLinkedList::remove_first() {
    if (size == 1){
        Node *temp = head_node;
        head_node = nullptr;
        update_list_size(false);
        delete temp;
    }else {
        Node *temp = head_node;
        head_node = head_node->next;
        update_list_size(false);
        delete temp;
    }
}

void SinglyLinkedList::remove_last() {
    if (size == 1){
        Node *temp = head_node;
        head_node = nullptr;
        update_list_size(false);
        delete temp;
    }else {
        Node *temp;
        Node *current = head_node;
        for (int i = 0; i < size - 1; ++i) {
            temp = current;
            current = current->next;
        }
        temp->next = nullptr;
        update_list_size(false);
        delete current;
    }

}

void SinglyLinkedList::remove_at_position(int position) {
    if (size-1 < position) {
        std::cout << "List not large enough" << std::endl;
    }else if (position == size-1) {
        remove_last();
    }else if (position == 0){
        remove_first();
    }else {
        Node *temp = head_node;
        Node *current;
        for (int i = 0; i < position; ++i) {
            current = temp;
            temp = temp->next;
        }
        current->next = temp->next;
        delete temp;
        update_list_size(false);
    }
}

Node *SinglyLinkedList::get_head_pointer() {
    return head_node;
};

int SinglyLinkedList::get_list_size() {
    return size;
}

void SinglyLinkedList::delete_nodes() { //Free all the internally allocated memory for the lists
    Node *temp = head_node;
    while (temp != nullptr) {
        temp = head_node->next;
        delete head_node;
        head_node = temp;
    }
}

SinglyLinkedList::~SinglyLinkedList() {
    delete_nodes();
}