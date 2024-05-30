"""
Author: Jennifer Chukwu
"""

class Entry:
    """
    This represents the template for the node object that is used for the linkedlist.
    """
        
    def __init__(self, element):
        """
        :param element: This represents the element contained in the Node.
        :type element: This element can be of any type ranging from strings, numbers, arrays etc.
        """
        self.element = element
        self.next = None

class Set:
    def __init__(self):

        # Prime used to increase chances of generating unique keys
        self.PRIME = 31
        self.entries = [None] * 29

    def add(self, element):
        """
        The `add` method Stores the element in the set.

        :param element: element to be stored in the set
        :return true if element to be added doesn't exist, and false if it does
        """

        # Generate hash (or index)
        hash = self.get_hash_for_element(element)

        # Store element, if there's no collision
        if self.entries[hash] is None:
            self.entries[hash] = Entry(element)
            return True
        
        # If there's a collision, insert entry at tail of bucket (linkedlist)
        else:
            current = self.entries[hash]
            while current.next is not None:
                if current.element == element:
                    return False
                current = current.next

            # If element exists already, return because we don't want duplicates
            if current.element == element:
                return False
            current.next = Entry(element)
            return True

    def contains(self, element):
        """
        The `contains` method checks if the element is in the set.

        :param element: element whose presence is to be checked in the set
        :return true if element exists, and false if it doesn't
        """

        # Generate hash (or index)
        hash = self.get_hash_for_element(element)
        current = self.entries[hash]

        # traverse bucket(linkedlist) to find out if the element exists
        while current is not None:
            if current.element == element:
                return True
            current = current.next

        # If element is not found, return false
        return False

    def list(self):
        """
        :return a list of all elements in the set
        """
        result = []
        for entry in self.entries:
            current = entry

            # Traverse every index in array
            while current is not None:
                result.append(current.element)
                current = current.next
        return result


    def remove(self, element):
        """
        The `remove` method removes element from the set.

        :param element: element to be removed
        :return true if element was removed, and false if it wasn't
        """

        # Generate hash
        hash = self.get_hash_for_element(element)
        current = self.entries[hash]

        # keep track of the previous element 
        prev = None

        # Traverse the list to find element 
        while current is not None:
            if current.element == element:
                if prev is None:
                    self.entries[hash] = current.next
                else:
                    prev.next = current.next
                return True
            prev = current
            current = current.next

        # If element doesn't exist, so was not deleted
        return False

    def get_hash_for_element(self, element):
        return (hash(element) * self.PRIME) % len(self.entries)

if __name__ == '__main__':
    my_set = Set()
    
    # Adding elements to the set
    print("Adding elements:")
    print("Add 10:", my_set.add(10))  # Should print True
    print("Add 20:", my_set.add(20))  # Should print True
    print("Add 30:", my_set.add(30))  # Should print True
    print("Add 10 again:", my_set.add(10))  # Should print False (already added)
    
    # Checking if elements are in the set
    print("\nChecking elements:")
    print("Contains 10:", my_set.contains(10))  # Should print True
    print("Contains 20:", my_set.contains(20))  # Should print True
    print("Contains 40:", my_set.contains(40))  # Should print False
    
    # Removing an element
    print("\nRemoving elements:")
    print("Remove 10:", my_set.remove(10))  # Should print True
    print("Remove 40:", my_set.remove(40))  # Should print False (not in set)
    
    # Listing all elements in the set
    print("\nCurrent set elements:")
    print(my_set.list())  # Should print [30, 20]
