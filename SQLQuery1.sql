﻿INSERT INTO [User]
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

INSERT INTO [User]
(UserName, Phone, Password, DateOfBirth, Photo, role)
VALUES
(N'Lý Thị Hường',     N'0902345678', N'huong111', '1993-06-14', N'/images/huong.jpg', 2),
(N'Phan Thị Bích',    N'0903456789', N'bich222',  '1995-09-30', N'/images/bich.jpg', 2),
(N'Tạ Thị Thảo',      N'0904567890', N'thao333',  '1990-02-11', N'/images/thao.jpg', 2),
(N'Huỳnh Thị Ngọc',   N'0905678901', N'ngoc444',  '1996-08-19', N'/images/ngoc.jpg', 2),
(N'Nguyễn Thị Hạnh',  N'0906789012', N'hanh555',  '1992-11-07', N'/images/hanh.jpg', 2);



INSERT INTO [Bike] 
(BikeName, LicensePlate, ManufacturingYear, BikeLine, OwnerId, BikeManufactor, Status, Photo, Description, Price, CreatedTime)
VALUES
(N'Honda Vision',     N'75F1-123.45', 2020, N'Xe tay ga',   4,  N'Honda',   1, N'vision.jpg',       N'Dòng tay ga tiết kiệm xăng, dễ điều khiển.',       90000, '2024-01-12'),
(N'Yamaha Sirius',    N'75F1-234.56', 2019, N'Xe số',       5,  N'Yamaha',  1, N'sirius.jpg',       N'Xe số phổ thông, mạnh mẽ và bền bỉ.',              70000, '2024-03-20'),
(N'Honda SH Mode',    N'75F1-345.67', 2021, N'Xe tay ga',   5,  N'Honda',   1, N'shmode.jpg',       N'Dòng xe cao cấp, thiết kế thời trang.',           110000, '2024-07-05'),
(N'Air Blade 150',    N'75F1-456.78', 2022, N'Xe tay ga',   4,  N'Honda',   1, N'airblade.jpg',     N'Xe tay ga thể thao, động cơ mạnh.',               100000, '2025-02-14'),
(N'Yamaha Exciter',   N'75F1-567.89', 2018, N'Xe số',       9,  N'Yamaha',  0, N'exciter.jpg',      N'Dòng xe số mạnh mẽ, phong cách thể thao.',         95000, '2024-10-30'),
(N'Suzuki Raider',    N'75F1-678.90', 2021, N'Xe thể thao', 6,  N'Suzuki',  1, N'raider.jpg',       N'Xe underbone mạnh mẽ, thích hợp đi phượt.',        95000, '2024-05-15'),
(N'Honda Lead',       N'75F1-789.01', 2017, N'Xe tay ga',   3,  N'Honda',   1, N'lead.jpg',         N'Cốp rộng, thích hợp cho nữ.',                       85000, '2025-01-08'),
(N'Vespa Primavera',  N'75F1-890.12', 2023, N'Xe tay ga',   8,  N'Piaggio', 1, N'vespa.jpg',        N'Dòng xe cao cấp, phong cách Ý sang trọng.',       120000, '2024-11-19'),
(N'Honda Wave Alpha', N'75F1-901.23', 2020, N'Xe số',       10, N'Honda',   1, N'wave.jpg',         N'Xe phổ thông tiết kiệm nhiên liệu.',               65000, '2025-04-01'),
(N'Yamaha Janus',     N'75F1-012.34', 2021, N'Xe tay ga',   7,  N'Yamaha',  1, N'janus.jpg',        N'Dành cho nữ, thiết kế nhẹ nhàng.',                 80000, '2024-09-10'),
(N'Honda Air Blade',  N'75F1-111.11', 2022, N'Xe tay ga',   5,  N'Honda',   1, N'airblade2.jpg',    N'Mạnh mẽ, thiết kế nam tính.',                      100000, '2025-06-22'),
(N'Winner X',         N'75F1-222.22', 2021, N'Xe số',       6,  N'Honda',   1, N'winner.jpg',       N'Xe số thể thao mạnh mẽ.',                           95000, '2024-03-29'),
(N'Suzuki GSX R150',  N'75F1-333.33', 2020, N'Xe thể thao', 4,  N'Suzuki',  1, N'gsx.jpg',          N'Dòng sportbike nhỏ gọn, mạnh mẽ.',                105000, '2025-05-10'),
(N'SH 150i',          N'75F1-444.44', 2023, N'Xe tay ga',   4,  N'Honda',   1, N'sh150.jpg',        N'Cao cấp, động cơ mạnh, thiết kế sang trọng.',     130000, '2024-04-14'),
(N'Piaggio Liberty',  N'75F1-555.55', 2021, N'Xe tay ga',   4,  N'Piaggio', 1, N'liberty.jpg',      N'Thiết kế Ý tinh tế, phù hợp đô thị.',              115000, '2025-02-02'),
(N'Honda Future',     N'75F1-666.66', 2019, N'Xe số',       4,  N'Honda',   0, N'future.jpg',       N'Dòng xe số cao cấp, tiết kiệm nhiên liệu.',        80000, '2024-12-28'),
(N'Satria F150',      N'75F1-777.77', 2020, N'Xe thể thao', 7,  N'Suzuki',  1, N'satria.jpg',       N'Dòng xe thể thao nổi bật của Suzuki.',              95000, '2025-03-17'),
(N'Vision 2023',      N'75F1-888.88', 2023, N'Xe tay ga',   9,  N'Honda',   1, N'vision2023.jpg',   N'Mẫu xe tay ga mới nhất năm 2023.',                 90000, '2024-06-06'),
(N'Mio Classico',     N'75F1-999.99', 2018, N'Xe tay ga',   10, N'Yamaha',  1, N'mio.jpg',          N'Kiểu dáng cổ điển, nhỏ gọn.',                      75000, '2025-01-25'),
(N'Honda Blade',      N'75F1-000.01', 2017, N'Xe số',       8,  N'Honda',   1, N'blade.jpg',        N'Xe số giá rẻ, bền bỉ.',                             68000, '2024-08-18');


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

