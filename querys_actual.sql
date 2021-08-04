INSERT INTO cat_usuario VALUES
('1', 'Jesus Alberto', 'Martinez', 'Cirilo', 'jesuscirilo', '1234567', '12345', '1', '2019-07-19 00:00:00', '2019-07-19 00:00:00'),
('2', 'Jaime', 'Cirilo', 'Jimenez', 'jaimecirilo', '01', '54321', '1', '2019-07-19 00:00:00', '2019-07-19 00:00:00'),
('3', 'Ziehl', 'Neelsen', '', 'ziehneelsen', '01', 'ziehlneelse2021_', '1', '2019-07-19 00:00:00', '2019-07-19 00:00:00'),
('4', 'Karen Dennis', 'Martinez', 'Cirilo', 'karen2021', '01', 'karen2021', '1', '2019-07-19 00:00:00', '2019-07-19 00:00:00');

INSERT INTO rol VALUES
('1','Super Administrador','1'),
('2','Administrador','1'),
('3', 'Recepcion', '1'),
('4', 'Quimico', '1');


INSERT INTO usuario_rol VALUES
(UUID_TO_BIN(UUID()),1,1),
(UUID_TO_BIN(UUID()),2,2),
(UUID_TO_BIN(UUID()),2,4),
(UUID_TO_BIN(UUID()),3,3),
(UUID_TO_BIN(UUID()),4,4);


INSERT INTO menu VALUES
('1', 'Inicio', '/inicio',0,'',1),
('2', 'Recepcion', '/recepcion',0,'',1),
('3', 'Resultados', '/resultado',0,'',1),
('4', 'Cotizar', '/Cotizar',0,'',1),
('5', 'Examen', '/examen',1,'',1),
('6', 'Administrar', '/administracion',1,'',1);
-- catalogos

INSERT INTO sub_menu VALUES
(1,'Pacientes','/paciente',0,'',1),
(2,'Medicos','/atencion',0,'',1),
(3,'Usuarios','/usuario',0,'',1),
(4,'Roles de usuario','/rol',0,'',1),
(5,'Examen','/examengeneral',0,'',1),
(6,'Categorias','/categoria',0,'',1),
(7,'Secciones','/seccion',0,'',1),
(8,'Metodos','/metodo',0,'',1),
(9,'Clasificacion pacientes','/clasificacion/paciente',0,'',1);

INSERT INTO menu_sub_menu VALUES
(UUID_TO_BIN(UUID()),5,5),
(UUID_TO_BIN(UUID()),5,6),
(UUID_TO_BIN(UUID()),5,7),
(UUID_TO_BIN(UUID()),5,8),
(UUID_TO_BIN(UUID()),5,9),
(UUID_TO_BIN(UUID()),6,1),
(UUID_TO_BIN(UUID()),6,2),
(UUID_TO_BIN(UUID()),6,3),
(UUID_TO_BIN(UUID()),6,4);

INSERT INTO rol_menu VALUES
(UUID_TO_BIN(UUID()),1,1,1,1,1,1),
(UUID_TO_BIN(UUID()),1,2,1,1,1,1),
(UUID_TO_BIN(UUID()),1,3,1,1,1,1),
(UUID_TO_BIN(UUID()),1,4,1,1,1,1),
(UUID_TO_BIN(UUID()),1,5,1,1,1,1),
(UUID_TO_BIN(UUID()),1,6,1,1,1,1),
(UUID_TO_BIN(UUID()),3,2,1,1,1,1),
(UUID_TO_BIN(UUID()),3,3,1,1,1,1),
(UUID_TO_BIN(UUID()),4,3,1,1,1,1);

INSERT INTO rol_sub_menu VALUES
(UUID_TO_BIN(UUID()),1,1,1,1,1,1),
(UUID_TO_BIN(UUID()),1,2,1,1,1,1),
(UUID_TO_BIN(UUID()),1,3,1,1,1,1),
(UUID_TO_BIN(UUID()),1,4,1,1,1,1),
(UUID_TO_BIN(UUID()),1,5,1,1,1,1),
(UUID_TO_BIN(UUID()),1,6,1,1,1,1),
(UUID_TO_BIN(UUID()),1,7,1,1,1,1),
(UUID_TO_BIN(UUID()),1,8,1,1,1,1),
(UUID_TO_BIN(UUID()),1,9,1,1,1,1);

