serveroutput on
BEGIN

CREATE SCHEMA BiddingProject
CHARACTER SET latin1
COLLATE latin1_bin;


CREATE TABLE PAGE_TABLE
( PAGE_ID numeric(10) not null,
  PAGE_NAME varchar2(50) not null,
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

insert into PAGE_HOTELS (HOTEL_ID)
select 
    (select PAGE_ID from PAGE_TABLE where PAGE_NAME = ?),
    HOTEL_ID
from (values 
      ('1')
) PAGE_HOTELS_DATA (HOTEL_ID)
	

CREATE TABLE HOTELS_COMMENTS
( HOTEL_ID numeric(10) not null,
  COMMENTS_COUNT numeric(10) not null,
  );
  
INSERT INTO HOTELS_COMMENTS
VALUES
  (100, 10),
  (101, 20),
  (102, 30),
  (103, 40);
 END;
 commit;
 /