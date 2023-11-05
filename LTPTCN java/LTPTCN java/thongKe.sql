use QLKaraoke

insert into ChiTietDichVu
	values('CTDV0021',3,'DV0025','PH0005')
	insert into ChiTietDichVu
	values('CTDV0022',3,'DV0022','PH0005')
	insert into ChiTietDichVu
	values('CTDV0023',3,'DV0023','PH0005')
	insert into ChiTietDichVu
	values('CTDV0024',3,'DV0024','PH0005')

	insert into ChiTietDichVu
	values('CTDV0025',4,'DV0009','PH0006')
	insert into ChiTietDichVu
	values('CTDV0026',2,'DV0013','PH0006')
	insert into ChiTietDichVu
	values('CTDV0027',6,'DV0001','PH0007')
	insert into ChiTietDichVu
	values('CTDV0028',5,'DV0008','PH0007')

	insert into ChiTietDichVu
	values('CTDV0029',5,'DV0007','PH0008')
	insert into ChiTietDichVu
	values('CTDV0030',5,'DV0017','PH0008')
	insert into ChiTietDichVu
	values('CTDV0031',5,'DV0018','PH0009')
	insert into ChiTietDichVu
	values('CTDV0032',5,'DV0002','PH0009')

	insert into ChiTietDichVu
	values('CTDV0033',7,'DV0006','PH0010')
	insert into ChiTietDichVu
	values('CTDV0034',7,'DV0020','PH0010')
	insert into ChiTietDichVu
	values('CTDV0035',7,'DV0019','PH0011')
	insert into ChiTietDichVu
	values('CTDV0036',7,'DV0003','PH0012')

	insert into ChiTietDichVu
	values('CTDV0037',2,'DV0004','PH0013')
	insert into ChiTietDichVu
	values('CTDV0038',2,'DV0005','PH0014')
	insert into ChiTietDichVu
	values('CTDV0039',6,'DV0024','PH0015')
	insert into ChiTietDichVu
	values('CTDV0040',5,'DV0011','PH0016')

	select * from ChiTietDichVu
	select * from KhachHang
	insert into KhachHang
	values('KH0008',N'Võ Minh Chiến','Nam','0326392431',N'Bến Tre')
	insert into KhachHang
	values('KH0009',N'Võ Trọng Tài','Nam','0326392421',N'Bến Tre')
	insert into KhachHang
	values('KH0010',N'Bùi Nhật Duy','Nam','0326392432',N'Bến Tre')
	insert into KhachHang
	values('KH0011',N'Võ Minh Anh','Nam','0326222431',N'Bình Định')
	insert into KhachHang
	values('KH0012',N'Nguyễn Minh Trường Giang','Nam','0326882431',N'Bến Tre')
	insert into KhachHang
	values('KH0013',N'Võ Hoàng Phúc','Nam','0326397731',N'Bến Tre')
	insert into KhachHang
	values('KH0014',N'Lương Tuấn Kiệt','Nam','0326355431',N'Bến Tre')
	insert into KhachHang
	values('KH0015',N'Nguyễn Thị Kim Quyên','Nam','0378992431',N'Bến Tre')
	insert into KhachHang
	values('KH0016',N'Lê Thị Kim Loan','Nam','0326312331',N'Bến Tre')


	select * from ChiTietDatPhong
	insert into ChiTietDatPhong
	values('DP0005','9:30','12:30','PH0004','KH0008')
	insert into ChiTietDatPhong
	values('DP0006','9:30','12:30','PH0005','KH0009')
	insert into ChiTietDatPhong
	values('DP0007','9:30','12:30','PH0006','KH0010')
	

	insert into ChiTietDatPhong
	values('DP0008','7:30','9:30','PH0007','KH0011')
	
	insert into ChiTietDatPhong
	values('DP0009','7:30','9:30','PH0008','KH0012')
	
	insert into ChiTietDatPhong
	values('DP0010','7:45','9:30','PH0009','KH0013')
	

	insert into ChiTietDatPhong
	values('DP0011','13:30','15:30','PH0010','KH0014')
	
	insert into ChiTietDatPhong
	values('DP0012','13:30','15:30','PH0011','KH0015')
	
	insert into ChiTietDatPhong
	values('DP0013','13:30','15:30','PH0012','KH0016')


	insert into DatTruocPhong
	values('DTP0003','11-07-2022','9:00','9:10','11:00','PH0016','KH0007')
	
	insert into DatTruocPhong
	values('DTP0004','11-08-2022','9:00','9:10','11:00','PH0016','KH0008')
	
	insert into DatTruocPhong
	values('DTP0005','11-09-2022','9:00','9:10','12:00','PH0015','KH0009')
	
	insert into DatTruocPhong
	values('DTP0006','11-10-2022','10:00','10:10','11:00','PH0010','KH0010')
	
	insert into DatTruocPhong
	values('DTP0007','12-11-2022','9:00','9:10','11:00','PH0016','KH0011')
	
	insert into DatTruocPhong
	values('DTP0008','10-07-2022','13:00','13:10','15:00','PH0010','KH0012')
	
	insert into DatTruocPhong
	values('DTP0009','09-09-2022','14:00','14:08','16:00','PH0002','KH0013')
	
	insert into DatTruocPhong
	values('DTP0010','08-07-2022','19:00','19:10','21:00','PH0003','KH0001')
	
	
	insert into TaiKhoan(tenDangNhap,matKhau,quyen)
	values('nv4','nv4',N'Nhân viên tiếp tân')
	insert into TaiKhoan(tenDangNhap,matKhau,quyen)
	values('nv5','nv5',N'Nhân viên tiếp tân')

	insert into NhanVien
	values('NV0004',N'Lê Văn Ngọc',N'Nam','0326392433',N'Nhân viên tiếp tân','nv4')
	insert into NhanVien
	values('NV0005',N'Nguyễn Thành Nhân',N'Nam','0362285522',N'Nhân viên tiếp tân','nv5')
	

	select * from HoaDon

	insert into HoaDon
	values('HD0004','11-07-2022','NV0001','KH0008','DP0005',null)
	insert into HoaDon
	values('HD0006','11-07-2022','NV0001','KH0010','DP0007',null)
	insert into HoaDon
	values('HD0005','11-07-2022','NV0001','KH0009','DP0006',null)
	insert into HoaDon
	values('HD0007','11-08-2022','NV0004','KH0011','DP0008',null)
	insert into HoaDon
	values('HD0008','11-08-2022','NV0004','KH0012','DP0009',null)
	insert into HoaDon
	values('HD0009','11-08-2022','NV0004','KH0013','DP0010',null)
	insert into HoaDon
	values('HD0010','11-09-2022','NV0005','KH0014','DP0011',null)
	insert into HoaDon
	values('HD0011','11-09-2022','NV0005','KH0015','DP0012',null)
	insert into HoaDon
	values('HD0012','11-09-2022','NV0005','KH0016','DP0013',null)

	insert into HoaDon
	values('HD0013','11-07-2022','NV0001','KH0007',null,'DTP0003')
	insert into HoaDon
	values('HD0014','11-08-2022','NV0004','KH0008',null,'DTP0004')
	insert into HoaDon
	values('HD0015','11-09-2022','NV0005','KH0009',null,'DTP0005')
	insert into HoaDon
	values('HD0016','11-10-2022','NV0001','KH0010',null,'DTP0006')
	insert into HoaDon
	values('HD0017','12-11-2022','NV0004','KH0011',null,'DTP0007')
	insert into HoaDon
	values('HD0018','10-07-2022','NV0005','KH0012',null,'DTP0008')
	insert into HoaDon
	values('HD0019','09-09-2022','NV0001','KH0013',null,'DTP0009')
	insert into HoaDon
	values('HD0020','08-07-2022','NV0004','KH0001',null,'DTP0010')