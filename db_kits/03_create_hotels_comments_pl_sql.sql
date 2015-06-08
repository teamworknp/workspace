SET serveroutput on;

DECLARE
   v_count           NUMBER (1)    := 0;
   v_table_name      VARCHAR2 (50);
   v_schema_name     VARCHAR2 (50);
   v_synonym_name    VARCHAR2 (50);
BEGIN
   v_schema_name := 'BiddingProject';
   v_table_name := 'HOTELS_COMMENTS';
   v_synonym_name := '';
   
   SELECT COUNT (*)
     INTO v_count
     FROM all_tables
    WHERE owner = 'BiddingProject' AND table_name = v_table_name;

   IF v_count > 0
   THEN
      DBMS_OUTPUT.put_line ('TABLE ' || v_table_name || ' exists!');
   ELSE
      DBMS_OUTPUT.put_line ('Creating TABLE ' || v_table_name || '...');

      
      EXECUTE IMMEDIATE 'create table '
                        || v_schema_name
                        || '.'
                        || v_table_name
                        || '('
                        || 'id  NUMBER(3), '
                        || 'hotels VARCHAR2(50)'
                        || ') ';

      DBMS_OUTPUT.put_line ('TABLE ' || v_table_name || ' has been created!');
   END IF;

   v_synonym_name := 'HOTELS_COMMENTS';

   -- Check for Public Synonym
   SELECT COUNT (*)
     INTO v_count
     FROM SYS.publicsyn
    WHERE sname = v_synonym_name;

   IF v_count > 0
   THEN
      DBMS_OUTPUT.put_line ('PUBLIC SYNONYM:' || v_synonym_name || ', exists!');
   ELSE
      EXECUTE IMMEDIATE    'CREATE OR REPLACE PUBLIC SYNONYM '
                        || v_synonym_name
                        || ' FOR BiddingProject.'
                        || v_table_name;
   END IF;

  
   -- Check for Public Synonym
   SELECT COUNT (*)
     INTO v_count
     FROM SYS.publicsyn
    WHERE sname = v_synonym_name;

   IF v_count > 0
   THEN
      DBMS_OUTPUT.put_line ('PUBLIC SYNONYM:' || v_synonym_name || ', exists!');
   ELSE
      EXECUTE IMMEDIATE    'CREATE OR REPLACE PUBLIC SYNONYM '
                        || v_synonym_name
                        || ' FOR BiddingProject.'
                        || v_table_name;
   END IF;

   -- Doesn't hurt to redo the grants
   EXECUTE IMMEDIATE    'GRANT select, insert, update, delete on '
                     || v_table_name
                     || ' to BiddingProject';

   
END;
/
