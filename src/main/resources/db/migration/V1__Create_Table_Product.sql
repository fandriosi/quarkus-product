CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE product (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name varchar(255) unique not null,
    description varchar(255) not null,
    categoria varchar(255),
    model varchar(255),
    price decimal,
    estoque number;
);