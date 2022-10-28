CREATE SCHEMA IF NOT EXISTS exchange;

SET search_path TO exchange;


CREATE TABLE IF NOT EXISTS exchange.currency_exchange (
  id               VARCHAR(100) PRIMARY KEY,
  currency_from        VARCHAR(100),
  currency_to  VARCHAR(50),
  conversion_multiple VARCHAR(50),
  environment VARCHAR(50),
  created_by       VARCHAR(100) NOT NULL,
  created_date     TIMESTAMP    NOT NULL DEFAULT current_timestamp,
  modified_by      VARCHAR(100) ,
  modified_date    TIMESTAMP
);