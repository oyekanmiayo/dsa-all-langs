#include <iostream>
/**
 * @author: Jennifer Chukwu
 */

template <class T> class Set {
  /**
   * This represents the template for the object that is stored at the
   * underlying array's indexes
   */

private:
  struct Entry {
    T element;
    Entry *next;

    Entry(T element) : element(element), next(nullptr) {}
    Entry() : next(nullptr) {} // Default constructor to allow array of pointers
  };

  static const int TABLE_SIZE = 29; // Size of the hash table
  static const int PRIME = 31;      // Prime number used in the hash function
  Entry *entries[TABLE_SIZE];       // Array of pointers to Entry

  int getHashForElement(const T &element) {
    return (std::hash<T>()(element) * PRIME) % TABLE_SIZE;
  }

public:
  Set() {
    for (int i = 0; i < TABLE_SIZE; ++i) {
      entries[i] = nullptr; // Initialize all entries to nullptr
    }
  }

  ~Set() {
    for (int i = 0; i < TABLE_SIZE; ++i) {
      Entry *current = entries[i];
      while (current != nullptr) {
        Entry *toDelete = current;
        current = current->next;
        delete toDelete;
      }
    }
  }

  /**
   * Stores the element in the set.
   *
   * @param element element to be stored in the set
   * @return true if element to be added doesn't exist, and false if it does
   */
  bool add(T element) {
    // Generate hash (or index)
    int hash = getHashForElement(element);

    Entry *newEntry = new Entry(element);
    Entry *entry = entries[hash];

    // Store element, if there's no collision
    if (entry == nullptr) {
      entries[hash] = newEntry;
      return true;
    }

    // If there's a collision, insert entry at tail of bucket (linkedlist)
    while (entry != nullptr) {

      // If element exists already, return because we don't want duplicates
      if (element == entry->element) {
        return false;
      }

      entry = entry->next;
    }

    entry->next = newEntry;
    return true;
  }

  /**
   * Checks if the element is in the set.
   *
   * @param element element whose presence is to be checked in the set
   * @return true if element exists, and false if it doesn't
   */
  bool contains(T element) {
    // Generate hash (or index)
    int hash = getHashForElement(element);

    // If no element is stored at index, then return false
    if (entries[hash] == nullptr) {
      return false;
    }

    // If there's a collision, traverse bucket(linkedlist) to find
    // out if the element exists
    Entry *entry = entries[hash];
    while (entry != nullptr) {

      // If element is found, return true
      if (element == entry->element) {
        return true;
      }

      entry = entry->next;
    }

    // If element is not found, return false
    return false;
  }

  /**
   * @removes element from the set
   * @return true if element to be deleted was removed, and false if it wasn't
   */
  bool remove(const T &element) {
    // Generate hash
    int hash = getHashForElement(element);

    Entry *current = entries[hash];
    Entry *prev = nullptr;

    // traverse each valid entry
    while (current != nullptr) {
      if (current->element == element) {
        if (prev == nullptr) {
          entries[hash] = current->next;
        } else {
          prev->next = current->next;
        }
        delete current;
        // return true if element exists and was deleted
        return true;
      }
      prev = current;
      current = current->next;
    }
    // If element doesn't exist, so was not deleted
    return false;
  }

  /**
   * @outputs all the elements in the set
   */

  void traverse() {
    for (int i = 0; i < TABLE_SIZE; ++i) {
      Entry *current = entries[i];
      while (current != nullptr) {
        std::cout << current->element << ", ";
        current = current->next;
      }
    }
    std::cout << std::endl;
  }
};

int main() {
  Set<int> mySet;
  mySet.add(10);
  mySet.add(20);
  mySet.add(30);
  mySet.add(30);

  mySet.traverse();

  std::cout << "Contains 20: " << mySet.contains(20) << std::endl;
  std::cout << "Contains 20 after removal: " << mySet.remove(80) << std::endl;

  return 0;
}