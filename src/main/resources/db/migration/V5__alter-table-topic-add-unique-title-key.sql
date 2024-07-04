alter table topic
    add constraint topic_pk
        unique (title);