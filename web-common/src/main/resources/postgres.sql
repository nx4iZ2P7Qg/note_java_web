insert into menstrual(id, dt) values('1', '2015-07-23');
insert into menstrual(id, dt) values('2', '2015-08-25');
insert into menstrual(id, dt) values('3', '2015-10-03');
insert into menstrual(id, dt) values('4', '2015-11-04');
insert into menstrual(id, dt) values('5', '2015-12-08');
insert into menstrual(id, dt) values('6', '2016-01-17');
insert into menstrual(id, dt) values('7', '2016-02-26');
insert into menstrual(id, dt) values('8', '2016-04-04');
insert into menstrual(id, dt) values('9', '2016-05-05');
insert into menstrual(id, dt) values('10', '2016-06-07');
insert into menstrual(id, dt) values('11', '2016-07-19');
insert into menstrual(id, dt) values('12', '2016-08-19');
insert into menstrual(id, dt) values('13', '2016-09-22');
insert into menstrual(id, dt) values('14', '2016-10-31');
insert into menstrual(id, dt) values('15', '2016-12-08');
insert into menstrual(id, dt) values('16', '2017-01-08');
insert into menstrual(id, dt) values('17', '2017-02-04');
insert into menstrual(id, dt) values('18', '2017-02-22');
insert into menstrual(id, dt) values('19', '2017-03-26');
insert into menstrual(id, dt) values('20', '2017-04-30');
insert into menstrual(id, dt) values('21', '2017-06-01');
insert into menstrual(id, dt) values('22', '2017-07-02');
insert into menstrual(id, dt) values('23', '2017-08-15');
insert into menstrual(id, dt) values('24', '2017-09-14');
insert into menstrual(id, dt) values('25', '2017-10-16');
insert into menstrual(id, dt) values('26', '2017-11-17');
insert into menstrual(id, dt) values('28', '2018-01-24');
insert into menstrual(id, dt) values('29', '2018-03-01');
insert into menstrual(id, dt) values('30', '2018-04-05');
insert into menstrual(id, dt) values('27', '2017-12-24');
insert into menstrual(id, dt) values('31', '2018-05-13');
insert into menstrual(id, dt) values('32', '2018-06-18');
insert into menstrual(id, dt) values('33', '2018-07-21');
insert into menstrual(id, dt) values('34', '2018-08-24');
insert into menstrual(id, dt) values('35', '2018-09-24');
insert into menstrual(id, dt) values('36', '2018-11-05');
insert into menstrual(id, dt) values('37', '2018-12-09');
insert into menstrual(id, dt) values('38', '2019-01-14');
insert into menstrual(id, dt) values('39', '2019-02-11');
insert into menstrual(id, dt) values('40', '2019-03-16');
insert into menstrual(id, dt) values('41', '2019-04-14');
insert into menstrual(id, dt) values('42', '2019-05-22');
insert into menstrual(id, dt) values('43', '2019-06-30');
insert into menstrual(id, dt) values('44', '2019-08-05');
insert into menstrual(id, dt) values('45', '2019-09-05');

# todo 补全menstrual表的各列
update menstrual
set create_at = to_timestamp(to_char(dt, 'yyyy-MM-dd') || ' 00:00:00', 'YYYY-MM-DD HH24:MI:SS'),
    create_by = 1,
    is_delete = 0,
    update_at = now(),
    update_by = 1;