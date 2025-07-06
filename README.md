# Car Rental System

## Overview
This Java console application allows users to manage a car rental service. It supports adding cars, renting cars to customers, editing car details, listing available cars, searching cars, and returning or removing cars. Data is persisted between sessions using CSV files.

## Features

- **Add New Car:** Add new cars with details like make, model, year, type, and status.
- **Rent Car:** Rent a car to a customer by associating customer info with the car.
- **Edit Car:** Update car information including status.
- **List Cars:** Display all cars with details, including who rented them.
- **Search Cars:** Search cars by various criteria (make, model, status, etc.).
- **Return Car:** Mark a car as returned and available.
- **Remove Car:** Delete a car from the system.
- **Data Persistence:** Save and load cars and customers data from CSV files.

## Technologies

- Java (Core)
- File I/O for CSV persistence
- Collections (HashMap) for storing cars and customers
- Enum types for car status (e.g., AVAILABLE, BOOKED)
- Console input/output for user interaction

## Project Structure

- `cars/` — Contains the `Cars` class and `CarStatus` enum.
- `customer/` — Contains the `Customer` class.
- `services/` — Business logic for managing cars and customers, including loading and saving data.
- `utils/` — Menus and user interaction utilities.

## How to Run

1. Compile all `.java` files.
2. Run the `Main` class.
3. Follow on-screen menu prompts to use the system.
4. Data will be automatically saved to CSV files upon changes or exit.
5. On startup, data will be loaded from CSV files if available.

## Notes

- Ensure `cars.csv` is in the working directory or will be created on first run.
- Car IDs are generated automatically and are unique.
- Renting a car links the customer by username to the car.
- When editing cars, validation ensures the car exists before changes.
- Input validation is implemented for numeric fields and options.

## Future Improvements

- Add GUI for better user experience.
- Implement better search filters.
- Add authentication for customers.
- Improve error handling and input validation.
- Add unit tests.