INSERT INTO [User]
(UserName, Phone, Password, DateOfBirth, Photo, role)
VALUES
(N'Admin',   N'1111111111', N'admin', '2003-07-24', N'/images/nam.jpg', 0),
(N'Nguyễn Văn Nam',   N'0912345678', N'nam123', '1995-05-12', N'/images/nam.jpg', 1),
(N'Lê Thị Hồng Nhung',N'0923456789', N'nhung456', '1992-08-20', N'/images/nhung.jpg', 2),
(N'Phạm Văn Hưng',    N'0934567890', N'hung789', '1990-01-15', N'/images/hung.jpg', 1),
(N'Vũ Thị Lan',       N'0945678901', N'lan321', '1996-10-10', N'/images/lan.jpg', 2),
(N'Hoàng Đức Minh',   N'0956789012', N'minh654', '1998-03-03', N'/images/minh.jpg', 1),
(N'Trần Thị Mai',     N'0967890123', N'mai987', '1993-12-25', N'/images/mai.jpg', 2),
(N'Bùi Văn Dũng',     N'0978901234', N'dung147', '1991-07-17', N'/images/dung.jpg', 1),
(N'Ngô Thị Thu',      N'0989012345', N'thu258', '1994-09-09', N'/images/thu.jpg', 2),
(N'Đặng Văn Kiên',    N'0990123456', N'kien369', '1989-11-01', N'/images/kien.jpg', 1),
(N'Đỗ Thị Yến',       N'0901234567', N'yen159', '1997-04-22', N'/images/yen.jpg', 2);


INSERT INTO [Bike] 
(BikeName, LicensePlate, ManufacturingYear, BikeLine, OwnerId, BikeManufactor, Status)
VALUES
(N'Honda Vision',     N'75F1-123.45', 2020, N'Xe tay ga',     4, N'Honda',   1),
(N'Yamaha Sirius',    N'75F1-234.56', 2019, N'Xe số',         5, N'Yamaha',  1),
(N'Honda SH Mode',    N'75F1-345.67', 2021, N'Xe tay ga',     5, N'Honda',   1),
(N'Air Blade 150',    N'75F1-456.78', 2022, N'Xe tay ga',     4, N'Honda',   1),
(N'Yamaha Exciter',   N'75F1-567.89', 2018, N'Xe số',         9, N'Yamaha',  0),
(N'Suzuki Raider',    N'75F1-678.90', 2021, N'Xe thể thao',   6, N'Suzuki',  1),
(N'Honda Lead',       N'75F1-789.01', 2017, N'Xe tay ga',     3, N'Honda',   1),
(N'Vespa Primavera',  N'75F1-890.12', 2023, N'Xe tay ga',     8, N'Piaggio', 1),
(N'Honda Wave Alpha', N'75F1-901.23', 2020, N'Xe số',         10, N'Honda',  1),
(N'Yamaha Janus',     N'75F1-012.34', 2021, N'Xe tay ga',     7, N'Yamaha',  1),
(N'Honda Air Blade',  N'75F1-111.11', 2022, N'Xe tay ga',     5, N'Honda',   1),
(N'Winner X',         N'75F1-222.22', 2021, N'Xe số',         6, N'Honda',   1),
(N'Suzuki GSX R150',  N'75F1-333.33', 2020, N'Xe thể thao',   4, N'Suzuki',  1),
(N'SH 150i',          N'75F1-444.44', 2023, N'Xe tay ga',     4, N'Honda',   1),
(N'Piaggio Liberty',  N'75F1-555.55', 2021, N'Xe tay ga',     4, N'Piaggio', 1),
(N'Honda Future',     N'75F1-666.66', 2019, N'Xe số',         4, N'Honda',   0),
(N'Satria F150',      N'75F1-777.77', 2020, N'Xe thể thao',   7, N'Suzuki',  1),
(N'Vision 2023',      N'75F1-888.88', 2023, N'Xe tay ga',     9, N'Honda',   1),
(N'Mio Classico',     N'75F1-999.99', 2018, N'Xe tay ga',     10, N'Yamaha', 1),
(N'Honda Blade',      N'75F1-000.01', 2017, N'Xe số',         8, N'Honda',   1);


INSERT INTO BikeManufactor (BikeManufactor)
VALUES 
(N'Honda'),
(N'Yamaha'),
(N'Suzuki'),
(N'Piaggio'),
(N'Kymco'),
(N'VinFast'),
(N'Peugeot'),
(N'SYM'),
(N'Husqvarna'),
(N'BMW');

select [User].UserId,UserName, COUNT(BikeId) from Bike join [User] on Bike.OwnerId = [User].UserId
group by [User].UserId,UserName


select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Photo
from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId


DECLARE @page INT = 1;
DECLARE @pageSize INT = 12;

SELECT 
    Bike.BikeId, BikeName, LicensePlate, ManufacturingYear, BikeLine, OwnerId, BikeManufactor, Status, Photo
FROM 
    Bike
LEFT JOIN 
    BikePhoto ON Bike.BikeId = BikePhoto.BikeId
ORDER BY 
    Bike.BikeId
OFFSET (@page - 1) * @pageSize ROWS
FETCH NEXT @pageSize ROWS ONLY;
