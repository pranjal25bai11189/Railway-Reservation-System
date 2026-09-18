# System Requirements

## 1. Functional Requirements

### FR1: Train Search

The system shall allow users to search for trains by entering:

- Source station
- Destination station

The system shall display matching trains and their available seats.

### FR2: Train Management

The administrator shall be able to:

- Add a new train
- View all trains
- View train number, name, route, and seat availability

### FR3: Passenger Management

The system shall collect passenger information including:

- Passenger ID
- Name
- Age
- Gender

The system shall validate passenger information before creating a passenger record.

### FR4: Ticket Booking

The system shall allow users to book tickets for one or more passengers.

The system shall:

- Validate the journey date
- Check seat availability
- Allocate seats automatically
- Generate a unique PNR
- Create a booking record

A maximum of 6 passengers shall be allowed in a single booking.

### FR5: Seat Allocation

The system shall automatically assign available seat numbers to passengers.

When a previously allocated seat is cancelled, the system shall make that
seat available for future bookings.

### FR6: Ticket Cancellation

The system shall allow users to cancel a booking using its booking ID.

After cancellation:

- The booking status shall become `CANCELLED`
- Allocated seats shall be released
- Waiting-list passengers may receive released seats

### FR7: Waiting List

When sufficient seats are not available, passengers shall be added to a
waiting list.

The system shall maintain the waiting list using a queue.

When seats become available after cancellation, waiting-list passengers
shall be processed automatically.

### FR8: PNR Search

The system shall allow users to search for an existing booking using its PNR.

The system shall display:

- Booking ID
- PNR
- Booking status
- Train details
- Journey date
- Passenger details
- Seat numbers

### FR9: Booking Records

The system shall allow the administrator or user interface to display
all booking records stored during the current program execution.

### FR10: Booking Report

The administrator shall be able to view a basic booking report containing:

- Total bookings
- Confirmed bookings
- Cancelled bookings
- Total active passengers

### FR11: Input Validation

The system shall handle invalid user inputs such as:

- Non-numeric input where a number is required
- Empty text input
- Invalid passenger age
- Invalid journey date
- Past journey date
- Invalid train number

### FR12: Administrator Authentication

The system shall require administrator credentials before allowing access
to administrator functions.

---

## 2. Non-Functional Requirements

### NFR1: Usability

The system should provide a simple console-based interface with clear menus,
instructions, and messages.

### NFR2: Reliability

The system should handle invalid inputs and unexpected user entries without
crashing during normal operation.

### NFR3: Performance

Train searching, booking lookup, seat allocation, and cancellation should
be performed efficiently for the expected size of the educational project.

### NFR4: Maintainability

The system should be divided into separate model, service, utility, and
exception classes so that individual components can be modified easily.

### NFR5: Error Handling

The system should provide meaningful error messages when invalid operations
are performed, such as invalid passenger information or unavailable seats.

### NFR6: Security

Administrator operations should be protected by basic username and password
authentication.

### NFR7: Scalability

The application structure should allow additional trains, passengers,
bookings, and future features to be added without redesigning the complete
system.

### NFR8: Resource Efficiency

The system should use Java collections and in-memory storage efficiently
for the expected scale of the project.

---

## 3. Storage Design

The current version of the project does not use a database.

The system stores information in memory using Java collections such as:

- `ArrayList` for trains and bookings
- `HashMap` for waiting lists
- `Queue` for waiting-list passengers

All data is temporary and is lost when the application terminates.