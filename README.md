# Tricol Suppliers

API REST de gestion des fournisseurs (phase 1) pour Tricol.

## Lancer l'application

- Prérequis: Java 17, Maven 3.9+
- Commande:

```
mvn spring-boot:run -pl tricol-suppliers -am
```

Ou depuis le module:

```
cd tricol-suppliers
mvn spring-boot:run
```

## Endpoints
- GET `/api/v1/fournisseurs?sort=societe&q=term`
- GET `/api/v1/fournisseurs/{id}`
- POST `/api/v1/fournisseurs`
- PUT `/api/v1/fournisseurs/{id}`
- DELETE `/api/v1/fournisseurs/{id}`

## Modèle `Fournisseur`
- societe, adresse, contact, email, telephone, ville, ice

## Configurations Spring
- XML: `src/main/resources/spring/app-context.xml`
- Annotations: `@Service`, `@RestController`, `@Configuration`
- Java Config: `com.tricol.suppliers.config.AppConfig`, `WebConfig`

## Base de données
- MySQL sur `localhost:3306`, base `tricol_suppliers`
- L'application créera automatiquement la base si elle n'existe pas
- Configuration dans `application.properties`
