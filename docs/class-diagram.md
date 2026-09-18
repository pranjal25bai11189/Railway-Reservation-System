# Class Diagram

## Main Classes

The Railway Reservation System is divided into model, service, utility,
and exception classes.

```text
                         +----------------------+
                         |        Train         |
                         +----------------------+
                         | - trainNumber        |
                         | - trainName          |
                         | - source             |
                         | - destination        |
                         | - totalSeats         |
                         | - availableSeats     |
                         | - nextSeatNumber     |
                         | - cancelledSeats     |
                         +----------------------+
                         | + allocateSeat()     |
                         | + cancelSeat()       |
                         +----------+-----------+
                                    |
                                    |
                                    v
+----------------------+    +----------------------+
|     Passenger        |    |       Booking        |
+----------------------+    +----------------------+
| - passengerId        |    | - bookingId          |
| - name               |    | - pnr                |
| - age                |    | - passengers         |
| - gender             |    | - train              |
+----------------------+    | - seatNumbers        |
                            | - journeyDate        |
                            | - status             |
                            +----------------------+
                            | + cancelBooking()    |
                            +----------+-----------+
                                       |
                                       |
                 +---------------------+---------------------+
                 |                     |                     |
                 v                     v                     v
        +----------------+   +------------------+   +----------------+
        | BookingService |   | Cancellation     |   | ReportService  |
        |                |   | Service          |   |                |
        +----------------+   +------------------+   +----------------+
        | + bookTicket() |   | + cancelTicket() |   | + display      |
        | + searchByPNR()|   |                  |   |   BookingReport|
        | + display...() |   +------------------+   +----------------+
        +--------+-------+
                 |
                 |
                 v
        +----------------+
        | TrainService   |
        +----------------+
        | + addTrain()   |
        | + searchTrains()|
        | + selectTrain()|
        | + display...() |
        +----------------+

        +--------------------+
        | PassengerService   |
        +--------------------+
        | + createPassenger()|
        +--------------------+

        +--------------------+
        |    AdminService    |
        +--------------------+
        | + showAdminMenu()  |
        +--------------------+

        +--------------------+
        |   InputValidator   |
        +--------------------+
        | + readInt()        |
        | + readPositiveInt()|
        | + readNonEmptyString()|
        +--------------------+

        +--------------------+
        |    PNRGenerator    |
        +--------------------+
        | + generatePNR()    |
        +--------------------+

        +--------------------------+
        | InvalidPassengerException|
        +--------------------------+