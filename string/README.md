## Introduction

A string is a sequence of characters. It is a data type implemented as an array data structure that stores characters
using some character encoding standard.

## Internals

In C, a string can be defined as an array of characters (mutable). It can also be defined as a pointer to an array of
characters (which is immutable)

```c
char name[] = "Ogbeni Owolabi";

char *name = "Ogbeni Owolabi";
```

In Java, all strings defined with the `String` data type are immutable. In Java a String is an object that contains an
array of characters within. Java’s abstraction enforces immutability in this case.

```java
String name = "Ogbeni Owolabi";

public final class String {
    private final char value[];
}
```

Another interesting thing related to strings with respect to languages like Java and Python is the concept of a *string
pool*. In Java, when you declare a string literal like we did above, the string is added to a pool (designated area in
memory to store strings) and if any other string literal is defined with the same string as one that’s already in the
pool, it will point to the address of the existing string.

```java
String name = "Ogbeni Owolabi";
String name1 = "Ogbeni Owolabi";

// This statement is comparing the addesses of both strings 
// They both have the same address in memory because of the string pool mechanism
sout(name == name1); // True
```

One purpose of a string pool is to improve performance since we won’t have to create a new string object if it already
exists in the pool. The process of adding a string to the pool is
called [string interning](https://en.wikipedia.org/wiki/String_interning).

Let’s talk about **character encoding** for a moment.

We know strings are made up of characters, but computers don’t know anything about “characters”, they only know about
bits. So, the computer somehow needs to convert a character to bits and back and to do this we need rules. These rules
are defined as an encoding standard.

For example, in ASCII  (an encoding standard), the word “Jireh” is interpreted as

```
// character = code point (int) = bit representation
J = 74 = 1001010
i = 105 = 1101001
r = 114 = 1110010
e = 101 = 1100101
h = 104 = 1101000
```

The ASCII standard only defined rules for 128 characters tho, which is very limited though in the landscape of languages
worldwide. And all the 128 characters (0 -127) can be represented in memory using only 7 bits.

To fix the limitation of ASCII, a plethora of encoding standards were born, most of which offered poor inter-language
operability. For example the character code 130 would display as é, but on computers sold in Israel it was the Hebrew
letter Gimel (ג) [10]. This created a
mess.

To really fix the problem, Unicode was created. It defines rules for 1,114,112 characters. Unicode defines code points (
integers), but doesn’t exactly tell you how to encode them to bits. Unicode code points can be encoded in several ways.
UTF-32 (32 bits). UTF-16 (16 bits). UTF-8 (8 bits).

If we used UTF-32 (32 bits) to always encode, we’d waste a lot of memory because most characters are ascii and can fit
into 1 byte. Using UTF-8 allows the number of bytes to grow as needed.

## Operations

These are probably better grouped into “classes” of operations

1. String Manipulation Operations: to manipulate a string or query info about the string. See
   this [list](https://en.wikipedia.org/wiki/Comparison_of_programming_languages_(string_functions)). Examples
   are `substring()`, `length()`, `contains()` and so on.
2. String Searching Operations: to find where one or several strings are found within a larger text or string. E.g.
   Naive Search, Robin Karp, Knuth-Morris-Pratt and so on.

## References

1. A character encoding standard defines a character set that tells us how to map characters to integers (bytes?). For
   example ASCII or UTF-8.
2. Code point. (2022, March 9). In /Wikipedia/. https://en.wikipedia.org/wiki/Code_point
3. String (computer science). (2022, September 7). In
   /Wikipedia/. https://en.wikipedia.org/wiki/String_(computer_science)
4. [Difference between String literal and New String object in Java | Java67](https://www.java67.com/2014/08/difference-between-string-literal-and-new-String-object-Java.html)
5. http://www.dickbaldwin.com/java/Java050.htm#StringsandtheJavaCompiler
6. [How big is an object reference in Java and precisely what information does it contain? - Stack Overflow](https://stackoverflow.com/questions/981073/how-big-is-an-object-reference-in-java-and-precisely-what-information-does-it-co)
7. [How to Get the Size of an Object in Java | Baeldung](https://www.baeldung.com/java-size-of-object)
8. [Array - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array#description)
9. [What is the difference between the location or index of an array and the address of an element in an array? - Quora](https://www.quora.com/What-is-the-difference-between-the-location-or-index-of-an-array-and-the-address-of-an-element-in-an-array)
10. [The Absolute Minimum Every Software Developer Absolutely, Positively Must Know About Unicode and Character Sets (No Excuses!) – Joel on Software](https://www.joelonsoftware.com/2003/10/08/the-absolute-minimum-every-software-developer-absolutely-positively-must-know-about-unicode-and-character-sets-no-excuses/)
11. [What Every Programmer Absolutely, Positively Needs to Know About Encodings and Character Sets to Work With Text](https://kunststube.net/encoding/)
12. https://www.reddit.com/r/learnprogramming/comments/rsxtds/how_is_memory_allocated_for_a_string_array_when/
13. [What Every Programmer Should Know About ‘String’ | by Ahmed shamim hassan | Better Programming](https://betterprogramming.pub/what-every-programmer-should-know-about-string-a6611537f84e)
14. [data storage - Memory usage of a Java String Array - Stack Overflow](https://stackoverflow.com/questions/8894672/memory-usage-of-a-java-string-array)
15. [If == compares references in Java, why does it evaluate to true with these Strings? - Stack Overflow](https://stackoverflow.com/questions/4033625/if-compares-references-in-java-why-does-it-evaluate-to-true-with-these-strin)
16. [Is the size of C “int” 2 bytes or 4 bytes? - Stack Overflow](https://stackoverflow.com/questions/11438794/is-the-size-of-c-int-2-bytes-or-4-bytes)
17. [Where does Array stored in JVM memory in Java?](https://www.tutorialspoint.com/where-does-array-stored-in-jvm-memory-in-java)
