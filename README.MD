# 🔗 JPA One-To-Many & One-To-One Example

This project demonstrates the use of **Spring Data JPA** and **Hibernate** to implement and manage entity relationships, including **One-to-Many** and **One-to-One** associations in a Spring Boot application.

---

## 📝 Description

The application showcases how to model real-world domain relationships using JPA annotations. It includes:
- Mapping between entities with proper foreign key constraints
- Use of `@OneToMany`, `@ManyToOne`, and `@OneToOne`
- Bidirectional and unidirectional mappings
- Cascade operations and fetch types

---

## ⚙️ Technologies Used

| Technology         | Role                                          |
|--------------------|-----------------------------------------------|
| Java 17+           | Programming language                          |
| Spring Boot        | Application framework                         |
| Spring Data JPA    | Simplified JPA integration                    |
| Hibernate ORM      | JPA implementation                            |
| H2 / MySQL         | Relational database (configurable)            |
| Maven              | Build and dependency management               |

---


---

## 🧩 Relationship Mapping

- **One-to-Many**  
  Example: `User` → `List<Order>`  
  Annotated with `@OneToMany(mappedBy = "user")`

- **One-to-One**  
  Example: `User` → `Profile`  
  Annotated with `@OneToOne(cascade = CascadeType.ALL)`



