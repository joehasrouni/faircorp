INSERT INTO BUILDING(id, name) VALUES(-6, 'Building1');

INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-10, 'Livingroom', 1, 22.3, 20., -6);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-9, 'Bedroom', 1, 25, 20, -6);
INSERT INTO ROOM(id, name, floor, current_temperature, target_temperature, building_id) VALUES(-9, 'Kitchen', 1, 25, 20, -6);


INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-10, 'ON', 'Heater1', 2000, -10);
INSERT INTO HEATER(id, heater_status, name, power, room_id) VALUES(-9, 'ON', 'Heater2', null, -10);

INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-10, 'CLOSED', 'Main Window', -10);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-9, 'CLOSED', 'Small Window', -10);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-8, 'OPEN', 'Panoramic Window', -9);
INSERT INTO RWINDOW(id, window_status, name, room_id) VALUES(-7, 'CLOSED', 'Small Window', -9);

