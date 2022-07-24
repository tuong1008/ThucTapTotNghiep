INSERT INTO public.authorities(authoritytype, username)
	VALUES ('ROLE_ADMIN', 'admin');
INSERT INTO public.customer(
	customeremailaddress, customername, customerphonenumber, enabled, password, username)
	VALUES ('admin@admin.com', 'admin', '0000000000', true, '123', 'admin');
