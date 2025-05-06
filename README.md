# Spring Rate Limiter

> Une librairie légère et plug-and-play pour ajouter une **limitation de requêtes** par annotation dans vos projets Spring Boot. Pratique pour protéger vos APIs contre l’abus sans config externe !

---

## 🚀 Fonctionnalités

- ✅ Annotation simple `@RateLimit`
- ✅ Limitation basée sur l’adresse IP et la méthode appelée
- ✅ Service en mémoire ultra rapide via **Caffeine Cache**
- ✅ Intégration transparente avec **Spring AOP**
- ✅ Gestionnaire d’erreurs personnalisable (`@ControllerAdvice`)

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