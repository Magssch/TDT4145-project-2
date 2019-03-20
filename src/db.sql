drop database if exists prosjekt2;
create schema prosjekt2;
use prosjekt2;

create table Treningsøkt (
ØktID integer not null auto_increment,
Dato date not null,
Tidspunkt time not null,
Varighet float(4, 1) not null,
Notat varchar(100),
constraint Treningsøkt_PK primary key (ØktID),
constraint VarighetSjekk check (Varighet > 0));


create table Apparat (
ApparatID integer not null auto_increment,
Navn varchar(30) not null,
Beskrivelse varchar(100) not null,
constraint Apparat_PK primary key (ApparatID));


create table Øvelse (
ØvelseID integer not null auto_increment,
Navn varchar(30) not null,
constraint Øvelse_PK primary key (ØvelseID));


create table Apparatøvelse (
ØvelseID integer not null auto_increment,
Kilo integer not null,
Sett integer not null,
ApparatID integer not null,
constraint Apparatøvelse_FK1 foreign key (ØvelseID) references Øvelse(ØvelseID)
					on update cascade
                                        on delete cascade,
constraint Apparatøvelse_FK2 foreign key (ApparatID) references Apparat(ApparatID)
					on update cascade
                                        on delete cascade,
constraint KiloSjekk check (Kilo > 0),
constraint SettSjekk check (Sett > 0));


create table IkkeApparatøvelse (
ØvelseID integer not null auto_increment,
Beskrivelse varchar(100) not null,
constraint IkkeApparatøvelse_FK foreign key (ØvelseID) references Øvelse(ØvelseID)
					on update cascade
                                        on delete cascade);


create table ØvelseIØkt (
ØktID integer not null,
ØvelseID integer not null,
constraint ØvelseIØkt_FK1 foreign key (ØktID) references Treningsøkt(ØktID)
					on update cascade
                                        on delete cascade,
constraint ØvelseIØkt_FK2 foreign key (ØvelseID) references Øvelse(ØvelseID)
					on update cascade
                                        on delete cascade);


create table Øvelsesgruppe (
GruppeID integer not null auto_increment,
Navn varchar(30) not null,
constraint Øvelsesgruppe_PK primary key (GruppeID));


create table ØvelseIGruppe (
ØvelseID integer not null,
GruppeID integer not null,
constraint ØvelseIGruppe_FK1 foreign key (ØvelseID) references Øvelse(ØvelseID)
					on update cascade
                                        on delete cascade,
constraint ØvelseIGruppe_FK2 foreign key (Gruppe) references Øvelsesgruppe(GruppeID)
					on update cascade
                                        on delete cascade);

