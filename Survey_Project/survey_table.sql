CREATE TABLE survey
(SID INTEGER PRIMARY KEY AUTO_INCREMENT,
SURVEY_TITLE VARCHAR(100));


create table survey_question
(QID integer primary key auto_increment,
question varchar(200) not null,
SID integer not null,
question_type varchar(20) not null,
foreign key (SID) references survey (SID));




create table survey_answer
(AID integer primary key auto_increment,
answer varchar(200) not null,
QID integer not null,
foreign key(QID) references survey_question(QID));


create table patient_survey
(UUID varchar(36) not null primary key,
SID integer not null,
foreign key (SID) references survey(SID));


create table survey_result
(uuid varchar(36) not null,
SID integer not null,
QID integer not null,
feedback varchar(2000),
foreign key(uuid) references patient_survey(uuid),
foreign key(SID) references survey(SID),
foreign key(QID) references survey_question(QID));