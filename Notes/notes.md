No news is good news. Junit sees if sth failed. If nth failed then it gives the green light.


## Principles on which Junit 5 is founded

-	 Minimize footprint.
-	 Simplify test cases.
-	 Provide extensibility over features.
-	 Prefer specific plug points to general ones
---

## Test Classes

 - JUnit 5 test classes and test methods are not required to be public
   - The constructor can be package protected, or protected, or even private. 
     - The constructors can have parameters
   
     ``` 
     // TestInfo is a parameter resolver
     public SomeTestClass(TestInfo test)
     {    
          // Displays the name of test class for each test case
          System.out.println("Working on Test "+ testInfo.getDisplayName());
     }       
     ````
     

### **@DisplayName**
  
- Test class name doesn't have to end with suffix Test. 

- Custom name to Test class can be given 
 `@DisplayName("<name>")`
- Use this to provide readable name to test class and test methods.  
### Test method
 - Should be annotated with `@Test` annotation. 
 
---

## @ Test Annotation
  - marks method as a test
  - Informs the Junit engine what methods need to run

--- 

## What is test case?

A test case is broken down into the following three parts:
- We set up data that our test case needs.
- We call the unit being tested.
- We perform assertions to verify if expected behavior is correct.

This is also called AAA (Arrange, Act, and Assert).


## Using Assertion

Assertions in JUnit are static methods that we call in our test methods to verify expected
behavior. Each assertion tests whether the given condition is true or not. If an asserted
condition does not evaluate to true then a test failure is reported

- Create an instant of the class under test. 
- Set up Inputs
- Execute the code you want to test
- Compare Expected versus actual. 

All assert method have three overloaded methods

    String str = null;
    assertNull(str);
    assertNull(str, "str should be null"); // provides the message
    assertNull(str, () -> "str should be null"); // Lazily load the message. 


####**assert(expected, actual, message)**

- assertTrue Assert that condition is true<br>
- assertFalse Assert that condition is false<br>

- assertNull Assert that object is null<br>

- assertNotNull Assert that object is not null<br>

- assertEquals Assert that expected and actual are equal<br>

- assertNotEquals Assert that expected and actual are not equal<br>

- assertArrayEquals Assert that expected and actual arrays are equals<br>

- assertSame Assert that expected and actual refer to the same object<br>

- assertNotSame Assert that expected and actual do not refer to the same object<br>

***It is important to note that assertTrue and assertFalse have one more overloaded
method, besides the previously discussed three variants. It takes a java.util.function.
BooleanSupplier as an argument.***


[Junit Assertion Docs](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

Junit will give proper log output

---


## AssertAll

- The assertAll comes to our rescue. The assertion can be used to club all related
assertions and run them as a single assertion to report only the failed ones.

    `assertAll(executables);`
  
---

## Error vs Failure

A test fails when an assertion
is not met and an error occurs when your test throws an unexpected exception.

---


## Test Driven Methodology
 - Write the test case before the code. If the test fails then refactor the code.

---
## Maven Surefire Plugin

 - Let you run maven to run junit tests.

---
## Asserting exceptions with assertThrows

 - A method can throw exceptions. To validate exceptions we use `assertThrows(expectedClass,executable)`

--- 

## Life Cycle and Test AntiPattern

Junit manages the Life Cycle of the class. It gives you hooks to execute test during the lifecycle of test.

Setup(ClassLevel)-->Setup --> Test Execution --> CleanUp --> CleanUp(Class level)

1. The first is the setup phase, where the test infrastructure is put
in place. JUnit provides two levels of setup. One is the class
level where a costly object like database connection can be
created which can be reused for all the tests without any side
effect. Test objects affecting test runs need to be created in the
individual test setup methods.
2. The next is the test execution itself. Result verification is also
   part of the test execution phase. The execution result will
   signify a success or failure.
3. The last phase is the cleanup phase where any cleanup
   required after post-test execution is performed. Just like the
   class-level setup, there is a class-level cleanup also, which can
   be used

### @BeforeAll
 - Single time initialization for all test cases in a class.
 - Static and Non-private
 - Create costly object like database connection
 - Superclass method with @BeforeAll will be executed first.

### @BeforeEach
- Runs before each test case
- Perform initialization 
- A test case can have any no of @BeforeEach methods but the order is random

### @AfterEach
- Post-test cleanup
- Static and non-private

### @AfterAll

- Runs after all the test-cases. 
