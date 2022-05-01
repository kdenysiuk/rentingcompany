Rental Company

Table: License

It has the driver license number and it has a relation with user one to one. (A incense could be had by a person, and a person has an only license).

Table: User

It has the user information, as name, telephone number and email. It has got a relation with orders one to many. (A order could be asked by a only user, but a user can ask for many orders).

Table: Insurance

Each order must to have a car-insurance. The relation between them is one to many (an insurance could be had by many orders).

Table: Location

The buildings are located in a city. So the relation that they have is one to many (many buildings can be sited in a city, but not viceversa).

Table: Building

It has the building information, as name and address. The building has workers who work on it. The building table has a relation with work table(one to many: a worker works on a only building, but in the same building, many workers work on it) and with orders (one to many: a order could be asked on a only building, but a building could receive many orders).

Table: Orders

The order table represent the orders that are asked for users for renting a vehicle in a certain location, counting the presence of an insurance.


Table: Category

It has the different vehicle types. It has a relation with model (one to many: many models fit an only category).

Table: Model

It has the information of vehicles models, as their names. It has got a relation with vehicle (one to one).

Table: Vehicles

It has the information of the vehicles' license plates. 

Table: Vehicles has orders

This table is used for link the orders with the vehicles that are asked for.

Table: Job Position

It has the different position types. It has a relation with worker (one to many, a worker could be sited in an only position, but in the same position there're many employees).

Table: Work Shift

Represent the different range of time that a employee could work

Table: Worker

It has the worker information, as its name, telephone number and email. It has got a relation with building, position and work shift table.