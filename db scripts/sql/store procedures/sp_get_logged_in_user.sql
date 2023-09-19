USE todoapp;

CREATE PROCEDURE sp_get_logged_in_user @username varchar(20),
                                @password varchar(100)
AS
BEGIN
SELECT *FROM todoapp..UserDetails where username=@username AND password=@password
END
GO;