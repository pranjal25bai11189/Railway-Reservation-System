# System Architecture

## Railway Reservation System

The Railway Reservation System is a console-based Java application.
It follows a modular layered structure where user interaction,
business logic, data models, supporting utilities, and in-memory
storage are separated.

## Architecture Flow

```text
User
  |
  v
Main.java
  |
  v
Service Layer
  |
  +-- TrainService
  +-- PassengerService
  +-- BookingService
  +-- CancellationService
  +-- AdminService
  +-- ReportService
  |
  v
Model Layer
  |
  +-- Train
  +-- Passenger
  +-- Booking
  |
  v
In-Memory Storage
  |
  +-- ArrayList
  +-- HashMap
  +-- Queue