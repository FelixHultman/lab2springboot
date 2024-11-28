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


INSERT INTO place (name, description, category_id, is_private, coordinates, user_id)
VALUES ('Central Park', 'A large public park in the city center.', 1, FALSE, POINT(40.785091, -73.968285), 101),
       ('Library Hall', 'A quiet place for study and research.', 2, FALSE, POINT(40.712776, -74.005974), 102),
       ('Sunset Cafe', 'A small, cozy cafe with great coffee.', 3, FALSE, POINT(34.052235, -118.243683), 103),
       ('Greenfield Estate', 'A private property with beautiful gardens.', 1, TRUE, POINT(51.509865, -0.118092), 104),
       ('Ocean View', 'A scenic spot overlooking the ocean.', 4, FALSE, POINT(37.774929, -122.419416), 105),
       ('Art Museum', 'A modern art museum with a rich collection.', 5, FALSE, POINT(48.856613, 2.352222), 106),
       ('Hidden Gem', 'A secret location known only to locals.', 1, TRUE, POINT(59.329323, 18.068581), 107);


