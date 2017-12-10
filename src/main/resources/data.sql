/**
 * CREATE Script for init of DB
 */

insert into configuration (id, name, conf_type, conf_value, is_active, application_name) 
values (1, 'SiteName', 'String', 'trendyol.com', true, 'SERVICE-A');

insert into configuration (id, name, conf_type, conf_value, is_active, application_name) 
values (2, 'IsBasketEnabled', 'Boolean', '1', true, 'SERVICE-B');

insert into configuration (id, name, conf_type, conf_value, is_active, application_name) 
values (3, 'MaxItemCount', 'Int', '50', false, 'SERVICE-A');


