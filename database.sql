create table if not exists blog(
	id int(10) not null auto_increment,
	blogCategory varchar(255) not null,
	headLine varchar(500) not null,
	content text not null,
	publishedOn timestamp not null,
	author varchar(500) not null,
	primary key (id)
);

insert into blog(blogCategory, headLine, content, publishedOn, author) values(
	'Entertainment',
	'New Year Celebration Going on',
	'Today also New Year Celebration Going on! Many people participated. The atmosphere is energitic. Happy New Year!',
	'2020-01-01',
	'tusar'
);

insert into blog(blogCategory, headLine, content, publishedOn, author) values(
	'Politics',
	'New Cheif of Defence',
	'New Cheif of Defence appointed. Warm regards are shown through out the day by netizens.',
	'2020-01-02',
	'tusar'
);