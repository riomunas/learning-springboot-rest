CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE app_user (
  sid UUID NOT NULL,
   name VARCHAR(255) NOT NULL,
   password VARCHAR(255),
   CONSTRAINT pk_app_user PRIMARY KEY (sid)
);

CREATE TABLE project (
  sid UUID NOT NULL,
   name VARCHAR(255) NOT NULL,
   start_date date,
   manager_sid UUID NOT NULL,
   CONSTRAINT pk_project PRIMARY KEY (sid)
);

CREATE TABLE task (
  sid UUID NOT NULL,
   name VARCHAR(255) NOT NULL,
   start_date TIMESTAMP,
   end_date TIMESTAMP,
   assignee_sid UUID,
   project_sid UUID,
   CONSTRAINT pk_task PRIMARY KEY (sid)
);

ALTER TABLE project ADD CONSTRAINT FK_PROJECT_ON_MANAGER_SID FOREIGN KEY (manager_sid) REFERENCES app_user (sid);

ALTER TABLE task ADD CONSTRAINT FK_TASK_ON_ASSIGNEE_SID FOREIGN KEY (assignee_sid) REFERENCES app_user (sid);

ALTER TABLE task ADD CONSTRAINT FK_TASK_ON_PROJECT_SID FOREIGN KEY (project_sid) REFERENCES project (sid);