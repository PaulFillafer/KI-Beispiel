# REST-API für Essensbestellung (Spring Boot)

Dieses Beispiel stellt eine REST-API und ein einfaches GUI-Frontend (Thymeleaf) bereit, persistiert via JPA in einer MySQL-Datenbank.

Start:
- MySQL aufsetzen und Datenbank `ki_beispiel` anlegen
- application.properties anpassen (username/password)
- mvn spring-boot:run

API-Endpunkte (JSON):
- GET /api/orders
- GET /api/orders/{id}
- POST /api/orders
- PUT /api/orders/{id}
- DELETE /api/orders/{id}

Web-UI:
- GET /orders -> Liste
- GET /orders/new -> Formular
- POST /orders -> Formular absenden

Hinweis: Diese Implementierung ist ein Beispiel. Für Produktion sollte man Sicherheitsmechanismen (Auth), Validierung, Fehlerbehandlung und Tests ergänzen.