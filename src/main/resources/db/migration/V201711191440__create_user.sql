create table users (
  ID serial primary key,
  NAME varchar(100) not null,
  STATUS varchar(500),
  LONGITUDE double precision,
  LATITUDE double precision
)