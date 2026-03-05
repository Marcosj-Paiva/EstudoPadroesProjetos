/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author marqu
 */
public class Builder2 {
    public static void main(String[] args){
        
        Query query1 = new QueryBuilder()
                .select("nome, email ")
                .from("usuarios ")
                .where("idade > 18 ")
                .build();
        
        System.out.println("Query 1: " + query1);
        
        Query query2 = new QueryBuilder()
                .select("* ")
                .from("produtos ")
                .build();
        
        System.out.println("Query 2: " + query2);
        
    }
}

class Query{
    private String select, from, where;
    
    Query(String select, String from, String where){
        this.select = select;
        this.from = from;
        this.where = where;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("SELECT ").append(select);
        sb.append("FROM ").append(from);
        
        if(where != null){
            sb.append("WHERE ").append(where);
        }
        
        return sb.toString();
    }
}

class QueryBuilder{
    private String select, from, where;
    
    public QueryBuilder(){
    }
    
    public QueryBuilder select(String dados){
        this.select = dados;
        return this;
    }
    
    public QueryBuilder from(String dados){
        this.from = dados;
        return this;
    }
    
    public QueryBuilder where(String dados){
        this.where = dados;
        return this;
    }
    
    public Query build(){
        return new Query(select, from, where);
    }
}