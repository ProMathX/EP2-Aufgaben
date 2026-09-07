Here is the English translation:

---

# EP2 Test 2

### General Instructions

* Your solution must be implemented within the given project and therefore in the existing files.
* You are *not* allowed to use the Java Collections Framework to solve this task.
* Do not modify the given method signatures or the signatures of the constructors.
* All object variables and any additional methods or constructors you create in the given classes must be declared 
 `private`. The only exception is the class `PhysicalStringTreeMapNode.java`, in which you may add additional `public` 
 methods.
* Do not define any additional classes.
* Projects that do not compile will receive 0 points without exception.

---

## Domain Information

The assignment models a universe (`Universe`) as a sorted collection of celestial bodies. The celestial bodies 
(`CelestialBody`) are a subtype of `Physical` and therefore have a position and a radius. `CelestialBody` objects are
organized in the `Universe` using a `UniverseTreeMap`. Like `PhysicalStringTreeMap`, the `UniverseTreeMap` is an 
associative data structure that associates `Physical` objects with a `String`. This allows celestial bodies to be 
assigned a name while simultaneously being sorted by their distance from the coordinate origin. To compare `Physical`
objects, `UniverseTreeMap` uses a `DistanceComparator`, which implements the `PhysicalComparator` interface.

---

## Task Description

The files to be completed for this test are:

* `DistanceComparator.java`
* `UniverseTreeMap.java` and additionally the existing node class `PhysicalStringTreeMapNode.java`
* `Universe.java`

Complete these classes at the locations marked with TODO.

The class `CelestialBody.java` is already fully provided and must not be modified.

The class `ApplicationTest2.java` can be used to test your implementation.

The following files (from AB2.3) are used but must not be modified:

* `Physical.java`
* `PhysicalComparator.java`

---

### Points Distribution

* `DistanceComparator`: 1 point
* `UniverseTreeMap`: 14 points
* `Universe`: 3 points

**Total: 18 points**
