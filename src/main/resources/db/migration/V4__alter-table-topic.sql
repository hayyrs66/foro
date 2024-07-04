alter table topic
    change author_id id_author bigint not null;

alter table topic change course_id id_course bigint not null;