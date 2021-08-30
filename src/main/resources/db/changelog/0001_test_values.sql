CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT
INTO node(id, title, text, priority, disable_drag, outputs, coordinate_x, coordinate_y)
VALUES (uuid_generate_v4(), 'HTML', 'START_MOCK_TEXT', 'MUST_KNOW', TRUE,
        '[{ id: ''port-1'', alignment: ''bottom'' }]', 520, 100),
       (uuid_generate_v4(), 'Start', 'START_MOCK_TEXT', 'POSSIBILITY', TRUE,
        '[{ id: ''port-1'', alignment: ''bottom'' }]', 520, 12),
       (uuid_generate_v4(), 'CSS', 'START_MOCK_TEXT', 'GOOD_TO_KNOW', TRUE,
        '[{ id: ''port-1'', alignment: ''bottom'' }]', 520, 180);

INSERT INTO program(id, title, link, index, node_id)
VALUES (uuid_generate_v4(), 'Learn the basics of HTML', 'https://www.w3schools.com/html/', 0,
        (SELECT id FROM node WHERE node.title = 'HTML')),
       (uuid_generate_v4(), 'Semantic HTML', 'https://www.geeksforgeeks.org/top-10-new-features-of-html5/', 1,
        (SELECT id FROM node WHERE node.title = 'HTML')),
       (uuid_generate_v4(), 'Dividing page into sections and structuring the DOM properly',
        'https://www.geeksforgeeks.org/top-10-new-features-of-html5', 2,
        (SELECT id FROM node WHERE node.title = 'HTML')),
       (uuid_generate_v4(), 'Complete the designs from description and send it for check. (Desktop)',
        'https://codesandbox.io/s/serene-cori-yc7f1?file=/index.html', 3,
        (SELECT id FROM node WHERE node.title = 'HTML')),
       (uuid_generate_v4(), 'Complete the designs from description and send it for check. (Mobile)',
        'https://codesandbox.io/s/serene-cori-yc7f1?file=/index.html', 4,
        (SELECT id FROM node WHERE node.title = 'HTML'));

INSERT INTO plan (id, title)
VALUES (uuid_generate_v4(), 'JavaScript');

INSERT INTO plan_node (plan_id, node_id)
VALUES ((SELECT id FROM plan WHERE title = 'JavaScript'), (SELECT id FROM node WHERE node.title = 'Start')),
       ((SELECT id FROM plan WHERE title = 'JavaScript'), (SELECT id FROM node WHERE node.title = 'HTML')),
       ((SELECT id FROM plan WHERE title = 'JavaScript'), (SELECT id FROM node WHERE node.title = 'CSS'));

INSERT INTO link (id, from_node, to_node, plan_id)
VALUES (uuid_generate_v4(), (SELECT id FROM node WHERE node.title = 'Start'),
        (SELECT id FROM node WHERE node.title = 'HTML'), (SELECT id FROM plan WHERE title = 'JavaScript')),
       (uuid_generate_v4(), (SELECT id FROM node WHERE node.title = 'HTML'),
        (SELECT id FROM node WHERE node.title = 'CSS'), (SELECT id FROM plan WHERE title = 'JavaScript'));
