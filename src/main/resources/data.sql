-- Insert sample books
INSERT INTO books (title, author, publication_year, isbn) VALUES
('Book 1', 'Author 1', 2020, 'ISBN1234567890'),
('Book 2', 'Author 2', 2019, 'ISBN0987654321'),
('Book 3', 'Author 3', 2018, 'ISBN5432167890');

-- Insert sample patrons
INSERT INTO patrons (name, contact_information) VALUES
('Patron 1', 'patron1@example.com'),
('Patron 2', 'patron2@example.com'),
('Patron 3', 'patron3@example.com');

-- Insert sample borrowing records
-- For simplicity, assuming patrons borrow books immediately after they are added
INSERT INTO borrowing_records (book_id, patron_id, borrow_date) VALUES
(1, 1, '2022-01-01'),
(2, 2, '2022-01-02'),
(3, 3, '2022-01-03');
