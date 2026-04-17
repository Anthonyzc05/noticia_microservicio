# Plataforma de Noticias - Microservicios Spring Boot + MongoDB

## Base de datos
- Motor: MongoDB
- Puerto: 27017
- Base de datos: noticiasdb (se crea automáticamente)

## Microservicios
| Servicio       | Puerto | Responsable | Colección MongoDB  |
|----------------|--------|-------------|---------------------|
| articulos      | 8081   | Alexander   | articulos           |
| categorias     | 8082   | Miguel      | categorias          |
| comentarios    | 8083   | Gabriel     | comentarios         |
| usuarios       | 8084   | Marco       | usuarios            |
| notificaciones | 8085   | Mery        | notificaciones      |
| reacciones     | 8086   | Eduardo     | reacciones          |
| favoritos      | 8087   | Anthony     | favoritos           |

## Requisitos
- Java 17+
- MongoDB corriendo en localhost:27017
- Maven 3.8+

## Ejecutar
1. Asegurarse que MongoDB esté corriendo
2. cd <microservicio>
3. ./mvnw spring-boot:run
