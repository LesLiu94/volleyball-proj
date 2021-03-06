insert into volleyballschema.person(id, age, first_name,last_name) values 
	(1, 18, 'Daichi', 'Sawamura'),
	(2, 18, 'Koshi', 'Sugawara'),
	(3, 18, 'Asahi', 'Azumane'),
	(4, 17, 'Yu', 'Nishinoya'),
	(5, 17, 'Ryunosuke' , 'Tanaka'),
	(6, 17, 'Chikara', 'Ennoshita'),
	(7, 17, 'Kazuhito', 'Narita'),
	(8, 17, 'Hisashi', 'Kinoshita'),
	(9, 16, 'Tobio', 'Kageyama'),
	(10, 16, 'Shoyo', 'Hinata'),
	(11, 16, 'Kei', 'Tsukishima'),
	(12, 16, 'Tadashi', 'Yamaguchi'),
	(13, 29, 'Ittetsu', 'Takeda'),
	(14, 18, 'Kiyoko', 'Shimizu'),
	(15, 16, 'Hitoka', 'Yachi'),
	(16, 26, 'Keishin', 'Ukai'),
	(17, 69, 'Ikkei', 'Ukai'),
	(18, 18, 'Tetsuro', 'Kuroo'),
	(19, 17, 'Taketora', 'Yamamoto'),
	(20, 17, 'Kenma', 'Kozume'),
	(21, 16, 'Lev', 'Haiba'),
	(22, 68, 'Yasufumi', 'Nekomata'),
	(23, 18, 'Toru', 'Oikawa'),
	(24, 18, 'Hajime', 'Iwaizumi'),
	(25, 16, 'Yutaro', 'Kindaichi'),
	(26, 17, 'Kentaro', 'Kyotani'),
	(27, 52, 'Nobuteru', 'Irihata'),
	(28, 17, 'Takanobu', 'Aone'),
	(29, 16, 'Kanji', 'Koganegawa'),
	(30, 17, 'Mai', 'Nametsu'),
	(31, 46, 'Takuro', 'Oiwake'),
	(32, 18, 'Kotaro', 'Bokuto'),
	(33, 17, 'Keiji', 'Akaashi'),
	(34, 18, 'Yukie', 'Shirofuku'),
	(35, 18, 'Kaori', 'Suzumeda'),
	(36, 18, 'Wakatoshi', 'Ushijima'),
	(37, 18, 'Reon', 'Ohira'),
	(38, 18, 'Satori', 'Tendo'),
	(39, 71, 'Tanji', 'Washijo'),
	(40, 26, 'Makoto', 'Shimada'),
	(41, 26, 'Yusuke', 'Takinoue');

insert into volleyballschema.team(id, team_name, place) values
	(1, 'Karasuno High', 'Miyagi'),
	(2, 'Nekoma High', 'Nerima'),
	(3, 'Aobajohsai High', 'Miyagi'),
	(4, 'Date Tech High', 'Miyagi'),
	(5, 'Fukurodani Academy', 'Kanto'),
	(6, 'Shiratorizawa Academy', 'Miyagi');

