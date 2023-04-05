-- inventory.product_inventory_entries definition
CREATE TABLE product_inventory_entries (
	id varchar(15) NOT NULL,
	user_address_id varchar(15) NOT NULL,
	product_id varchar(15) NOT NULL,
	quantity numeric(4, 2) NOT NULL,
	price numeric(4, 2) NULL,
	created_at timestamp NOT NULL,
	created_by varchar(15) NOT NULL,
	updated_at timestamp NOT NULL,
	updated_by varchar(15) NOT NULL,
	CONSTRAINT seller_inventory_entries_pk PRIMARY KEY (id),
	CONSTRAINT inventory_product_fk FOREIGN KEY (product_id) REFERENCES product_catalog.products(id),
	CONSTRAINT inventory_user_addr_fk FOREIGN KEY (user_address_id) REFERENCES "user".user_address(id)
);

-- inventory.product_inventory_stock definition
CREATE TABLE product_inventory_stock (
	id varchar(15) NOT NULL,
	product_id varchar(15) NOT NULL,
	stock numeric(4, 2) NOT NULL,
	price numeric(4, 2) NULL,
	created_at timestamp NOT NULL,
	created_by varchar(15) NOT NULL,
	updated_at timestamp NOT NULL,
	updated_by varchar(15) NOT NULL,
	user_address_id varchar(15) NOT NULL,
	CONSTRAINT seller_inventory_pk PRIMARY KEY (id),
	CONSTRAINT inventory_product_fk FOREIGN KEY (product_id) REFERENCES product_catalog.products(id),
	CONSTRAINT inventory_user_addr_fk FOREIGN KEY (user_address_id) REFERENCES "user".user_address(id)
);