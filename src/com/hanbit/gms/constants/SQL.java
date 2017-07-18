package com.hanbit.gms.constants;

public class SQL {
public static final String MEMBER_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES(?,?,?,?,SYSDATE)",DB.TABLE_MEMBER, DB.MEMBER_ID, DB.MEMBER_NAME, DB.MEMBER_PASS, DB.MEMBER_SSN,DB.MEMBER_REGDATE);
public static final String MEMBER_LIST=String.format("SELECT * FROM %s", DB.TABLE_MEMBER);
public static final String MEMBER_FINDBYNAME =String.format( "SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_NAME);
public static final String MEMBER_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_MEMBER,DB.MEMBER_ID);
public static final String MEMBER_COUNT=String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_MEMBER);
public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_PASS,DB.MEMBER_ID);
public static final String MEMBER_DELETE=String.format("DELETE FROM %s WHERE %s =?", DB.TABLE_MEMBER,DB.MEMBER_ID);

public static final String ARTICLE_INSERT=String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(article_seq.nextval,?,?,?,0,SYSDATE)",DB.TABLE_BOARD,DB.ARTICLE_SEQ,DB.ARTICLE_ID,DB.ARTICLE_TITLE,DB.ARTICLE_CONTENT,DB.HIT_COUNT,DB.ARTICLE_REGDATE);
public static final String ARTICLE_SELECTALL=String.format("SELECT * FROM %s", DB.TABLE_BOARD);
public static final String ARTICLE_FINDBYID=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD,DB.ARTICLE_ID);
public static final String ARTICLE_COUNT=String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_BOARD);
public static final String ARTICLE_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_CONTENT,DB.ARTICLE_SEQ);
public static final String ARTICLE_DELETE=String.format("DELETE FROM %s WHERE %s =?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
public static final String ARTICLE_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD,DB.ARTICLE_SEQ);
}