ALTER TABLE [Message]
ADD CONSTRAINT DF_ten_bang_time DEFAULT GETDATE() FOR time;







--
select [User].UserId,UserName, COUNT(BikeId) from Bike join [User] on Bike.OwnerId = [User].UserId
group by [User].UserId,UserName

--Bike info
select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime
from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId

select Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime
from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId
where Bike.BikeId = 1

select* from BikePhoto
where BikeId = ?
--Pagination
DECLARE @page INT = 1;
DECLARE @pageSize INT = 12;

SELECT Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Bike.Photo,CreatedTime
FROM Bike LEFT JOIN BikePhoto ON Bike.BikeId = BikePhoto.BikeId
ORDER BY Bike.BikeId
OFFSET (@page - 1) * @pageSize ROWS
FETCH NEXT @pageSize ROWS ONLY;


ALTER TABLE Bike
ADD CreatedTime DATETIME DEFAULT GETDATE();


select * from BikeManufactor

select Top 8 Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime
from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId
where Status=1
order by CreatedTime


select [User].UserId, UserName,Phone,Photo,DateOfBirth,Address,role,Password from [User] join Bike on [User].UserId = Bike.OwnerId
where BikeId = 1


select Top 8 Bike.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,Photo,CreatedTime
from Bike left join BikePhoto on Bike.BikeId = BikePhoto.BikeId
where BikeLine =(
				select BikeLine
				from Bike
				where BikeId =3)
and Status = 1

select * from OrderDetail
insert into OrderDetail(BikeId,RentalFee,PickupDate,ReturnDate)
values(2,1000,'2025-05-15 22:24:00.0','2025-05-15 22:24:00.0')


select * from [Order]

ALTER TABLE [Order]
ADD CONSTRAINT DF_Order_Status DEFAULT 0 FOR Status;

ALTER TABLE [Order]
ADD CONSTRAINT DF_Order_OrderDate DEFAULT GETDATE() FOR OrderDate;


select * from [Order]
select * from OrderDetail

Insert into OrderDetail(BikeId,RentalFee,PickupDate,ReturnDate)
values(?,?,?,?)

