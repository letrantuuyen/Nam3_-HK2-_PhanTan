
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'1045', 4, N'MATH', NULL, N'Calculus')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'1050', 4, N'CHEM', NULL, N'Chemistry')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'1061', 4, N'PHYS', NULL, N'Physics')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'2021', 3, N'CHEM', NULL, N'Composition')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'2030', 2, N'LITE', NULL, N'Poetry')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'2042', 4, N'LITE', NULL, N'Literature')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'3141', 4, N'MATH', NULL, N'Trigonometry')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'4022', 3, N'ECO', NULL, N'Microeconomics')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'4041', 3, N'ECO', NULL, N'Macroeconomics')
GO
INSERT [dbo].[Courses] ([course_id], [credit], [dept_id], [description], [title]) VALUES (N'4061', 2, N'ECO', NULL, N'Quantitative')
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'101101101', CAST(N'1961-11-15' AS Date), N'Marusia Churai', CAST(1690.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'102102102', CAST(N'1964-09-16' AS Date), N'Mykhailo Hrushevsky', CAST(1350.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'104104104', CAST(N'1987-12-29' AS Date), N'Pavlo Virsky', CAST(1990.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'105105105', CAST(N'2004-06-15' AS Date), N'Mykola Leontovych', CAST(1210.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'107107107', CAST(N'2004-01-02' AS Date), N'Lesia Ukrainka', CAST(1450.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'108108108', CAST(N'1994-03-01' AS Date), N'Pavlo Chubynsky', CAST(1220.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'110110110', CAST(N'2004-04-04' AS Date), N'Ivan Mazepa', CAST(1840.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'111111111', CAST(N'1976-08-23' AS Date), N'Taras Shevchenko', CAST(1000.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'112112112', CAST(N'1961-11-15' AS Date), N'Igor Sikorsky', CAST(1700.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[Faculties] ([fact_id], [date_of_birth], [full_name], [salary]) VALUES (N'113113113', CAST(N'2004-03-03' AS Date), N'Mykhailo Verbytsky', CAST(1300.00 AS Decimal(10, 2)))
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'101101101', N'2021')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'101101101', N'4022')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'102102102', N'1050')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'102102102', N'1061')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'104104104', N'2042')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'105105105', N'1045')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'105105105', N'4022')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'107107107', N'1050')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'107107107', N'4041')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'108108108', N'1061')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'108108108', N'2021')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'112112112', N'1050')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'112112112', N'4061')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'113113113', N'1045')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'113113113', N'1061')
GO
INSERT [dbo].[FacultyCourses] ([fact_id], [course_id]) VALUES (N'113113113', N'3141')
GO
