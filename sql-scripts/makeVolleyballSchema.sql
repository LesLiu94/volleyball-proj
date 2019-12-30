DROP SCHEMA IF EXISTS volleyballschema CASCADE;
CREATE SCHEMA volleyballschema;

CREATE TABLE volleyballschema.person (
	id SERIAL PRIMARY KEY,
	age INT,
	first_name VARCHAR NOT NULL,
	last_name VARCHAR NOT NULL
);

alter sequence volleyballschema.person_id_seq restart with 42 increment by 3;

CREATE TABLE volleyballschema.team (
 	id SERIAL PRIMARY KEY,
 	team_name VARCHAR,
 	place VARCHAR
);

alter sequence volleyballschema.team_id_seq restart with 7 increment by 3;

do $$ begin
if not exists (select 1 from pg_catalog.pg_type where typname = 'player_position') then
	create type volleyballschema.player_position as enum ('setter','middle_blocker',
				'libero', 'outside', 'opposite');
end if;
end $$;

CREATE TABLE volleyballschema.player (
	id INT REFERENCES volleyballschema.person(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	jersey_number INT,
	player_position volleyballschema.player_position,
	height FLOAT,
	weight FLOAT,
	team_id INT REFERENCES volleyballschema.team(id),
	active BOOLEAN,
	PRIMARY KEY(id,team_id)
);

CREATE INDEX id_player_index ON volleyballschema.player(id);
CREATE INDEX team_id_player_index ON volleyballschema.player(team_id); 

do $$ begin
if not exists (select 1 from pg_catalog.pg_type where typname = 'title') then
	create type volleyballschema.title as enum ('coach','manager','advisor');
end if;
end $$;

CREATE TABLE volleyballschema.management (
	id INT REFERENCES volleyballschema.person(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	title volleyballschema.title NOT NULL,
	team_id INT REFERENCES volleyballschema.team(id),
	active BOOLEAN,
	PRIMARY KEY(id,team_id)
);

CREATE INDEX id_management_index ON volleyballschema.management(id);
CREATE INDEX team_id_management_index ON volleyballschema.management(team_id);

CREATE TABLE volleyballschema.game (
	id SERIAL PRIMARY KEY,
	game_date DATE,
	winner INT REFERENCES volleyballschema.team(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	loser INT REFERENCES volleyballschema.team(id) ON UPDATE CASCADE ON DELETE RESTRICT,
	win_points INT,
	lose_points INT
);

alter sequence volleyballschema.game_id_seq restart with 29 increment by 3;

do $$ begin
if not exists (select 1 from pg_catalog.pg_type where typname = 'card_color') then
	create type volleyballschema.card_color as enum ('yellow','red');
end if;
end $$;

CREATE TABLE volleyballschema.card (
	id SERIAL PRIMARY KEY,
	color volleyballschema.card_color,
	person INT REFERENCES volleyballschema.person(id),
	game INT REFERENCES volleyballschema.game(id),
	reason VARCHAR
);

alter sequence volleyballschema.card_id_seq restart with 7 increment by 3;