Insert into [Order](OrderDetailId,UserId,PickupPlace,ReturnPlace)
values(?,?,?,?)

delete from OrderDetail
where 1=1
delete from [Order]
where 1=1

select * from [User]

insert into [User](UserName, Phone,Password,DateOfBirth,role,Address)
values(?,?,?,?,?,?)

select * from [User]
where Phone='0123456789' and Password='Dignissimos harum si';


select *from [user]

select *from [Order]
where UserId = 5
select *from [OrderDetail]


SELECT 
    o.OrderId,
    o.OrderDate,
    o.PickupPlace,
    o.ReturnPlace,
    o.Status,
    od.OrderDetailId,
    od.BikeId,
    od.RentalFee,
    od.PickupDate,
    od.ReturnDate
FROM [Order] o
JOIN OrderDetail od ON o.OrderId = od.OrderId
WHERE o.UserId = 5
ORDER BY o.OrderDate DESC, od.OrderDetailId ASC;


SELECT 
    o.OrderId,
    o.OrderDate,
    o.PickupPlace,
    o.ReturnPlace,
    od.BikeId,
    b.BikeName,
    b.LicensePlate,
    b.ManufacturingYear,
    b.BikeLine,
    b.BikeManufactor,
    bp.Photo, -- lấy ảnh
    b.Description,
    od.RentalFee,
    od.PickupDate,
    od.ReturnDate,
	o.Status
FROM [Order] o
JOIN OrderDetail od ON o.OrderId = od.OrderDetailId
JOIN Bike b ON od.BikeId = b.BikeId
LEFT JOIN BikePhoto bp ON bp.BikeId = b.BikeId AND bp.Priority = (
    SELECT MIN(Priority)
    FROM BikePhoto
    WHERE BikeId = b.BikeId
)
WHERE o.UserId = 5
ORDER BY o.OrderDate DESC

select * from OrderDetail





SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status, 
	            od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor,  
	            bp.Photo, b.Description, od.RentalFee, od.PickupDate, od.ReturnDate  
	            FROM [Order] o  
	            JOIN OrderDetail od ON o.OrderId = od.OrderId  
	            JOIN Bike b ON od.BikeId = b.BikeId  
	            LEFT JOIN BikePhoto bp ON bp.BikeId = b.BikeId AND bp.Priority = (  
	                SELECT MIN(Priority) FROM BikePhoto WHERE BikeId = b.BikeId )  
	            WHERE o.UserId = 5
	            ORDER BY o.OrderDate DESC

select* from BikePhoto

select * from or


select * from [User]

update [User]	
set UserName=?,Phone=?,DateOfBirth=?,Photo,Address=?
where UserId=?

select * from [User]
where UserId = ?

update [User]
set Password='8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'
where UserId = 5

select * from [User]
where Phone=0923456789  and Password='03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'

SELECT * FROM [User] WHERE UserId = 5 AND Password = '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92'

select b.BikeId,BikeName,LicensePlate,ManufacturingYear,BikeLine,BikeManufactor,Description,Price,Status,CreatedTime ,
(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo
from [User] left join Bike as b on [User].UserId = b.OwnerId
where [User].UserId = 5

select * from BikePhoto
where BikeId = 5

select COUNT(*) as countBike from Bike
where OwnerId=5





select * 
from OrderDetail join [Order] on [Order].OrderId = OrderDetail.OrderId
				 join Bike on Bike.BikeId = OrderDetail.BikeId

select [Order].OrderId
from OrderDetail join [Order] on [Order].OrderId = OrderDetail.OrderId
				 join Bike on Bike.BikeId = OrderDetail.BikeId
where OwnerId = 5

SELECT CAST(o.OrderDate AS DATE) AS OrderDay,SUM(od.RentalFee) AS TotalRevenue 
FROM [Order] o 
JOIN OrderDetail od ON o.OrderId = od.OrderId 
WHERE CAST(o.OrderDate AS DATE) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE)) 
GROUP BY CAST(o.OrderDate AS DATE)
ORDER BY OrderDay





