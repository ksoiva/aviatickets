CREATE TYPE gender AS ENUM('MALE', 'FEMALE', 'OTHER');

CREATE TABLE "user" (
                        id                      integer PRIMARY KEY,
                        first_name              varchar NOT NULL,
                        last_name               varchar NOT NULL,
                        phone                   varchar NOT NULL,
                        email                   varchar NOT NULL UNIQUE,
                        date_of_birth           date NOT NULL,
                        gender                  gender NOT NULL,
                        nationality             varchar NOT NULL,
                        document_No             varchar NOT NULL UNIQUE,
                        document_expire_date    date NOT NULL
);

CREATE TABLE "plane" (
                          id                      integer PRIMARY KEY,
                          model                   varchar NOT NULL,
                          seat_count              integer NOT NULL,
                          row_count               integer NOT NULL
);

CREATE TABLE "flight" (
                          id                      integer PRIMARY KEY,
                          departure_airport       varchar NOT NULL,
                          arrival_airport         varchar NOT NULL,
                          departure_date          timestamp NOT NULL,
                          arrival_date            timestamp NOT NULL,
                          initial_price           float NOT NULL,
                          plane_id                integer NOT NULL REFERENCES "plane"(id) on DELETE CASCADE,
                          available_seats         integer NOT NULL,
                          created_date            timestamp NOT NULL
);

CREATE TABLE "ticket" (
                        id                      integer PRIMARY KEY,
                        seat                    varchar NOT NULL,
                        user_id                 integer NOT NULL REFERENCES "user"(id) on DELETE CASCADE,
                        flight_id               integer NOT NULL REFERENCES "flight"(id) on DELETE CASCADE,
                        baggage                 boolean NOT NULL DEFAULT false,
                        priority                boolean NOT NULL DEFAULT false,
                        total_price             float NOT NULL
);


