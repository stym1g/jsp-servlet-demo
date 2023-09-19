USE todoapp;

create table UserDetails(
                            Id INT IDENTITY(1,1) PRIMARY KEY,
                            name varchar(50),
                            username varchar(20) not null UNIQUE ,
                            email varchar(50) not null UNIQUE ,
                            mobile varchar(13) not null UNIQUE ,
                            password varchar(100) not null
)