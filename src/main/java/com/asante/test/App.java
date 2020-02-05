package com.asante.test;

import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Inverted Index" );
        
        Index index = new Index();
        index.buildIndex(new String[]{
        		"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad"
        		,"Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir"
        		,"Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell"
        		,"This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith"
        		,"Another book with music related content"});

        System.out.println("Pattern to search: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String pattern = input.readLine();
        Object[] results = index.get(pattern).toArray();
        
        System.out.println(results.length);
        System.out.println(Arrays.toString(results));
    }
}
