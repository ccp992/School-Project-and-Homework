insert into survey (survey_title)
values ('Hello World');

insert into survey_question (question, SID, question_type)
values('How old are you?','1','radio'),
		('What kind of fruit do you like:','1','checkbox'),
        ('How are you feeling?','1','text');
		
insert into survey_answer (answer,QID)
values ('10 < age <= 20','1'),
		('20 < age <= 30','1'),
        ('30 < age <= 40','1'),
        ('age > 40','1');
		
insert into survey_answer (answer, QID)
values ('orange','2'),
		('apple','2'),
        ('water','2'),
        ('watermelon','2'),
        ('banana','2');
		
	
insert into patient_survey
values (uuid(),'1');

insert into patient_survey
values (uuid(),'1');