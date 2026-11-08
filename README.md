# Inventory Query Service

Spring Boot service that reads product inventory from PostgreSQL. It exposes a product lookup endpoint and returns a structured error when the product does not exist.

## Requirements

- Java 17 or later (the project targets Java 17).
- PostgreSQL with a database named `inventorydb`.
- Maven Wrapper (included); initial builds require access to Maven repositories.

The project declares Spring Boot `4.1.2`, Spring Cloud BOM `2025.1.4`, Spring Data JPA, Spring MVC, and Lombok in `pom.xml`.

## Configuration

Defaults are defined in `src/main/resources/application.properties`:

| Setting | Default |
| --- | --- |
| HTTP port | `8081` |
| Database URL | `jdbc:postgresql://localhost:5432/inventorydb` |
| Database user | `postgres` |
| Database password | Required environment variable `DB_PASSWORD` |
| Hibernate schema management | `update` |

Create the database before starting the application. Hibernate updates the tables on startup; the repository does not include seed data or migration scripts. SQL logging is enabled.

Use `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, and `SERVER_PORT` to override the corresponding defaults.

## Run

PowerShell:

```powershell
$env:DB_PASSWORD = 'your-local-database-password'
.\mvnw.cmd spring-boot:run
```

Linux/macOS:

```sh
export DB_PASSWORD='your-local-database-password'
./mvnw spring-boot:run
```

## Product lookup

```http
GET /api/products/{productCode}?quantity=2
```

Example in PowerShell:

```powershell
Invoke-RestMethod 'http://localhost:8081/api/products/SKU-001?quantity=2'
```

For a matching stored product, an illustrative `200 OK` response is:

```json
{
  "productCode": "SKU-001",
  "productName": "Keyboard",
  "avilableQuantity": 10,
  "avilable": true
}
```

The JSON names `avilableQuantity` and `avilable` reflect the current DTO spelling. `quantity` is a required integer query parameter, but the service currently does not use it to calculate availability or validate that it is positive. The response reports the stored quantity and availability flag; it does not reserve or decrement stock. Missing or non-integer quantities are rejected by Spring MVC with HTTP 400.

An unknown product returns `404 Not Found` with this custom error shape:

```json
{
  "timestamp": "2026-11-08T12:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Product not found: SKU-001",
  "path": "/api/products/SKU-001"
}
```

The timestamp is server-local time without an offset. This custom error structure applies to `ProductNotFoundException`; other errors use framework handling.

## Persistence and structure

`Product` maps to the `products` table, with an identity-generated ID, required product name, product code, and quantity, and a nullable `avialable` flag. Populate inventory through the database or an external writer; this service has no write endpoint. Set the availability flag to a non-null value because the response uses a primitive boolean. Keep product codes unique: lookup expects a single match, although the entity does not declare a uniqueness constraint.

- `controller`: HTTP request mapping.
- `service`: product lookup and response mapping.
- `repository`: Spring Data JPA lookup by product code.
- `entity`: database mapping.
- `dto`: product and error response models.
- `exception`: missing-product exception and HTTP 404 handling.

## Build and test

```powershell
.\mvnw.cmd clean verify
```

On Linux/macOS, use `./mvnw clean verify`. The existing `@SpringBootTest` loads the application context and requires a reachable PostgreSQL database and `DB_PASSWORD`. It does not currently verify endpoint behavior.
