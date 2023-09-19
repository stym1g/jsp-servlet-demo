USE todoapp;

CREATE PROCEDURE sp_get_user @username varchar(20)=null,
                                @email varchar(50)=null,
                                @mobile varchar(13)=null
AS
BEGIN
SELECT *FROM todoapp..UserDetails where username=@username OR email=@email OR mobile=@mobile
END
GO;