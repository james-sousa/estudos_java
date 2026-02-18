DROP TABLE IF EXISTS remedio;

CREATE TABLE remedios (
    id bigint primary key auto_increment,
    nome varchar(255) not null,
    via varchar(100) not null,
    lote varchar(100) not null,
    quantidade int not null,
    data_validade date not null,
    laboratorio varchar(255) not null
);
