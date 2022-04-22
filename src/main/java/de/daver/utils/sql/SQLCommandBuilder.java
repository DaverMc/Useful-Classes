package de.daver.utils.sql;

import de.daver.utils.iteration.Iterations;
import de.daver.utils.lang.StringHandler;

public class SQLCommandBuilder {

    private final StringHandler command;

    public SQLCommandBuilder(String sql){
        this.command = new StringHandler(sql);
    }

    public SQLCommandBuilder(Commands sql){
        this(sql.toString());
    }

    public SQLCommandBuilder tableName(String value){
        command.append(" ").append(value);
        return this;
    }

    public SQLCommandBuilder values(String...values){
        command.append(" VALUES (").append(",", values).append(")");
        return this;
    }

    public SQLCommandBuilder columnBrackets(String...columns){
        command.append(" (").append(",", columns).append(")");
        return this;
    }

    public SQLCommandBuilder columns(String...columns){
        command.append(" ").append(", ",  columns);
        return this;
    }

    public SQLCommandBuilder set(String[] columns, String[] values){
        //SET column1 = value1, column2 = value2, ...
        command.append(" SET");
        Iterations.forIndex(columns.length, index -> command.append(columns[index])
                .append(" = '")
                .append(values[index])
                .append("', "));
        command.trimBackwards(2);
        return this;
    }

    public SQLCommandBuilder where(String column, String operator, String value){
        command.append(" WHERE")
                .append(column)
                .append(" " + operator + "'")
                .append(value)
                .append("'");
        return this;
    }

    public SQLCommandBuilder columnTypes(String[] names, String[] types){
        command.append(" (");
        Iterations.forIndex(names.length, index -> command.append(names[index])
                .append(" ")
                .append(types[index])
                .append(", "));
        command.append(")");
        return this;
    }

    public SQLCommandBuilder from(String tableName){
        command.append(" FROM ").append(tableName);
        return this;
    }

    public String toString() {
        return this.command.toString();
    }

}
