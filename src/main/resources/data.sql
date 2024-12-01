SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE category;
TRUNCATE place;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO category (name, symbol, description)
VALUES ('Park', '🌳', 'Outdoor green spaces.'),
       ('Library', '📚', 'Places for study and learning.'),
       ('Cafe', '☕', 'Coffee shops and small eateries.'),
       ('Scenic Spot', '🌅', 'Locations with beautiful views.'),
       ('Museum', '🖼️', 'Places to explore art and history.');

-- Park category
INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Central Park', 'A large public park in the city center, popular for picnics and walks.', 1, FALSE, ST_GeomFromText('POINT(-73.968285 40.785091)', 4326), 101),
       ('Greenfield Park', 'A peaceful park with walking trails and lakes.', 1, FALSE, ST_GeomFromText('POINT(-74.003134 40.704342)', 4326), 102);

-- Library category
INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Library Hall', 'A quiet place for study and research with a large selection of books.', 2, FALSE, ST_GeomFromText('POINT(-74.006015 40.712746)', 4326), 103),
       ('City Library', 'A public library with modern facilities and a diverse collection.', 2, FALSE, ST_GeomFromText('POINT(-89.252225 34.052748)', 4326), 104);

-- Cafe category
INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Sunset Cafe', 'A cozy cafe offering great coffee and a relaxing atmosphere.', 3, FALSE, ST_GeomFromText('POINT(-15.243683 34.052235)', 4326), 105),
       ('The Beanery', 'A small coffee shop with excellent pastries and a welcoming vibe.', 3, FALSE, ST_GeomFromText('POINT(-82.419416 37.774929)', 4326), 106);

-- Scenic Spot category
INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Ocean View', 'A breathtaking spot overlooking the ocean with stunning sunsets.', 4, FALSE, ST_GeomFromText('POINT(-78.419416 37.774929)', 4326), 107),
       ('Mountain Peak', 'A secluded peak offering panoramic views of the valley.', 4, FALSE, ST_GeomFromText('POINT(7.263537 44.722244)', 4326), 108);

-- Museum category
INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Art Museum', 'A modern art museum with a rich collection of contemporary works.', 5, FALSE, ST_GeomFromText('POINT(2.352222 48.856613)', 4326), 109),
       ('History Museum', 'A museum dedicated to the history of ancient civilizations.', 5, FALSE, ST_GeomFromText('POINT(-0.118092 51.509865)', 4326), 110);