WITH Last7Days AS (
    SELECT CAST(GETDATE() AS DATE) AS OrderDay
    UNION ALL
    SELECT DATEADD(DAY, -1, OrderDay)
    FROM Last7Days
    WHERE DATEADD(DAY, -1, OrderDay) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))
)
SELECT 
    FORMAT(d.OrderDay, 'dddd') AS DayLabel, 
    ISNULL(SUM(od.RentalFee), 0) AS TotalRevenue
FROM Last7Days d
LEFT JOIN [Order] o ON CAST(o.OrderDate AS DATE) = d.OrderDay AND o.Status = 1
LEFT JOIN OrderDetail od ON o.OrderId = od.OrderId
GROUP BY d.OrderDay
ORDER BY d.OrderDay;

SELECT *,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo, 
	             b.Description, od.RentalFee, od.PickupDate, od.ReturnDate 
	             JOIN Bike b ON od.BikeId = b.BikeId 

select Top 8 *, (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo
from Bike as b

select * from Bike

select b.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,
OwnerId,BikeManufactor,Status,Description,Price,
(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,CreatedTime
from Bike as b 
where b.BikeId = 5



delete from BikePhoto
where  BikeId =22
delete from Bike
where  BikeId =22

--- check xe con trong don hang
select * 
from Bike
where BikeId in( 
				select BikeId
				from OrderDetail join [Order] as o on OrderDetail.OrderId = o.OrderId 
				where Status =1 or status=0)
and BikeId = 1



SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status,
	             od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor,
	             (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,
	             b.Description, od.RentalFee, od.PickupDate, od.ReturnDate
	             FROM [Order] o
	             JOIN OrderDetail od ON o.OrderId = od.OrderId
	             JOIN Bike b ON od.BikeId = b.BikeId
	             WHERE o.UserId = 5
	             ORDER BY o.OrderDate DESC


SELECT o.OrderId,OrderDetailId , b.BikeId,OwnerId,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo
FROM [Order] AS o 
	JOIN OrderDetail AS od ON od.OrderId = o.OrderId
	JOIN Bike AS b ON b.BikeId = od.BikeId
WHERE OwnerId = 5
	

SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status,
       od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor,
       (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,
       b.Description, od.RentalFee, od.PickupDate, od.ReturnDate
FROM [Order] o
JOIN OrderDetail od ON o.OrderId = od.OrderId
JOIN Bike b ON od.BikeId = b.BikeId
WHERE b.OwnerId =5
ORDER BY o.OrderDate DESC

select * from [User]

SELECT b.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,CreatedTime
FROM Bike as b
ORDER BY b.BikeId
OFFSET (1 - 1) * 15 ROWS
FETCH NEXT 15 ROWS ONLY


SELECT * FROM [User]
where UserName like N'%văn%'
ORDER BY userId OFFSET 1 ROWS FETCH NEXT 15 ROWS ONLY

SELECT *,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo
FROM Bike as b
WHERE 
    BikeLine LIKE N'%%' 
    AND BikeManufactor LIKE N'%%'
    AND BikeName LIKE N'%%'
	AND Status Like '%%'
ORDER BY BikeId
OFFSET ((1 - 1) * 15) ROWS
FETCH NEXT 15 ROWS ONLY;

select * from BikeStatus where statusId=1

update Bike
set Status = -2
where BikeId=?



	insert into Slider(sliderPhoto)
	values(?);


SELECT * FROM Message WHERE
 (sender = '' AND receiver = '') OR (sender = '' AND receiver = '')
 ORDER BY time ASC

 insert into Message(sender,reciever,content)
 values(sender,receiver,content)


 SELECT o.OrderId, o.OrderDate, o.PickupPlace, o.ReturnPlace, o.Status,
od.BikeId, b.BikeName, b.LicensePlate, b.ManufacturingYear, b.BikeLine, b.BikeManufactor,
(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,
b.Description, od.RentalFee, od.PickupDate, od.ReturnDate,OwnerId
FROM [Order] o 
JOIN OrderDetail od ON o.OrderId = od.OrderId 
JOIN Bike b ON od.BikeId = b.BikeId
WHERE o.UserId = 5
ORDER BY o.OrderDate DESC

select * from [Order]

select * from [User]
select * from OrderDetail
select * from Bike where OwnerId=5
select * from OrderStatus
select * from BikeStatus
select * from BikePhoto
Update Bike
set Status = 0
where BikeId=?	

select * from Bike where ownerId=5

select * from [Order] as o join OrderDetail as  od on o.OrderId = od.OrderId
join Bike as b on b.BikeId = od.BikeId
where OwnerId=5 and o.Status>=0

SELECT sum( Price*DATEDIFF(DAY, PickupDate, ReturnDate) )as Subtotal
FROM [Order] AS o
JOIN OrderDetail AS od ON o.OrderId = od.OrderId
JOIN Bike AS b ON b.BikeId = od.BikeId
WHERE b.OwnerId = 5 AND o.Status = 2

select * from Bike


select Top 8 *, (SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo
from Bike as b
where Status>-2
order by CreatedTime

SELECT b.BikeId,BikeName,LicensePlate, ManufacturingYear,BikeLine,OwnerId,BikeManufactor,Status,Description,Price,(SELECT TOP 1 bp.Photo FROM BikePhoto bp WHERE bp.BikeId = b.BikeId ORDER BY bp.PhotoId ASC) AS Photo,CreatedTime,OwnerId
FROM Bike as b
where Status>-2
ORDER BY b.BikeId
OFFSET (? - 1) * ? ROWS
FETCH NEXT ? ROWS ONLY

select * from [User]

select * from Bike where OwnerId =18
select * from [User] where Phone = '1111111111'

SELECT DISTINCT u.*
FROM [User] u
WHERE u.Phone IN (
    SELECT sender FROM Message WHERE receiver = '1111111111'
    UNION
    SELECT receiver FROM Message WHERE sender = '11111111111'
)

WITH Last7Days AS (
    SELECT CAST(GETDATE() AS DATE) AS OrderDay
    UNION ALL
    SELECT DATEADD(DAY, -1, OrderDay)
    FROM Last7Days
    WHERE DATEADD(DAY, -1, OrderDay) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))
),
OwnerOrders AS (
    SELECT o.OrderId, o.OrderDate, od.RentalFee, od.PickupDate, od.ReturnDate
    FROM [Order] o
    JOIN OrderDetail od ON o.OrderId = od.OrderId
    JOIN Bike b ON od.BikeId = b.BikeId
    WHERE o.Status = 2 AND b.OwnerId = 5
)
SELECT 
    FORMAT(d.OrderDay, 'dddd', 'en-US') AS DayLabel, 
    ISNULL(SUM(oo.RentalFee * 
        (DATEDIFF(DAY, oo.PickupDate, oo.ReturnDate))
    ), 0) AS TotalRevenue
FROM Last7Days d
LEFT JOIN OwnerOrders oo ON CAST(oo.OrderDate AS DATE) = d.OrderDay
GROUP BY d.OrderDay
ORDER BY d.OrderDay;

select * from Bike
select * from [Order];


WITH Last7Days AS (
    SELECT CAST(GETDATE() AS DATE) AS OrderDay
    UNION ALL
    SELECT DATEADD(DAY, -1, OrderDay)
    FROM Last7Days
    WHERE DATEADD(DAY, -1, OrderDay) >= DATEADD(DAY, -6, CAST(GETDATE() AS DATE))
)
SELECT 
    FORMAT(d.OrderDay, 'dddd', 'en-US') AS DayLabel, 
    ISNULL(SUM(od.RentalFee * DATEDIFF(DAY, od.PickupDate, od.ReturnDate)), 0) AS TotalRevenue
FROM Last7Days d
LEFT JOIN [Order] o 
    ON CAST(o.OrderDate AS DATE) = d.OrderDay AND o.Status = 2
LEFT JOIN OrderDetail od 
    ON o.OrderId = od.OrderId
LEFT JOIN Bike b 
    ON od.BikeId = b.BikeId
WHERE b.OwnerId = 5
GROUP BY d.OrderDay
ORDER BY d.OrderDay;


SELECT * FROM BikeStatus

select* from Bike

delete from Bike
where BikeId=?