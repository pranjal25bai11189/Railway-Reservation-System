# Railway Reservation System

## Overview

The Railway Reservation System is a Java-based console application that
simulates the basic process of railway ticket reservation.

The system allows users to search for trains, enter passenger details,
book tickets, allocate seats, cancel tickets, search bookings using PNR,
and manage waiting-list passengers.

An administrator can also add trains, view train details, and generate
basic booking reports.

This project is developed as an educational simulation using Java and
Object-Oriented Programming concepts.

---

## Features

- Search trains by source and destination
- View train and seat availability
- Book tickets for multiple passengers
- Automatic seat allocation
- PNR generation
- Ticket cancellation
- Waiting-list management
- Automatic waiting-list seat allocation after cancellation
- Search booking using PNR
- View all bookings
- Admin authentication
- Add new trains
- Booking reports
- Input validation
- Custom exception handling

---

## Technologies Used

- Java
- Object-Oriented Programming
- ArrayList
- HashMap
- Queue
- Exception Handling
- Java Date and Time API
- VS Code

---

## Project Structure

```text
RailwayReservationSystem/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   ├── Train.java
│   │   ├── Passenger.java
│   │   └── Booking.java
│   │
│   ├── service/
│   │   ├── TrainService.java
│   │   ├── PassengerService.java
│   │   ├── BookingService.java
│   │   ├── CancellationService.java
│   │   ├── AdminService.java
│   │   └── ReportService.java
│   │
│   ├── util/
│   │   ├── PNRGenerator.java
│   │   └── InputValidator.java
│   │
│   └── exception/
│       └── InvalidPassengerException.java
│
├── statement.md
└── README.md