-- public.product_category definition

-- Drop table

-- DROP TABLE public.product_category;

CREATE TABLE public.product_category (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	deleted_at timestamp NOT NULL,
	description varchar(128) NOT NULL,
	"name" varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT product_category_pkey PRIMARY KEY (id)
);


-- public.roles definition

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	deleted_at timestamp NOT NULL,
	"name" varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);


-- public.suppliers definition

-- Drop table

-- DROP TABLE public.suppliers;

CREATE TABLE public.suppliers (
	id uuid NOT NULL,
	address varchar(128) NOT NULL,
	created_at timestamp NOT NULL,
	first_name varchar(128) NOT NULL,
	last_name varchar(128) NOT NULL,
	mobile varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT suppliers_pkey PRIMARY KEY (id)
);


-- public.user_role definition

-- Drop table

-- DROP TABLE public.user_role;

CREATE TABLE public.user_role (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	role_name varchar(255) NOT NULL,
	updated_at timestamp NOT NULL,
	CONSTRAINT user_role_pkey PRIMARY KEY (id)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	first_name varchar(128) NOT NULL,
	last_name varchar(128) NOT NULL,
	mobile varchar(128) NOT NULL,
	"password" varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	user_name varchar(128) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


-- public.order_details definition

-- Drop table

-- DROP TABLE public.order_details;

CREATE TABLE public.order_details (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	deleted_at timestamp NOT NULL,
	details varchar(128) NOT NULL,
	status varchar(128) NOT NULL,
	total float8 NOT NULL,
	updated_at timestamp NOT NULL,
	user_id uuid NULL,
	CONSTRAINT order_details_pkey PRIMARY KEY (id),
	CONSTRAINT fkk2w14ysy80rutm079xu6d4ygm FOREIGN KEY (user_id) REFERENCES public.users(id)
);


-- public.purchases definition

-- Drop table

-- DROP TABLE public.purchases;

CREATE TABLE public.purchases (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	quantity int4 NOT NULL,
	total float8 NOT NULL,
	unit_price float8 NOT NULL,
	updated_at timestamp NOT NULL,
	supplier_id uuid NULL,
	user_id uuid NULL,
	CONSTRAINT purchases_pkey PRIMARY KEY (id),
	CONSTRAINT fk9ho3w23v5du4x0hrp6rqs1wmh FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id),
	CONSTRAINT fkm0ndjymn9p747pfp4515pio8i FOREIGN KEY (user_id) REFERENCES public.users(id)
);


-- public.stocks definition

-- Drop table

-- DROP TABLE public.stocks;

CREATE TABLE public.stocks (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	deleted_at timestamp NOT NULL,
	quantity float8 NOT NULL,
	updated_at timestamp NOT NULL,
	purchase_id uuid NULL,
	CONSTRAINT stocks_pkey PRIMARY KEY (id),
	CONSTRAINT fka7pvyqp8uf4k462yfkgw0avt5 FOREIGN KEY (purchase_id) REFERENCES public.purchases(id)
);


-- public.user_role_mapping definition

-- Drop table

-- DROP TABLE public.user_role_mapping;

CREATE TABLE public.user_role_mapping (
	id uuid NOT NULL,
	role_id uuid NULL,
	user_id uuid NULL,
	CONSTRAINT user_role_mapping_pkey PRIMARY KEY (id),
	CONSTRAINT fk3y767mrjaru6vl6ctdaaw7os9 FOREIGN KEY (user_id) REFERENCES public.users(id),
	CONSTRAINT fkkef7naqyarqhho7ykj9g3rcu8 FOREIGN KEY (role_id) REFERENCES public.roles(id)
);


-- public.order_items definition

-- Drop table

-- DROP TABLE public.order_items;

CREATE TABLE public.order_items (
	id uuid NOT NULL,
	created_at timestamp NOT NULL,
	quantity float8 NOT NULL,
	updated_at timestamp NOT NULL,
	order_details_id uuid NULL,
	stock_id uuid NULL,
	CONSTRAINT order_items_pkey PRIMARY KEY (id),
	CONSTRAINT fkbhmexinsmhota253wid908dh5 FOREIGN KEY (order_details_id) REFERENCES public.order_details(id),
	CONSTRAINT fkcmdn0m9k191pwprk6xta7pi0q FOREIGN KEY (stock_id) REFERENCES public.stocks(id)
);


-- public.payment_details definition

-- Drop table

-- DROP TABLE public.payment_details;

CREATE TABLE public.payment_details (
	id uuid NOT NULL,
	amount float8 NOT NULL,
	created_at timestamp NOT NULL,
	provider varchar(128) NOT NULL,
	status varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	order_details_id uuid NULL,
	stock_id uuid NULL,
	CONSTRAINT payment_details_pkey PRIMARY KEY (id),
	CONSTRAINT fkc6u2ewc1g57tow46dmjjf9fit FOREIGN KEY (stock_id) REFERENCES public.stocks(id),
	CONSTRAINT fkotxadyxr4kjhahkvb32bhmigb FOREIGN KEY (order_details_id) REFERENCES public.order_details(id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id uuid NOT NULL,
	code varchar(128) NOT NULL,
	created_at timestamp NOT NULL,
	deleted_at timestamp NOT NULL,
	description varchar(128) NOT NULL,
	"name" varchar(128) NOT NULL,
	price float8 NOT NULL,
	"size" varchar(128) NOT NULL,
	sku varchar(128) NOT NULL,
	updated_at timestamp NOT NULL,
	product_category_id uuid NULL,
	purchase_id uuid NULL,
	CONSTRAINT products_pkey PRIMARY KEY (id),
	CONSTRAINT fkb74tk5jq8jwurq34dks9agydq FOREIGN KEY (product_category_id) REFERENCES public.product_category(id),
	CONSTRAINT fkruth84jv3p5joyk1nvsi8wuyh FOREIGN KEY (purchase_id) REFERENCES public.purchases(id)
);