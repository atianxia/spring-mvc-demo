package com.qihoo.study;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import graphql.GraphQL;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
public class HelloWorld {
    public static void main1(String[] args) {
        GraphQLObjectType queryType = newObject()
                        .name("helloWorldQuery")
                        .field(newFieldDefinition()
                                .type(GraphQLString)
                                .name("hello")
                                .staticValue("world")
                                .build())
                        .build();
        GraphQLSchema schema = GraphQLSchema.newSchema()
                        .query(queryType)
                        .build();
        Map<String, Object> result = (Map<String, Object>) new GraphQL(schema).execute("{hello}").getData();
        System.out.println(result);
        // Prints: {hello=world}
    }
    public static void main(String[] args) {
		Test test = new Test();
		System.out.println(StringUtils.equalsIgnoreCase("abc", test.abc.trim()));
		test.abc.trim();
	}
    public static class Test{
    	public String abc = "  abc";
    }
}