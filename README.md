
This project represents a Spring Boot backend application with a relational database, developed for a company that rents electric vehicles.
The backend provides core business logic, data persistence, authentication, and RESTful services used by other applications within the system.


The company manages multiple types of vehicles, each with specific attributes:

CARS

 - For each car, the following data is stored:
    - Unique identifier (ID – string, manually defined)
    - Purchase date
    - Purchase price
    - Manufacturer
    - Model
    - Description
    - Vehicle image

ELECTIC BIKES

For electric bikes, the following data is stored:
    - Unique identifier (ID – string)
    - Manufacturer
    - Model
    - Purchase price
    - Range per charge (autonomy)
    - Vehicle image

ELECTIC SCOOTERS

For electric scooters, the following data is stored:
    - Unique identifier (ID – string)
    - Manufacturer
    - Model
    - Purchase price
    - Maximum speed
    - Vehicle image

String-based IDs are not the same as database primary keys, which are defined separately.

 Malfunctions Tracking

All vehicles can experience malfunctions.
For each malfunction, the system records:

    - Description of the malfunction
    - Date and time of occurrence

The data model allows determining at any moment whether a vehicle is:

 - Available
 - Rented
 - Out of service due to malfunction

Manufacturers

For vehicle manufacturers, the following information is stored:
  - Name
  - Country
  - Address
  - Contact information (phone, fax, email)
  - 
 Rental Management

The core business of the company is vehicle rental.

For each rental, the system stores:

 - Rental date and time
 - User who rented the vehicle
 - Pickup location (coordinates)
 - Drop-off location (coordinates)
 - Rental duration
 - Car Rental Requirements

When renting a car, users must provide:

 - Identification document
 - Passport (foreign citizens)
 - National ID card (domestic citizens)
 - Driver’s license number
