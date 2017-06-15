INSERT INTO public.prepaid_meter_user_role(	prepaid_meter_user_role_id, role_description, role_name) VALUES (1, 'Consumer', 'CONSUMER');
INSERT INTO public.prepaid_meter_user_role(	prepaid_meter_user_role_id, role_description, role_name) VALUES (2, 'Admin', 'ADMIN');
    
INSERT INTO public.prepaid_meter_user(prepaid_meter_user_id, email, mobile_number, prepaid_meter_user_role_id) 	VALUES (1, 'rajamohan', '7893220062', 1);

INSERT INTO public.prepaid_meter_service(prepaid_meter_service_id, consumer_name, date_of_deletion, date_of_installation, electricity_revenue_officer, 
    gps_latitude, gps_longitude, location, prepaid_meter_serial_number,
    service_number, unique_service_number)
	VALUES (1, 'Green Ark Enersol Pvt Ltd', NULL, now(), 'HYDERABAD', '17.4195828', '78.3307105', 'HYDERABAD',1061293824, 1061293824,
    1061293824);
	

INSERT INTO public.prepaid_meter_user_service(
	prepaid_meter_user_service_id, is_default, prepaid_meter_service_id, prepaid_meter_user_id)
	VALUES (1, true, 1, 1);
	

INSERT INTO public.prepaid_meter_service_account(
	prepaid_meter_service_account_id, balance_amount, is_low_balace,prepaid_meter_serial_number, prepaid_meter_service_id)
	VALUES (1, '200',false,'1061293824', 1);
	



	
drop view prepaid_meter_user_view;

CREATE OR REPLACE VIEW prepaid_meter_user_view AS
 SELECT pmu.prepaid_meter_user_id  AS id,
 pms.prepaid_meter_service_id AS prepaid_meter_service_id,
    pms.consumer_name AS consumer_name,
    pms.prepaid_meter_serial_number AS prepaid_meter_serial_number,
    pmu.email AS email,
    pmu.mobile_number as mobile_number,
	pmu.device_token_id AS device_token_id
    FROM prepaid_meter_service pms
     JOIN prepaid_meter_user_service pmus ON pmus.prepaid_meter_service_id = pms.prepaid_meter_service_id
	 JOIN prepaid_meter_user pmu ON pmus.prepaid_meter_user_id = pmu.prepaid_meter_user_id;
	 

INSERT INTO public.prepaid_meter_usage_data(
	prepaid_meter_usage_data_id, charge_end_date, charge_start_date, charged_amount, prepaid_meter_serial_number,
    present_reading, previous_reading, usage_quantity, prepaid_meter_service_id)
	VALUES (1, now(), now(), 100, 1061293824, 200, 150, 50, 1);
	

CREATE OR REPLACE VIEW prepaid_meter_balance_view AS
SELECT pmud.prepaid_meter_usage_data_id AS id,
    pms.prepaid_meter_service_id AS prepaid_meter_service_id,
    pms.consumer_name AS consumer_name,
    pms.prepaid_meter_serial_number AS prepaid_meter_serial_number,
	pms.service_number AS service_number,
    pms.unique_service_number AS unique_service_number,
    pmud.present_reading AS present_reading,
    pmud.previous_reading AS previous_reading,
    pmud.usage_quantity AS usage_quantity,
    pmud.charged_amount AS charged_amount,
    pmud.charge_start_date AS charge_start_date,
    pmud.charge_end_date AS charge_end_date,
    pmsa.balance_amount AS balance_amount,
	pmsa.last_recharged_amount AS last_recharged_amount,
    pmsa.is_low_balace AS is_low_balace,
	pmsa.is_negative_balance AS is_negative_balance	
    FROM prepaid_meter_service pms
     JOIN prepaid_meter_usage_data pmud ON pmud.prepaid_meter_service_id = pms.prepaid_meter_service_id
	 JOIN prepaid_meter_service_account pmsa ON pmsa.prepaid_meter_service_id =pms.prepaid_meter_service_id;
	 
CREATE OR REPLACE VIEW recharge_data_view AS
 SELECT rd.recharge_data_id  AS id,
    pms.prepaid_meter_service_id AS prepaid_meter_service_id,
    rd.loaded_amount AS loaded_amount,
    rd.transaction_id AS transaction_id,
    rd.instrument_type AS instrument_type,
    pms.prepaid_meter_serial_number AS prepaid_meter_serial_number ,
	rd.date_time as date_time,    
    FROM prepaid_meter_service pms
     JOIN recharge_data rd ON rd.prepaid_meter_serial_number = pms.prepaid_meter_serial_number;
	 

update prepaid_meter_usage_data set charged_amount=0, usage_quantity=0, previous_reading=0, present_reading=0;

update prepaid_meter_service_account set balance_amount=0, last_recharged_amount=0, is_low_balace=false, is_negative_balance=false;



truncate table recharge_data;

INSERT INTO public.modem_commands(
	modem_commands_id, name, value)
	VALUES (1, 'RELAY_OFF', 'adfd');
	
	
update sim_card set static_ip_address='100.88.154.176';


CREATE OR REPLACE VIEW prepaid_meter_service_filter_view AS 
	select  ps.prepaid_meter_service_id as id ,ps.prepaid_meter_serial_number,
	ps.service_number,ps.unique_service_number,ps.consumer_name,ps.electricity_revenue_officer,
	ps.date_of_deletion,ps.date_of_installation,ps.prepaid_meter_serial_number,ps.phase,
	pn.manufacturer_name,pn.prepaid_meter_type,pn.meter_year_of_manufacture,pn.potentials_transformers_ratio,
	pn.current_transformers_ratio,
	c.name as circle,
	d.name as division,
	s.name as section,
	l.address2 as location,
	c.circle_id,
	d.division_id,
	s.section_id,
	l.location_id 
	from prepaid_meter_service ps JOIN prepaid_meter_name_plate pn on  ps.prepaid_meter_serial_number = pn.prepaid_meter_serial_number
	 JOIN circle c on c.circle_id = ps.circle_id
	 JOIN division d on d.division_id = ps.division_id
	 JOIN section s on s.section_id = ps.section_id
	 JOIN location l on l.location_id = ps.location_id
