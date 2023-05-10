SET CONSTRAINTS ALL DEFERRED;
TRUNCATE ticket, "user", flight, plane;
SET CONSTRAINTS ALL IMMEDIATE;

INSERT INTO "user"(id, first_name, last_name, phone, email, date_of_birth, gender, nationality, document_no, document_expire_date)
VALUES
    (1, 'Іванна', 'Ксьондзик', '+380937485924', 'ivannaks@gmail.com', '2003-07-07',
     'FEMALE', 'ukrainian', '238747122283', '2031-05-23'),
    (2, 'Анна', 'Перч', '+380964973330', 'perch@gmail.com', '2003-12-22',
     'FEMALE', 'ukrainian', '39847729833', '2029-01-15');

INSERT INTO "plane"(id, model, seat_count, row_count)
VALUES
    (3, 'Boeing 737-800', 162, 27),
    (4, 'Airbus A320', 160, 20);

INSERT INTO "flight"(id, departure_airport, arrival_airport, departure_date, arrival_date, initial_price, plane_id, available_seats, created_date)
VALUES
    (5, 'LGW', 'DXB', '2023-04-30 15:25:00', '2023-05-01 03:15:00', 13572, 3, 142, '2023-03-25 10:25:00'),
    (6, 'WAW', 'FCO', '2023-05-10 05:50:00', '2023-05-10 08:15:00', 2072, 4, 159, '2023-04-04 9:05:00');

INSERT INTO "ticket"(id, seat, user_id, flight_id, baggage, priority, total_price)
VALUES
    (7, '4B', 2, 5, true, false, 15673),
    (8, '1A', 1, 6, false, false, 2072);


