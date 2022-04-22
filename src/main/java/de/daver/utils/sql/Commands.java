package de.daver.utils.sql;

public enum Commands {

    INSERT_INTO("INSERT INTO"),
    DELETE_FROM("DELETE FROM"),
    UPDATE("UPDATE"),
    CREATE_TABLE("CREATE TABLE"),
    DROP_TABLE("DROP TABLE"),
    SELECT_ALL_FROM("SELECT * FROM"),
    SELECT("SELECT");

    private final String command;

    Commands(String value){
        this.command = value;
    }

    public String toString(){
        return this.command;
    }
}
