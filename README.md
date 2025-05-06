# Spring Rate Limiter

Une librairie simple pour limiter le nombre de requêtes sur vos endpoints Spring Boot avec une annotation `@RateLimit`.

## Installation (via JitPack)

```xml
<dependency>
  <groupId>com.github.MonkilaTECHNOLOGIE</groupId>
  <artifactId>spring-rate-limiter</artifactId>
  <version>v1.0.0</version>
</dependency>
```

## Exemple d'utilisation
```java
@RateLimit(limit = 5, duration = 60)
@GetMapping("/produits")
public List<String> produits() {
    return List.of("A", "B", "C");
}
```

## 📄 Licence

**MIT License**

---

## 👨‍💻 Auteur & Contact

**Développé par [MonkilaTECHNOLOGIE](https://github.com/MonkilaTECHNOLOGIE)**  
📧 Contact : [contact@monkila-tech.com](mailto:contact@monkila-tech.com)