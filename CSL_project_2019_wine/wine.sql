create table Wine_Colours(
	colour varchar(10) not null,
	constraint Wine_Colours_primary_key primary key(colour)
);

create table Merchants (
	merchant_id char(5) not null,
	merchant_name varchar(50) not null,
	constraint Merchants_primary_key primary key(merchant_id)
);

create table Food (
	food_name varchar(50) not null,
	food_description varchar(255) not null,
	constraint Food_primary_key primary key(food_name)
);

create table Countries (
	country_id char(3) not null,
	country_name varchar(50) not null,
	constraint Countries_primary_key primary key(country_id)
);

create table Info_Sources (
	info_source_id char(5) not null,
	info_source_description varchar(255) not null,
	constraint Info_Sources_primary_key primary key(info_source_id)
);

create table Winemaker (
	winemaker_id char(5) not null,
	country_id char(3) not null,
	winemaker_name varchar(50) not null,
	constraint Winemaker_primary_key primary key(winemaker_id),
	constraint Winemaker_Countries_foreign_key foreign key(country_id) references Countries(country_id)
);

create table Rating_Guide (
	rating_id char(5) not null,
	colour varchar(10) not null,
	rating_description varchar(255) not null,
	constraint Rating_Guide_primary_key primary key(rating_id),
	constraint Rating_Guide_Wine_Colours_foreign_key foreign key(colour) references Wine_Colours(colour)
);

create table Wine (
	wine_id char(5) not null,
	colour varchar(10) not null,
	info_source_id char(5) not null,
	rating_id char(5) not null,
	winemaker_id char(5) not null,
	wine_name varchar(50) not null,
	wine_description varchar(255) not null,
	label_picture_filename varchar(50) not null,
	good_years varchar(20) not null,
	price_bottle real not null,
	price_half_bottle real not null,
	constraint Wine_primary_key primary key(wine_id),
	constraint Wine_Wine_Colours_foreign_key foreign key(colour) references Wine_Colours(colour),
	constraint Wine_Info_Sources_foreign_key foreign key(info_source_id) references Info_Sources(info_source_id),
	constraint Wine_Rating_Guide_foreign_key foreign key(rating_id) references Rating_Guide(rating_id),
	constraint Wine_Winemaker_foreign_key foreign key(winemaker_id) references Winemaker(winemaker_id)
);

create table Wine_goes_with_Food (
	food_name varchar(50) not null,
	wine_id char(5) not null,
	comments varchar(255) not null,
	constraint WgwF_primary_key primary key(food_name,wine_id),
	constraint WgwF_Food_foreign_key foreign key(food_name) references Food(food_name),
	constraint WgwF_Wine_foreign_key foreign key(wine_id) references Wine(wine_id)
);

create table Wine_at_Merchants (
	wine_id char(5) not null,
	merchant_id char(5) not null,
	offer_start_date Date not null,
	offer_end_date Date not null,
	price_on_offer real not null,
	constraint WaM_primary_key primary key(wine_id,merchant_id),
	constraint WaM_Wine_foreign_key foreign key(wine_id) references Wine(wine_id),
	constraint WaM_Merchants_foreign_key foreign key(merchant_id) references Merchants(merchant_id)
);
