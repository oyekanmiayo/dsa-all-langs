#include <iostream>
#include "SinglyLinkedLists.h"

int main() {
    auto head = new SinglyLinkedList();
    head->add_first(6);
    head->add_first(7);
    head->add_first(7);
    head->add_first(7);
    head->add_last(8);
    head->add_last(9);
    delete head;
    return 0;
}
