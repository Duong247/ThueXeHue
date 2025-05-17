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