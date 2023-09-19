USE todoapp;

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