INSERT INTO cat_dias VALUES
(1,"1","Domingo"),
(2,"2","Lunes"),
(3,"3","Martes"),
(4,"4","Miercoles"),
(5,"5","Jueves"),
(6,"6","Viernes"),
(7,"7","Sabado");

INSERT INTO cat_medico VALUES
('1','A','Q','C','1',NOW(),NOW());

INSERT INTO cat_categoria VALUES
('1', 'Hematologia', '1', '1',NOW(),NOW()),
('2', 'Uruanalisis', '2', '1',NOW(),NOW()),
('3', 'Función Hepatica', '3', '1',NOW(),NOW()),
('4', 'Función Cardiaca', '4', '1',NOW(),NOW()),
('5', 'Enfermedades Reumaticas', '5', '1',NOW(),NOW()),
('6', 'Electrolitos', '6', '1',NOW(),NOW()),
('7', 'Anemias Carenciales', '7', '1',NOW(),NOW()),
('8', 'Microbiologia', '8', '1',NOW(),NOW()),
('9', 'Marcadores Tumorales', '9', '1',NOW(),NOW()),
('10', 'Quimica Sanguinea', '10', '1',NOW(),NOW()),
('11', 'Parasitologia', '11', '1',NOW(),NOW()),
('12', 'Funcion Pancreatica', '12', '1',NOW(),NOW()),
('13', 'Enfermedades Autoinmunes', '13', '1',NOW(),NOW()),
('14', 'Infectologia', '14', '1',NOW(),NOW()),
('15', 'Endocrinologia', '15', '1',NOW(),NOW()),
('16', 'Diversos', '16', '1',NOW(),NOW());

INSERT INTO cat_metodo VALUES
(1,'Impedancia','1',NOW(),NOW()),
(2,'Automatizado','1',NOW(),NOW()),
(3,'Quimica seca','1',NOW(),NOW()),
(4,'Espectrofotometria','1',NOW(),NOW()),
(5,'Espectrofotometria por reflactancia','1',NOW(),NOW()),
(6,'Acs Monoclonales','1',NOW(),NOW()),
(7,'Ion selectivo/Quimica seca','1',NOW(),NOW()),
(8,'Inmunoturbidimetria','1',NOW(),NOW()),
(9,'Wintrobe/Inmunoturbidimetria','1',NOW(),NOW()),
(10,'Concentracion Minima Inhibitoria','1',NOW(),NOW());

INSERT INTO cat_clasificacion_paciente VALUES 
(1,"Sin clasificacion","0","100",1,now(),now()),
(2,"Todas las edades","0","100",1,now(),now()),
(3,"Niños de 0 a 1 año","0","1",1,now(),now()),
(4,"Niños de 1 año a 4 años","1","4",1,now(),now()),
(5,"Niños de 5 años a 9 años","5","9",1,now(),now()),
(6,"Adolecente","10","20",1,now(),now()),
(7,"Adulto","20","50",1,now(),now()),
(8,"Adultos mayores","50","100",1,now(),now()),
(9,"Mascota canina","1","20",1,now(),now());


-- ESTUDIOS

