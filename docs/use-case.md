# Use Case Diagram

## Actors

### Passenger

The passenger can:

- Search trains
- Book tickets
- Enter passenger details
- Search booking using PNR
- Cancel tickets
- View bookings

### Administrator

The administrator can:

- Login
- Add new trains
- View all trains
- View booking reports

## Use Cases

```text
                    Railway Reservation System
                 +--------------------------------+

       Passenger  |                                |
          |       |   Search Train                 |
          |------>|                                |
          |       |   Book Ticket                  |
          |------>|                                |
          |       |   Search Booking by PNR        |
          |------>|                                |
          |       |   Cancel Ticket                |
          |------>|                                |
          |       |   View Bookings                |
          |------>|                                |
                  |                                |
                  |                                |
     Administrator|   Admin Login                  |
          |------>|                                |
          |       |   Add New Train                |
          |------>|                                |
          |       |   View All Trains              |
          |------>|                                |
          |       |   View Booking Report          |
          |------>|                                |
                 +--------------------------------+