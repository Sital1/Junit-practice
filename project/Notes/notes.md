# Junit5

It is a testing framewor for java

##  Steps
- Design
- Write Code
- Write Tests
- Run the tests

Why even runt test?
- Not to verify the code works now. Verify that the code continues to work in the future.

---

## Why a Testing framework?

Without Junit?

- Prepare
- Provide Test Inputs
- Runt the tests
- Provide the expected output
- Verify Result
- Do sth to alert the developer

Junit will run the test, verify result, and alert the developer.

## Why Junit 5?

- Junit 4 is 10 years old.
    - Not up to date with the Java Language Feature.
    - Not up to date with new Testing patterns.
    - Monolithic
    - Bugs and requests feature piled up.
    - Junit 5 != Junit 4 + 1

--- 

## Junit 5 Architecture

### Platform(Test Engine)
- Core of the library of the Junit 5. We don't interact with this

## Junit Api (**Jupiter**)
- Thing the developer interact with.

## Vintage
- For older Junit

## EXT(3rd party)
- Creating own extensions and still use the Platform Engine.

We can use corresponding maven dependencies to import in the class path.
Lot of IDE support the Junit5 directly.

--- 
<br>
<br>

## Junit Jupiter
