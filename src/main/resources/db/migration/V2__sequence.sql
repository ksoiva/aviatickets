CREATE SEQUENCE hibernate_sequence START 100;
ALTER TABLE "user" ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence');
ALTER TABLE "flight" ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence');
ALTER TABLE "ticket" ALTER COLUMN id SET DEFAULT nextval('hibernate_sequence');
