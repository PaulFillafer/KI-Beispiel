# REST-API für Essensbestellung (Beispiel)

Start:
- npm install
- npm start

Endpoints:
- GET /orders
  - Liste aller Bestellungen
- GET /orders/:id
  - Einzelne Bestellung abrufen
- POST /orders
  - Bestellung anlegen
  - Beispiel-Body:
  ```json
  {
    "customer": "Max Mustermann",
    "items": [
      { "name": "Pizza Margherita", "quantity": 1 },
      { "name": "Cola", "quantity": 2 }
    ],
    "note": "Keine Zwiebeln"
  }
  ```
- PUT /orders/:id
  - Bestellung aktualisieren (ganze oder teilweise Felder)
- DELETE /orders/:id
  - Bestellung löschen

Hinweis: Diese Implementierung verwendet einen einfachen In-Memory-Store. Für Produktion nutze bitte eine persistente Datenbank (z. B. PostgreSQL, MongoDB) und Authentifizierung.