package com.softtek.academy.java.basics.fourthdayexercises.javaMethodOverriding;

class Soccer extends Sports{
    @Override
    String getName(){
        return "Soccer Class";
    }

    @Override
    void getNumberOfTeamMembers(){
        System.out.println( "Each team has 11 players in " + getName() );
    }

}
