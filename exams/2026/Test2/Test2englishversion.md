# EP2 Test 2

### General Instructions

* Your solution must be implemented within the given project and therefore in the existing files.
* You are *not* allowed to use the Java Collections Framework to solve this task.
* Do not modify the given method signatures or the signatures of the constructors.
* All object variables and any additional methods or constructors you create in the given classes must be declared `private`.
* Do not define any additional classes.
* Projects that do not compile will receive 0 points without exception.

---

## Domain Information

The assignment models a universe (`Universe`) as a sorted collection of celestial bodies.
The celestial bodies (`CelestialBody`) are a subtype of `Physical` and, in addition to position and radius, 
also have a name. `CelestialBody` objects are sorted in the `Universe` in descending order according to their radius.
The `Universe` uses the singly linked list `OrderedPhysicalSinglyLinkedList` to store celestial bodies in sorted order. 
This list organizes `Physical` objects in descending order by their radius. To compare `Physical` objects, `OrderedPhysicalSinglyLinkedList` uses a `RadiusComparator`, which implements the `PhysicalComparator` interface.

---

## Task Description

The files to be completed for this test are:

* `RadiusComparator.java`
* `OrderedPhysicalSinglyLinkedList.java`
* `Universe.java`

Complete these classes at the locations marked with TODO.

The class `CelestialBody.java` is already fully provided and must not be modified.

The class `ApplicationTest2.java` can be used to test your implementation.

The following files (from AB2.3) are used but must not be modified:

* `Physical.java`
* `PhysicalComparator.java`
* `Vector2D.java`
* `PhysicalSinglyLinkedListNode.java`

---

### Points Distribution

* `RadiusComparator`: 1 point
* `OrderedPhysicalSinglyLinkedList`: 13 points
* `Universe`: 4 points

**Total: 18 points**