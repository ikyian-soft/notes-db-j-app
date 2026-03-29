-- Drop user first if they exist
DROP USER if exists 'notesuser'@'%' ;

-- Now create user with prop privileges
CREATE USER 'notesuser'@'%' IDENTIFIED BY 'notes1pass';

GRANT ALL PRIVILEGES ON * . * TO 'notesuser'@'%';
