ALTER TABLE node
    ADD COLUMN index INT NOT NULL DEFAULT 0;

UPDATE node
SET index = 1
WHERE node.title = 'Start';

UPDATE node
SET index = 2
WHERE node.title = 'HTML';

UPDATE node
SET index = 3
WHERE node.title = 'CSS';