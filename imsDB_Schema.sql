-- DROP SCHEMA ims;

CREATE SCHEMA ims AUTHORIZATION postgres;


CREATE TABLE ims.product (
	id serial NOT NULL,
	title varchar(40) NOT NULL,
	category varchar(20) NULL,
	manufacturer varchar(40) NOT NULL,
	minumum_limit int NULL,
	boh int NOT NULL DEFAULT 0,
	CONSTRAINT product_pk PRIMARY KEY (id),
	CONSTRAINT product_un UNIQUE (title)
);

-- Column comments

COMMENT ON COLUMN ims.product.title IS 'Name of Product';
COMMENT ON COLUMN ims.product.category IS 'Category the product falls into';
COMMENT ON COLUMN ims.product.manufacturer IS 'Who produces this product';
COMMENT ON COLUMN ims.product.minumum_limit IS 'Minimum BOH before reorder';
COMMENT ON COLUMN ims.product.boh IS 'Running total BOH, balance on hand, needs extra line in product_stock controller to update';

CREATE TABLE ims.product_stock (
	id serial NOT NULL,
	product_id int NOT NULL,
	transaction_date date NOT NULL,
	vendor varchar(40) NOT NULL,
	batch_code varchar(10) NULL,
	invoice_number varchar(10) NULL,
	quantity int NOT NULL,
	transaction_type varchar(3) NOT NULL,
	CONSTRAINT product_stock_fk FOREIGN KEY (product_id) REFERENCES ims.product(id)
);
CREATE INDEX product_stock_product_id_idx ON ims.product_stock (product_id,id);

-- Column comments

COMMENT ON COLUMN ims.product_stock.transaction_date IS 'Date of transaction, coallates with transaction_type';
COMMENT ON COLUMN ims.product_stock.vendor IS 'Who provided the product';
COMMENT ON COLUMN ims.product_stock.batch_code IS 'Batch Code for update';
COMMENT ON COLUMN ims.product_stock.invoice_number IS 'Invoice for the transaction';
COMMENT ON COLUMN ims.product_stock.transaction_type IS 'IN or OUT, denotes addition or subtraction from running total, respectively';

CREATE TABLE ims."user" (
	uid serial NOT NULL,
	username varchar NOT NULL,
	"password" varchar NOT NULL,
	permision_level varchar NOT NULL DEFAULT 'employee',
	CONSTRAINT user_pk PRIMARY KEY (uid)
);

-- Column comments

COMMENT ON COLUMN ims."user".uid IS 'default user ID, serial';
COMMENT ON COLUMN ims."user".username IS 'username for user';
COMMENT ON COLUMN ims."user"."password" IS 'password for user';
COMMENT ON COLUMN ims."user".permision_level IS 'Permission level in system, default employee, others are manager, admin, super';
