CREATE TABLE IF NOT EXISTS auto_mobiles (
    id SERIAL PRIMARY KEY,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS property (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL
);


CREATE TABLE IF NOT EXISTS policy_main (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    start_year VARCHAR(10),
    end_year VARCHAR(10),
    premium DOUBLE PRECISION
);


CREATE TABLE IF NOT EXISTS policy_contents (
    content_id BIGSERIAL PRIMARY KEY,
    policy_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    item_type VARCHAR(100),
    cover_amount BIGINT,

    CONSTRAINT fk_policy FOREIGN KEY (policy_id) REFERENCES policy_main(id) ON DELETE CASCADE
);