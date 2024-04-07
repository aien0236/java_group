USE `FWRP` ;

INSERT INTO `FWRP`.`user` (`user_name`, `email`, `password`, `usertype`) VALUES
('retailer', 'admin@foodsaver.com', '1234', 'Retailer'),
('consumer', 'admin@foodsaver.com', '1234', 'Consumer'),
('charity', 'admin@foodsaver.com', '1234', 'Organization');


INSERT INTO `FWRP`.`retailer_inventory` (`food_name`, `expiration_date`, `donated`, `claimed`, `claimed_by`, `price`, `discount`, `foodtype`, `quantity`, `retailer_id`) VALUES
('Apple', '2024-10-31 00:00:00', TRUE, FALSE, NULL, 2.50, 0, 'Fruits & Vegetables', 10, 1),
('Banana', '2024-11-30 00:00:00', TRUE, FALSE, NULL, 1.99, 0, 'Fruits & Vegetables', 15, 1),
('Milk', '2024-12-31 00:00:00', TRUE, FALSE, NULL, 3.50, 0, 'Dairy & Eggs', 20, 1),
('Egg', '2024-09-30 00:00:00', TRUE, FALSE, NULL, 2.00, 0, 'Dairy & Eggs', 12, 1),
('Salmon', '2024-10-15 00:00:00', TRUE, FALSE, NULL, 9.99, 0, 'Meat & Seafood', 18, 1),
('Beef', '2024-11-20 00:00:00', TRUE, FALSE, NULL, 12.25, 0, 'Meat & Seafood', 25, 1),
('Rice', '2024-12-25 00:00:00', TRUE, FALSE, NULL, 5.50, 0, 'Grains & Starches', 30, 1),
('Pasta', '2024-09-05 00:00:00', TRUE, FALSE, NULL, 4.99, 0, 'Grains & Starches', 22, 1),
('Cake', '2024-10-10 00:00:00', TRUE, FALSE, NULL, 6.75, 0, 'Desserts', 28, 1),
('Ice Cream', '2024-11-15 00:00:00', TRUE, FALSE, NULL, 4.50, 0, 'Desserts', 35, 1),
('Bread', '2024-12-20 00:00:00', TRUE, FALSE, NULL, 3.99, 0, 'Other', 45, 1),
('Cookies', '2024-09-25 00:00:00', TRUE, FALSE, NULL, 2.75, 0, 'Other', 50, 1);

INSERT INTO `FWRP`.`retailer_inventory` (`food_name`, `expiration_date`, `donated`, `claimed`, `claimed_by`, `price`, `discount`, `foodtype`, `quantity`, `retailer_id`) VALUES
('Orange', '2024-11-10 00:00:00', FALSE, FALSE, NULL, 1.75, 0, 'Fruits & Vegetables', 8, 1),
('Grapes', '2024-10-20 00:00:00', FALSE, FALSE, NULL, 3.25, 0, 'Fruits & Vegetables', 12, 1),
('Cheese', '2024-12-05 00:00:00', FALSE, FALSE, NULL, 4.99, 0, 'Dairy & Eggs', 15, 1),
('Yogurt', '2024-09-15 00:00:00', FALSE, FALSE, NULL, 2.50, 0, 'Dairy & Eggs', 18, 1),
('Shrimp', '2024-11-25 00:00:00', FALSE, FALSE, NULL, 8.99, 0, 'Meat & Seafood', 20, 1),
('Chicken', '2024-10-05 00:00:00', FALSE, FALSE, NULL, 6.75, 0, 'Meat & Seafood', 22, 1),
('Potato', '2024-12-15 00:00:00', FALSE, FALSE, NULL, 2.25, 0, 'Grains & Starches', 25, 1),
('Quinoa', '2024-09-30 00:00:00', FALSE, FALSE, NULL, 7.50, 0, 'Grains & Starches', 30, 1),
('Brownie', '2024-11-05 00:00:00', FALSE, FALSE, NULL, 5.25, 0, 'Desserts', 32, 1),
('Pie', '2024-12-10 00:00:00', FALSE, FALSE, NULL, 6.99, 0, 'Desserts', 38, 1);
