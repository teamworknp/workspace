CREATE SCHEMA BiddingProject
CHARACTER SET latin1
COLLATE latin1_bin;


CREATE TABLE PAGE_TABLE
( PAGE_ID numeric(10) not null,
  PAGE_NAME varchar(50) not null,
  CONSTRAINT PAGE_ID_pk PRIMARY KEY (PAGE_ID )
);

commit;

CREATE TABLE PAGE_HOTELS
( PAGE_ID numeric(10) not null,
  HOTEL_ID numeric(10) not null,
  CONSTRAINT fk_PAGE_ID
    FOREIGN KEY (PAGE_ID)
    REFERENCES PAGE_TABLE(PAGE_ID) );
	
commit;
	

CREATE TABLE HOTELS_COMMENTS
( HOTEL_ID numeric(10) not null,
  COMMENTS_COUNT numeric(10) not null
  );
  
INSERT INTO HOTELS_COMMENTS
VALUES
  (1, 10),
  (2, 20),
  (3, 30),
  (4, 40);


insert into PAGE_HOTELS (HOTEL_ID)
select 
   (select PAGE_ID from PAGE_TABLE where PAGE_NAME = ?),
   HOTEL_ID
from (values 
     ('1')
) PAGE_HOTELS_DATA (HOTEL_ID)