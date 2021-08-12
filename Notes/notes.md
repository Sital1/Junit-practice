No news is good news. Junit sees if sth failed. If nth failed then it gives the green light.

## @ Test Annotation
  - marks method as a test
  - Informs the Junit engine what methods need to run

--- 

## Using Assertion

- Create an instant of the class under test. 
- Set up Inputs
- Execute the code you want to test
- Compare Expected versus actual. 

assertEqual(): 
  - `assertEquals(Expected,Actual)` // Asserts that expected and actual are equal
  - `assertArrayEquals(expectedArray,actualArray)` // Verifies each item in the arrays are equal in the right position
  - `assertIterableEquals(expectedArray,actualArray))`// Verifies each item in the iterable are equal in the right position

[Junit Assertion Docs](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

Junit will give proper log output
