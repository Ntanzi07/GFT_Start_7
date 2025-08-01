CREATE TABLE employees_audit(
    id BIGINT not null auto_increment,
    name VARCHAR(150) not null,
    old_name VARCHAR(150) not null,
    salary DECIMAL(10,2) not null,
    old_salary DECIMAL(10,2) not null,
    birthday TIMESTAMP not null,
    old_birthday TIMESTAMP not null,
    operation CHAR(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
)engine=InnoDB default charset=utf8;