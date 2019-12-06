INSERT INTO category (name) VALUES ('A'), ('B'), ('C'), ('D'), ('E'), ('F');

INSERT INTO rate (name, rateamount) VALUES ('T1', 0.65), 
                                                  ('T2', 0.34), 
                                                  ('T3', 0.45), 
                                                  ('T4', 0.21),
                                                  ('T5', 0.44), 
                                                  ('T6', 0.74);

INSERT INTO decisiontable ( minamount,
                        maxamount,
                        minduration,
                        maxduration,
                        categ_id,
                        rate_id ) 
                        VALUES 
                        (5000, 9999, 1, 30, 1, 1),
                        (5000, 9999, 31, 48, 1, 2),
                        (10000, 14999, 1, 24, 1, 2),
                        (10000, 14999, 25, 48, 1, 3),
                        (5000, 14999, 1, 18, 2, 3),
                        (5000, 14999, 19, 36, 2, 4),
                        (5000, 14999, 37, 48, 2, 5),
                        (15000, 25000, 1, 24, 2, 5),
                        (15000, 25000, 25, 48, 2, 6),
                        (25001, 50000, 25, 48, 2, 6);