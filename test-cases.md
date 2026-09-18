# Test Cases

## Railway Reservation System

Testing was performed through the console interface to verify that the main
functional modules of the Railway Reservation System work correctly.

## Test Case Table

| Test ID | Feature             | Test Input / Action                                     | Expected Result                                            | Actual Result                                              | Status |
| ------- | ------------------- | ------------------------------------------------------- | ---------------------------------------------------------- | ---------------------------------------------------------- | ------ |
| TC01    | Train Search        | Enter source and destination with an available train    | Matching train details and seat availability are displayed | Matching train was displayed successfully                  | Passed |
| TC02    | Ticket Booking      | Enter valid train, journey date, and passenger details  | Ticket is booked and seats are allocated                   | Booking was created with Booking ID, PNR, and seat numbers | Passed |
| TC03    | Ticket Cancellation | Enter a valid Booking ID                                | Booking status changes to CANCELLED and seats are released | Ticket was cancelled successfully                          | Passed |
| TC04    | View All Bookings   | Select View All Bookings                                | All stored booking records are displayed                   | Booking records were displayed successfully                | Passed |
| TC05    | PNR Search          | Enter a valid PNR                                       | Correct booking and passenger details are displayed        | Booking details were displayed successfully                | Passed |
| TC06    | Waiting List        | Attempt booking when sufficient seats are unavailable   | Passengers are added to the waiting list                   | Passenger was added to the waiting list successfully       | Passed |
| TC07    | Admin Login         | Enter valid administrator credentials                   | Admin menu is displayed                                    | Admin menu was accessed successfully                       | Passed |
| TC08    | Add New Train       | Enter details of a new train with a unique train number | New train is added successfully                            | New train was added successfully                           | Passed |
| TC09    | Booking Report      | Select Booking Report from the admin menu               | Booking statistics are displayed                           | Booking report was displayed successfully                  | Passed |

## Testing Approach

The system was tested manually through the console interface.

The testing focused on the major features of the application:

* Train searching
* Ticket booking
* Ticket cancellation
* Booking record display
* PNR searching
* Waiting-list management
* Administrator authentication
* Train addition
* Booking reporting

## Test Results

The main functional modules tested during development produced the expected
results.

The tests confirmed that the system can:

* Search for available trains.
* Create bookings for passengers.
* Allocate seats automatically.
* Generate PNR numbers.
* Cancel existing bookings.
* Maintain a waiting list when seats are unavailable.
* Provide administrator functions.
* Add new trains.
* Generate basic booking reports.

## Screenshots

Screenshots of the tested features are included in the project documentation.

The screenshots demonstrate:

1. Train Search
2. Successful Booking
3. Ticket Cancellation
4. All Bookings
5. PNR Search
6. Waiting List
7. Admin Menu
8. Add New Train
9. Booking Report

## Conclusion

The functional testing confirms that the major implemented features of the
Railway Reservation System operate as intended under the tested scenarios.
