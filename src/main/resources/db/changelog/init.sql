CREATE TABLE node
(
    id           UUID PRIMARY KEY,
    title        VARCHAR(255) NOT NULL UNIQUE,
    text         TEXT         NULL,
    priority     VARCHAR(12)  NOT NULL,
    disable_drag BOOLEAN      NOT NULL,
    outputs      VARCHAR(255) NOT NULL,
    coordinate_x INT          NOT NULL,
    coordinate_y INT          NOT NULL
);

CREATE TABLE program
(
    id      UUID PRIMARY KEY,
    title   VARCHAR(255) NOT NULL UNIQUE,
    link    VARCHAR(255) NULL,
    index   INT          NOT NULL,
    node_id UUID         NOT NULL REFERENCES node (id)
);

CREATE TABLE plan
(
    id    UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE link
(
    id        UUID PRIMARY KEY,
    from_node UUID NOT NULL REFERENCES node (id) ON DELETE CASCADE,
    to_node   UUID NOT NULL REFERENCES node (id) ON DELETE CASCADE,
    plan_id   UUID NOT NULL REFERENCES plan (id) ON DELETE CASCADE
);

CREATE TABLE users
(
    id    UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE plan_node
(
    plan_id UUID NOT NULL REFERENCES plan (id),
    node_id UUID NOT NULL REFERENCES node (id),
    PRIMARY KEY (plan_id, node_id)
);

CREATE TABLE user_program
(
    user_id    UUID NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    program_id UUID NOT NULL REFERENCES program (id) ON DELETE CASCADE,
    count      INT  NOT NULL,
    finished   DATE NULL,
    PRIMARY KEY (user_id, program_id)
);