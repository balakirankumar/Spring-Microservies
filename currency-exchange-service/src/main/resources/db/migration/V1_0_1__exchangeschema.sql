SET search_path TO exchange;


insert into currency_exchange (id,currency_from,currency_to,conversion_multiple,environment,created_by) select '89b82e35-f6c3-48ff-a905-0c2a3ca48deb','EUR','INR',75,'','00000000-0000-0000-0000-000000000000'
where not exists (
  select 1 from currency_exchange where id = '89b82e35-f6c3-48ff-a905-0c2a3ca48deb'
);
insert into currency_exchange (id,currency_from,currency_to,conversion_multiple,environment,created_by) select '4bd8f699-b078-4573-8b9e-d4a5313d4e4d','USD','INR',79,'','00000000-0000-0000-0000-000000000000'
where not exists (
  select 1 from currency_exchange where id = '4bd8f699-b078-4573-8b9e-d4a5313d4e4d'
);
insert into currency_exchange (id,currency_from,currency_to,conversion_multiple,environment,created_by) select 'b4373ef7-3445-4b61-8458-4dc81c61ac74','AUD','INR',25,'','00000000-0000-0000-0000-000000000000'
where not exists (
  select 1 from currency_exchange where id = 'b4373ef7-3445-4b61-8458-4dc81c61ac74'
);