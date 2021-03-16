CREATE TABLE gas_prices (
   id serial PRIMARY KEY,
   created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
   name VARCHAR ( 50 ) NOT NULL,
   company_name VARCHAR ( 50 ),
   zipcode VARCHAR ( 4 ) NOT NULL,
   city VARCHAR ( 50 ) NOT NULL,
   street VARCHAR ( 50 ) NOT NULL,
   lat NUMERIC(9, 7) NOT NULL,
   lon NUMERIC(9, 7) NOT NULL,
   diesel_price NUMERIC(4, 3) NOT NULL,
   petrol_price NUMERIC(4, 3) NOT NULL
);
