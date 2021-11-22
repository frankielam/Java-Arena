CREATE TABLE exchange_value(
id BIGINT,
currency_from VARCHAR(64),
currency_to VARCHAR(64),
conversion_multiple INT,
port INT
);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(10001,'usd','inr',65,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(10002,'eur','inr',75,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port) values(10003,'aud','inr',25,0);