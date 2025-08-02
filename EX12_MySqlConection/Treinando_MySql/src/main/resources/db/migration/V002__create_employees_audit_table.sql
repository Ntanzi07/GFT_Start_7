CREATE TABLE employees_audit(
    id BIGINT not null auto_increment,
    name VARCHAR(150) not null,
    old_name VARCHAR(150),
    salary DECIMAL(10,2) not null,
    old_salary DECIMAL(10,2),
    birthday TIMESTAMP not null,
    old_birthday TIMESTAMP,
    operation CHAR(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
)engine=InnoDB default charset=utf8;