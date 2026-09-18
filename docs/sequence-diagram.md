# Sequence Diagram

## Ticket Booking Sequence

The following sequence shows the flow when a passenger books a railway
ticket.

```text
Passenger          Main.java       TrainService      PassengerService
   |                   |                |                   |
   |-- Book Ticket --->|                |                   |
   |                   |-- Search ----->|                   |
   |                   |<-- Train ------|                   |
   |                   |                                    |
   |                   |------------------------------->    |
   |                   |      Create Passenger              |
   |                   |<-------------------------------    |
   |                   |                                    |
   |                   |-- Select Train -->|                |
   |                   |<-- Selected Train-|                |
   |                   |                                    |
   |                   |                                    |
   |                   |---- Book Ticket ------------------------>
   |                   |                                    |
   |                   |                                    |
   |                   |          BookingService            |
   |                   |                 |                  |
   |                   |                 |-- Check Seats    |
   |                   |                 |                  |
   |                   |                 |-- Allocate Seat  |
   |                   |                 |                  |
   |                   |                 |-- Generate PNR   |
   |                   |                 |                  |
   |                   |<---- Booking Created -------------|
   |                   |                                    |
   |<-- Booking Details|                                    |
   |                   |                                    |