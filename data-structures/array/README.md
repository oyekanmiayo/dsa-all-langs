## Introduction

An array is a collection of items that are store contiguously in memory. This means that they are right next to each
other. Each index in an array maps to an addressable region in memory.

## Internals

In most languages, arrays have two properties: they have a fixed size and they contain the same type of elements.

They have a fixed size because the semantics of an array requires assigning space in advance. Therefore, the computer
must know if it has enough space or not.

They have to contain the same types of elements because different types of elements take up a different amounts of space
in memory. For example, in Java, int requires 4 bytes (32 bits) of storage and long requires 8 bytes (64 bits) of
storage.

If the compiler knows the type of elements and the length of the array, it knows how much space is needed in total for
the array.

```java
// The below will require 4 * 10 == 40 bytes of memory
int[] intArr = new int[10];
```

Strings (and Objects in general) present an interesting case though. Assuming confinement to the ASCII standard, each
character requires a byte of memory. Therefore, having a string like “Ogbeni” will require 6 bytes of storage. Cool, but
how does the compiler know exactly how much memory an array of strings needs?

```java
// 10 * x bytes. What is x?
String[] strArr = new String[10];
``` 

For Strings (and Objects), what is stored at the each block (or range of blocks) in memory is actually a reference to
the actual String (or Object).

(TODO: An image to illustrate)

The size of a reference is typically 32 bits (4 bytes) on a 32-bit machine and 64 bits (8 bytes) on a 64-bit machine. 
So `x` above could be 4 or 8.  (The JVM allows something called a compressed pointer which allows 32 bit references on 64 bit machines.)

```java
// 10 * 4 bytes = 40 bytes (32-bit)
// 10 * 8 bytes = 80 bytes (64-bit)
String[] strArr = new String[10];
```

Each string is stored in a different area in memory when it’s created its size is known.

One last thing to discuss: how do languages like JS and Python allow different data types in their array (/list)? Arrays
are objects, so they can contain any combination of things. In that case how do we decide the amount of memory to
preallocate to an array in a language like JS?

Well, we can either use the reference method I explained for Strings or use max data type size present or a mixture of
both. I haven’t properly researched this, so this is just my assumption.

## Operations

1. Accessing an element  (at index)

   This is a constant operation - O(1) - because of some of the guarantees we have for arrays. We know there’s a fixed
   size and we know the data type (which means we know how much memory each element in the array needs).

   So the formula to get the address for an index is `firstIndexAddress + (indexToGet * bytesForEachElement)`.

## References

1. [Array Data Structure](https://www.youtube.com/watch?v=QJNwK2uJyGs)