INSERT INTO cat_seccion (NOMBRE,TITULO,TEXTO_CENTRO,TEXTO_DERECHO,ESTADO,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Examen Fisico-Químico',NULL,NULL,NULL,1,'2021-08-02 23:02:06.0','2021-08-02 23:02:06.0'),
	 ('MICROSCOPIA DEL SEDIMENTO URINARIO CENTRIFUGADO (400x)',NULL,NULL,NULL,1,'2021-08-02 23:20:12.0','2021-08-02 23:20:12.0'),
	 ('Formula roja','FORMULA ROJA','','VALORES DE REFERENCIA<br/><div><span class="titleSubexamen">Masculino</span>&nbsp;<span class="titleSubexamen">Femenino</span></div>',1,'2021-08-02 23:44:33.0','2021-08-03 12:41:35.0'),
	 ('Formula blanca','FORMULA BLANCA',NULL,NULL,1,'2021-08-02 23:55:11.0','2021-08-02 23:55:11.0');
INSERT INTO cat_estudio (NOMBRE,RESULTADO,RESULTADO_SELECT,MOSTRAR_INPUT,COMODIN,ESTADO,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Volumen',NULL,NULL,0,0,1,'2021-08-02 23:02:36.0','2021-08-02 23:02:36.0'),
	 ('Olor',NULL,'[{"value": "Caracteristico", "viewValue": "Caracteristico"}]',0,0,1,'2021-08-02 23:02:58.0','2021-08-02 23:02:58.0'),
	 ('Color',NULL,'[{"value": "Amarillo claro", "viewValue": "Amarillo claro"}]',0,0,1,'2021-08-02 23:12:21.0','2021-08-02 23:12:21.0'),
	 ('Aspecto',NULL,'[{"value": "Transparente", "viewValue": "Transparente"}]',0,0,1,'2021-08-02 23:12:41.0','2021-08-02 23:12:41.0'),
	 ('Ph',NULL,NULL,0,0,1,'2021-08-02 23:12:54.0','2021-08-02 23:12:54.0'),
	 ('Densidad',NULL,NULL,0,0,1,'2021-08-02 23:13:08.0','2021-08-02 23:13:08.0'),
	 ('(N: 1,010 - 1025)',NULL,NULL,0,1,1,'2021-08-02 23:13:34.0','2021-08-02 23:13:34.0'),
	 ('Glucosa',NULL,'[{"value": "Positivo", "viewValue": "Positivo"}, {"value": "Negativo", "viewValue": "Negativo"}]',0,0,1,'2021-08-02 23:14:09.0','2021-08-02 23:14:09.0'),
	 ('Bilirrubina',NULL,'[{"value": "Positivo", "viewValue": "Positivo"}, {"value": "Negativo", "viewValue": "Negativo"}]',0,0,1,'2021-08-02 23:14:28.0','2021-08-02 23:14:28.0'),
	 ('C. cetonicos',NULL,'[{"value": "Positivo", "viewValue": "Positivo"}, {"value": "Negativo", "viewValue": "Negativo"}]',0,0,1,'2021-08-02 23:14:51.0','2021-08-02 23:14:51.0');
INSERT INTO cat_estudio (NOMBRE,RESULTADO,RESULTADO_SELECT,MOSTRAR_INPUT,COMODIN,ESTADO,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Hemoglobina',NULL,'[{"value": "Positivo", "viewValue": "Positivo"}, {"value": "Negativo", "viewValue": "Negativo"}]',0,0,1,'2021-08-02 23:15:06.0','2021-08-02 23:15:06.0'),
	 ('Proteínas',NULL,'[{"value": "Negativo", "viewValue": "Negativo"}, {"value": "Positivo", "viewValue": "Positivo"}]',0,0,1,'2021-08-02 23:15:21.0','2021-08-02 23:15:21.0'),
	 ('Nitritos',NULL,'[{"value": "Negativo", "viewValue": "Negativo"}, {"value": "Positivo", "viewValue": "Positivo"}]',0,0,1,'2021-08-02 23:15:38.0','2021-08-02 23:15:38.0'),
	 ('Urobilinógeno',NULL,NULL,0,0,1,'2021-08-02 23:16:08.0','2021-08-02 23:16:08.0'),
	 ('(Normal: 3,5 µmol/L)',NULL,NULL,0,1,1,'2021-08-02 23:18:58.0','2021-08-02 23:18:58.0'),
	 ('Celulas del Epitelio pavimentoso',NULL,NULL,0,0,1,'2021-08-02 23:20:44.0','2021-08-02 23:20:44.0'),
	 ('Leucocitos',NULL,NULL,0,0,1,'2021-08-02 23:21:13.0','2021-08-02 23:21:13.0'),
	 ('Bacterias',NULL,NULL,0,0,1,'2021-08-02 23:21:28.0','2021-08-02 23:21:28.0'),
	 ('Eritrocitos, millones',NULL,NULL,0,0,1,'2021-08-02 23:44:56.0','2021-08-02 23:44:56.0'),
	 ('Hb, g/dl',NULL,NULL,0,0,1,'2021-08-02 23:48:52.0','2021-08-02 23:48:52.0');
INSERT INTO cat_estudio (NOMBRE,RESULTADO,RESULTADO_SELECT,MOSTRAR_INPUT,COMODIN,ESTADO,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Hto, %',NULL,NULL,0,0,1,'2021-08-02 23:50:12.0','2021-08-02 23:50:12.0'),
	 ('V.G.M.fl',NULL,NULL,0,0,1,'2021-08-02 23:51:04.0','2021-08-02 23:51:04.0'),
	 ('Cm.Hb.g/dl',NULL,NULL,0,0,1,'2021-08-02 23:52:55.0','2021-08-02 23:52:55.0'),
	 ('H.G.M,pg',NULL,NULL,0,0,1,'2021-08-02 23:53:59.0','2021-08-02 23:53:59.0'),
	 ('Leucocitos,mm3',NULL,NULL,0,0,1,'2021-08-02 23:55:31.0','2021-08-02 23:55:31.0'),
	 ('Linfocitos, %',NULL,NULL,0,0,1,'2021-08-02 23:55:50.0','2021-08-02 23:55:50.0'),
	 ('Monocitos, %',NULL,NULL,0,0,1,'2021-08-02 23:56:06.0','2021-08-02 23:56:06.0'),
	 ('Eosinofilos, %',NULL,NULL,0,0,1,'2021-08-02 23:56:21.0','2021-08-02 23:56:21.0'),
	 ('Basofilos, %',NULL,NULL,0,0,1,'2021-08-02 23:56:49.0','2021-08-02 23:56:49.0'),
	 ('Neutrofilos Totales, %',NULL,NULL,0,0,1,'2021-08-02 23:57:37.0','2021-08-02 23:57:37.0');
INSERT INTO cat_estudio (NOMBRE,RESULTADO,RESULTADO_SELECT,MOSTRAR_INPUT,COMODIN,ESTADO,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Segmentados, %',NULL,NULL,0,0,1,'2021-08-02 23:58:03.0','2021-08-02 23:58:03.0'),
	 ('En Banda, %',NULL,NULL,0,0,1,'2021-08-02 23:58:32.0','2021-08-02 23:58:32.0'),
	 ('Mielocitos, %',NULL,NULL,0,0,1,'2021-08-02 23:58:57.0','2021-08-02 23:58:57.0'),
	 ('Metamielocitos, %',NULL,NULL,0,0,1,'2021-08-02 23:59:24.0','2021-08-02 23:59:24.0'),
	 ('Plaquetas/mm3',NULL,NULL,0,0,1,'2021-08-02 23:59:43.0','2021-08-02 23:59:43.0'),
	 ('VPM, fl',NULL,NULL,0,0,1,'2021-08-03 00:00:01.0','2021-08-03 00:00:01.0'),
	 ('PDW',NULL,NULL,0,0,1,'2021-08-03 00:00:18.0','2021-08-03 00:00:18.0');
	
INSERT INTO referencia (REFERENCIA_ID,CLASIFICACION_ID,ESTUDIO_ID,MASCULINO,FEMENINO,`GENERAL`,ORDEN,NOTA,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 (0x03CBBB6C2CE5491AAFECA18F30F4DC7F,1,31,'','','45 - 65',0,'','2021-08-03 00:02:37.0','2021-08-03 00:02:37.0'),
	 (0x0B67949F77714A82843949843DC93E86,1,30,'','','50 - 70',0,'','2021-08-03 00:02:12.0','2021-08-03 00:02:12.0'),
	 (0x3317A20B16E94F75A97D4F48B98D3EF4,1,28,'','','1 - 4',0,'','2021-08-03 00:01:41.0','2021-08-03 00:01:41.0'),
	 (0x3EE5D700F0684789A6801A31B37D12A6,1,26,'','','18 - 45',0,'','2021-08-03 00:01:06.0','2021-08-03 00:01:06.0'),
	 (0x46FF11191E7F4982AA552E9A50C3DC5A,1,32,'','','2 - 7',0,'','2021-08-03 00:02:50.0','2021-08-03 00:02:50.0'),
	 (0x4A60F8F9A8954557819CD967AF847D66,1,25,'','','4,500 10,500',0,'','2021-08-03 00:00:51.0','2021-08-03 00:00:51.0'),
	 (0x4C88AEF3F32F403A9B762EDC21832A6C,1,19,'5,0 - 6,0','4,5 - 5,5','',0,'','2021-08-02 23:45:44.0','2021-08-02 23:45:44.0'),
	 (0x58FB3FFC9254457DB29554188014D418,1,27,'','','3 - 10',0,'','2021-08-03 00:01:28.0','2021-08-03 00:01:28.0'),
	 (0x64ADC37BF97A4355A1080C0C2D935147,1,23,'32 - 34,5','32 - 34,5','',0,'','2021-08-02 23:53:34.0','2021-08-02 23:53:34.0');
INSERT INTO referencia (REFERENCIA_ID,CLASIFICACION_ID,ESTUDIO_ID,MASCULINO,FEMENINO,`GENERAL`,ORDEN,NOTA,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 (0x7F65F08BA2B148589796FBEE73E1AA7C,1,20,'13,0 - 17,0','12,0 - 15,0','',0,'','2021-08-02 23:49:41.0','2021-08-02 23:49:41.0'),
	 (0x85FC272919404F41AEFBFDA2279A5BE4,1,33,'','','0',0,'','2021-08-03 00:03:02.0','2021-08-03 00:03:02.0'),
	 (0x86B2A0BF03A049A7BBB1FB53262D4C39,1,34,'','','0',0,'','2021-08-03 00:03:12.0','2021-08-03 00:03:12.0'),
	 (0xA878CEFADFF2413E852FAA0A0D5F5760,1,22,'83 - 100','83 - 100','',0,'','2021-08-02 23:52:21.0','2021-08-02 23:52:21.0'),
	 (0xB066A63A8B4B4BD084FBA02A18AE5D69,1,21,'41 - 52','37 - 47','',0,'','2021-08-02 23:50:40.0','2021-08-02 23:50:40.0'),
	 (0xB774EF9DE4E644599560E8AC2FA3E971,1,37,'','','15,0 - 17,0',0,'','2021-08-03 00:04:50.0','2021-08-03 00:04:50.0'),
	 (0xBFC46BED126F4CDBA2767555EDD922A3,1,38,'','','Normal Menor a 30,00 mg /g de creatinina',0,'','2021-08-03 17:49:11.0','2021-08-03 17:49:11.0'),
	 (0xC14968AB30484C28AC8E7435F159F747,1,36,'','','7,0 - 11,0',0,'','2021-08-03 00:04:13.0','2021-08-03 00:04:13.0'),
	 (0xC5A2A8FA0CA84C3BA961C9E3592F0D48,1,29,'','','0 - 1',0,'','2021-08-03 00:01:51.0','2021-08-03 00:01:51.0');
INSERT INTO referencia (REFERENCIA_ID,CLASIFICACION_ID,ESTUDIO_ID,MASCULINO,FEMENINO,`GENERAL`,ORDEN,NOTA,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 (0xE34C3C332847480F94D1E945267D989F,1,35,'','','140,000 - 450,000',0,'','2021-08-03 00:03:39.0','2021-08-03 00:03:39.0'),
	 (0xE87B45F025AE40D1A914F2EF7461B344,1,24,'28 - 32','28 - 32','',0,'','2021-08-02 23:54:26.0','2021-08-02 23:54:26.0');
	
INSERT INTO estudio_seccion (ESTUDIO_SECCION_ID,ESTUDIO_ID,SECCION_ID,ORDEN) VALUES
	 (0x0DE48F19048747BF8F5FC1B8A429F41B,36,4,12),
	 (0x123BE03BEF7B4CF28B978FEC8E1563D7,20,3,2),
	 (0x15BEB168F65D47578B4143C10F29FF5B,3,1,3),
	 (0x1975CE7998334BBCAF891E0A6CAEEF62,35,4,11),
	 (0x1D2E00CAB6AD46C6A2846149AA76075E,18,2,3),
	 (0x20D8BADC725D4B07824F877348C7B17B,6,1,6),
	 (0x24299DFF797E4526B90D3660281AFDBD,32,4,8),
	 (0x249AEF87913740A598023A396C31DA05,14,1,14),
	 (0x319DCD01074C40F0BC94C21392A34AB7,19,3,1),
	 (0x356DCE604CF94041832E145BC64E7421,15,1,15);
INSERT INTO estudio_seccion (ESTUDIO_SECCION_ID,ESTUDIO_ID,SECCION_ID,ORDEN) VALUES
	 (0x38AA31B424784FEABD9AB9D49CF143AF,26,4,2),
	 (0x3A4EC9F3B368410F800ACE5BD1DE4122,12,1,12),
	 (0x4B0D42D911FD413EBA400DBFCA92183D,8,1,8),
	 (0x5248B82FA8354CC4B745EC798E5EC8B8,13,1,13),
	 (0x56477D46BDB24529B4006D4BEBE557E9,37,4,13),
	 (0x5D4AF601A5E44BD4B3C18C067B3A8A22,24,3,6),
	 (0x5FADFBC2E9C945EBB21484A680297286,28,4,4),
	 (0x7501D783306B4447B5122C9DC6A6CDAA,2,1,2),
	 (0x7EE38C2BA33F45DAA7AA40FFFCA119C6,29,4,5),
	 (0x81C2AADD8FF34BC4A8A966F77BFDC46A,9,1,9);
INSERT INTO estudio_seccion (ESTUDIO_SECCION_ID,ESTUDIO_ID,SECCION_ID,ORDEN) VALUES
	 (0x82B18D7F06654402A01C6FBEAC0B6153,30,4,6),
	 (0x8721F5AF8ADF41578EAB47CFC9E9B879,31,4,7),
	 (0x92025F90DF4C47C398CEBC45AC22620D,21,3,3),
	 (0x9349A60B3D884D8AA81BDEFDA6B8F92F,16,2,1),
	 (0xA4AF587AD61D496798565EBF8C0B775B,33,4,9),
	 (0xB9749FD1E1DD498B8260D5716917CF53,4,1,4),
	 (0xBF282FBEF79840A7B85EDE651F3074CB,27,4,3),
	 (0xC03A966040494033962416F662160C0A,23,3,5),
	 (0xCE54B842340D4643805F8B00D47B3119,25,4,1),
	 (0xCFD38A41CFAC44F38598A49CA6EA97BC,22,3,4);
INSERT INTO estudio_seccion (ESTUDIO_SECCION_ID,ESTUDIO_ID,SECCION_ID,ORDEN) VALUES
	 (0xD0A78CA831494D7A94AE8F62976F9FDB,5,1,5),
	 (0xD0E5BD6FDB0541D99682657EC4CF9C15,11,1,11),
	 (0xE3CB53E5F46A4B77B4124C64844BBC23,7,1,7),
	 (0xEA3A173BAD4D449EAA819C38BFE388CD,10,1,10),
	 (0xEC03C2D79E754932BC0A1A19D25D94BF,1,1,1),
	 (0xF90F83BFC25C415A836162D4CD396A31,34,4,10),
	 (0xFDDF77F2295D423C9BB3BD3FB8F16F84,17,2,2);
	
	
INSERT INTO examen_general (NOMBRE,ALIAS,TITULO_EXAMEN_IZQUIERDO,TITULO_EXAMEN_CENTRO,TITULO_EXAMEN_DERECHO,ESTADO,PRECIO,CLAVE,LAYOUT,CATEGORIA_ID,FECHA_CREACION,FECHA_ACTUALIZACION) VALUES
	 ('Examen general de orina','EGO','','EXAMEN GENERAL DE ORINA','',1,250.00,'',4,1,'2021-08-02 23:00:27.0','2021-08-03 00:43:41.0'),
	 ('Citometria hematica','','','CITOMETRIA HEMATICA','',1,300.00,'',5,2,'2021-08-02 23:38:56.0','2021-08-02 23:38:56.0');
	
INSERT INTO seccion_examen_general (SECCION_EXAMEN_ID,SECCION_ID,EXAMEN_ID,ORDEN) VALUES
	 (0x08746AE93CB343CCBE6703409316706C,3,2,1),
	 (0x166BF0BC76744BBD991247D364E0A1BC,1,1,1),
	 (0xEC665887949E478382192951D8A856CC,4,2,2),
	 (0xFAD154C036FD4ADAA6DEB3EAAF69E9F3,2,1,2);
	
-- paquetes descuentos cotizaciones


SELECT * FROM cat_paquete;
INSERT INTO cat_paquete VALUES
(1,"Paquete 1","Descuento por aniversario Nro: 75","2020-09-07 23:59:00","2020-09-07 23:59:00","1234567",'500',50,123.50,1,now(),now()),
(2,"Paquete 2","Descuento por buen fin","2020-09-07 23:59:00","2020-12-30 23:59:00","123",'500',50,150.00,1,now(),now()),
(3,"Paquete 3","Descripcion paquete 2","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'600',50,150.00,1,now(),now()),
(4,"Paquete 4","La descripcion paquete 4","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1,now(),now()),
(5,"Paquete 5","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1,now(),now()),
(6,"Paquete 6","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1,now(),now()),
(7,"Paquete 7","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1,now(),now());




USE laboratorio;
SELECT * FROM cotizacion;
INSERT INTO cotizacion VALUES("020820200004","2020-09-03","22:34:24");
SELECT * FROM examen_general_cotizacion;
INSERT INTO examen_general_cotizacion VALUES(1,"020820200004");

SELECT * FROM cat_descuento;

INSERT INTO cat_descuento VALUES(1,"Hot Sale","40",150.50,1);
INSERT INTO cat_descuento VALUES(2,"Black day","40",100.00,1);

SELECT * FROM examen_general_descuento;
INSERT INTO examen_general_descuento VALUES(2,1);

SELECT * FROM dia_descuento;
-- format datetime YYYY-MM-DD hh:mm:ss
INSERT INTO dia_descuento VALUES
(1,1,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(2,2,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(3,1,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(4,1,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(5,1,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(6,1,"2020-09-07 23:59:00","2020-10-08 23:59:00"),
(7,1,"2020-09-07 23:59:00","2020-10-08 23:59:00");


SELECT * FROM cat_paquete;
INSERT INTO cat_paquete VALUES
(1,"Paquete 1","Descuento por aniversario Nro: 75","2020-09-07 23:59:00","2020-09-07 23:59:00","123",'500',50,123.50,1),
(2,"Paquete 2","Descuento por buen fin","2020-09-07 23:59:00","2020-09-07 23:59:00","123",'500',50,150.00,1),
(3,"Paquete 3","Descripcion paquete 2","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'600',50,150.00,1),
(4,"Paquete 4","La descripcion paquete 4","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1),
(5,"Paquete 5","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1),
(6,"Paquete 6","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1),
(7,"Paquete 7","Descripcion paquete 5","2020-09-07 23:59:00","2020-12-30 23:59:00","1234567",'350',50,150.00,1);

SELECT * FROM cat_paquete_examen;
INSERT INTO cat_paquete_examen VALUES
(5,1),
(5,2),
(5,3);



