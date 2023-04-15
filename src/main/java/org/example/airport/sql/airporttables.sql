create table company(
                        company_id serial primary key ,
                        company_name varchar(50) not null ,
                        found_date varchar(50) not null

);

create table passengers(
                           pass_id serial primary key ,
                           pass_name varchar(100) not null ,
                           pass_phone varchar(50) not null unique ,
                           pass_country varchar(50) not null ,
                           pass_city varchar(50) not null

);
create table address(
                        address_id serial primary key ,
                        country varchar(50) not null ,
                        city varchar(50) not null
);
CREATE TABLE Trip (
                      trip_id SERIAL PRIMARY KEY,
                      trip_number INTEGER NOT NULL,
                      company_id INTEGER NOT NULL,
                      airplane_name varchar(50) NOT NULL,
                      town_from VARCHAR(255) NOT NULL,
                      town_to VARCHAR(255) NOT NULL,
                      time_out TIMESTAMP NOT NULL,
                      time_in TIMESTAMP NOT NULL,
                      CONSTRAINT fk_company
                          FOREIGN KEY (company_id)
                              REFERENCES Company (company_id)
);