insert into volleyballschema.player(id, person_id, jersey_number, player_position, height, weight, team_id, active) values
	(1, 1, 1, 'OPPOSITE', 176.7, 70.1, 1, true),
	(2, 2, 2, 'SETTER', 174.6, 63.5, 1, true),
	(3, 3, 3, 'OUTSIDE', 186.4, 75.2, 1, true),
	(4, 4, 4, 'LIBERO', 160.5, 51.1, 1, true),
	(5, 5, 5, 'OUTSIDE', 178.2, 68.8, 1, true),
	(6, 6, 6, 'OPPOSITE', 176.1, 66.4, 1, true),
	(7, 7, 8, 'MIDDLE_BLOCKER', 180.9, 70.2, 1, true),
	(8, 8, 7, 'OPPOSITE', 175.8, 65.5, 1, true),
	(9, 9, 9, 'SETTER', 181.9, 66.3, 1, true),
	(10, 10, 10, 'MIDDLE_BLOCKER', 171, 51.9, 1, true),
	(11, 11, 11, 'MIDDLE_BLOCKER', 190.1, 68.4, 1, true),
	(12, 12, 12, 'MIDDLE_BLOCKER', 180, 63, 1, true),
	(13, 18, 1, 'MIDDLE_BLOCKER', 188, 75.3, 2, true),
	(14, 19, 4, 'OUTSIDE', 178, 69.1, 2, true),
	(15, 20, 5, 'SETTER', 170, 58.3, 2, true),
	(16, 21, 11, 'MIDDLE_BLOCKER', 196, 79.7, 2, true),
	(17, 23, 1, 'SETTER', 184.3, 72.2, 3, true),
	(18, 24, 4, 'OUTSIDE', 179.3, 70.2, 3, true),
	(19, 25, 12, 'MIDDLE_BLOCKER', 190, 74.3, 3, true),
	(20, 26, 16, 'OUTSIDE', 178.8, 70.8, 3, true),
	(21, 28, 1, 'MIDDLE_BLOCKER', 192, 88.2, 4, true),
	(22, 29, 7, 'SETTER', 193, 80.2, 4, true),
	(23, 32, 4, 'OUTSIDE', 186, 78.3, 5, true),
	(24, 33, 5, 'SETTER', 183, 70.7, 5, true),
	(25, 36, 1, 'OUTSIDE', 189.5, 84.8, 6, true),
	(26, 37, 4, 'OPPOSITE', 182.7, 82.4, 6, true),
	(27, 38, 5, 'MIDDLE_BLOCKER', 187.7, 71.1, 6, true),
	(28, 40, 11, 'OPPOSITE', 177.7, null, 1, false),
	(29, 41, 9, 'MIDDLE_BLOCKER', 185.6, null, 1, false);

insert into volleyballschema.management(id, person_id, title, team_id, active) values
	(1, 13, 'ADVISOR', 1, true),
	(2, 14, 'MANAGER', 1, true),
	(3, 15, 'MANAGER', 1, true),
	(4, 16, 'COACH', 1, true),
	(5, 17, 'COACH', 1, false),
	(6, 22, 'COACH', 2, true),
	(7, 27, 'COACH', 3, true),
	(8, 30, 'MANAGER', 4, true),
	(9, 31, 'COACH', 4, true),
	(10, 34, 'MANAGER', 5, true),
	(11, 35, 'MANAGER', 5, true),
	(12, 39, 'COACH', 6, true);

insert into volleyballschema.game(id, game_date, winner, loser, win_points, lose_points) values
	(1, '2014-05-11', 3, 1, 25, 13),
	(2, '2014-05-11', 1, 3, 25, 22),
	(3, '2014-05-11', 1, 3, 25, 23),
	(4, '2014-06-22', 2, 1, 25, 22),
	(5, '2014-06-22', 2, 1, 25, 23),
	(6, '2014-06-22', 2, 1, 25, 22),
	(7, '2014-06-22', 2, 1, 26, 24),
	(8, '2014-06-22', 2, 1, 27, 25),
	(9, '2014-06-22', 2, 1, 32, 30),
	(10, '2015-11-15', 5, 1, 25, 12),
	(11, '2015-11-15', 5, 1, 25, 14),
	(12, '2015-11-15', 5, 1, 25, 22),
	(13, '2015-11-15', 5, 1, 25, 23),
	(14, '2015-11-29', 2, 1, 25, 15),
	(15, '2015-11-29', 2, 1, 25, 16),
	(16, '2014-07-27', 1, 4, 25, 19),
	(17, '2014-07-27', 1, 4, 25, 22),
	(18, '2014-08-10', 3, 1, 25, 15),
	(19, '2014-08-10', 1, 3, 25, 23),
	(20, '2014-08-10', 3, 1, 33, 31),
	(21, '2016-02-21', 1, 3, 25, 23),
	(22, '2016-02-21', 3, 1, 28, 26),
	(23, '2016-02-21', 1, 3, 26, 24),
	(24, '2016-10-08', 6, 1, 25, 16),
	(25, '2016-10-08', 1, 6, 31, 29),
	(26, '2016-10-08', 6, 1, 25, 18),
	(27, '2016-10-08', 1, 6, 29, 27),
	(28, '2016-10-08', 1, 6, 21, 19);
	
insert into volleyballschema.card(id, color, person, game, reason) values
	(1, 'YELLOW', 5, 1, 'Player yelled at referee.'),
	(2, 'YELLOW', 9, 10, 'Player yelled at teammate.'),
	(3, 'YELLOW', 19, 4, 'Player yelled at teammate.'),
	(4, 'YELLOW', 26, 1, 'Player yelled at referee.'),
	(5, 'RED', 26, 1, 'Player punched referee.'),
	(6, 'YELLOW', 31, 16, 'Coach yelled at referee.');
	
