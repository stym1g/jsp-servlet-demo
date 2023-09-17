use todoapp;
create table UserDetails(
                            Id INT IDENTITY(1,1) PRIMARY KEY,
                            name varchar(50),
                            username varchar(20) not null UNIQUE ,
                            email varchar(50) not null UNIQUE ,
                            mobile varchar(13) not null UNIQUE ,
                            password varchar(100) not null
)

--------------------------------------------------------------------------
CREATE PROCEDURE sp_create_user @name varchar(50),
                                @username varchar(20),
                                @email varchar(50),
                                @mobile varchar(13),
                                @password varchar(100)
AS
BEGIN
INSERT INTO todoapp..UserDetails(name,username,email,mobile,password) VALUES
    (@name,@username,@email,@mobile,@password)
SELECT 'Success'
END
GO;

--------------------------------------------------------------------------
CREATE PROCEDURE sp_get_logged_in_user @username varchar(20),
                                @password varchar(100)
AS
BEGIN
SELECT *FROM todoapp..UserDetails where username=@username AND password=@password
END
GO;
--------------------------------------------------------------------------
CREATE PROCEDURE sp_get_user @username varchar(20)=null,
                                @email varchar(50)=null,
                                @mobile varchar(13)=null
AS
BEGIN
SELECT *FROM todoapp..UserDetails where username=@username OR email=@email OR mobile=@mobile
END
GO;