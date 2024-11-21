INSERT INTO mantis_user_table (username, realname, email, password, enabled, protected, access_level, cookie_string)
VALUES
    ('john.doe', 'John Doe', ' reporter1@gmail.com', MD5('a2s1d3'), 1, 0, 25, UUID()),
    ('alex.pereira', 'Alex Pereira', ' reporter2@gmail.com', MD5('a2s1d3'), 1, 0, 25, UUID()),
    ('oliv.rodrigo', 'Olivia Rodrigo', ' reporter3@gmail.com', MD5('a2s1d3'), 1, 0, 25, UUID()),
    ('max.holloway', 'Max Holloway', ' dev1@gmail.com', MD5('a2s1d3'), 1, 0, 55, UUID()),
    ('lili.stemkovska', 'Lilia Stemkovska', ' dev2@gmail.com', MD5('a2s1d3'), 1, 0, 55, UUID()),
    ('yana.nov', 'Yana Novikova', ' dev3@gmail.com', MD5('a2s1d3'), 1, 0, 55, UUID());