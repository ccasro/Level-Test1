# Level-Test1

# Solar System

### **Context**

The Space Agency is developing a system to manage the celestial bodies of the solar system.

The goal is to digitally represent the different objects that comprise it, including **planets, stars, and moons**, with their unique characteristics.

---

### 👀 **Objective**

Implement a program in **Java** that allows you to **register celestial bodies** of the solar system and **view their details**.

> 💡 It is not necessary to use a database or a graphical interface.

>
>
> The correct functioning of the system can be demonstrated in the `main()` method or through **unit tests**.

>
> To solve this exercise, you are expected to apply principles of **object-oriented programming**, including **inheritance**, **polymorphism**, and **interfaces**. Design an appropriate class hierarchy to model the celestial bodies and reuse code whenever possible.
>

---

### 📌 1 - Celestial Body Registration

The system must allow the registration of different types of celestial bodies with the following general attributes:

- Name of the celestial body.

- Diameter (in kilometers).

- Length of day (in hours).

Each type of celestial body has specific attributes:

| Type | Specific Attributes |

--- | --- | --- |

Planet | Number of moons, presence of atmosphere (`true/false`) |

Star | Surface temperature (in K), spectral type |

Moon | Planet it orbits (name), rocky surface (`true/false`) |

---

### 📌 2 - Scientific Description

Each celestial body must have its own scientific description, dynamically generated from its attributes.

Examples:

- 🌍 **Planet**

“The Earth has a diameter of 12,742 km and possesses an atmosphere. It has 1 moon.”

- ☀️ **Star**

“The Sun is a G2V type star with a surface temperature of 5,778 K. It is the main source of energy for the solar system.”

- 🌕 **Moon**

“The Moon orbits around the Earth. Its surface is rocky and its diameter is 3,474 km.”

> 💡 These descriptions must be generated from a specific method in each class.

>

---

### 📌 3 ​​- Queries

The system must allow the following operations:

1. **List all registered celestial bodies** with their descriptions.

2. **Filter planets that have an atmosphere**.

3. **Filter moons orbiting a specific planet** (by name).

---

### 📌 4 - Habitable Bodies

Some celestial bodies, such as certain **planets** or **moons**, are considered potentially **habitable**.

The following class has been created to print habitability reports:

```java
public class HabitabilityPrinter {
public void printReport(Habitable body) {
System.out.println("Habitability Analysis:");
System.out.println(body.getHabitabilityReport());

}
}
```

Make planets and moons compatible with this functionality.